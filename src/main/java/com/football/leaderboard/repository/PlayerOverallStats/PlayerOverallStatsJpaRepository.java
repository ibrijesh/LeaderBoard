package com.football.leaderboard.repository.PlayerOverallStats;

import com.football.leaderboard.entity.PlayerOverallStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("in-memory")
public class PlayerOverallStatsJpaRepository implements IPlayerOverallStatsRepository {

    @Autowired
    private IPlayerOverallStatsJpaRepository playerOverallStatsJpaRepository;

    @Override
    public Optional<PlayerOverallStats> findById(final Long id) {
        return playerOverallStatsJpaRepository.findById(id);
    }

    @Override
    public PlayerOverallStats save(final PlayerOverallStats playerOverallStats) {
        return playerOverallStatsJpaRepository.save(playerOverallStats);
    }

    @Override
    public PlayerOverallStats findByPlayerId(final Long id) {
        return playerOverallStatsJpaRepository.findByPlayerId(id);
    }

    @Override
    public void deleteById(final Long id) {
        playerOverallStatsJpaRepository.deleteById(id);
    }
}
