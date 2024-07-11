package com.urbanlt.reservation.entity;

import com.urbanlt.reservation.core.timestamp.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login_id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false, length = 13)
    private String phoneNumber;

    @Column(nullable = false)
    private String position;

    @ManyToOne
    @JoinColumn(name = "center_id", updatable = false)
    private Center center;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviewList;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservationList;

}
