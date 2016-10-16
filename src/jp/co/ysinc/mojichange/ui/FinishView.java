package jp.co.ysinc.mojichange.ui;

import jp.co.ysinc.mojichange.ui.spec.CUIView;

/**
 * Created by fumiya on 2016/10/16.
 */
public class FinishView extends CUIView {

    private String name, score;

    @Override
    public void output() {
        System.out.println();
        System.out.println("------------ 獲得ポイント ------------");
        System.out.println( "player name: " + name + "\n" +
                            "Total score: " + score);
        System.out.println("------------ おわり ------------");
    }

    public void showResult(String name, String score) {
        this.name   = name;
        this.score  = score;

        output();
    }
}
