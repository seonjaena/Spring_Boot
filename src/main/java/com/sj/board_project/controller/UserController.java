package com.sj.board_project.controller;

import com.sj.board_project.dto.user.JoinUserDto;
import com.sj.board_project.dto.user.LoginDto;
import com.sj.board_project.dto.user.SessionDto;
import com.sj.board_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/login")
    public String login(Model model, @RequestParam(name = "fail", defaultValue = "false") String fail) {
        model.addAttribute("loginUserDto", new LoginDto());
        model.addAttribute("fail", fail);
        return "user/login";
    }

    @PostMapping(value = "/login_do")
    public String login_do(@ModelAttribute(name = "loginUserDto") LoginDto loginUserDto, HttpSession session, Model model) {
        SessionDto loginUserSession = userService.login(loginUserDto.getUser_id(), loginUserDto.getUser_pw());
        if(loginUserSession == null) {
            model.addAttribute("msg", "[오류!] 아이디/비밀번호가 일치하지 않습니다");
            model.addAttribute("loc", "/user/login?fail=true");
        }else {
            session.setAttribute("loginUserSession", loginUserSession);
            model.addAttribute("msg", loginUserSession.getUser_nickname() + "님 환영합니다");
            model.addAttribute("loc", "/");
        }
        return "message";
    }

    @GetMapping(value = "/join")
    public String join(Model model) {
        model.addAttribute("joinUserDto", new JoinUserDto());
        return "user/join";
    }

    @PostMapping(value = "/join_do")
    public String join_do(@Valid @ModelAttribute(name = "joinUserDto") JoinUserDto joinUserDto, BindingResult result, Model model, Errors errors) {
        if(result.hasErrors()) {
            return "user/join";
        }
        userService.join(joinUserDto);
        model.addAttribute("msg", "회원가입이 완료되었습니다");
        model.addAttribute("loc", "/user/login");
        return "message";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("msg", "로그아웃이 완료되었습니다");
        model.addAttribute("loc", "/");
        return "message";
    }

}
