package jp.co.ysinc.mojichange.domain.entity.game;

/**
 * Created by Fumiya on 2016/05/24.
 */
public class Juror {

    //正誤判定
    public boolean judgeRightOrWrong(String input, String correct) {
        return correct.equals(input);
    }

}
