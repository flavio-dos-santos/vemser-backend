package exerciciosColections.exercicio4;

import java.util.Scanner;
import java.util.Stack;

public class Pilha {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          Stack<Integer> pilha = new Stack<>();

          int num;
          for (int i = 0; i < 15; i++) {
               System.out.println("digite um numero: ");
               num = sc.nextInt();
               if (num % 2 == 0) {
                    pilha.add(num);
               } else {
                    if (!pilha.isEmpty()) {
                    }
               }
          }
          sc.nextLine();
          while (!pilha.isEmpty()) {
               System.out.print(pilha.pop() + ", ");
          }
     }
}


