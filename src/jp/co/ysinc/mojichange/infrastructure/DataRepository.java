package jp.co.ysinc.mojichange.infrastructure;

import jp.co.ysinc.mojichange.resource.Config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by fumiya on 2016/10/18.
 */
public class DataRepository<T> {

    public void saveObject(T target, String fileName) throws IllegalArgumentException {
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

            System.out.println("プレイヤー情報を保存しました");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
