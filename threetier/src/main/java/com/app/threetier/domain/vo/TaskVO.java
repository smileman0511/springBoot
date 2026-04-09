package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {
    private Long id;
    private String studentName;
    private Long scoreKor;
    private Long scoreMath;
    private Long scoreEng;
}
