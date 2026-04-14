package com.app.restful.domain.dto;

import com.app.restful.domain.vo.MemberVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema
public class MemberResponseDTO {
    @Schema(description = "회원 번호", required = true, example = "1")
    private Long id;
    @Schema(description = "회원 이메일" ,required = true, example = "test123@gmail.com")
    private String memberEmail;
    // required는 테이블에서 NOT NULL인 것에만 필요함. 또는 파라미터로 반드시 넘겨야 하는 값들.
    @Schema(description = "회원 이름", example = "홍길동")
    private String memberName;

//    정적 팩토리 메서드
    public static MemberResponseDTO from(MemberVO memberVO) {
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        memberResponseDTO.setId(memberVO.getId());
        memberResponseDTO.setMemberEmail(memberVO.getMemberEmail());
        memberResponseDTO.setMemberName(memberVO.getMemberName());
        return memberResponseDTO;
    }
}
