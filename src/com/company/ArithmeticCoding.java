package com.company;

import java.math.BigDecimal;

public class ArithmeticCoding {
    static final int MAX_CHARACTERS = 256;
    static BigDecimal lower,upper,range;
    static BigDecimal[] cumulative;
    static void init() {
        lower = new BigDecimal(0);
        upper = new BigDecimal(0);
        range = new BigDecimal(0);
    }
    public static void setProbabilities(double[] prob)
    {
        // @TODO: build frequency array
        cumulative = new BigDecimal[MAX_CHARACTERS];
        assert prob.length == MAX_CHARACTERS;
    }
    public static String Encode(String data) {
        init();
        BigDecimal value = new BigDecimal(0);
        return null;
    }

    public static String Decode(String data) {
        init();
        BigDecimal value = FloatToDecimal(data);
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
