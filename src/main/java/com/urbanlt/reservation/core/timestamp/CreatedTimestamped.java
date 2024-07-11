package com.urbanlt.reservation.core.timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class CreatedTimestamped {
    public static final ZoneId SEOUL_ZONE_ID = ZoneId.of("Asia/Seoul");
    public static final ZoneId EST_ZONE_ID = ZoneId.of("America/New_York");
    @CreatedDate
    @Column(nullable = false)
    private ZonedDateTime createdAt;
}
