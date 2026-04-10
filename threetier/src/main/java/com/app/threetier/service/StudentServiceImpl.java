package com.app.threetier.service;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import com.app.threetier.repository.StudentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    //    학생 등록
    @Override
    public void registerStudent(StudentVO studentVO) {
        studentDAO.save(studentVO);
    }

    //    서비스단에서 Optional 처리
//    단일 객체라서 Optional로 감싸야 하는 건 아님
//    자바에서 쓰느냐, 화면에서 쓰느냐에 따라 다름
//    자바에서만 사용하면 Optional로 감싸지 않고 null 검사 진행
//    화면에서 사용하면 Optional로 감싸기
//    학생 단일 조회
    @Override
    public Optional<StudentDTO> getStudent(Long id) {
        return Optional.ofNullable(studentDAO.findById(id));
    }

    @Override
    public List<StudentDTO> getStudentList() {
        return studentDAO.findAll();
    }

    @Override
    public void updateStudent(StudentVO studentVO) {
        studentDAO.update(studentVO);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDAO.delete(id);
    }
}
