package com.dbc.exercicios2;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        int contagem = 0;

        int linha;
        int coluna;
        for(linha = 0; linha < 4; ++linha) {
            for(coluna = 0; coluna < 4; ++coluna) {
                System.out.printf("%d linha, %d coluna = %n", linha + 1, coluna + 1);
                matriz[linha][coluna] = scanner.nextInt();
            }
        }

        for(linha = 0; linha < 4; ++linha) {
            for(coluna = 0; coluna < 4; ++coluna) {
                if (matriz[linha][coluna] > 10) {
                    ++contagem;
                }
            }
}
        System.out.printf("Existem na matriz %d números maiores que 10.", contagem);
    }
}
