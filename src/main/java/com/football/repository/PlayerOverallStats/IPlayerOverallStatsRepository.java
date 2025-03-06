package com.football.repository.PlayerOverallStats;

import com.football.entity.PlayerOverallStats;

import java.util.Optional;

public interface IPlayerOverallStatsRepository {

    Optional<PlayerOverallStats> findById(Long id);

    PlayerOverallStats save(PlayerOverallStats playerOverallStats);

    PlayerOverallStats findByPlayerId(Long id);

    void deleteById(Long id);
}
