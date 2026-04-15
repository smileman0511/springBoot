package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.domain.vo.PostVO;

import java.util.List;

public interface PostService {

    // 게시글 작성 서비스
    public void registerPost(PostVO postVO);

    // 게시글 목록 조회 서비스
    public List<PostListRequestDTO> getAllPosts();

    // 게시글 상세보기 조회 서비스
    public PostDTO getPostById(Long id);

    // 게시글 수정 서비스
    public void updatePost(PostVO postVO);

    // 게시글 삭제 서비스
    public void deletePost(Long id);

    // 게시글 삭제(탈퇴시) 서비스
    public void deletePostByMemberId(Long memberId);



}
