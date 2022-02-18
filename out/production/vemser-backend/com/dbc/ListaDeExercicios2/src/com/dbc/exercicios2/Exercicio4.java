package com.dbc.exercicios2;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[3];
        System.out.println("Digite um número: ");
        numeros[0] = scanner.nextInt();
        System.out.println("Digite mais um número: ");
        numeros[1] = scanner.nextInt();
        System.out.println("Digite o último número: ");
        numeros[2] = scanner.nextInt();
        if(numeros[0] < numeros[1] && numeros[0] < numeros[2]){
            System.out.printf("O menor número está na primeira posição");
        }else if(numeros[1] < numeros[0] && numeros[1] < numeros[2]){
            System.out.printf("O menor número está na segunda posição");
        }else{
            System.out.printf("O menor número está na terceira posição");
        }
    }
}

