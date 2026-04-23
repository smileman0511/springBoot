package com.app.oauth.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberPicture;
    private String memberName;
    private String memberNickname;

    {
//        초기화 블럭
        this.setMemberPicture("/default.jpg");
        this.setMemberNickname("개복치 1단계");
    }
}
