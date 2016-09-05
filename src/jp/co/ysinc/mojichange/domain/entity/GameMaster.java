package jp.co.ysinc.mojichange.domain.entity;

import jp.co.ysinc.mojichange.domain.factory.ResourceFactory;
import jp.co.ysinc.mojichange.ui.interfaces.Inputtable;
import jp.co.ysinc.mojichange.ui.interfaces.Outputtable;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameMaster {

    private boolean isGaming;

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

    private void init() {
        //initをThread化する日も近いかもしれないね
        this.isGaming = true;
        this.player = new Player();
        this.resource = ResourceFactory.newResource();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void startGame() {
        showGameStart();
        showGameExplain();

        System.out.println("main thread start, gaming state is " + isGaming);

        Timer timer = Timer.newInstace(10);
        timer.start(() -> {
            isGaming = false;
            System.out.println("sub thread end");
            System.out.println("isGaming: " + isGaming);
        });

        while (!isGaming) {
            startGameLogic();
        }
    }

    private void startGameLogic() {

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
