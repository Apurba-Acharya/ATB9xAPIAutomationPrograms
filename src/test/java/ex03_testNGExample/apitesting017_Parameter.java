package ex03_testNGExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class apitesting017_Parameter {

    @Parameters ("browser")
    @Test
    public void demo1(String value){
        System.out.println("browser is " + value);
        if (value.equalsIgnoreCase("chrome")){
            System.out.println("Start chrome");
        }
        if (value.equalsIgnoreCase("firefox")){
            System.out.println("Start firefox");
        }
    }

}
