package com.kellylyke.service.finance;

import com.kellylyke.service.FinanceService;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertNotNull;


public class FinanceServiceTest {
    @Test
    public void getFinancialData() throws Exception {

        String id = "N00004367";
        FinanceService fs = new FinanceService();
        Contributors contributors = fs.getFinancialDataForCandidate(id);
        assertNotNull(contributors);

    }


}
