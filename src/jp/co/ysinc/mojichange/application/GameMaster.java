package jp.co.ysinc.mojichange.application;

import jp.co.ysinc.mojichange.ui.Output;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private Output output;
    private ScoreManager manager;

    public GameMaster() {
        output = new Output();
        manager = new ScoreManager();
    }

    public void startGame() {
        output.tellGameStart();
    }

}
