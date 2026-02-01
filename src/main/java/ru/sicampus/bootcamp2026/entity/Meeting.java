package ru.sicampus.bootcamp2026.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "meeting")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "participant_one_id", nullable = false)
    private Person participantOne;

    @ManyToOne
    @JoinColumn(name = "participant_two_id", nullable = false)
    private Person participantTwo;

    @Column(name = "is_accepted")
    private Boolean isAccepted;
}