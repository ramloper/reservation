package com.urbanlt.reservation.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Terminal {
    PHONE("PHONE"),
    PC("PC"),
    PAD("PAD")
    ;
    private final String terminalName;
}
