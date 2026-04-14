package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.repository.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    @Test
    public void getMember(){
        log.info("memberService: {}", memberService.getMemberInfo(1L));
    }

    @Test
    public void insertMemberTest(){
        MemberJoinRequestDTO memberJoinRequestDTO = new MemberJoinRequestDTO();
        memberJoinRequestDTO.setMemberEmail("test145@gmail.com");
        memberJoinRequestDTO.setMemberPassword("1234");
        memberJoinRequestDTO.setMemberName("장길동");
        memberService.join(memberJoinRequestDTO);
    }

    @Test
    public void memberUpdateTest(){
        MemberUpdateRequestDTO memberUpdateRequestDTO = new MemberUpdateRequestDTO();
        memberUpdateRequestDTO.setMemberPassword("12345678");
        memberUpdateRequestDTO.setId(1L);
        memberUpdateRequestDTO.setMemberName("홍갈갈동");

        memberService.updateMember(memberUpdateRequestDTO);
    }

}
