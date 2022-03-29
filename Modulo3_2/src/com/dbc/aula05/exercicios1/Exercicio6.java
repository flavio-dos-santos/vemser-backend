package com.dbc.exercicios1;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("digite com letras minúsculas a palavra que deseja traduzir:");
        String palavra = scanner.nextLine();

        switch (palavra){
            case "cachorro":
                System.out.println("dog");
                break;

            case "tempo":
                System.out.println("time");
                break;

            case "amor":
                System.out.println("love");
                break;

            case "cidade":
                System.out.println("city");
                break;

            case "feliz":
                System.out.println("happy");
                break;

            case "dog":
                System.out.println("cachorro");
                break;

            case "time":
                System.out.println("tempo");
                break;

            case "love":
                System.out.println("amor");
                break;

            case "city":
                System.out.println("cidade");
                break;

            case "happy":
                System.out.println("feliz");
                break;

            default:
                System.out.println("Essa palavra não é válida!"
                        );
        }
    }
}
