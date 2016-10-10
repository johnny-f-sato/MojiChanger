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

    public void setPlayerInfo(String name) {
        this.playerInfo = new PlayerInfo(name);
    }

    public PlayerInfo getPlayerName() {
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
