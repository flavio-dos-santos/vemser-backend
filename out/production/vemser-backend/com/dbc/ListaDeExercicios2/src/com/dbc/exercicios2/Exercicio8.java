package com.dbc.exercicios2;

import java.util.Scanner;

public class Exercicio8 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int[][] matriz = new int[5][4];
            int somaMediaFinal = 0;
            int maiorNotaFinal = 0;
            int matriculaMaiorNota = 0;

            for (int linha=0; linha<5; linha++){
                for (int coluna=0; coluna<3; coluna++){
                    System.out.printf("%d linha, %d coluna = %n",linha+1, coluna+1);
                    matriz[linha][coluna] = scanner.nextInt();
                }
            }
            for (int linha=0; linha<5; linha++){
                for (int coluna=1; coluna<2; coluna++){
                    matriz[linha][3] = (int) (matriz[linha][1] * 0.6 + matriz[linha][2] * 0.4);
                    System.out.printf("A média final do aluno %d é %d %n", linha+1, matriz[linha][3]);
                    somaMediaFinal += matriz[linha][3];
                }
                if(matriz[linha][3] > maiorNotaFinal){
                    maiorNotaFinal = matriz[linha][3];
                    matriculaMaiorNota = matriz[linha][0];
                }
            }
            int media = somaMediaFinal / 5;
            System.out.printf("Média de todas as notas finais é %d %n", media);
            System.out.printf("A maior nota foi %d do aluno com a matrícula número - %d %n", maiorNotaFinal, matriculaMaiorNota);


        }
    }

