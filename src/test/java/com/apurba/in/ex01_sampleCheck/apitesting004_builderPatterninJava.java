package com.apurba.in.ex01_sampleCheck;

public class apitesting004_builderPatterninJava {
    public apitesting004_builderPatterninJava step1(){
        System.out.println("Step 1");
        return this;
    }
    public apitesting004_builderPatterninJava step2(){
        System.out.println("Step 2");
        return this;
    }
    public apitesting004_builderPatterninJava step3(String param1){
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        apitesting004_builderPatterninJava bp = new apitesting004_builderPatterninJava();
        bp.step1().step2().step3("hello");
    }
}