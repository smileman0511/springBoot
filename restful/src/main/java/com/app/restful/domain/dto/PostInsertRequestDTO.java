package com.app.restful.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostInsertRequestDTO {
    private String postTitle;
    private String postContent;
    private Long memberId;
}
