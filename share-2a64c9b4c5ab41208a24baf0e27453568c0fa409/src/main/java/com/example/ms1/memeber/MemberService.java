package com.example.ms1.memeber;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member create(String userId, String password, String nickname, String email){
        Member member = new Member();
        member.setUserId(userId);
        member.setPassword(passwordEncoder.encode(password));
        member.setNickname(nickname);
        member.setEmail(email);
        member.setCreateDate(LocalDateTime.now());

        return memberRepository.save(member);
    }
}
