package com.app.threetier.service;

import com.app.threetier.domain.vo.TaskVO;
import com.app.threetier.exception.TaskException;
import com.app.threetier.mapper.TaskMapper;
import com.app.threetier.repository.TaskDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {TaskException.class, Exception.class})
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    public void resister(TaskVO taskVO) {
        taskDAO.insert(taskVO);
    }
}
