package com.football.leaderboard.controller;

import com.football.leaderboard.entity.PlayerTotalStats;
import com.football.leaderboard.service.PlayerStats.IPlayerStatsService;
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

@RestController
@RequestMapping("api/v2/players_total_stats")
public class PlayerTotalStatsController {

    @Autowired
    private IPlayerStatsService playerTotalStatsService;

    @GetMapping()
    public ResponseEntity<?> getPlayerTotalStatsById(@PathVariable("id") Long id) {
        try {
            PlayerTotalStats playerTotalStats = playerTotalStatsService.findPlayerTotalStatsById(id);

            if (playerTotalStats == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PLayer Total Stats does not exist");

            return ResponseEntity.ok(playerTotalStats);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<?> getPlayerTotalStatsByPlayerId(@PathVariable("id") Long id) {
        try {
            PlayerTotalStats playerTotalStats = playerTotalStatsService.findPlayerTotalStatsByPlayerId(id);
            return ResponseEntity.ok(playerTotalStats);

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @PostMapping()
    public ResponseEntity<?> addPlayerTotalStats(@RequestBody PlayerTotalStats model) {
        try {
            PlayerTotalStats playerTotalStats = playerTotalStatsService.savePlayerTotalStats(model);
            return ResponseEntity.ok(playerTotalStats);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePlayerTotalStats(@PathVariable("id") Long id, @RequestBody PlayerTotalStats model) {
        try {
            PlayerTotalStats playerTotalStats = playerTotalStatsService.updatePlayerTotalStats(id, model);
            return ResponseEntity.ok(playerTotalStats);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPlayerTotalStats(@PathVariable("id") Long id, @RequestBody PlayerTotalStats model) {
        try {
            PlayerTotalStats newModel = playerTotalStatsService.patchPlayerTotalStats(id, model);
            return ResponseEntity.ok(newModel);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removePlayerTotalStats(@PathVariable("id") Long id) {
        try {
            playerTotalStatsService.deletePlayerTotalStatsBById(id);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
