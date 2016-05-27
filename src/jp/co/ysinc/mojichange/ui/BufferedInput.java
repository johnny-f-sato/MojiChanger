package jp.co.ysinc.mojichange.ui;

import jp.co.ysinc.mojichange.application.app_interface.Inputable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class BufferedInput implements Inputable {
    @Override
    public String inputCharacterEvent() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }
}