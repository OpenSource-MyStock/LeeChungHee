package com.example.test_assign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping(value = "/")
    public String board(){
        return "board" ;
    }
}
