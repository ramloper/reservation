package com.urbanlt.reservation.entity;

import com.urbanlt.reservation.core.timestamp.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "mapping_item")
@Getter
@Setter
public class MappingItem extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(nullable = false)
    private String name;

    private Integer timeTaken;

    private LocalTime startTime;

    private LocalTime endTime;

}
