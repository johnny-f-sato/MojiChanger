package jp.co.ysinc.mojichange.infrastructure;

import com.google.gson.Gson;
import jp.co.ysinc.mojichange.domain.context.tools.resources.StringResource;
import jp.co.ysinc.mojichange.resource.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by fumiya on 2016/10/10.
 */
public class GameDataMapper {

    public StringResource mapStringData() {
        StringResource resource = null;

        try {
            File file = new File(Config.MASTER_JSON_PATH);
            FileReader reader = new FileReader(file);

            Gson gson = new Gson();
            resource = gson.fromJson(reader, StringResource.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return resource;
    }

}
