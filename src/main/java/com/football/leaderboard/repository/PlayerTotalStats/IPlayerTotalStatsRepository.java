package com.football.leaderboard.repository.PlayerTotalStats;


import com.football.leaderboard.entity.PlayerTotalStats;

import java.util.Optional;

public interface IPlayerTotalStatsRepository<P, L extends Number> {
    Optional<PlayerTotalStats> findById(Long id);

    PlayerTotalStats save(PlayerTotalStats playerTotalStats);

    void deleteById(Long id);

    PlayerTotalStats findByPlayerId(Long id);
}
