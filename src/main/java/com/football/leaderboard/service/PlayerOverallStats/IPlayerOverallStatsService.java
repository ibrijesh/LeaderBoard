package com.football.leaderboard.service.PlayerOverallStats;

import com.football.leaderboard.entity.PlayerOverallStats;

import java.util.Optional;

public interface IPlayerOverallStatsService {
    Optional<PlayerOverallStats> findPlayerOverallStatsById(Long id);

    PlayerOverallStats savePlayerOverallStats(PlayerOverallStats playerOverallStats);

    PlayerOverallStats updatePlayerOverallStats(Long id, PlayerOverallStats playerOverallStats);

    PlayerOverallStats patchPlayerOverallStats(Long id, PlayerOverallStats playerOverallStats) throws IllegalAccessException;

    void deletePlayerOverallStats(Long id);
}
