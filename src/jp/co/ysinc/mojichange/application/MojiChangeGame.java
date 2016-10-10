package jp.co.ysinc.mojichange.application;

import jp.co.ysinc.mojichange.domain.game.GameMaster;
import jp.co.ysinc.mojichange.ui.Input;
import jp.co.ysinc.mojichange.ui.Output;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class MojiChangeGame {
    public static void main(String[] arguments) {
        GameMaster gm = new GameMaster(new Input(), new Output());
        gm.startGame();
    }
}
