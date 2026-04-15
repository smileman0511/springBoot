package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.exception.PostException;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    // 게시글 작성
    @Override
    public void registerPost(PostVO postVO) {
        postDAO.save(postVO);
    }

    // 게시글 목록 조회
    @Override
    public List<PostListRequestDTO> getAllPosts(){
        return postDAO.findAll();
    }
    
    // 게시글 상세보기 조회
    @Override
    public PostDTO getPostById(Long id) {
        return postDAO
                .findById(id)
                .orElseThrow(() -> new PostException("게시글이 존재하지 않습니다."));
    }

    // 게시글 수정
    @Override
    public void updatePost(PostVO postVO) {
        postDAO.findById(postVO.getId())
                .orElseThrow(() -> new PostException("게시글이 존재하지 않습니다."));
        postDAO.update(postVO);
    }

    // 게시글 삭제
    @Override
    public void deletePost(Long id) {
        postDAO.findById(id)
                .orElseThrow(() -> new PostException("게시글이 존재하지 않습니다."));
        postDAO.delete(id);
    }

    // 게시글 삭제(탈퇴시)
    @Override
    public void deletePostByMemberId(Long memberId) {
        postDAO.deleteByMemberId(memberId);
    }












}