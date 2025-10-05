package com.example.test_assign.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reply")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private int id;
    private String reply;

    public ReplyEntity(int id, String reply){
        this.id = id;
        this.reply = reply;
    }
}
