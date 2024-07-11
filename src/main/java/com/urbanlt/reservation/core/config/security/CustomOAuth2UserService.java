package com.urbanlt.reservation.core.config.security;

import com.urbanlt.reservation.entity.Member;
import com.urbanlt.reservation.repository.MemberRepository;
import jakarta.security.auth.message.AuthException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 1. 유저 정보(attributes) 가져오기
        Map<String, Object> oAuth2UserAttributes = super.loadUser(userRequest).getAttributes();

        // 2. resistrationId 가져오기 (third-party id)
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // 3. userNameAttributeName 가져오기
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        // 4. 유저 정보 dto 생성
        OAuth2UserInfo oAuth2UserInfo = null;
        try {
            oAuth2UserInfo = OAuth2UserInfo.of(registrationId, oAuth2UserAttributes);
        } catch (AuthException e) {
            throw new RuntimeException(e);
        }

        // 5. 회원가입 및 로그인
        Member member = getOrSave(oAuth2UserInfo,registrationId);

        // 6. OAuth2User로 반환
        return new PrincipalDetails(member, oAuth2UserAttributes, userNameAttributeName);
    }

    private Member getOrSave(OAuth2UserInfo oAuth2UserInfo, String registrationId) {
        // 1. OAuth2UserInfo에서 이메일을 통해 회원을 조회합니다.
        Optional<Member> existingMemberOptional = Optional.ofNullable(memberRepository.findByEmail(oAuth2UserInfo.email()));

        if (existingMemberOptional.isPresent()) {
            // 2. 이미 존재하는 회원이면 조회된 회원 엔티티를 반환합니다.
            return existingMemberOptional.get();
        } else {
            // 3. 존재하지 않는 경우, 새로운 회원 엔티티를 생성하고 저장한 후 반환합니다.
            Member newMember = oAuth2UserInfo.toEntity(registrationId);
            return memberRepository.save(newMember);
        }
    }
}
