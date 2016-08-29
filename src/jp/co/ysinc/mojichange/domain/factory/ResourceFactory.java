package jp.co.ysinc.mojichange.domain.factory;

import jp.co.ysinc.mojichange.domain.entity.Resource;
import jp.co.ysinc.mojichange.infrastructure.ResourceManager;
import jp.co.ysinc.mojichange.resource.Config;

/**
 * Created by johnny.f.sato on 2016/08/23.
 */
public class ResourceFactory {

    public static Resource newResource() {
        return ResourceManager.parseResourceFile(
                Config.MASTER_JSON_PATH,
                Resource.class
        );
    }

}
