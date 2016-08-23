package jp.co.ysinc.mojichange.application;

import jp.co.ysinc.mojichange.domain.entity.GameMaster;
import jp.co.ysinc.mojichange.ui.BufferedInput;
import jp.co.ysinc.mojichange.ui.Output;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class MojiChangeGame {
    public static void main(String[] arguments) {
        GameMaster gm = new GameMaster(new BufferedInput(), new Output());
        gm.startGame();
    }
}
