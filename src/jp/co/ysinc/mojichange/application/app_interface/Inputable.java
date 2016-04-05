package jp.co.ysinc.mojichange.application.app_interface;

import java.io.IOException;

/**
 * Created by Fumiya on 2016/04/05.
 */
public interface Inputable {
    //入力に対する装飾や処理をここで行う
    String inputCharacterEvent() throws IOException;
}