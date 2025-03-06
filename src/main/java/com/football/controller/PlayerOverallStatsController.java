package com.football.controller;

import com.football.entity.PlayerOverallStats;
import com.football.service.PlayerOverallStats.IPlayerOverallStatsService;
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
@RequestMapping("/api/v2/player_overall_stats")
public class PlayerOverallStatsController {

    @Autowired
    private IPlayerOverallStatsService playerOverallStatsService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerOverallStats(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(playerOverallStatsService.findPlayerOverallStatsById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> addPlayerOverallStats(@RequestBody PlayerOverallStats model) {

        System.out.println(model);

        try {
            return ResponseEntity.ok(playerOverallStatsService.savePlayerOverallStats(model));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayerOverallStats(@PathVariable Long id, @RequestBody PlayerOverallStats newModel) {
        try {
            return ResponseEntity.ok(playerOverallStatsService.updatePlayerOverallStats(id, newModel));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPlayerOverallStats(@PathVariable Long id, @RequestBody PlayerOverallStats newModel) {
        try {
            return ResponseEntity.ok(playerOverallStatsService.updatePlayerOverallStats(id, newModel));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletePlayerOverallStats(Long id) {
        try {
            playerOverallStatsService.deletePlayerOverallStats(id);
            return ResponseEntity.ok("Deleted Successful");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
