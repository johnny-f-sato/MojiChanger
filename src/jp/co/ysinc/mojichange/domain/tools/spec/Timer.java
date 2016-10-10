package jp.co.ysinc.mojichange.domain.tools.spec;

import jp.co.ysinc.mojichange.domain.tools.event.OnAlarmListener;

/**
 * Created by fumiya on 2016/10/09.
 */
public interface Timer {

    /**
     * カウントダウンする
     */
    void start(OnAlarmListener listener);

}
