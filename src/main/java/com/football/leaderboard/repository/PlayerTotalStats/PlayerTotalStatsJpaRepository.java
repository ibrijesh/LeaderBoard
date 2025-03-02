package com.football.leaderboard.repository.PlayerTotalStats;

import com.football.leaderboard.entity.PlayerTotalStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("in-memory")
public class PlayerTotalStatsJpaRepository implements IPlayerTotalStatsRepository {

    @Autowired
    private IPlayerTotalStatsJpaRepository playerTotalStatsJpaRepository;


    @Override
    public Optional<PlayerTotalStats> findById(final Long id) {
        return playerTotalStatsJpaRepository.findById(id);
    }

    @Override
    public PlayerTotalStats save(final PlayerTotalStats playerTotalStats) {
        return playerTotalStatsJpaRepository.save(playerTotalStats);
    }

    @Override
    public void deleteById(final Long id) {
        playerTotalStatsJpaRepository.deleteById(id);
    }

    @Override
    public PlayerTotalStats findByPlayerId(final Long id) {
        return playerTotalStatsJpaRepository.findByPlayerId(id);
    }
}
