package com.dbc.aula03.aula06.paradigmafuncional;

import java.util.function.Function;

public class main {
    public static void main(String[] args) {


// ambos fazem a mesma coisa, de modo mais simples!
//        Calculo funcao = new Calculo() {
//            @Override
//            public  gerar(double valor, double valor2) {
//                return 0;
//            }
//      @Override
//      public String gerar(String valor){
//          return "Sr. " + valor;
//      }
//        };

//        Calculo funcaoSoma = (valor, valor2) -> (valor - valor2);
//        Calculo funcaoMult = (valor, valor2) -> (valor * valor2);
//        System.out.println("Funçao de soma: " + funcaoSoma.gerar(50,30));
//        System.out.println("Funão de multiplicação: " + funcaoMult.gerar(10,5));
//  Ambos fazem a mesma coisa

        Function<Double, Double> cos = (value) -> Math.cos(value);
        Function<Double, Double> sqrt = (value) -> Math.sqrt(value);
        Function<Double, Double> cosThenSqrt = cos.andThen(sqrt);

        System.out.println(cosThenSqrt.apply(1.0));
    }
}
