package jp.co.ysinc.mojichange.application;

import jp.co.ysinc.mojichange.ui.BufferedInput;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class MojiChangeGame {

    public static void main(String[] arguments) {
        GameMaster gm = new GameMaster();
        gm.register(new BufferedInput());
    }

}
