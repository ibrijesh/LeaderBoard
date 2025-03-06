package com.football.repository.PlayerStats;

import com.football.entity.PlayerStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Profile("in-memory")
public class PlayerStatsJpaRepository implements IPlayerStatsRepository {

    @Autowired
    private IPlayerStatsJpaRepository playerStatsJpaRepository;


    @Override
    public Optional<PlayerStats> findById(final Long id) {
        return playerStatsJpaRepository.findById(id);
    }

    @Override
    public PlayerStats save(final PlayerStats playerStats) {
        return playerStatsJpaRepository.save(playerStats);
    }

    @Override
    public void deleteById(final Long id) {
        playerStatsJpaRepository.deleteById(id);
    }

    @Override
    public List<PlayerStats> findAll() {
        return playerStatsJpaRepository.findAll();
    }

    @Override
    public List<PlayerStats> findStatsByPlayerId(final Long playerId) {
        return playerStatsJpaRepository.findStatsByPlayerId(playerId);
    }

}
