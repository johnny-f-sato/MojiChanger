package jp.co.ysinc.mojichange.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class MojiCard {
    private String shuffledQuestion;

    public MojiCard(String question) {
        shuffle(question);
    }

    private void shuffle(String question) {
        List<Character> characters = new ArrayList<>();

        for (Character character : question.toCharArray()) {
            characters.add(character);
        }

        Collections.shuffle(characters);

        shuffledQuestion = new CustomCharacter(characters).toString();
    }

    public String getQuestion() {
        return this.shuffledQuestion;
    }

    private class CustomCharacter {

        private List<Character> list;

        public CustomCharacter(List<Character> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append("[ ");
            for (Character character : list) {
                builder.append(character).append(", ");
            }
            // 最後のカンマは消す
            builder.deleteCharAt(builder.length() - 2);
            builder.append("]");

            return builder.toString();
        }
    }
}
