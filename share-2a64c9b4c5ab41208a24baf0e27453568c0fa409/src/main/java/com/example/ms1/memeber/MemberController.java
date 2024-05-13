package com.example.ms1.memeber;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup(MemberCreateForm memberCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        memberService.create(memberCreateForm.getUserId(),
                memberCreateForm.getPassword(), memberCreateForm.getNickname(),memberCreateForm.getEmail());

        return "redirect:/";
    }
}
