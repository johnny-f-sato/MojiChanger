package jp.co.ysinc.mojichange.domain.tools;

import jp.co.ysinc.mojichange.domain.tools.resources.StringResource;
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

    public static R init() {
        if (resource == null) {
            resource = new R();
        }

        return resource;
    }

    public StringResource string() {
        return string;
    }

}
