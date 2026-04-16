package com.app.rest.domain.vo;

import com.app.rest.domain.dto.PostCreateRequestDTO;
import com.app.rest.domain.dto.PostUpdateRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private int postReadCount;

    // 게시글 작성 DTO
    public static PostVO from(PostCreateRequestDTO postCreateRequestDTO){
        PostVO postVO = new PostVO();
        postVO.setPostTitle(postCreateRequestDTO.getPostTitle());
        postVO.setPostContent(postCreateRequestDTO.getPostContent());
        return postVO;
    }

    // 게시글 수정 DTO
    public static PostVO from(PostUpdateRequestDTO postUpdateRequestDTO){
        PostVO postVO = new PostVO();
        postVO.setPostTitle(postUpdateRequestDTO.getPostTitle());
        postVO.setPostContent(postUpdateRequestDTO.getPostContent());
        return postVO;
    }
}
