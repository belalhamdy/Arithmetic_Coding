package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
//      System.out.println(TestCaseBuilder.buildCase(System.in,System.out));
        System.out.println("Welcome to Standard & Modified Huffman Encoder/Decoder");
        while (true) {
            System.out.println("\n1- Encode by Standard huffman\n2- Encode by Modified huffman\n3- Decode\nAny other character will halt");
            String c = in.nextLine();
            double EPS = 1e-7;
            double minimumProbability = EPS*2;
            //double minimumProbability = 0.05;
            if (c.equals("1")) {
                System.out.println("Enter the text line to encode");
                String text = in.nextLine();
                try {
                    String encoded = ArithmeticCoding.Encode(text);
                    System.out.println("Encoded Text : " + encoded);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            } else if (c.equals("2")) {
                System.out.println("Enter the encoded bits to decode");
                String text = in.nextLine();
                try {
                    String decoded = ArithmeticCoding.Decode(text);
                    System.out.println("Decoded Text : " + decoded);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else break;
        }
    }
}
