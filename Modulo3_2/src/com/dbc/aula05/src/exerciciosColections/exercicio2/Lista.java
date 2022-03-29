package exerciciosColections.exercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> minhaLista = new ArrayList<>();

        String nome = "";

        while(!nome.equalsIgnoreCase("sair")) {
            System.out.println("digite um nome: ");
            nome = scanner.nextLine();
            if(!nome.equalsIgnoreCase("sair")){
                minhaLista.add(nome);

            }
        }
        System.out.println("penultimo nome: " + minhaLista.get(minhaLista.size() - 2));
        System.out.println("primeiro nome: " + minhaLista.get(0));
        System.out.println("remover o ultimo: " + minhaLista.remove(minhaLista.size() -1));
        System.out.println("nomes restantes: " + minhaLista);
        System.out.println("tamanho da lista: " + minhaLista.size());



//        System.out.println(minhaLista);
//        System.out.println(minhaLista.size());
//        System.out.println(minhaLista.get(0));
//        System.out.println(minhaLista.indexOf("Maicon"));
//        System.out.println(minhaLista.remove(0));
//        minhaLista.add(nome);


    }
}
