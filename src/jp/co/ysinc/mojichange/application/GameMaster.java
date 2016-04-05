package jp.co.ysinc.mojichange.application;

import jp.co.ysinc.mojichange.application.app_interface.Inputable;
import jp.co.ysinc.mojichange.application.app_interface.Outputtable;
import jp.co.ysinc.mojichange.ui.Output;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private ScoreManager manager;
    private Inputable inputable;
    private Outputtable outputtable;

    public GameMaster() {
        manager = new ScoreManager();
    }

    public void startGame() {
        outputtable.show();
    }

    public void register(Inputable inputable) {
        this.inputable = inputable;
    }

    public void registerOutput() {

    }

}
