package com.football.leaderboard.service.PlayerTotalStats;

import com.football.leaderboard.entity.PlayerTotalStats;


public interface IPlayerTotalStatsService {
    PlayerTotalStats findPlayerTotalStatsById(Long id);

    PlayerTotalStats savePlayerTotalStats(PlayerTotalStats playerTotalStats);

    PlayerTotalStats updatePlayerTotalStats(Long id, PlayerTotalStats playerTotalStats);

    PlayerTotalStats patchPlayerTotalStats(Long id, PlayerTotalStats playerTotalStats) throws IllegalAccessException;

    void deletePlayerTotalStatsBById(Long id);

    PlayerTotalStats findPlayerTotalStatsByPlayerId(Long id);
}
