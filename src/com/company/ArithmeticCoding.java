package com.company;

import javafx.util.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ArithmeticCoding {
    static final int MAX_CHARACTERS = 256;
    static final char EOF = '\0';
    static final BigDecimal ZERO = new BigDecimal(0);
    static BigDecimal lower, upper, range;
    static Map<Character, Pair<BigDecimal, BigDecimal>> dict;

    static void init() {
        lower = new BigDecimal(0);
        upper = new BigDecimal(1);
        range = new BigDecimal(1);
    }

    public static void setProbabilities(BigDecimal[] prob) {
        dict = new HashMap<>();
        BigDecimal[] cumulative = new BigDecimal[MAX_CHARACTERS];
        cumulative[0] = prob[0];
        for (int i = 1; i < MAX_CHARACTERS; ++i) {
            cumulative[i] = cumulative[i - 1].add(prob[i]);
            if (prob[i].compareTo(ZERO) != 0) {
                dict.put((char) (i), new Pair<>(cumulative[i - 1], cumulative[i]));
            }
        }
    }

    public static String Encode(String data) {
        init();
        char current;
        for (int i = 0; i < data.length(); ++i) {
            current = data.charAt(i);
            upper = lower.add(range.multiply(getHighRange(current)));
            lower = lower.add(range.multiply(getLowRange(current)));
            range = upper.subtract(lower);
        }
        return DecimalToFloat(lower, upper);
    }

    public static String Decode(String data,int numberOfSteps) throws Exception {
        init();
        BigDecimal value = new BigDecimal(FloatToDecimal(data));
        StringBuilder ret = new StringBuilder();
        while (numberOfSteps-- > 0){
            Map.Entry<Character, Pair<BigDecimal, BigDecimal>> curr = findByValue(value);


            ret.append(curr.getKey());
            lower = curr.getValue().getKey();
            upper = curr.getValue().getValue();
            range = upper.subtract(lower);
            value = value.subtract(lower).divide(range, RoundingMode.HALF_UP);
        }
        return ret.toString();
    }

    static BigDecimal getLowRange(char s) {
        return dict.get(s).getKey();
    }

    static BigDecimal getHighRange(char s) {
        return dict.get(s).getValue();
    }

    static Map.Entry<Character, Pair<BigDecimal, BigDecimal>> findByValue(BigDecimal val) throws Exception {
        for (Map.Entry<Character, Pair<BigDecimal, BigDecimal>> curr : dict.entrySet()) {
            Pair<BigDecimal, BigDecimal> values = curr.getValue();
            int lowCmp = val.compareTo(values.getKey());
            int highCmp = val.compareTo(values.getValue());
            if (lowCmp >= 0 && highCmp<= 0) return curr;
        }
        throw new Exception("Character is not found");
    }

    static String DecimalToFloat(BigDecimal low, BigDecimal high) {
        long one = 1;
        int idx = 1;
        double num = 0;
        StringBuilder ret = new StringBuilder();
        while (true) {
            int lowCmp = low.compareTo(new BigDecimal(num));
            int highCmp = high.compareTo(new BigDecimal(num));
            if (lowCmp > 0) {
                num += 1 / (double) (one << idx);
                ret.append(1);
            } else if (highCmp < 0) {
                num -= 1 / (double) (one << idx);
                ret.replace(ret.length() - 1, ret.length(), "01");
            } else {
                return ret.toString();
            }
            ++idx;
        }
    }

    static double FloatToDecimal(String val) {
        double ret = 0;
        long one = 1;
        for (int i = 0; i < val.length(); ++i) {
            if (val.charAt(i) == '1') ret += 1 / (double) (one << (i + 1));
        }
        return ret;
    }
}
