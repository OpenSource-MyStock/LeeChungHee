package com.example.test_assign.dao;

import com.example.test_assign.entity.BoardEntity;
import com.example.test_assign.entity.ReplyEntity;
import com.example.test_assign.memberDTO.BoardDTO;
import com.example.test_assign.repository.BoardRepository;
import com.example.test_assign.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    private BoardRepository repo ;
    private ReplyRepository Replyrepo;

    @Autowired
    public BoardService(BoardRepository repo, ReplyRepository Replyrepo){
        this.repo = repo ;
        this.Replyrepo = Replyrepo;
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

    public BoardDTO findData(int id) {
        Optional<BoardEntity> entity = repo.findById(id);
        BoardEntity entityValue = entity.get();
        BoardDTO dto = new BoardDTO(entityValue.getTitle(), entityValue.getContent(), entityValue.getRid(), entityValue.getCreatedAt());
        return dto ;
    }

    public void addReply(String reply, int rid) {
        ReplyEntity entity = new ReplyEntity(rid, reply);
        Replyrepo.save(entity);
    }

    public List<String> findReplys(int id) {
        List<ReplyEntity> replys = Replyrepo.findReplysTo(id);
        List<String> list = new ArrayList<>();
        for(ReplyEntity e : replys){
            System.out.println("this is for service : " + e.getReply());
            list.add(e.getReply());
        }
        return list;


    }

//    @Transactional
//    List<ReplyEntity> findReplysTo(int id){
//        return Replyrepo.findReplysTo(id);
//    }
}
