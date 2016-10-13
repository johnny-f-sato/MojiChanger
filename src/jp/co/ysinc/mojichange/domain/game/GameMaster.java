package jp.co.ysinc.mojichange.domain.game;

import jp.co.ysinc.mojichange.domain.tools.GameTimer;
import jp.co.ysinc.mojichange.domain.tools.R;
import jp.co.ysinc.mojichange.domain.tools.spec.Resource;
import jp.co.ysinc.mojichange.domain.tools.spec.Scene;
import jp.co.ysinc.mojichange.domain.tools.spec.Timer;
import jp.co.ysinc.mojichange.ui.interfaces.Inputtable;
import jp.co.ysinc.mojichange.ui.interfaces.Outputtable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private Inputtable in;
    private Outputtable out;

    private Player player;
    private ScoreManager manager;
    private Resource<ArrayList<String>> resource;
    private Timer timer;

    public GameMaster(Inputtable in, Outputtable out) {
        this.in = in;
        this.out = out;

        init();
    }

    private void init() {
        this.manager = new ScoreManager();

        this.resource = R.string();
        this.timer = GameTimer.newInstance(30);
    }

    public void startGame() {
        showGameStart();
        showGameExplain();

        timer.start(() -> {
            player = manager.fixScore(player);
            out.show( "player name: " + player.getPlayerInfo().getPlayerName()
                    + "\nscore: " + player.getScore().getScore());
        });

        execGameLogic();
    }

    private void execGameLogic() {
        // 問題を出す
        Collections.shuffle(resource.provideResource(Scene.QUESTION));
        for (String question : resource.provideResource(Scene.QUESTION)) {
            out.show(new SentenceCard(question).toString());
            String answer = in.input();
            judgeAnswer(question, answer);
        }
    }

    private void showGameStart() {
        for (String s : resource.provideResource(Scene.GAME_START)) {
            out.show(s);
        }

        player = new Player(in.input());
    }

    private void showGameExplain() {
        String answer = "あぶらそば";
        String playerAnswer = "";

        for (String s : resource.provideResource(Scene.GAME_EXPLAIN)) {
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
                player.chooseContinuePlaying(true);
                return;
            }

            if (isContinuing.equals("E")) {
                return;
            }
        }
    }

    private void judgeAnswer(String question, String answer) {
        if (question.equals(answer)) {
            manager.increment(answer);
        }
    }
}
