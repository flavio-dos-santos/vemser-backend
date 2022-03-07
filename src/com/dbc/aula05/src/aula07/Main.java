package aula07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pedido = "";
        System.out.println("Digite o pedido, temos JAPONESA, FAST_FOOD e TRADICIONAL: ");
        pedido = scanner.nextLine();
        Comida tipo = Comida.valueOf(pedido);
        switch (tipo) {
            case JAPONESA -> System.out.println("comida japonesa custa R$50");
            case FAST_FOOD -> System.out.println("FAST_FOOD custa 30R$");
            case TRADICIONAL -> System.out.println("Tradicional custa R$20");
//            default -> System.out.println("não temos esse tipo de comida");
        }

    }
}
