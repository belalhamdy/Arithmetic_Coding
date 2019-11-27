package com.company;

import java.math.BigDecimal;
import java.nio.file.Path;

public class ArithmeticCoding {
    static final int MAX_CHARACTERS = 256;
    static BigDecimal lower,upper,range,value;
    static BigDecimal[] cumulative;
    static void init(double[] prob) {
        lower = new BigDecimal(0);
        upper = new BigDecimal(0);
        range = new BigDecimal(0);
        cumulative = new BigDecimal[MAX_CHARACTERS];
        assert prob.length == MAX_CHARACTERS;


    }

    public static String Encode(String data,double[] prob) {
        init(prob);

        return null;
    }

    public static String Decode(String data,double[] prob) {
        init(prob);
        return null;
    }
    static BigDecimal getLowRange(char s){
        return null;
    }
    static BigDecimal getHighRange(char s){
        return null;
    }
    static char findByValue(BigDecimal val){
        return '\0';
    }
    static String DecimalToFloat (BigDecimal val)
    {
        return null;
    }
    static BigDecimal FloatToDecimal (String val)
    {
        return null;
    }
}
