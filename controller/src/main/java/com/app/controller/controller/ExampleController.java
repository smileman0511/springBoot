package com.app.controller.controller;

import com.app.controller.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@Slf4j
@RequestMapping("/ex/*")
public class ExampleController {
    private final MemberVO memberVO;
    private String names;

    public ExampleController(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    //    doGet과 똑같다고 생각하면 된다.
    @GetMapping("/ex01")
    public String ex01(String name, int age){
        log.info("ex01 응답완료");
        log.info("name : {}, age : {}, realAge {}", name, age, age - 1);


        // ex01.html
        // ex01 -> templates/ex01.html
        // ex/ex/ex01 -> templates/ex/ex/ex01.html
        // 응답되는 페이지의 파일 경로
        return "ex01";
    }

    // 실습!
    // GET방식으로 데이터를 어떻게 보내야 하는가?
    // 이름과 나이를 요청보내고,
    // 이름과 나이, 만 나이를 로그에 출력하기
    @PostMapping("/ex01")
    public String ex01Post(String name, int age){
        log.info("name : {}, age : {}, realAge : {}", name, age, age - 1);
        return "ex01";
    }

    // model 객체를 이용해서 페이지를 보낸다. return은 페이지의 경로.
    @GetMapping("ex02")
    public String ex02(String name, Model model){
        model.addAttribute("name", name);
        return "ex02";
    }

    @GetMapping("ex03")
    public String ex03(Model model){
        // 1. "홍길동", "장보고", "이순신"을 리스트에 담고
        // 2. 화면에 보낸 후 반복문으로 출력하기 -> ex03.html에서 작성
        ArrayList<String> names = new ArrayList<>(Arrays.asList("홍길동", "장보고", "이순신"));
        model.addAttribute("names", names);
        return "ex03";
    }

    // ModelAttribute: 반드시 쿼리스트링 값을 전달해야한다.
    @GetMapping("ex04")
    public String ex04(@ModelAttribute("name") String name){
        return "ex04";
    }

    // ex05
    // Model 어노테이션 활용! Attribute
    // 이름, 취미를 받고
    // 화면에
    // 이름: OOO
    // 취미: OOO으로 출력하기
    @GetMapping("ex05")
    public String ex05(
            @ModelAttribute("name") String name,
            @ModelAttribute("hobby") String hobby
    ){
        return "ex05";
    }

    @GetMapping("ex06")
    public String goToEx06(){
        return "ex06";
    }

    @GetMapping("ex06-complete")
    public String goToEx06Complete(@ModelAttribute("memberName") String memberName){
        return "ex06-complete";
    }

    @PostMapping("ex06")
    public String ex06(MemberVO memberVO){
        log.info("응답 들어옴!");
        log.info("memberVO : {}", memberVO);
//        return "redirect:/ex/ex06-complete?memberName=" + memberVO.getMemberName();
        return "redirect:/ex/ex06-complete";
    }

    // 테이블 - VO - config - mapper - 인터페이스 매퍼 - 컨트롤러
    
    // QA 단계: 쿼리 - config - mapper - 인터페이스 - 단위테스트


}
