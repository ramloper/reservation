package com.urbanlt.reservation.repository;

import com.urbanlt.reservation.core.enums.Gender;
import com.urbanlt.reservation.entity.Member;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;


    @BeforeEach
    public void setUp() throws Exception {
        String rawPassword = "Rladnfka12!@";
        String encodedPassword = "encodedPassword"; // 원하는 인코딩된 비밀번호로 변경
        when(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword);
        Member member = Member.builder()
                .id(1L)
                .loginId("test")
                .password(passwordEncoder.encode(rawPassword))
                .memberName("김우람")
                .phoneNumber("01012341234")
                .birthDate("19940906")
                .gender(Gender.MALE)
                .email("rla7360@nate.com")
                .profile("ttt")
                .role(Member.MemberRole.USER)
                .registrationId("nomal")
                .smsEnabled(true)
                .emailEnabled(true)
                .build();
        memberRepository.save(member);
    }

    @Nested
    @DisplayName("회원찾기")
    class findMember{
        @Test
        @DisplayName("ID로 찾기")
        void memberFindById(){
            //given

            //when

            //then
            Assertions.assertDoesNotThrow(() -> memberRepository.findById(1L));
        }

        @Test
        @DisplayName("eamil로 찾기")
        void memberFindByEmail(){
            //given

            //when

            //then
            Assertions.assertDoesNotThrow(() -> memberRepository.findByEmail("rla7360@gmail.com"));
        }

        @Test
        @DisplayName("회원 리스트")
        void memberListFind(){
            //given

            //when

            //then
            Assertions.assertDoesNotThrow(() -> memberRepository.findAll());
        }
    }


    @Test
    @DisplayName("회원저장")
    void memberSave(){
        //given
        String rawPassword = "Rladnfka12!@";
        String encodedPassword = "encodedPassword"; // 원하는 인코딩된 비밀번호로 변경
        when(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword);
        Member member = Member.builder()
                .loginId("rla7360")
                .password(passwordEncoder.encode(rawPassword))
                .memberName("김우람")
                .phoneNumber("01094333753")
                .birthDate("19940906")
                .gender(Gender.MALE)
                .email("rla7360@gmail.com")
                .profile("ttt")
                .role(Member.MemberRole.USER)
                .registrationId("nomal")
                .smsEnabled(true)
                .emailEnabled(true)
                .build();
        when(memberRepository.save(member)).thenReturn(member);
        //when
        Member result = memberRepository.save(member);
        //then
        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("회원실패")
    void memberSaveFailed(){
        //given
        Member member = Member.builder()
                .loginId("test")
                .password("123")
                .memberName("김우람")
                .phoneNumber("01094333753")
                .birthDate("19940906")
                .gender(Gender.MALE)
                .email("rla7360@gmail.com")
                .profile("ttt")
                .role(Member.MemberRole.USER)
                .registrationId("nomal")
                .smsEnabled(true)
                .emailEnabled(true)
                .build();

        //when
        Member result = memberRepository.save(member);

        //then
        assertThat(result).isNull();
    }
}
