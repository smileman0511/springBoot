package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    // 회원가입
    public void join(MemberJoinRequestDTO memberJoinRequestDTO);

    // 로그인
    public MemberResponseDTO login(MemberVO memberVO);

    // 회원 정보 조회
    public MemberResponseDTO getMemberInfo(Long id);

    // 회원 정보 전체 조회
    public List<MemberResponseDTO> getMemberInfoList();

    // 이메일 중복 확인
    public void checkMemberEmailDuplicate(String memberEmail);

    // 회원 정보 수정
    public void updateMember(MemberUpdateRequestDTO memberUpdateRequestDTO);

    // 회원 탈퇴
    public void withdraw(Long id);

    // 회원 비밀번호 변경(마이페이지)
    // 회원 비밀번호 변경
}
