package com.dbc.exercicios1;

import java.util.Scanner;

public class exercicio6 {
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

            default:
                System.out.println("Essa palavra não é válida!"
                        );
        }
    }
}
