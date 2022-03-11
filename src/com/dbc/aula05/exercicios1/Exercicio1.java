package com.dbc.exercicios1;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nomeUsuario = scanner.nextLine();

        System.out.println("Digite sua idade:");
        int idade = scanner.nextInt();

        System.out.println("Digite a cidade onde mora:");
        String cidade = scanner.nextLine();

        System.out.println("Digite o estado onde fica localizado sua cidade:");
        String estado = scanner.nextLine();

        System.out.println("Olá, seu nome é " + nomeUsuario + ", você tem " + idade + " anos, é da cidade de " + cidade + ", situada no estado de " + estado + "!" );

    }
}
