package com.app.threetier.service;

import com.app.threetier.domain.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    @Test
    public void resisterTest() {
        TaskVO taskVO = new TaskVO();
        taskVO.setStudentName("이순신");
        taskVO.setScoreKor(100L);
        taskVO.setScoreMath(90L);
        taskVO.setScoreEng(80L);

        taskService.resister(taskVO);
        log.info("저장 완료");
    }
}