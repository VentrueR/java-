package test.duotai;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/10/16 9:23
 **/
public class test {
    public static void main(String[] args) {
        Father u = new Son();
        System.out.println(u.b);
        System.out.println(u.c);
        u.f();
        u.g();
        ((Son) u).gg();
/**
 * 0
 * 0 走的是父类引用
 * Static Father
 * Son
 */
        //Father father = new Father();
        Son son = new Son();
        System.out.println(son.b);
        System.out.println(son.c);
        son.f();
        son.g();
    }
}
