package com.app.rest.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostUpdateRequestDTO {
    private String postTitle;
    private String postContent;
}
