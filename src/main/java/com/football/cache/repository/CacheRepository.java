package com.football.cache.repository;

import com.football.contant.Gender;
import com.football.entity.Player;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CacheRepository implements ICacheRepository {

    private final static List<Player> players;

    static {
        players = new ArrayList<>(List.of(
                new Player(1L, "Lionel Peterson", 27, Gender.MALE, "Argentina", LocalDateTime.now(), null, null),
                new Player(2L, "Cristiano Romero", 34, Gender.MALE, "Portugal", LocalDateTime.now(), null, null),
                new Player(3L, "Alex Morgan", 30, Gender.FEMALE, "USA", LocalDateTime.now(), null, null),
                new Player(4L, "Kylian Fernandes", 25, Gender.MALE, "France", LocalDateTime.now(), null, null),
                new Player(5L, "Erling Gustavsson", 22, Gender.MALE, "Norway", LocalDateTime.now(), null, null),
                new Player(6L, "Megan Raphaels", 28, Gender.FEMALE, "Canada", LocalDateTime.now(), null, null),
                new Player(7L, "Sam Kerrington", 29, Gender.FEMALE, "Australia", LocalDateTime.now(), null, null),
                new Player(8L, "Kevin De Brunner", 33, Gender.MALE, "Belgium", LocalDateTime.now(), null, null),
                new Player(9L, "Luka Modrino", 38, Gender.MALE, "Croatia", LocalDateTime.now(), null, null),
                new Player(10L, "Neymar Santos", 31, Gender.MALE, "Brazil", LocalDateTime.now(), null, null)
        ));
    }

    @Override
    public List<?> topN(String board) {
        return players.stream().limit(5).collect(Collectors.toList());
    }
}
