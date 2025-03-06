package com.football.service.PlayerStats;

import com.football.entity.PlayerStats;

import java.util.List;


public interface IPlayerStatsService {
    PlayerStats findPlayerStatsById(Long id);

    PlayerStats savePlayerStats(Long id, PlayerStats playerStats) throws IllegalAccessException;

    PlayerStats updatePlayerStats(Long id, PlayerStats playerStats) throws IllegalAccessException;

    PlayerStats patchPlayerStats(Long id, PlayerStats playerStats) throws IllegalAccessException;

    void deletePlayerStatsById(Long playerId, Long statsId) throws IllegalAccessException;

    List<PlayerStats> findAllPlayerStats();

    List<PlayerStats> findPlayerStatsByPlayerId(Long id);
}
