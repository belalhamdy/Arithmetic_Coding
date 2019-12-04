package com.company;
import javax.swing.*;
import java.math.BigDecimal;
import java.util.Scanner;

import static com.company.ArithmeticCoding.MAX_CHARACTERS;

public class Main {

    private static Scanner in = new Scanner(System.in);
    public static GUI myGUI;
    public static void main(String[] args) {
      /*  String testCase = "bill gates";
//      System.out.println(TestCaseBuilder.buildCase(System.in,System.out));
        System.out.println("Welcome to Arithmetic floating point Encoder/Decoder");
        while (true) {
            System.out.println("\n1- Encode\n2- Decode\nAny other character will halt");
            String c = in.nextLine();
            if (c.equals("1")) {
                System.out.println("Enter the text line to encode");
                String text = in.nextLine();
                try {
                    ArithmeticCoding.setProbabilities(getProbabilities());
                   String encoded = ArithmeticCoding.Encode(text);
                   // String encoded = ArithmeticCoding.Encode(text);
                    System.out.println("Encoded Text : " + encoded);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            } else if (c.equals("2")) {
                System.out.println("Enter the encoded bits to decode");
                String text = in.nextLine();
                try {
//                    ArithmeticCoding.setProbabilities(getProbabilities());
                    String decoded = ArithmeticCoding.Decode(text,text.length());
                    System.out.println("Decoded Text : " + decoded);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            } else break;
        }*/

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        myGUI = new GUI();
    }
    static BigDecimal[] getProbabilities(){
        Scanner i = new Scanner(System.in);
        BigDecimal[] ret = new BigDecimal[MAX_CHARACTERS];
        for (int f = 0 ; f<ret.length ; ++f)
        {
            ret[f] = new BigDecimal(0);
        }
        ret['a'] = new BigDecimal(0.8);
        ret['b'] = new BigDecimal(0.02);
        ret['c'] = new BigDecimal(0.18);
        //----------------------
//        ret[' '] = new BigDecimal("0.1");
//        ret['a'] = new BigDecimal("0.1");
//        ret['b'] = new BigDecimal("0.1");
//        ret['e'] = new BigDecimal("0.1");
//        ret['g'] = new BigDecimal("0.1");
//        ret['i'] = new BigDecimal("0.1");
//        ret['l'] = new BigDecimal("0.2");
//        ret['s'] = new BigDecimal("0.1");
//        ret['t'] = new BigDecimal("0.1");
//        return ret;
        /*while(true) {
            System.out.println("Enter character and it's probability of occurrence (-ve prob to halt)");
            char c = i.next().charAt(0);
            String p = i.next();
            if (Double.parseDouble(p)<0) return ret;
            System.out.println(c +" " +p);
            ret[c] = new BigDecimal(p);
        }*/
        return ret;
    }
}
