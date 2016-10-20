package jp.co.ysinc.mojichange.domain.repository;

import jp.co.ysinc.mojichange.domain.context.game.Player;
import jp.co.ysinc.mojichange.domain.repository.spec.PlayerRepositorySpec;
import jp.co.ysinc.mojichange.infrastructure.DataRepository;

/**
 * Created by fumiya on 2016/10/18.
 */
public class PlayerRepository implements PlayerRepositorySpec {

    @Override
    public void save(Player player) {
        String filename = String.valueOf(player.getPlayerInfo().getPlayerId());

        DataRepository<Player> repository = new DataRepository<>();
        repository.save(player, filename);
    }

    @Override
    public Player find() {
        DataRepository<Player> repository = new DataRepository<>();
        return repository.once();
    }
}
