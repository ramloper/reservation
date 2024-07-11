package com.urbanlt.reservation.entity;

import com.urbanlt.reservation.core.timestamp.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "center")
@Getter
@Setter
public class Center extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String region;
    @Column(nullable = false)
    private String x;
    @Column(nullable = false)
    private String y;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviewList;

}
