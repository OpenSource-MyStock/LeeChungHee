package com.example.test_assign.controller;

import com.example.test_assign.dao.BoardService;
import com.example.test_assign.memberDTO.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    private BoardService service ;

    @Autowired
    public BoardController(BoardService service){
        this.service = service ;
    }

    @GetMapping(value = "/")
    public String board(Model model){
        List<BoardDTO> list = service.getList();
        for(BoardDTO e : list){
            System.out.println(e.toString());
        }
        model.addAttribute("boards", list);
        return "boardlist";
    }
    @GetMapping(value = "/boardtext")
    public String baord1(){
        return "boardtext";
    }

    @PostMapping(value = "addquestion")
    public String add(@RequestParam String text, String title){
        service.add(title, text);
        return "boardlist";
    }
}
