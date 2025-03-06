package com.football.leaderboard.service.PlayerStats;

import com.football.leaderboard.entity.Player;
import com.football.leaderboard.entity.PlayerOverallStats;
import com.football.leaderboard.entity.PlayerStats;
import com.football.leaderboard.repository.PlayerStats.IPlayerStatsRepository;
import com.football.leaderboard.service.Player.IPlayerService;
import com.football.leaderboard.service.PlayerOverallStats.IPlayerOverallStatsService;
import com.football.leaderboard.utils.ReflectionPatch;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;


@Service
@Transactional
public class PlayerStatsServiceImpl implements IPlayerStatsService {

    @Autowired
    private IPlayerStatsRepository playerStatsRepository;

    @Autowired
    private IPlayerService playerService;

    @Autowired
    private IPlayerOverallStatsService playerOverallStatsService;


    @Override
    public PlayerStats findPlayerStatsById(final Long id) {
        Optional<PlayerStats> playerStats = playerStatsRepository.findById(id);
        return playerStats.get();
    }

    @Override
    public PlayerStats savePlayerStats(final Long playerId, final PlayerStats model) throws IllegalAccessException {

        Player player = playerService.findPlayerById(playerId);

        if (player == null)
            throw new RuntimeException("Player does not exist");

        PlayerOverallStats playerOverallStats = player.getPlayerOverallStats();
        if (playerOverallStats == null) {
            playerOverallStats = new PlayerOverallStats();
            playerOverallStats.setPlayer(player);

            playerOverallStats = playerOverallStatsService.savePlayerOverallStats(playerOverallStats);
            player.setPlayerOverallStats(playerOverallStats);
        }

        ReflectionPatch.performAddition(playerOverallStats, model);   // update overall score

        model.setPlayer(player);
        PlayerStats playerStats = playerStatsRepository.save(model);
        player.getPlayerStats().add(playerStats);  // add to playerStats list

        return playerStats; //playerStats;
    }

    @Override
    public PlayerStats updatePlayerStats(final Long playerId, final PlayerStats newModel) throws IllegalAccessException {

        Player player = playerService.findPlayerById(playerId);

        if (player == null)
            throw new RuntimeException("Player does not exist");

        PlayerOverallStats playerOverallStats = player.getPlayerOverallStats();
        PlayerStats oldPlayerStats = playerStatsRepository.findById(newModel.getStatsId()).get();

        ReflectionPatch.performSubtraction(playerOverallStats, oldPlayerStats);
        ReflectionPatch.performAddition(playerOverallStats, newModel);

        newModel.setStatsId(oldPlayerStats.getStatsId());
        newModel.setPlayer(oldPlayerStats.getPlayer());
        playerStatsRepository.save(newModel);

        return newModel;
    }

    @Override
    public PlayerStats patchPlayerStats(final Long playerId, final PlayerStats newModel) throws IllegalAccessException {

        Player player = playerService.findPlayerById(playerId);

        if (player == null)
            throw new RuntimeException("Player does not exist");

        PlayerOverallStats playerOverallStats = player.getPlayerOverallStats();
        PlayerStats existingPlayerStats = playerStatsRepository.findById(newModel.getStatsId()).get();

        ReflectionPatch.performSubtraction(playerOverallStats, existingPlayerStats);
        ReflectionPatch.performAddition(playerOverallStats, newModel);
        ReflectionPatch.performPatch(existingPlayerStats, newModel);

        return existingPlayerStats;
    }

    @Override
    public void deletePlayerStatsById(final Long playerId, final Long statsId) throws IllegalAccessException {

        Player player = playerService.findPlayerById(playerId);

        PlayerOverallStats playerOverallStats = player.getPlayerOverallStats();
        PlayerStats existingPlayerStats = playerStatsRepository.findById(statsId).get();

        ReflectionPatch.performSubtraction(playerOverallStats, existingPlayerStats);
        playerStatsRepository.deleteById(statsId);

    }

    @Override
    public List<PlayerStats> findAllPlayerStats() {
        return playerStatsRepository.findAll();
    }

    @Override
    public List<PlayerStats> findPlayerStatsByPlayerId(final Long id) {
        return playerStatsRepository.findStatsByPlayerId(id);
    }
}
