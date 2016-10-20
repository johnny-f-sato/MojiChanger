package jp.co.ysinc.mojichange.domain.context.game.core_logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fumiya on 2016/09/19.
 */
public class SimpleOperator implements Operable {
    @Override
    public List<Character> shuffle(String question) {
        List<Character> characters = new ArrayList<>();

        for (Character character : question.toCharArray()) {
            characters.add(character);
        }

        Collections.shuffle(characters);

        return characters;
    }

    @Override
    public String pretty(List<Character> characters) {
        StringBuilder builder = new StringBuilder();

        builder.append("[ ");
        for (Character character : characters) {
            builder.append(character).append(", ");
        }
        // 最後のカンマは消す
        builder.deleteCharAt(builder.length() - 2);
        builder.append("]");

        return builder.toString();
    }
}
