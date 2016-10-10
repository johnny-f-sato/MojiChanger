package jp.co.ysinc.mojichange.domain.tools.event;

/**
 * Created by fumiya on 2016/10/09.
 */
public interface OnAlarmListener {

    /**
     * タイマーが終了したときに発火するイベント
     */
    void onRumble();

}
