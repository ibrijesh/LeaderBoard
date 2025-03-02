package com.football.leaderboard.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_total_stats")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerTotalStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totalStatsId;

    private Long totalGoalsScored;
    private Long totalAssists;
    private Long totalMatchesPlayed;
    private Long totalTacklesWon;
    private Long totalSaves;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

}
