package com.app.rest.service;

import com.app.rest.domain.dto.PostCreateRequestDTO;
import com.app.rest.domain.dto.PostDTO;
import com.app.rest.domain.dto.PostUpdateRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostServiceTests {

    @Autowired
    private PostService postService;

    @Test
    public void getAllPostsTest() {
        List<PostDTO> postDTO = postService.getAllPosts();
        log.info("postDTO : {}", postDTO);
    }

    @Test
    public void getPostTest(){
        PostDTO postDTO = postService.getPost(1L);
        log.info("postDTO : {}", postDTO);
    }

    @Test
    public void createPostTest(){
        PostCreateRequestDTO postCreateRequestDTO = new PostCreateRequestDTO();
        postCreateRequestDTO.setPostTitle("테스트 테스트");
        postCreateRequestDTO.setPostContent("내용 내용");
        postService.createPost(postCreateRequestDTO, 1212L);
    }

    @Test
    public void updatePostTest(){
        PostUpdateRequestDTO postUpdateRequestDTO = new PostUpdateRequestDTO();
        postUpdateRequestDTO.setPostTitle("아브라카타브라");
        postUpdateRequestDTO.setPostContent("볼드모트 사라져!");
        postService.updatePost(postUpdateRequestDTO, 82L);
    }

    @Test
    public void deletePostTest(){
        postService.deletePost(82L);
    }

}
