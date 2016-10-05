package jp.co.ysinc.mojichange.domain.factory;

import com.google.gson.Gson;
import jp.co.ysinc.mojichange.domain.entity.tools.StringResource;
import jp.co.ysinc.mojichange.domain.entity.tools.spec.Resource;
import jp.co.ysinc.mojichange.resource.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by fumiya on 2016/10/06.
 */
public class StringResourceFactory implements ResourceFactory<ArrayList<String>> {
    @Override
    public Resource<ArrayList<String>> create() {
        StringResource resource = new StringResource();

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
