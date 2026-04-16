package com.app.rest.service;

import com.app.rest.domain.dto.PostCreateRequestDTO;
import com.app.rest.domain.dto.PostDTO;
import com.app.rest.domain.dto.PostUpdateRequestDTO;
import com.app.rest.domain.vo.PostVO;

import java.util.List;

public interface PostService {
    // 모든 게시글 조회
    public List<PostDTO> getAllPosts();

    // 게시글 상세 조회
    public PostDTO getPost(Long id);

    // 게시글 추가
    public void createPost(PostCreateRequestDTO postCreateRequestDTO, Long memberId);

    public void updatePost(PostUpdateRequestDTO postUpdateRequestDTO, Long id);

    public void deletePost(Long id);
}
