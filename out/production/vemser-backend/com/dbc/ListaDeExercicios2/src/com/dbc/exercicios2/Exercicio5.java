package com.dbc.exercicios2;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[20];
        System.out.println("Digite 20 numeros: ");

        for(int i = 0; i < numeros.length; i++){
            System.out.printf("Número %d %n", i+1);
            numeros[i] = scanner.nextInt();
        }
        for(int i = numeros.length; i > 0; i--){
            System.out.printf("Posição %d ficou o número %d %n", i, numeros[i-1]);
        }
    }
}

