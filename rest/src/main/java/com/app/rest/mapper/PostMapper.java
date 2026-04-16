package com.app.rest.mapper;

import com.app.rest.domain.dto.PostCreateRequestDTO;
import com.app.rest.domain.dto.PostDTO;
import com.app.rest.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    // 모든 게시글 조회
    public List<PostDTO> selectAll();

    // 게시글 상세 조회
    public PostDTO select(Long id);

    // 게시글 추가
    public void insert(PostVO postVO);

    // 게시글 수정
    public void update(PostVO postVO);

    // 게시글 삭제
    public void delete(Long id);

}
