package com.urbanlt.reservation.service.impl;

import com.urbanlt.reservation.dto.member.MemberRequestDTO;
import com.urbanlt.reservation.entity.Member;
import com.urbanlt.reservation.repository.MemberRepository;
import com.urbanlt.reservation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.http.HttpHeaders;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    @Override
    public Member getMemberById(Long id) {
        return null;
    }

    @Override
    public Member getMemberByEmail(String email) {
        return null;
    }

    @Override
    public Member getMemberList(MemberRequestDTO.GetList request) {
        return null;
    }

    @Override
    public HttpHeaders login(MemberRequestDTO.Login request) {
        return null;
    }

    @Override
    public void logout() {

    }
}
