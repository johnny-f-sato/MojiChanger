package jp.co.ysinc.mojichange.domain.value_object;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class Score implements Comparable<Score> {
    private static final String UNIT_NAME = "pt";

    private final Integer score;

    public Score(int scorePoint) {
        this.score = scorePoint;
    }

    public String getScore() {
        return this.score + UNIT_NAME;
    }

    public boolean equals(Score target) {
        if (target == null) {
            return false;
        }

        return this.score.equals(target.score);
    }

    @Override
    public int compareTo(Score target) {
        //if target is null, then return minus number.
        if (target == null) {
            return -1;
        }

        return this.score > target.score ? 1 : 0;
    }
}
