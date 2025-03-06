package com.football.repository.Player;

import com.football.entity.Player;

import java.util.List;
import java.util.Optional;

public interface IPlayerRepository {
    Optional<Player> findById(Long id);

    Player save(Player player);

    void deleteById(Long id);

    List<Player> findAll();

    boolean exitsById(Long id);

    List<Player> findByName(String name);

    List<Player> findByGoals(Long minScore, Long maxScore);
}
