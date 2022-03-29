package exerciciosColections.exercicio3;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(40);
        fila.add(41);
        fila.add(42);
        fila.add(43);
        fila.add(44);
        fila.add(45);
        fila.add(46);
        fila.add(47);


//        5 pessoas entram na fila:
        fila.add(48);
        fila.add(49);
        fila.add(50);
        fila.add(51);
        fila.add(52);
        System.out.println("5 pessoas entram na fila" + fila);
//        2 pessoas são atendidas:
        fila.poll();
        fila.poll();
        System.out.println("2 pessoas são atendidas: " + fila);
//        mais uma pessoa é atendida:
        fila.poll();
        System.out.println("mais uma pessoa atendida: " + fila);
//        3 pessoas entram na fila:
        fila.add(53);
        fila.add(54);
        fila.add(55);
        System.out.println("3 pessoas entram na fila : " + fila);
//        3 pessoas atendidas
        fila.poll();
        fila.poll();
        fila.poll();
        System.out.println("3 pessoas atendidas: " + fila);
    }
}
