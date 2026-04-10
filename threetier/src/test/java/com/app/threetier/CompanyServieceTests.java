package com.app.threetier;

import com.app.threetier.domain.vo.CompanyVO;
import com.app.threetier.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CompanyServieceTests {

    @Autowired
    private CompanyService companyService;

    @Test
    public void registerCommuteStatus(){
        CompanyVO companyVO = new CompanyVO();
        companyVO.setCompanyName("코리아IT");
        companyVO.setGetToWorkDateTime("2026-04-10 11:00:00");

        companyService.registerCommuteStatus(companyVO);
    }
}
