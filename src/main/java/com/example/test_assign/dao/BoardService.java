package com.example.test_assign.dao;

import com.example.test_assign.entity.BoardEntity;
import com.example.test_assign.memberDTO.BoardDTO;
import com.example.test_assign.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository repo ;

    @Autowired
    public BoardService(BoardRepository repo){
        this.repo = repo ;
    }
    public void add(String title, String text) {
        BoardEntity entity = new BoardEntity(title, text);
        repo.save(entity);
    }

    public List<BoardDTO> getList() {
        List<BoardEntity> list = repo.findAll();
        List<BoardDTO> dtos = new ArrayList<>();
        for(BoardEntity e : list){
            BoardDTO dto = new BoardDTO(e.getTitle(),e.getContent(), e.getRid(), e.getCreatedAt());
            dtos.add(dto);
        }
        return dtos;
    }
}
