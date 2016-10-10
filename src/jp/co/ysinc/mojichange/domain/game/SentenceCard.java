package jp.co.ysinc.mojichange.domain.game;

import jp.co.ysinc.mojichange.domain.tools.core_logic.Operable;
import jp.co.ysinc.mojichange.domain.tools.core_logic.SimpleOperator;

import java.util.List;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class SentenceCard {

    private List<Character> characters;
    private Operable operable;

    public SentenceCard(String question) {
        operable = new SimpleOperator();
        characters = operable.shuffle(question);
    }

    @Override
    public String toString() {
        return operable.pretty(characters);
    }

}
