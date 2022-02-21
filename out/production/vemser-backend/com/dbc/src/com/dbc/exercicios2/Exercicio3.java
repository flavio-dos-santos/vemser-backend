package com.dbc.exercicios2;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeJogador = "";
        double alturaMaiorJogador = 0.0;
        String maiorJogador = "";
        int quantidadeJogador = 0;
        String maisVelho = "";
        int idadeMaisVelho = 0;
        String maisPesado = "";
        double pesoMaisPesado = 0.0;

        double todasAlturas;
        double altura;
        for(todasAlturas = 0.0; !nomeJogador.equalsIgnoreCase("sair"); todasAlturas += altura) {
            System.out.println("Digite o nome do jogador: ");
            nomeJogador = scanner.next();
            if (nomeJogador.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Digite a altura do jogador: ");
            altura = scanner.nextDouble();
            System.out.println("Digite o peso do jogador: ");
            double pesoJogador = scanner.nextDouble();
            System.out.println("Digite a idade do jogador: ");
            int idadeJogador = scanner.nextInt();
            ++quantidadeJogador;
            if (alturaMaiorJogador < altura) {
                alturaMaiorJogador = altura;
                maiorJogador = nomeJogador;
            }

            if (pesoMaisPesado < pesoJogador) {
                pesoMaisPesado = pesoJogador;
                maisPesado = nomeJogador;
            }

            if (idadeMaisVelho < idadeJogador) {
                idadeMaisVelho = idadeJogador;
                maisVelho = nomeJogador;
            }
        }

        altura = todasAlturas / (double)quantidadeJogador;
        System.out.printf("Quantidade de jogadores cadastrados é: %d %n", quantidadeJogador);
        System.out.printf("O jogador mais alto e sua altura: %s %.2fm %n", maiorJogador, alturaMaiorJogador);
        System.out.printf("O jogador mais pesado e seu peso: %s %.2fKg \n", maisPesado, pesoMaisPesado);
        System.out.printf("O jogador mais velho e sua idade: %s %danos \n", maisVelho, idadeMaisVelho);
        System.out.printf("A média de altura total é igual a: %.2fm", altura);
    }
}
