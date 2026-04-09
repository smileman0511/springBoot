package com.app.threetier.controller;

import com.app.threetier.domain.vo.TaskVO;
import com.app.threetier.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/resister")
    public String resister(TaskVO taskVO) {
        return "tasks/resister";
    }

    @GetMapping("/result")
    public String result(TaskVO taskVO) {
        return "tasks/result";
    }

    @PostMapping("/result")
    public String result(TaskVO taskVO, Model model) {
        taskService.resister(taskVO);
        model.addAttribute("taskVO", taskVO);
        return "tasks/result";
    }
}