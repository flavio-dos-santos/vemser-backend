package com.dbc.exercicios1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class exercicio4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        System.out.println("selecione o estado de 1 a 3!");
        System.out.println("1- Distrito Federal!");
        System.out.println("2- Rio de Janeiro!");
        System.out.println("3- Bahia!");
        int num = scanner.nextInt();

        switch (num){
            case 1:
                System.out.println("selecione a cidade de 1 ou 2!");
                System.out.println("1- Ceilandia!");
                System.out.println("2- Samambaia!");
                int num1 = scanner.nextInt();

                if(num1<=1){
                    System.out.println("A cidade de ceilandia tem uma população de 443.824 habitantes, um idh de 0,784 e sua maior festa acontece quando é liberado o saidão!");
                }
                else {
                    System.out.println("A cidade de samambaia tem uma população de 244.960 habitantes, um idh de 0,781 e sua maior festa é o forró da Leila!");
                }
                break;

            case 2:
                System.out.println("selecione a cidade de 1 ou 2!");
                System.out.println("1- Niteroi!");
                System.out.println("2- Angra dos Reis!");
                int num2 = scanner.nextInt();

                if(num2<=1) {
                    System.out.println("A cidade de Niterói tem uma população de 515.317 habitantes, um idh de 0,886 e sua maior festa é a Food Lovers!");

                }
                else{
                    System.out.println("A cidade de Angra dos Reis tem uma população de 207.044 habitantes, um idh de 0,724 e sua maior festa é a praia!");
                }
                break;

            case 3:
                System.out.println("selecione a cidade de 1 ou 2!");
                System.out.println("1- Salvador!");
                System.out.println("2- Porto Seguro!");
                int num3 = scanner.nextInt();

                if(num3<=1){
                    System.out.println("A cidade de Salvador tem uma população de 2.000.000 habitantes, um idh de 0,791 e sua maior festa é o carnaval!");
                }
                else {
                    System.out.println("A cidade de Porto Seguro tem uma população de 150.658 habitantes, um idh de 0,676 e sua maior festa é a Axé Moi!");
                }

        }





    }
}
