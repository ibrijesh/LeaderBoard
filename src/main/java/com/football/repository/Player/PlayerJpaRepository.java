package com.football.repository.Player;

import com.football.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("in-memory")
public class PlayerJpaRepository implements IPlayerRepository {

    @Autowired
    private IPlayerJpaRepository playerJpaRepository;

    @Override
    public Optional<Player> findById(final Long id) {
        return playerJpaRepository.findById(id);
    }

    @Override
    public Player save(final Player player) {
        return playerJpaRepository.save(player);
    }

    @Override
    public void deleteById(final Long id) {
        playerJpaRepository.deleteById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerJpaRepository.findAll();
    }

    @Override
    public boolean exitsById(final Long id) {
        return playerJpaRepository.existsById(id);
    }

    @Override
    public List<Player> findByName(final String name) {
        // raw SQL query
        return playerJpaRepository.searchPlayerByName(name);
    }

    @Override
    public List<Player> findByGoals(final Long minScore, final Long maxScore) {
        // raw SQL query
        return playerJpaRepository.filterPlayerByGoals(minScore, maxScore);
    }
}
