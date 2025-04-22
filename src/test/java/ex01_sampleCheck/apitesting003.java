package ex01_sampleCheck;

public class apitesting003 {
    public  void step1(){
        System.out.println("Step 1");
    }
    public void step2(){
        System.out.println("Step 2");
    }
    public void step3(String param1){
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        apitesting003 np = new apitesting003();
        np.step1();
        np.step2();
        np.step3("atb9x");
    }

}
