package com.dbc.exercicios1;

import java.util.Scanner;

public class exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float matematica, portugues, geografia, historia, media;

        System.out.println("nota de Matemática de 0 a 10:");
        matematica = scanner.nextFloat();

        System.out.println("nota de Português de 0 a 10:");
        portugues = scanner.nextFloat();

        System.out.println("nota de Geografia de 0 a 10:");
        geografia = scanner.nextFloat();

        System.out.println("nota de História de 0 a 10:");
        historia = scanner.nextFloat();

        media = (matematica+portugues+geografia+historia)/4;

        System.out.println(media + ", é a sua nota final!");

       if (media>=7){
           System.out.println("Aluno aprovado!");
       }

       else if(media>5.1){
            System.out.println("Aluno em exame!");
        }

       else {
            System.out.println("Aluno reprovado!");
        }


}

    }
