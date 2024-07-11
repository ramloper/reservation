package com.urbanlt.reservation.entity;

import com.urbanlt.reservation.core.timestamp.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter
public class Review extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private VisibilityStatus visibilityStatus;

    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus;

    public enum VisibilityStatus{
        PUBLIC(0), PRIVATE(1);

        VisibilityStatus(int i) {}
    }

    public enum ReviewStatus {
        CREATE(0), UPDATE(1);
        ReviewStatus(int i) {}
    }
}
