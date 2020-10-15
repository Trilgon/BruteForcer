package com.company;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static com.company.Brute.force;

public class Main {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите хэш пароля");
        String password = in.nextLine();

        Runnable r1 = () -> {
            try {
                force(97, 103, password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                force(103, 110, password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        };
        Runnable r3 = () -> {
            try {
                force(110, 117, password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        };
        Runnable r4 = () -> {
            try {
                force(117, 123, password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        Thread thread3 = new Thread(r3);
        Thread thread4 = new Thread(r4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
