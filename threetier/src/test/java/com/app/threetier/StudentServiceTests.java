package com.app.threetier.service;

import com.app.threetier.domain.vo.StudentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudentServiceTests {

    //    Autowired는 주입 시점이 테스트단
    @Autowired
    private StudentService studentService;

    @Test
    public void addStudentTest(){
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentName("test");
        studentVO.setEng(30);
        studentVO.setMath(40);
        studentVO.setKor(50);
        studentService.registerStudent(studentVO);
        log.info("studentService : {}", studentService.getStudent(studentVO.getId()));
    }

    @Test
    public void updateStudentTest(){
        log.info("studentService : {}", studentService.getStudent(3L));
        StudentVO studentVO = new StudentVO();
        studentVO.setId(3L);
        studentVO.setStudentName("규호");
        studentVO.setEng(90);
        studentVO.setMath(70);
        studentVO.setKor(100);
        studentService.updateStudent(studentVO);
        log.info("studentService : {}", studentService.getStudent(3L));
    }

    @Test
    public void deleteStudentTest(){
        studentService.deleteStudent(3L);
    }


}
