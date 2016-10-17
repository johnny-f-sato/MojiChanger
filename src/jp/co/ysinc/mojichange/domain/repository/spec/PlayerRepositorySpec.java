package jp.co.ysinc.mojichange.domain.repository.spec;

import jp.co.ysinc.mojichange.domain.context.game.Player;

/**
 * Created by fumiya on 2016/10/18.
 */
public interface PlayerRepositorySpec {

    void save(Player player);

    Player find();

}
