package com.dbc.exercicios1;

import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double hora,horasnormais,horasextras,horaextra100,salariobruto;

        System.out.println("Valor da hora em R$:");
        hora = scanner.nextDouble();

        System.out.println("numero de horas normais trabalhadas:");
        horasnormais = scanner.nextDouble();

        System.out.println("quantas horas extras de 50%:");
        horasextras = scanner.nextDouble();

        System.out.println("quantas horas extras de 100%:");
        horaextra100 = scanner.nextDouble();

        salariobruto =  (horasnormais * hora) + (horasextras * hora * 1.5) + (horaextra100 * hora * 2);
        System.out.println("O seu salário bruto é de: R$" + salariobruto);

    }
}
