package com.urbanlt.reservation.service;

import com.urbanlt.reservation.entity.Member;
import com.urbanlt.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

}
