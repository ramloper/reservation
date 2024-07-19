package com.urbanlt.reservation.service;


import com.urbanlt.reservation.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;
    @Mock
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원중복으로 인해 회원가입실패")
    public void memberJoinFailDuplicate(){

    }

    @Test
    @DisplayName("회원중복으로 인해 이메일검증실패")
    public void memberJoinFailEmail(){

    }
}
