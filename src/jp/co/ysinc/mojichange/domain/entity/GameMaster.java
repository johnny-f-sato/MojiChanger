package jp.co.ysinc.mojichange.domain.entity;

import jp.co.ysinc.mojichange.domain.factory.ResourceFactory;
import jp.co.ysinc.mojichange.ui.interfaces.Inputtable;
import jp.co.ysinc.mojichange.ui.interfaces.Outputtable;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private ScoreManager manager;
    private Inputtable in;
    private Outputtable out;

    private Resource resource;

    private Player player;

    public GameMaster(Inputtable in, Outputtable out) {
        manager = new ScoreManager();
        this.in = in;
        this.out = out;

        init();
    }

    public void startGame() {
        showGameStart();
        showGameExplain();
        // debug
        if (player.isContinuePlaying()) {
            out.show(player.getPlayerName() + "さんは、このあとゲームつづける！");
        }

        Timer timer = Timer.newInstace(10);
        
    }

    private void showGameStart() {
        for (String s : resource.game_start) {
            out.show(s);
        }

        player.setPlayerName(in.input());
    }

    private void showGameExplain() {
        String answer = "あぶらそば";
        String playerAnswer = "";

        for (String s : resource.game_explain) {
            if (s.contains("A. あぶらそば")) {
                while (!answer.equals(playerAnswer)) {
                    playerAnswer = in.input();
                }
            }

            out.show(s);
        }

        while (true) {
            String isContinuing = in.input();
            if (isContinuing.equals("S")) {
                player.setIsPlayContinuing(true);
                return;
            }

            if (isContinuing.equals("E")) {
                return;
            }
        }
    }

    private void init() {
        //initをThread化する日も近いかもしれないね
        this.player = new Player();
        this.resource = ResourceFactory.newResource();
    }
}
