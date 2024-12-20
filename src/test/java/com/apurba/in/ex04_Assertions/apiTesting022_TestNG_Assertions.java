package com.apurba.in.ex04_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class apiTesting022_TestNG_Assertions {
    @Test
    public void test_hardassertion(){
        System.out.println("Start");
        Boolean is_Neeru = false;
        //Assert.assertTrue(is_Neeru);
        System.out.println("End");

        Assert.assertEquals("Pramod","Pramod");
    }
    @Test
    public void test_softassertions(){
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(false);
        System.out.println("execute ths line");
        sa.assertAll(); //to report all collected errors
    }
}
