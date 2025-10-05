package com.example.test_assign.memberDTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private String title;
    private String content;
    private int rid;
    private LocalDateTime createAt ;
}
