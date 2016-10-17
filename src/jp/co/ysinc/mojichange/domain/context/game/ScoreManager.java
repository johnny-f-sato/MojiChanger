package jp.co.ysinc.mojichange.domain.context.game;

import jp.co.ysinc.mojichange.domain.context.game.value_object.Score;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class ScoreManager {

    private int gamePoint;
    
    public Player fixScore(Player player) {
        Score score = new Score(gamePoint);
        player.newScore(score);

        return player;
    }

    public void increment(String answer) {
        gamePoint += answer.length() * 100;
        plusBonusPoint(answer);
    }

    private void plusBonusPoint(String bonusAnswer) {
        if (bonusAnswer.length() > 10) {
            gamePoint += bonusAnswer.length() * 200;
        }
    }

}
