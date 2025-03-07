package com.football.leaderboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/leaderboard")
public class LeaderBoardController {

    @Autowired
    private LeaderBoardService leaderBoardService;


    @GetMapping()
    public ResponseEntity<?> getTopNPlayers(@RequestParam() String board) {
        try {
            return ResponseEntity.ok(leaderBoardService.fetchTopNPlayers(board));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
