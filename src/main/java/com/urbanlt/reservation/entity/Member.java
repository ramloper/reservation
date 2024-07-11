package com.urbanlt.reservation.entity;

import com.urbanlt.reservation.core.enums.Gender;
import com.urbanlt.reservation.core.timestamp.Timestamped;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String loginId;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false, length = 13)
    private String phoneNumber;

    @Column(nullable = false, length = 10)
    private String birthDate;

    @Column(nullable = false, length = 10)
    private Gender gender;

    @Column(unique = true, length = 60)
    private String email;

    private String profile;

    private MemberRole role;

    private String registrationId;

    private boolean smsEnabled;

    private boolean emailEnabled;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservationList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviewList;

    public enum MemberRole{
        USER
    }
}
