package com.football.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "player_overall_stats")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "player")
public class PlayerOverallStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long overallStatsId;

    private Long goalsScored;
    private Long assists;
    private Long matchesPlayed;
    private Long tacklesWon;
    private Long saves;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)  // This is foreign key
    @JsonIgnore
    private Player player;

}
