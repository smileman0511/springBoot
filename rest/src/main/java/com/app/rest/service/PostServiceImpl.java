package com.app.rest.service;

import com.app.rest.domain.dto.PostCreateRequestDTO;
import com.app.rest.domain.dto.PostDTO;
import com.app.rest.domain.dto.PostUpdateRequestDTO;
import com.app.rest.domain.vo.PostVO;
import com.app.rest.exception.PostException;
import com.app.rest.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    // 모든 게시글 조회
    @Override
    public List<PostDTO> getAllPosts() {
        return postDAO.findAll();
    }

    @Override
    public PostDTO getPost(Long id) {
        return postDAO.findById(id)
                .orElseThrow(() -> {
                    throw new PostException("게시글을 찾을 수 없습니다.");
                });
    }

    @Override
    public void createPost(PostCreateRequestDTO postCreateRequestDTO, Long memberId){
        PostVO postVO = PostVO.from(postCreateRequestDTO);
        postVO.setMemberId(memberId);
        postDAO.create(postVO);
    }

    @Override
    public void updatePost(PostUpdateRequestDTO postUpdateRequestDTO, Long id){
        PostVO postVO = PostVO.from(postUpdateRequestDTO);
        postVO.setId(id);
        postDAO.update(postVO);
    }

    @Override
    public void deletePost(Long id){
        postDAO.delete(id);
    }
}
