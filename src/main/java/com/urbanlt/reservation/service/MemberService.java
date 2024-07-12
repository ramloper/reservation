package com.urbanlt.reservation.service;

import com.urbanlt.reservation.dto.member.MemberRequestDTO;
import com.urbanlt.reservation.entity.Member;

import java.net.http.HttpHeaders;

public interface MemberService {
    Member getMemberById(Long id);
    Member getMemberByEmail(String email);
    Member getMemberList(MemberRequestDTO.GetList request);
    HttpHeaders login(MemberRequestDTO.Login request);

    void logout();
}
