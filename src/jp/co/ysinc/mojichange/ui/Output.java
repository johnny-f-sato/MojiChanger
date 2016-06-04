package jp.co.ysinc.mojichange.ui;

import jp.co.ysinc.mojichange.application.app_interface.Outputtable;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class Output implements Outputtable {

    @Override
    public void show(String outputString) {
        System.out.println(outputString);
    }

    public void decorateByHyphen(String target) {
        show("--------- " + target + " ---------");
    }

    public void tellGameStart() {
        decorateByHyphen("対戦型文章入れ替えゲーム　ＭＯＪＩ");
    }

    public void tellGameEnd() {
        decorateByHyphen("Thank you for playing!!");
    }
}
