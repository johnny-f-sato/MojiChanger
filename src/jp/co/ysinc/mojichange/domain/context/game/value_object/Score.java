package jp.co.ysinc.mojichange.domain.context.game.value_object;

import java.io.Serializable;

/**
 * Created by fumiya on 2016/10/09.
 */
public class Score implements Comparable<Score>, Serializable {
    private static final String UNIT_NAME = "pt";

    private final int score;

    public Score(int point) {
        score = point;
    }

    public int getPoint() {
        return score;
    }

    public String getScorePoint() {
        return score + UNIT_NAME;
    }

    @Override
    public int compareTo(Score score) {
        return this.getPoint() > score.getPoint() ? 1 : 0;
    }
}
