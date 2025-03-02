package com.football.leaderboard.repository.PlayerTotalStats;

import com.football.leaderboard.entity.PlayerTotalStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPlayerTotalStatsJpaRepository extends JpaRepository<PlayerTotalStats, Long> {

    @Query("Select p FROM PlayerTotalStats p where p.player.playerId = :id")
    PlayerTotalStats findByPlayerId(@Param("id") Long id);

}
