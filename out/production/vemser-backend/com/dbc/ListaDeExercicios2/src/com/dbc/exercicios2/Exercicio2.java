package com.dbc.exercicios2;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int num = sc.nextInt();

        int acertar;
        do {
            System.out.println("tente acertar o número: ");
            acertar = sc.nextInt();

            if (acertar < num) {
                System.out.println("O número a ser encontrado é maior do que você digitou.");
            } else if (acertar > num) {
                System.out.println("O número a ser encontrado é menor do que você digitou.");
            }
        } while(num != acertar);
        System.out.println("ACERTOU!!");
    }
}
