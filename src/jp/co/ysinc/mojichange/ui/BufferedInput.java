package jp.co.ysinc.mojichange.ui;

import jp.co.ysinc.mojichange.ui.interfaces.Inputtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class BufferedInput implements Inputtable {
    @Override
    public String input(String input) {
        String str = "";
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}