package jp.co.ysinc.mojichange.infrastructure;

import jp.co.ysinc.mojichange.resource.Config;

import java.io.*;
import java.util.Objects;

/**
 * Created by fumiya on 2016/10/18.
 */
//TODO もっと汎用性の高いやつにする
public class DataRepository<T> {

    public void save(T target, String fileName) {
        // Serializableを実装していなければIllegalArgumentError
        if (!(target instanceof Serializable)) {
            throw new IllegalArgumentException( "this argument doesn't implements Serializable." +
                                                " please, implement Serializable");
        }

        if (fileName == null || fileName.isEmpty()) {
            //ファイル名がなければ、ハッシュをファイル名にする
            fileName = String.valueOf(Objects.hashCode(target));
        }

        try {
            ObjectOutputStream stream =
                    new ObjectOutputStream(new FileOutputStream(Config.SAVE_DATA_STORE + fileName + ".txt"));
            stream.writeObject(target);

            //TODO AOPで実装できたらかっこいい
            System.out.println("指定の情報を保存しました");

            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 最新のオブジェクトを１件取得する
    public T once() {
        File lastFile = getOnceFile(getSaveDirectory());
        if (lastFile == null) {
            return null;
        }

        // デシリアライズ
        ObjectInputStream stream;
        try {
            stream = new ObjectInputStream(new FileInputStream(lastFile));
            T object = (T) stream.readObject();

            stream.close();

            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private File getOnceFile(File[] directory) {
        // 最新のファイルを1件取得する
        File lastFile = null;
        for (File file : directory) {
            if (lastFile == null) {
                lastFile = file;
            }

            if (file.lastModified() > lastFile.lastModified()) {
                lastFile = file;
            }
        }

        return lastFile;
    }

    private File[] getSaveDirectory() {
        String directoryPath = Config.SAVE_DATA_STORE;
        File root =  new File(directoryPath);
        root.mkdirs();

        return root.listFiles();
    }

}
