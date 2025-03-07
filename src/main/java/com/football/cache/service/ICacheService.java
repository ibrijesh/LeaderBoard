package com.football.cache.service;

import java.util.List;

public interface ICacheService {
    List<?> getTopN(final String board);
}
