package com.dbc.exercicios2;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        int contagem = 0;

        for(int linha=0; linha<4; linha++){
            for(int coluna=0; coluna<4; coluna++){
                System.out.println(linha+1 + " linha, " + coluna+1 + " coluna = ");
                matriz[linha][coluna] = scanner.nextInt();
            }
        }

        for(int linha=0; linha<4; linha++){
            for(int coluna=0; coluna<4; coluna++){
                if(matriz[linha][coluna] > 10){
                    contagem++;
                }
            }
        }
        System.out.println("Existem na matriz " + contagem + " números maiores que 10.");
    }
}

