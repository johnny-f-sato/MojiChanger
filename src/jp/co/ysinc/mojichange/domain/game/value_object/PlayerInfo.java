package jp.co.ysinc.mojichange.domain.game.value_object;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by fumiya on 2016/10/09.
 */
public class PlayerInfo implements Comparable<PlayerInfo>, Serializable {

    private int playerId;
    private String playerName;

    public PlayerInfo(String playerName) {
        this.playerName = playerName;
        generatePlayerId();
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    private void generatePlayerId() {
        playerId = Objects.hash(this, playerName);
    }


    @Override
    public int compareTo(PlayerInfo target) {
        return this.playerId != target.playerId ? 1 : 0;
    }
}
