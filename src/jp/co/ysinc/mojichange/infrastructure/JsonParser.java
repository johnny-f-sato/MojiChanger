package jp.co.ysinc.mojichange.infrastructure;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by fumiya on 2016/08/02.
 */
public class JsonParser {

    public static <T> T parseJsonFile(String path, Class<T> clazz) {
        try {
            File file = new File(path);
            FileReader reader = new FileReader(file);

            Gson gson = new Gson();
            return gson.fromJson(reader, clazz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return null;
        }
    }
}
