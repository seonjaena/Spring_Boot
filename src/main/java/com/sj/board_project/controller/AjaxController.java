package com.sj.board_project.controller;

import com.sj.board_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AjaxController {

    private final UserService userService;

    @GetMapping(value = "/user/checkUserIdExist")
    public String checkUserIdExist(@RequestParam(name = "user_id") String user_id) {
        return userService.checkUserIdExist(user_id);
    }

    @GetMapping(value = "/user/checkUserNickNameExist")
    public String checkUserNickNameExist(@RequestParam(name = "user_nickname") String user_nickname) {
        return userService.checkUserNickNameExist(user_nickname);
    }

}
