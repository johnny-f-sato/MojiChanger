package jp.co.ysinc.mojichange.ui;

import jp.co.ysinc.mojichange.ui.spec.CUIView;

/**
 * Created by fumiya on 2016/10/20.
 */
public class LastTimeRecordView extends CUIView {

    @Override
    public void output() {
        System.out.println("・～・～・・～・～・前回のスコア・～・～・・～・～・");
        System.out.println(this.outString);
        System.out.println("・～・～・・～・～・・～・～・・～・～・・～・～・～・");
    }
}
