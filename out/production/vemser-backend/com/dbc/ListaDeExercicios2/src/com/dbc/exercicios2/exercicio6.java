package com.dbc.exercicios2;

import java.util.Scanner;

public class exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Digite um número: ");
        int inserido = scanner.nextInt();
        for (int i = 0; i < numeros.length; i++){
            if (inserido == numeros[i]){
                System.out.println("Número encontrado na posição " + i +" do vetor. ");
                break;
            }else{
                System.err.println("Número não encontrado no vetor! ");
            }
        }

    }
}


