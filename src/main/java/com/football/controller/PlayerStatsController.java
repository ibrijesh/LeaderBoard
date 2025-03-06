package com.football.controller;

import com.football.entity.PlayerStats;
import com.football.service.PlayerStats.IPlayerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/players_stats")
public class PlayerStatsController {

    @Autowired
    private IPlayerStatsService playerStatsService;


    @GetMapping()
    public ResponseEntity<?> getAllPlayerStats() {
        try {
            return ResponseEntity.ok(playerStatsService.findAllPlayerStats());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerStatsById(@PathVariable("id") Long id) {
        try {
            PlayerStats playerStats = playerStatsService.findPlayerStatsById(id);

            if (playerStats == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PLayer Total Stats does not exist");

            return ResponseEntity.ok(playerStats);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<?> getPlayerStatsByPlayerId(@PathVariable("id") Long playerId) {
        try {
            List<PlayerStats> playerStats = playerStatsService.findPlayerStatsByPlayerId(playerId);
            return ResponseEntity.ok(playerStats);

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addPlayerStats(@PathVariable("id") Long playerId, @RequestBody PlayerStats model) {

        System.out.println(playerId);
        System.out.println(model);

        try {
            PlayerStats playerStats = playerStatsService.savePlayerStats(playerId, model);
            System.out.println(playerStats);
            return ResponseEntity.ok(playerStats);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayerStats(@PathVariable("id") Long playerId, @RequestBody PlayerStats model) {
        try {
            PlayerStats playerStats = playerStatsService.updatePlayerStats(playerId, model);
            return ResponseEntity.ok(playerStats);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPlayerStats(@PathVariable("id") Long playerId, @RequestBody PlayerStats model) {
        try {
            PlayerStats newModel = playerStatsService.patchPlayerStats(playerId, model);
            return ResponseEntity.ok(newModel);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{statsId}/player/{playerId}")
    public ResponseEntity<?> removePlayerStats(@PathVariable("playerId") Long playerId, @PathVariable("statsId") Long statsId) {

        System.out.println(playerId + " " + statsId);

        try {
            playerStatsService.deletePlayerStatsById(playerId, statsId);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
