package com.kellylyke.service.congress;



import com.kellylyke.service.MemberService;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertNotNull;


public class MemberServiceTest {

    @Test
    public void testGetMember() throws Exception {
       MemberService ms = new MemberService();
       MembersItem member = ms.getSpecificMember("Baldwin").get(0);
       assertNotNull(member);

    }


}



