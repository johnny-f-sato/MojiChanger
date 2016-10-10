package jp.co.ysinc.mojichange.domain.game;

import jp.co.ysinc.mojichange.domain.game.value_object.PlayerInfo;
import jp.co.ysinc.mojichange.domain.game.value_object.Score;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class Player {
    private PlayerInfo playerInfo;
    private Score score;

    private Boolean isPlayContinuing;

    protected Player(String name) {
        playerInfo = new PlayerInfo(name);
        score = new Score(0);
    }

    public void newScore(Score score) {
        this.score = new Score(score.getPoint());
    }

    private void setPlayerInfo(String name) {
        this.playerInfo = new PlayerInfo(name);
    }

    public PlayerInfo getPlayerInfo() {
        return this.playerInfo;
    }

    public Score getScore() {
        return this.score;
    }

    public void notifyContinuePlaying(Boolean isContinue) {
        this.isPlayContinuing = isContinue;
    }

    public Boolean isContinuePlaying() {
        if (isPlayContinuing == null) {
            return Boolean.FALSE;
        }
        return this.isPlayContinuing;
    }
}
