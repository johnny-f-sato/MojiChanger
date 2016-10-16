package jp.co.ysinc.mojichange.domain.game;

import jp.co.ysinc.mojichange.domain.tools.GameTimer;
import jp.co.ysinc.mojichange.domain.tools.R;
import jp.co.ysinc.mojichange.domain.tools.spec.Resource;
import jp.co.ysinc.mojichange.domain.tools.spec.Scene;
import jp.co.ysinc.mojichange.domain.tools.spec.Timer;
import jp.co.ysinc.mojichange.ui.FinishView;
import jp.co.ysinc.mojichange.ui.NormalView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private NormalView view;
    private FinishView finishView;

    private Player                      player;
    private ScoreManager                manager;
    private Timer                       timer;
    private Resource<ArrayList<String>> resource;

    public GameMaster() {
        this.view       = new NormalView();
        this.finishView = new FinishView();
        this.manager    = new ScoreManager();

        this.resource   = R.string();
        this.timer      = GameTimer.newInstance(20);
    }


    public void startGame() {
        showGameStart();
        showGameExplain();

        timer.start(() -> {
            player = manager.fixScore(player);
            finishView.showResult(  player.getPlayerInfo().getPlayerName(),
                                    player.getScore().getScorePoint());
        });

        execGameLogic();
    }

    private void execGameLogic() {
        // 問題を出す
        Collections.shuffle(resource.provideResource(Scene.QUESTION));
        for (String question : resource.provideResource(Scene.QUESTION)) {
            view.setText(new SentenceCard(question).toString());
            view.output();
            String answer = view.input();
            judgeAnswer(question, answer);
        }
    }

    private void showGameStart() {
        for (String s : resource.provideResource(Scene.GAME_START)) {
            view.setText(s);
            view.output();
        }

        player = new Player(view.input());
    }

    private void showGameExplain() {
        String answer = "あぶらそば";
        String playerAnswer = "";

        for (String s : resource.provideResource(Scene.GAME_EXPLAIN)) {
            if (s.contains("A. あぶらそば")) {
                while (!answer.equals(playerAnswer)) {
                    playerAnswer = view.input();
                }
            }

            view.setText(s);
            view.output();
        }

        while (true) {
            String isContinuing = view.input();
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
