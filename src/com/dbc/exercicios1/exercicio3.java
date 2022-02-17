package com.dbc.exercicios1;

import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float consumo, pagamento, troco;

        System.out.println("qual valor consumido:");
        consumo = scanner.nextFloat();

        System.out.println("qual valor pago:");
        pagamento = scanner.nextFloat();

        troco = pagamento - consumo;
        if (pagamento < consumo) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido! ");
        } else {
            System.out.println("o valor de troco é igual a " + troco);
        }
    }
}
