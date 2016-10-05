package jp.co.ysinc.mojichange.domain.entity.participant;

import jp.co.ysinc.mojichange.domain.value_object.Score;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class Player {
    private String name;
    private Score score;

    private Boolean isPlayContinuing;

    public void setPlayerName(String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return this.name;
    }

    public Score getScore() {
        return this.score;
    }

    public void setIsPlayContinuing(Boolean isContinue) {
        this.isPlayContinuing = isContinue;
    }

    public Boolean isContinuePlaying() {
        if (isPlayContinuing == null) {
            return Boolean.FALSE;
        }
        return this.isPlayContinuing;
    }
}
