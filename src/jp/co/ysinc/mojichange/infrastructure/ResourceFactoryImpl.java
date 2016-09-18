package jp.co.ysinc.mojichange.infrastructure;

import com.google.gson.Gson;
import jp.co.ysinc.mojichange.domain.entity.tools.Resource;
import jp.co.ysinc.mojichange.domain.factory.ResourceFactory;
import jp.co.ysinc.mojichange.resource.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by fumiya on 2016/08/02.
 */
public class ResourceFactoryImpl implements ResourceFactory {
    @Override
    public Resource mapStringResource() {
        try {
            File file = new File(Config.MASTER_JSON_PATH);
            FileReader reader = new FileReader(file);

            Gson gson = new Gson();
            return gson.fromJson(reader, Resource.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return null;
        }
    }
}
