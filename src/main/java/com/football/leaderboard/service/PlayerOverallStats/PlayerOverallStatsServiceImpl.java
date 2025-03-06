package com.football.leaderboard.service.PlayerOverallStats;

import com.football.leaderboard.entity.PlayerOverallStats;
import com.football.leaderboard.repository.PlayerOverallStats.IPlayerOverallStatsRepository;
import com.football.leaderboard.utils.ReflectionPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerOverallStatsServiceImpl implements IPlayerOverallStatsService {

    @Autowired
    private IPlayerOverallStatsRepository playerOverallStatsRepository;

    @Override
    public Optional<PlayerOverallStats> findPlayerOverallStatsById(final Long id) {
        return playerOverallStatsRepository.findById(id);
    }

    @Override
    public PlayerOverallStats savePlayerOverallStats(final PlayerOverallStats model) {
        return playerOverallStatsRepository.save(model);
    }

    @Override
    public PlayerOverallStats updatePlayerOverallStats(final Long id, final PlayerOverallStats newModel) {
        newModel.setOverallStatsId(id);
        return playerOverallStatsRepository.save(newModel);
    }

    @Override
    public PlayerOverallStats patchPlayerOverallStats(final Long id, final PlayerOverallStats newModel) throws IllegalAccessException {
        PlayerOverallStats existing = playerOverallStatsRepository.findById(id).get();
        ReflectionPatch.performPatch(existing, newModel);
        return newModel;
    }

    @Override
    public void deletePlayerOverallStats(final Long id) {
        playerOverallStatsRepository.deleteById(id);
    }
}
