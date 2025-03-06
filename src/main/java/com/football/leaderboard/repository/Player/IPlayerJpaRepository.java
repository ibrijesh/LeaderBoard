package com.football.leaderboard.repository.Player;

import com.football.leaderboard.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPlayerJpaRepository extends JpaRepository<Player, Long> {
    @Query("SELECT p FROM Player  p WHERE p.playerName = :name")
    List<Player> searchPlayerByName(@Param("name") final String name);

    @Query("SELECT p FROM Player p WHERE p.playerOverallStats.goalsScored > :minScore AND p.playerOverallStats.goalsScored < :maxScore")
    List<Player> filterPlayerByGoals(@Param("minScore") final Long minScore, @Param("maxScore") final Long maxScore);
}
