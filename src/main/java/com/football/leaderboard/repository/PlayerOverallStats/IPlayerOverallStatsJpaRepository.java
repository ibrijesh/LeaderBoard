package com.football.leaderboard.repository.PlayerOverallStats;

import com.football.leaderboard.entity.PlayerOverallStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPlayerOverallStatsJpaRepository extends JpaRepository<PlayerOverallStats, Long> {

    @Query("select p from PlayerOverallStats p where p.player.playerId = :id")
    PlayerOverallStats findByPlayerId(@Param("id") Long id);
}
