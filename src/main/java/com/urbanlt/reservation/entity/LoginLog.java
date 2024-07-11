package com.urbanlt.reservation.entity;

import com.urbanlt.reservation.core.enums.Terminal;
import com.urbanlt.reservation.core.timestamp.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "login_log")
@Getter
@Setter
public class LoginLog extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String authType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Terminal terminal;

    @Column(nullable = false)
    private String ip;

    private String role;

    private String loginUrl;

    private String loginReferer;
}
