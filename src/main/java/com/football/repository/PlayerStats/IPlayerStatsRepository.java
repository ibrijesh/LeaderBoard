package com.football.repository.PlayerStats;


import com.football.entity.PlayerStats;

import java.util.Optional;
import java.util.List;

public interface IPlayerStatsRepository {
    Optional<PlayerStats> findById(Long id);

    PlayerStats save(PlayerStats playerStats);

    void deleteById(Long id);

    List<PlayerStats> findAll();

    List<PlayerStats> findStatsByPlayerId(Long playerId);
}
