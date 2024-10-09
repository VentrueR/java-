package test.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/9/1 16:50
 **/
public class testBigDecimal {
    public static void main(String[] args) {

    double a = 0.1;
    double b = 0.2;
    System.out.println(a+b);

    BigDecimal bigDecimala = BigDecimal.valueOf(a);
    BigDecimal bigDecimalb = BigDecimal.valueOf(b);
    BigDecimal bigDecimalc;
        //add
        bigDecimalc = bigDecimala.add(bigDecimalb);
        System.out.println(bigDecimalc);
        //divide
        bigDecimalc = bigDecimala.divide(bigDecimalc, 3, RoundingMode.HALF_UP);
        System.out.println(bigDecimalc);
        //subtraction
        bigDecimalc = bigDecimala.subtract(bigDecimalb);
        System.out.println(bigDecimalc);
        //multiply
        bigDecimalc = bigDecimala.multiply(bigDecimalb);
        System.out.println(bigDecimalc);

        //System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
