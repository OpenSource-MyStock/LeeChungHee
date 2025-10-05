package com.example.test_assign.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private String title;
    private String content;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    public BoardEntity(String title, String text){
        this.title = title;
        this.content = text ;
    }
    @PrePersist
    public void createTime(){
        this.createdAt = LocalDateTime.now();
    }
}
