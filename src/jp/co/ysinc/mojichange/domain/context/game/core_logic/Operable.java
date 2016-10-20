package jp.co.ysinc.mojichange.domain.context.game.core_logic;

import java.util.List;

/**
 * Created by fumiya on 2016/09/19.
 */
public interface Operable {

    // 文字列をシャッフルして、文字のリストとして返す。
    List<Character> shuffle(String Characters);

    // 文字列を整形する。
    String pretty(List<Character> characters);

}
