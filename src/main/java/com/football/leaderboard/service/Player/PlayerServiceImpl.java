package com.football.leaderboard.service.Player;

import com.football.leaderboard.entity.Player;
import com.football.leaderboard.repository.Player.IPlayerRepository;
import com.football.leaderboard.utils.ReflectionPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private IPlayerRepository playerRepository;


    @Override
    public Player savePlayer(final Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player findPlayerById(final Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player Not Found"));
    }

    @Override
    public Player updatePlayer(Long id, Player player) {
        return playerRepository.save(player);
    }


    @Override
    public Player patchPlayer(final Long id, final Player newModel) throws IllegalAccessException {
        Player existingPlayer = findPlayerById(id);
        ReflectionPatch.performPatch(existingPlayer, newModel);
        return newModel;
    }

    @Override
    public void deletePlayer(final Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public boolean exitsById(final Long id) {
        return playerRepository.exitsById(id);
    }

    @Override
    public List<Player> findPlayerByName(final String name) {
        return playerRepository.findByName(name);
    }

    @Override
    public List<Player> findPlayerByScore(final Long minScore, final Long maxScore) {
        return playerRepository.findByGoals(minScore, maxScore);
    }
}
