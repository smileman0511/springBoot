package com.app.restful.api;

import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public MemberResponseDTO getMemberInfo(@PathVariable Long id){
        Optional<MemberResponseDTO> foundMember = memberService.getMemberInfo(id);
        if(foundMember.isPresent()){
            return foundMember.get();
        }
        return new MemberResponseDTO();
    }

    @GetMapping("/list")
    public List<MemberResponseDTO> getMemberInfoList(){
        return memberService.getMemberInfoList();
    }
}