package jp.co.ysinc.mojichange.ui;

import jp.co.ysinc.mojichange.ui.interfaces.Outputtable;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class Output implements Outputtable {
    @Override
    public void show(String various) {
        System.out.println(various);
    }
}
