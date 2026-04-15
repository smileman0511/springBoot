package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class PostServiceTests {

    @Autowired
    private PostService postService;

    @Test
    public void insertPostTest() {
        PostVO postVO = new PostVO();
        postVO.setPostTitle("테스트 제목 등록");
        postVO.setPostContent("테스트 내용 등록");
        postVO.setMemberId(1L);
        postVO.setPostReadCount(10);
        postService.registerPost(postVO);
    }

    @Test
    public void getAllPostsTest(){
        List<PostListRequestDTO> postDTO = postService.getAllPosts();
        postDTO.forEach(post -> {
            log.info(post.toString());
        });
    }

    @Test
    public void getPostByIdTest(){
        PostDTO postDTO = postService.getPostById(1L);
        log.info(postDTO.toString());
    }

    @Test
    public void updatePostTest(){
        PostVO postVO = new PostVO();
        postVO.setId(61L);
        postVO.setPostTitle("업데이트 서비스 제목 테스트");
        postVO.setPostContent("업데이트 서비스 내용 테스트");
        postService.updatePost(postVO);
        log.info(postService.getPostById(61L).toString());
    }

    @Test
    public void deletePostTest(){
        postService.deletePost(63L);
    }

    @Test
    public void deletePostByMemberIdTest(){
        postService.deletePostByMemberId(2L);
    }


























}
