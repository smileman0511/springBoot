package com.app.rest.repository;

import com.app.rest.domain.dto.PostCreateRequestDTO;
import com.app.rest.domain.dto.PostDTO;
import com.app.rest.domain.vo.PostVO;
import com.app.rest.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    // 모든 게시글 조회
    public List<PostDTO> findAll() {
        return postMapper.selectAll();
    }

    // 게시글 상세 조회
    public Optional<PostDTO> findById(Long id) {
        return Optional.ofNullable(postMapper.select(id));
    }

    // 게시글 추가
    public void create(PostVO postVO){
        postMapper.insert(postVO);
    }

    // 게시글 수정
    public void update(PostVO postVO){
        postMapper.update(postVO);
    }

    // 게시글 삭제
    public void delete(Long id){
        postMapper.delete(id);
    }
}
