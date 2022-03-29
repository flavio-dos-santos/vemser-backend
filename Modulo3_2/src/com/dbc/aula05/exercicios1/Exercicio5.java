package com.dbc.exercicios1;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double hora,horasNormais,horasExtras,horaExtra100,salarioBruto;

        System.out.println("Valor da hora em R$:");
        hora = scanner.nextDouble();

        System.out.println("numero de horas normais trabalhadas:");
        horasNormais = scanner.nextDouble();

        System.out.println("quantas horas extras de 50%:");
        horasExtras = scanner.nextDouble();

        System.out.println("quantas horas extras de 100%:");
        horaExtra100 = scanner.nextDouble();

        salarioBruto =  (horasNormais * hora) + (horasExtras * hora * 1.5) + (horaExtra100 * hora * 2);
        System.out.println("O seu salário bruto é de: R$" + salarioBruto);

    }
}
