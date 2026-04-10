package com.app.threetier.mapper;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// mapper.xml의 id와 메서드 이름이 똑같아야 한다.

@Mapper
public interface StudentMapper {
    //    학생 추가
    public void insert(StudentVO studentVO);

    //    학생 전체 조회
    public List<StudentDTO> selectAll();

    //    학생 단일 조회
    public StudentDTO select(Long id);

    //    학생 정보 수정
    public void update(StudentVO studentVO);

    //    학생 정보 삭제
    public void delete(Long id);

}


