package jp.co.ysinc.mojichange.domain.entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class MojiCard {
    private String shuffledQuestion;

    public MojiCard(String question) {
        shuffle(question);
    }

    private void shuffle(String question) {
        ArrayList<Character> characters = new ArrayList<>();

        for (Character character : question.toCharArray()) {
            characters.add(character);
        }

        Collections.shuffle(characters);

        shuffledQuestion = characters.toString();
    }

    public String getQuestion() {
        return this.shuffledQuestion;
    }
}
