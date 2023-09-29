package br.com.ienh.util;

import java.util.Scanner;

public class Scan {
    private static Scanner tecla = new Scanner(System.in);

    public static String lerString(){
        return tecla.nextLine();
    }

    public static int lerInt(){
        return tecla.nextInt();
    }

    public static double lerDouble(){
        return tecla.nextDouble();
    }
}
