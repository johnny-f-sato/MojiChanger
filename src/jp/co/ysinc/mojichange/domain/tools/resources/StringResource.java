package jp.co.ysinc.mojichange.domain.tools.resources;

import jp.co.ysinc.mojichange.domain.tools.spec.Resource;
import jp.co.ysinc.mojichange.domain.tools.spec.Scene;

import java.util.ArrayList;

/**
 * Created by fumiya on 2016/08/26.
 */
public class StringResource implements Resource<ArrayList<String>> {

    private ArrayList<String>
        game_start,
        game_end,
        game_explain,
        question;

    @Override
    public ArrayList<String> provideResource(Scene scene) {
        switch (scene) {
            case GAME_START:
                return game_start;
            case GAME_END:
                return game_end;
            case GAME_EXPLAIN:
                return game_explain;
            case QUESTION:
                return question;
            default:
                return new ArrayList<>();
        }
    }
}
