package exerciciosColections.exercicio6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pessoas> minhaLista = new ArrayList<>();
        minhaLista.add(new Pessoas("Flavio",30));
        minhaLista.add(new Pessoas("Maicon",30));
        minhaLista.add(new Pessoas("Lucas",20));
        minhaLista.add(new Pessoas("Lucas", 19));
        minhaLista.add(new Pessoas("gustavo", 26));
        minhaLista.add(new Pessoas("Hugo",50));

        System.out.println(minhaLista);
        System.out.println("\n######################################################################\n");
        minhaLista.sort(new Comparator<Pessoas>() {
            @Override
            public int compare(Pessoas o1, Pessoas o2) {
                return o1.getNome().compareToIgnoreCase(o2.getNome());
            }
        });
        System.out.println(minhaLista);
        System.out.println("\n######################################################################\n");

        minhaLista.sort(new Comparator<Pessoas>() {
            @Override
            public int compare(Pessoas o1, Pessoas o2) {
                int comparacaoIdade = o2.getIdade() - o1.getIdade() ;
                return comparacaoIdade;
            }
        });
        System.out.println(minhaLista);
        System.out.println("\n######################################################################\n");


        minhaLista.sort(new Comparator<Pessoas>() {
                            @Override
                            public int compare(Pessoas o1, Pessoas o2) {
                                int comparacao1 = o1.getNome().compareTo(o2.getNome());
                                if(comparacao1 != 0){
                                    return comparacao1;
                                }
                                return o1.getIdade() - o2.getIdade();
                            }
                        });

                System.out.println(minhaLista);


    }
}
