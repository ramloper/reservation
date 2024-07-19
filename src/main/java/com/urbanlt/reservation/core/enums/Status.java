package com.urbanlt.reservation.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    WAIT("WAIT"),
    CONFIRMED("CONFIRMED"),
    COMPLETE("COMPLETE"),
    CANCEL("CANCEL"),;

    private final String statusName;
}
