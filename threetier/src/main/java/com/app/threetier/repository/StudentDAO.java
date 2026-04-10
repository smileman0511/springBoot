package com.app.threetier.repository;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import com.app.threetier.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// FM
// Mapper, DAO는 Optional로 감싸지 않는다.
// 유지보수나 비즈니스 로직에 혼란을 야기할 수 있음.

@Repository
@RequiredArgsConstructor
public class StudentDAO {
    private final StudentMapper studentMapper;

    //    학생 추가
    public void save(StudentVO studentVO){
        studentMapper.insert(studentVO);
    }

    //    학생 전체 조회
    public List<StudentDTO> findAll(){
        return studentMapper.selectAll();
    }

    //    학생 단일 조회
    public StudentDTO findById(Long id){
        return studentMapper.select(id);
    }

    //    학생 정보 수정
    public void update(StudentVO studentVO){
        studentMapper.update(studentVO);
    }

    //    학생 정보 삭제
    public void delete(Long id){
        studentMapper.delete(id);
    }


}
