package jp.co.ysinc.mojichange.ui;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class Output {

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
