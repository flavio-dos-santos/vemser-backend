package com.dbc.exercicios2;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.printf("Digite um número: %n");
        int inserido = scanner.nextInt();

        for(int i = 0; i < numeros.length; ++i) {
            if (inserido == numeros[i]) {
                System.out.printf("Número encontrado na posição %d do vetor. %n", i);
                return;
            }
        }

        System.err.printf("Número não encontrado no vetor! %n");
    }
}
