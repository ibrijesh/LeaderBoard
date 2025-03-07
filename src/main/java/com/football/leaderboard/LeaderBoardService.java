package com.football.leaderboard;

import com.football.cache.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderBoardService {

    @Autowired
    private ICacheService cacheService;

    public List<?> fetchTopNPlayers(String board) {
        return cacheService.getTopN(board);
    }

}
