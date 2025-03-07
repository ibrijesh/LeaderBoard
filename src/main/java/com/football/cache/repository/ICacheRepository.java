package com.football.cache.repository;

import java.util.List;

public interface ICacheRepository {
    List<?> topN(String board);
}
