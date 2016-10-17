package jp.co.ysinc.mojichange.domain.tools;

import jp.co.ysinc.mojichange.domain.game.Player;
import jp.co.ysinc.mojichange.domain.tools.spec.PlayerRepositorySpec;
import jp.co.ysinc.mojichange.infrastructure.DataRepository;

/**
 * Created by fumiya on 2016/10/18.
 */
public class PlayerRepository implements PlayerRepositorySpec{

    @Override
    public void save(Player player) {
        DataRepository<Player> repository = new DataRepository<>();

        String filename = String.valueOf(player.getPlayerInfo().getPlayerId());

        repository.saveObject(player, filename);
    }

    @Override
    public Player find() {
        return null;
    }
}
