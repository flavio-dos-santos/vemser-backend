package com.dbc.exercicios2;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double desconto = 0.95;
        System.out.println("Digite o nome do produto: ");
        String produto = scanner.nextLine();
        System.out.println("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        for (int i = 1; i <= 10; ++i) {
            double valor = preco * desconto;
            double total = valor * (double) i;
            System.out.println(i + " x R$" + valor + " = R$" + total);
            desconto -= 0.05;
        }
    }
}
