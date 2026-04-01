package com.app.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // test를 위한 클래스
@Slf4j // log에 결과를 출력
public class ComputerTest {

    @Autowired @Qualifier("desktop")
    private Computer computer;

    @Test
    public void laptopTest(){
        log.info("computer : {}", computer);
        log.info("computer.getScreenSize() : {}", computer.getScreenSize());
    }



}
