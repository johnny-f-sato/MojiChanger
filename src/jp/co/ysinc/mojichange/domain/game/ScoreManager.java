package jp.co.ysinc.mojichange.domain.game;

import jp.co.ysinc.mojichange.domain.game.value_object.Score;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class ScoreManager {

    private int point;

    public void increment(String answer) {
        point += answer.length() * 100;

        plusBonusPoint(answer);
    }

    public Player fixScore(Player player) {
        Score score = new Score(point);
        player.newScore(score);

        return player;
    }

    private void plusBonusPoint(String bonusAnswer) {
        if (bonusAnswer.length() > 10) {
            point += bonusAnswer.length() * 200;
        }
    }
}
