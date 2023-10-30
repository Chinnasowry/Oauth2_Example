package com.example.Sample.javaExample;

import java.util.Scanner;

public class Sample {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        int a, b;
        String name = "hello";
//        name = myObj.nextLine();
        a = myObj.nextInt();
        b = myObj.nextInt();
        System.out.println("Sum of two numbers : "+(a+b));
        if(a>b) {
            System.out.println("a is grater then b : " +a);
        }
        System.out.println("Given name is : "+name);
    }
}
