package com.football.leaderboard.repository.Player;


import com.football.leaderboard.contant.Gender;
import com.football.leaderboard.entity.Player;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Profile("dummy")
public class PlayerFakeDataRepository implements IPlayerRepository {

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
    public Optional<Player> findById(final Long id) {
        return players.stream().filter(p -> p.getPlayerId().equals(id)).findFirst();
    }

    @Override
    public Player save(final Player player) {
        players.add(player);
        return player;
    }

    @Override
    public void deleteById(final Long id) {
        players.removeIf(player -> player.getPlayerId().equals(id));
    }

    @Override
    public List<Player> findAll() {
        return players;
    }

    @Override
    public boolean exitsById(final Long id) {
        return players.stream().anyMatch(player -> player.getPlayerId().equals(id));
    }

    @Override
    public List<Player> findByName(final String name) {
        return players.stream().filter(player -> player.getPlayerName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Player> findByGoals(final Long minScore, final Long maxScore) {
        return players.stream().filter(player -> player.getPlayerOverallStats().getGoalsScored() >= minScore &&
                player.getPlayerOverallStats().getGoalsScored() <= maxScore).collect(Collectors.toList());
    }
}
