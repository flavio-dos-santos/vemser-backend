package com.dbc.aula03.aula05;

public class Main {

    public static void main(String[] args) {
        Soma soma = new Soma();
        soma.calcula(8,2);


        Subtracao subtracao = new Subtracao();
        subtracao.calcula(8,2);

        Multiplicacao mult = new Multiplicacao();
        mult.calcula(8,2);

        Divisao divisao = new Divisao();
        divisao.calcula(50,30);
        System.out.println(divisao.calcula(8,2));
    }
}
