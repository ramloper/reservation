package com.urbanlt.reservation.entity;

import com.urbanlt.reservation.core.timestamp.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sms_send")
@Getter
@Setter
public class SmsSend extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;

    @Enumerated(EnumType.STRING)
    private SmsType smsType;

    private String title;
    private String content;

    public enum SmsType{
        MESSAGE(0), KAKAO(1)
        ;
        SmsType(int i){}
    }
}
