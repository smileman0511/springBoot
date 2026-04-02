package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
// RDB 중심 설계
public interface MemberMapper {
    public List<MemberVO> selectAll();

    // 1개만 조회하기.
    // 단일 객체면 Optional로 감싸라.
    public Optional<MemberVO> select(Long id);

    public void insert(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public void delete(Long id);
}
