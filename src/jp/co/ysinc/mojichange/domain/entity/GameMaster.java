package jp.co.ysinc.mojichange.domain.entity;

import jp.co.ysinc.mojichange.domain.factory.ResourceFactory;
import jp.co.ysinc.mojichange.ui.interfaces.Inputtable;
import jp.co.ysinc.mojichange.ui.interfaces.Outputtable;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private ScoreManager manager;
    private Inputtable input;
    private Outputtable output;

    private Resource resource;

    public GameMaster(Inputtable input, Outputtable output) {
        manager = new ScoreManager();
        this.input = input;
        this.output = output;

        init();
    }

    public void startGame() {
        //操作方法を表示する
        for (String explain : resource.game_explain) {
            output.show(explain);
            if (explain.contains("Q.")) {
                output.show(input.input(null));
            }
        }
    }

    private void init() {
        this.resource = ResourceFactory.newResource();
    }

}
