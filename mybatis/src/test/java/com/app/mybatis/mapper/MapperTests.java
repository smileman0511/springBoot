package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PostMapperTests postMapperTests;

    @Test
    public void mapperTests(){
        log.info(timeMapper.getTime());
    }

    @Test
    public void mapperTest2(){
        log.info(timeMapper.getTime2());
    }

    @Test
    public void mapperTest3(){
        log.info(memberMapper.selectAll().toString());
    }

    @Test
    public void mapperTest4(){
        // 타입은 Optional MemberVO 타입
        memberMapper.select(1L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void insertTest(){
        MemberVO memberVO = new MemberVO();
//        memberVO.setMemberEmail("test789@gmail.com");
//        memberVO.setMemberPassword("test123!@#");
//        memberVO.setMemberName("장보고");
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("이순신");
        memberMapper.insert(memberVO);

    }

    @Test
    public void updateTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setId(27L);
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("장길동");

        memberMapper.select(27L).map(MemberVO::toString).ifPresent(log::info);
        memberMapper.update(memberVO);
        memberMapper.select(27L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void deleteTest(){
        memberMapper.delete(27L);
    }

}
