package jp.co.ysinc.mojichange.domain.event;

/**
 * Created by fumiya on 2016/10/12.
 */
public interface OnJudgeListener {

    void judgeRightOrWrong(String answer, String question);

}
