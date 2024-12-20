package com.apurba.in.ex03_testNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class apitesting014_TestNGroup {
    @Test(groups = {"sanity", "qa","prod", "P0"})
    public void sanityRun() {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"reg", "P1"})
    public void RegRun() {
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"qa", "P0"})
    public void SmokeRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

}
