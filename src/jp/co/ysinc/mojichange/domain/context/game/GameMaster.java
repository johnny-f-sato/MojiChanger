package jp.co.ysinc.mojichange.domain.context.game;

import jp.co.ysinc.mojichange.domain.context.tools.GameTimer;
import jp.co.ysinc.mojichange.domain.repository.PlayerRepository;
import jp.co.ysinc.mojichange.domain.context.tools.R;
import jp.co.ysinc.mojichange.domain.repository.spec.PlayerRepositorySpec;
import jp.co.ysinc.mojichange.domain.context.tools.spec.Resource;
import jp.co.ysinc.mojichange.domain.context.tools.spec.Scene;
import jp.co.ysinc.mojichange.domain.context.tools.spec.Timer;
import jp.co.ysinc.mojichange.ui.FinishView;
import jp.co.ysinc.mojichange.ui.LastTimeRecordView;
import jp.co.ysinc.mojichange.ui.NormalView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private LastTimeRecordView lastTimeView;
    private NormalView view;
    private FinishView finishView;

    private Player                      player;
    private ScoreManager                manager;
    private Timer                       timer;
    private Resource<ArrayList<String>> resource;

    private PlayerRepositorySpec repository;

    public GameMaster() {
        this.lastTimeView   = new LastTimeRecordView();
        this.view           = new NormalView();
        this.finishView     = new FinishView();
        this.manager        = new ScoreManager();

        this.resource   = R.string();
        this.timer      = GameTimer.newInstance(20);

        this.repository = new PlayerRepository();
    }


    public void startGame() {
        showGameStart();
        showGameExplain();

        if (!player.isContinuePlaying()) {
            System.exit(1);
            return;
        }

        timer.start(() -> {
            player = manager.fixScore(player);
            finishView.showResult(  player.getPlayerInfo().getPlayerName(),
                                    player.getScore().getScorePoint());

            repository.save(player);
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
        Player prePlayer = repository.find();
        if (prePlayer != null) {
            lastTimeView.setText(
                    " name: " + prePlayer.getPlayerInfo().getPlayerName()
                    + "\n" +
                    "score: " + prePlayer.getScore().getScorePoint()
            );
            lastTimeView.output();
        }

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
