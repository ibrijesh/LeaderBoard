package com.football.controller;

import com.football.entity.Player;
import com.football.service.Player.IPlayerService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/players")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;


    @GetMapping
    public ResponseEntity<?> getAllPlayers() {
        try {
            List<Player> players = playerService.findAllPlayers();
            return ResponseEntity.ok(players);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable Long id) {

        System.out.println("Hello");

        try {
            Player player = playerService.findPlayerById(id);
            return ResponseEntity.ok(player);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> addNewPlayer(@RequestBody Player model) {

        System.out.println(model);

        if (model == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Body cannot be null");

        try {
            Player player = playerService.savePlayer(model);
            return ResponseEntity.status(HttpStatus.CREATED).body(player);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable("id") Long id, @RequestBody Player model) {
        if (model == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Body cannot be null");

        try {
            Player player = playerService.updatePlayer(id, model);
            return ResponseEntity.status(HttpStatus.CREATED).body(player);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPlayer(@PathVariable("id") Long id, @RequestBody Player model) {
        try {
            Player updatedModel = playerService.patchPlayer(id, model);
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedModel);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removePlayer(@PathVariable("id") Long id) {
        try {
            playerService.deletePlayer(id);
            return ResponseEntity.ok("Deleted Successful");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> getPlayerByName(@PathVariable("name") String name) {

        try {
            List<Player> players = playerService.findPlayerByName(name);
            return ResponseEntity.ok(players);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @GetMapping("/filter")
    public ResponseEntity<?> getPlayerByGoals(@RequestParam Long minScore, @RequestParam Long maxScore) {
        try {
            List<Player> players = playerService.findPlayerByScore(minScore, maxScore);
            return ResponseEntity.ok(players);

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }


}
