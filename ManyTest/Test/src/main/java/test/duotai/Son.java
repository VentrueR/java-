package test.duotai;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/10/16 9:23
 **/
public class Son extends Father {
    public static int b = 1;
    public int c = 1;
    public static void f(){
        System.out.println("static Son");
    }
    public void g() {
        System.out.println("Son");
    }
    public void gg()
    {
        System.out.println("gg");
    }
    public int getC() {
        return c;
    }
}
