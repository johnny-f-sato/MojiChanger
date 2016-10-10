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
    private Resource<ArrayList<String>> resource;
    private Timer timer;

    public GameMaster(Inputtable in, Outputtable out) {
        this.in = in;
        this.out = out;

        init();
    }

    private void init() {
        this.resource = R.string();
        this.timer = GameTimer.newInstance(30);
    }

    public void startGame() {
        showGameStart();
        showGameExplain();

        out.show("main thread start !");

        Timer time = GameTimer.newInstance(10);
        time.start(() -> {
           out.show("おわり");
        });

        execGameLogic();
    }

    private void execGameLogic() {
        // 問題を出す
        Collections.shuffle(resource.provideResource(Scene.QUESTION));
        for (String question : resource.provideResource(Scene.QUESTION)) {
            out.show(new SentenceCard(question).toString());
            in.input();
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
                player.notifyContinuePlaying(true);
                return;
            }

            if (isContinuing.equals("E")) {
                return;
            }
        }
    }
}
