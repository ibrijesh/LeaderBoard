package com.football.cache.service;

import com.football.cache.repository.ICacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheServiceInMemory implements ICacheService {

    @Autowired
    private ICacheRepository cacheRepository;

    @Override
    public List<?> getTopN(final String board) {
        return cacheRepository.topN(board);
    }
}
