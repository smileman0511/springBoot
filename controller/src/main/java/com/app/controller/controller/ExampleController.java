package com.app.controller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@Slf4j
@RequestMapping("/ex/*")
public class ExampleController {
    private String names;

//    doGet과 똑같다고 생각하면 된다.
/*
    @GetMapping("/ex01")
    public String ex01(){
        log.info("ex01 응답완료");
        log.info("name : {}, age : {}, realAge {}", name, age, age - 1);

        // 실습!
        // GET방식으로 데이터를 어떻게 보내야 하는가?
        // 이름과 나이를 요청보내고,
        // 이름과 나이, 만 나이를 로그에 출력하기

        // ex01.html
        // ex01 -> templates/ex01.html
        // ex/ex/ex01 -> templates/ex/ex/ex01.html
        // 응답되는 페이지의 파일 경로
        return "ex01";
    }
*/

    @PostMapping("/ex01")
    public String ex01Post(String name, int age){
        log.info("name : {}, age : {}, realAge : {}", name, age, age - 1);
        return "ex01";
    }

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
    public String ex05(@ModelAttribute("name") String name, @ModelAttribute("hobby") String hobby){
        return "ex05";
    }


}
