package com.football.service.Player;


import com.football.entity.Player;


import java.util.List;


public interface IPlayerService {
    Player savePlayer(Player player);

    Player findPlayerById(Long id);

    Player updatePlayer(Long id, Player player);

    Player patchPlayer(Long id, Player update) throws IllegalAccessException;

    void deletePlayer(Long id);

    List<Player> findAllPlayers();

    boolean exitsById(Long id);

    List<Player> findPlayerByName(String name);

    List<Player> findPlayerByScore(Long minScore, Long maxScore);

}
