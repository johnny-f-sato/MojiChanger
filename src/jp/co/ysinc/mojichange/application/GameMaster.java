package jp.co.ysinc.mojichange.application;

import jp.co.ysinc.mojichange.application.app_interface.Inputable;
import jp.co.ysinc.mojichange.application.app_interface.Outputtable;
import jp.co.ysinc.mojichange.ui.BufferedInput;
import jp.co.ysinc.mojichange.ui.Output;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private ScoreManager manager;
    private Inputable input;
    private Outputtable output;

    public GameMaster() {
        manager = new ScoreManager();
        input = new BufferedInput();
        output = new Output();
    }

    public void startGame() {
        output.show("moji change test test test");
    }

}
