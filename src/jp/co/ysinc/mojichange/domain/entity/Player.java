package jp.co.ysinc.mojichange.domain.entity;

import jp.co.ysinc.mojichange.domain.value_object.Score;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class Player {
    private String name;
    private Score score;

    public Player(String playerName) {
        this.name = playerName;
    }

    public String getPlayerName() {
        return this.name;
    }

    public Score getScore() {
        return this.score;
    }
}
