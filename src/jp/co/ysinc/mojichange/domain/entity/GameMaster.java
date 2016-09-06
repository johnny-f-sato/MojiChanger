package jp.co.ysinc.mojichange.domain.entity;

import jp.co.ysinc.mojichange.domain.factory.ResourceFactory;
import jp.co.ysinc.mojichange.ui.interfaces.Inputtable;
import jp.co.ysinc.mojichange.ui.interfaces.Outputtable;

import java.util.Collections;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private Inputtable in;
    private Outputtable out;

    private Player player;
    private Resource resource;
    private ScoreManager manager;

    public GameMaster(Inputtable in, Outputtable out) {
        manager = new ScoreManager();
        this.in = in;
        this.out = out;

        init();
    }

    private void init() {
        //initをThread化する日も近いかもしれないね
        this.player = new Player();
        this.manager = new ScoreManager();
        this.resource = ResourceFactory.newResource();
    }

    public void startGame() {
        showGameStart();
        showGameExplain();

        System.out.println("main thread start !");

        Timer timer = Timer.newInstace(30);
        timer.start(() -> {
            System.out.println("sub thread end");

            System.exit(0);
        });

        startGameLogic();
    }

    private void startGameLogic() {
        // 問題を出す
        Collections.shuffle(resource.question);
        for (String question : resource.question) {
            MojiCard card = new MojiCard(question);
            out.show(card.getQuestion());
            in.input();
        }
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
}
