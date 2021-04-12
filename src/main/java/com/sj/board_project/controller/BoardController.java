package com.sj.board_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @GetMapping(value = "/main")
    public String main(@RequestParam(name = "idx", defaultValue = "1") int idx) {
        return "board/board_main";
    }

}
