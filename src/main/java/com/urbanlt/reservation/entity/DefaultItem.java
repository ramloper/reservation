package com.urbanlt.reservation.entity;

import com.urbanlt.reservation.core.timestamp.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "default_item")
@Getter
@Setter
public class DefaultItem extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;

    @Column(nullable = false)
    private String name;

    private Integer timeTaken;

    private LocalTime startTime;

    private LocalTime endTime;

}
