package com.app.threetier.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentVO {
    private Long id;
    private String studentName;
    private Integer kor;
    private Integer eng;
    private Integer math;


//    scoreEng까지만 VO이다.
//    밑에 total과 average는 +@된 컬럼이라서
//    DTO로 들어가야함.

//    private Integer total;
//    private Double average;
}
