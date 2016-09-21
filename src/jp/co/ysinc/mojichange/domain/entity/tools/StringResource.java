package jp.co.ysinc.mojichange.domain.entity.tools;

import jp.co.ysinc.mojichange.domain.entity.tools.spec.Resource;

import java.util.ArrayList;

/**
 * Created by fumiya on 2016/08/26.
 */
public class StringResource implements Resource<ArrayList<String>> {
     public ArrayList<String>
            game_start,
            game_end,
            game_explain,
            question;

    private Scene scene;

    public void specifyScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public ArrayList<String> provideResource() {
        if (scene == null) {
            return new ArrayList<>();
        }

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

    @Override
    public String getUUID() {
        return "StringResource";
    }

    public enum Scene {
        GAME_START,
        GAME_END,
        GAME_EXPLAIN,
        QUESTION,
    }
}
