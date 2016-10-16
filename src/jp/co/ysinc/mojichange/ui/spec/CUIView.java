package jp.co.ysinc.mojichange.ui.spec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by fumiya on 2016/10/16.
 */
public class CUIView {

    protected String outString;

    public String input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public void output() {
        System.out.println(outString);
    }

    public void setText(String text) {
        this.outString = text;
    }

}
