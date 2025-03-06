package com.football.leaderboard.service.PlayerTotalStats;

import com.football.leaderboard.entity.PlayerTotalStats;
import com.football.leaderboard.repository.PlayerTotalStats.IPlayerTotalStatsRepository;
import com.football.leaderboard.utils.ReflectionPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerTotalStatsServiceImpl implements IPlayerTotalStatsService {

    @Autowired
    private IPlayerTotalStatsRepository playerTotalStatsRepository;

    @Override
    public PlayerTotalStats findPlayerTotalStatsById(final Long id) {
        PlayerTotalStats playerTotalStats = playerTotalStatsRepository.findByPlayerId(id);
        return playerTotalStats;
    }

    @Override
    public PlayerTotalStats savePlayerTotalStats(final PlayerTotalStats playerTotalStats) {
        return playerTotalStatsRepository.save(playerTotalStats);
    }

    @Override
    public PlayerTotalStats updatePlayerTotalStats(final Long id, final PlayerTotalStats newModel) {
        newModel.setTotalStatsId(id);   // Ensure ID is set for update
        playerTotalStatsRepository.save(newModel);
        return newModel;
    }

    @Override
    public PlayerTotalStats patchPlayerTotalStats(final Long id, final PlayerTotalStats newModel) throws IllegalAccessException {
        PlayerTotalStats existingPlayerTotalStats = playerTotalStatsRepository.findByPlayerId(id);
        ReflectionPatch.performPatch(existingPlayerTotalStats, newModel);
        return newModel;
    }

    @Override
    public void deletePlayerTotalStatsBById(final Long id) {
        playerTotalStatsRepository.deleteById(id);
    }

    @Override
    public PlayerTotalStats findPlayerTotalStatsByPlayerId(final Long id) {
        return playerTotalStatsRepository.findByPlayerId(id);
    }
}
