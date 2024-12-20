package com.apurba.in.ex03_testNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class apitesting018_alwaysrun {
    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = false)
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
