package jp.co.ysinc.mojichange.domain.context.tools;

import jp.co.ysinc.mojichange.domain.context.tools.resources.StringResource;
import jp.co.ysinc.mojichange.infrastructure.GameDataMapper;

/**
 * Created by fumiya on 2016/10/10.
 */
public class R {

    private static R resource;

    private StringResource string;

    private R() {
        string = new GameDataMapper().mapStringData();
    }

    private static R init() {
        if (resource == null) {
            resource = new R();
        }

        return resource;
    }

    public static StringResource string() {
        init();

        return resource.string;
    }

}
