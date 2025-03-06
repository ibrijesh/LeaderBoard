package com.football.leaderboard.repository.PlayerOverallStats;

import com.football.leaderboard.entity.PlayerOverallStats;

public interface IPlayerOverallStats {

    PlayerOverallStats findById(PlayerOverallStats playerOverallStats);

    PlayerOverallStats save(PlayerOverallStats playerOverallStats);

    void deleteByID(Long id);
}
