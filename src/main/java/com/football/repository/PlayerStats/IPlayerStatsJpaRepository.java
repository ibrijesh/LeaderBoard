package com.football.repository.PlayerStats;

import com.football.entity.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPlayerStatsJpaRepository extends JpaRepository<PlayerStats, Long> {

    @Query("Select p FROM PlayerStats p where p.player.playerId = :id")
    List<PlayerStats> findStatsByPlayerId(@Param("id") Long id);

}
