package com.app.threetier.service;

import com.app.threetier.domain.dto.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTests {
    @Autowired
    private PostService postService;

    @Test
    void getPostTest(){
        log.info("post: {}", postService.getPost(10L));
    }

    @Test
    void updatePostTest(){
        PostDTO postDTO = new PostDTO();

        postDTO.setId(1L);
        postDTO.setPostTitle("테스트 게시글!!!");
        postDTO.setPostContent("테스트 내용!!!");

        PostDTO updatedPost = postService.updatePost(postDTO);

        log.info("post: {}", updatedPost);
    }
}