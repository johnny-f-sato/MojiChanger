package jp.co.ysinc.mojichange.domain.entity.participant;

import jp.co.ysinc.mojichange.domain.entity.tools.Resource;
import jp.co.ysinc.mojichange.domain.entity.tools.SentenceCard;
import jp.co.ysinc.mojichange.domain.entity.tools.Timer;
import jp.co.ysinc.mojichange.domain.factory.ResourceFactory;
import jp.co.ysinc.mojichange.infrastructure.ResourceFactoryImpl;
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
    private ResourceFactory factory;

    public GameMaster(Inputtable in, Outputtable out) {
        this.in = in;
        this.out = out;

        init();
    }

    private void init() {
        this.player = new Player();
        this.factory = new ResourceFactoryImpl();
        this.resource = factory.mapStringResource();
    }

    public void startGame() {
        showGameStart();
        showGameExplain();

        System.out.println("main thread start !");

        Timer timer = Timer.newInstance(20);
        timer.start(new CustomHandler());

        startGameLogic();
    }

    private void startGameLogic() {
        // 問題を出す
        Collections.shuffle(resource.question);
        for (String question : resource.question) {
            out.show(new SentenceCard(question).toString());
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

    private class CustomHandler implements Timer.TimerHandler {
        @Override
        public void countDown() {

        }

        @Override
        public void timeUp() {
            out.show("sub thread end");
            System.exit(0);
        }
    }
}