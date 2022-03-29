package exerciciosColections.exercicio5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> mapa = new HashMap<>();
       String nome = "";
       String cpf = "";

        System.out.println("cpf: ");
        cpf = scanner.nextLine();
        while(!cpf.equalsIgnoreCase("sair")){
            System.out.println("nome: ");
            nome = scanner.nextLine();
            mapa.put(cpf,nome);
            System.out.println("Digite mais um cpf ou sair para sair:");
            cpf = scanner.nextLine();
        }
        System.out.println("consulte um cpf: ");
        cpf = scanner.nextLine();
        if(mapa.containsKey(cpf)){
            System.out.println("cpf e nome: " + mapa.remove(cpf));
        }
        else{
            System.out.println("cpf invalido!");
        }
        System.out.println("Lista de nomes e cpf: " + mapa);

    }
}
