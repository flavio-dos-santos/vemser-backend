package aula06;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class HomeworkStream {
        public static void main(String[] args) {
            List<Pessoa> lista = new ArrayList<>();
            int i = 0;
            lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
            lista.add(new Pessoa(++i, "Pedro", 5300, "Desenvolvedor"));
            lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
            lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
            lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
            lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

            //1- listar todas as pessoas
//        lista.forEach(p->{
//            System.out.println(p.getNome());
//            System.out.println(p.getCargo());
//        } );

            //2- filtrar todas as pessoas com salario maior do que 5 mil


//        List<Pessoa> pessoasComSalariaMaiorQ5000 = lista.stream()
//                .filter(pessoa -> pessoa.getSalario() > 5000)
//                .collect(Collectors.toList());
//        System.out.println(pessoasComSalariaMaiorQ5000);


            //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente



//        List<Pessoa> desenvolvedoresSalarioCrescente = lista.stream()
//                .filter(pessoa -> pessoa.getCargo().equalsIgnoreCase("desenvolvedor"))
//                .sorted(Comparator.comparingDouble(Pessoa::getSalario))
//                .collect(Collectors.toList());
//        System.out.println(desenvolvedoresSalarioCrescente);


            //4- fazer a média salarial de todos



//       Double media =  lista.stream().mapToDouble(pessoa -> pessoa.getSalario())
//                .average().getAsDouble();
//        System.out.println(media);




            //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil



//        boolean pessoaQGanhaBem = lista.stream().anyMatch(pessoa-> pessoa.getSalario() > 20000);
//        System.out.println(pessoaQGanhaBem);





            //6 - retornar uma lista de todos os ids das pessoas




//
//       List<Integer> todosIds = lista.stream()
//               .map(Pessoa::getId)
//               .collect(Collectors.toList());
//       System.out.println(todosIds);







            //7 - criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream retornar uma lista desse novo objeto



//       List<Salario> salarioMap = lista.stream().map(pessoa -> new Salario(pessoa.getSalario(), pessoa.getId()))
//                .collect(Collectors.toList());
//        System.out.println(salarioMap);





            //8- retornar um Map (HashMap) contendo os ids e os nomes dos colaboradores


//    Map<Integer,String> idsENomes = lista.stream().collect(Collectors.toMap(pessoa -> pessoa.getId(), pessoa -> pessoa.getNome()));
//        System.out.println(idsENomes);






            //9- com o mapa da questão 8, retornar o nome com o id=2



//        Map<Integer,String> idsENomes = lista.stream().collect(Collectors.toMap(pessoa -> pessoa.getId(), pessoa -> pessoa.getNome()));
//                System.out.println(idsENomes.get(2));

        }


        static class Salario{
            int id = 0;
            Double salario;

            public Salario(Double salario, int id){
                this.salario = salario;
                this.id = id;

            }

            @Override
            public String toString() {
                return "Salario{" +
                        "id=" + id +
                        ", salario=" + salario +
                        '}';
            }
        }

        static class Pessoa {
            private int id;
            private String nome;
            private double salario;
            private String cargo;

            public Pessoa(int id, String nome, double salario, String cargo) {
                this.id = id;
                this.nome = nome;
                this.salario = salario;
                this.cargo = cargo;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNome() {
                return nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }

            public double getSalario() {
                return salario;
            }

            public void setSalario(double salario) {
                this.salario = salario;
            }

            public String getCargo() {
                return cargo;
            }

            public void setCargo(String cargo) {
                this.cargo = cargo;
            }

            @Override
            public String toString() {
                return "Pessoa{" +
                        "id=" + id +
                        ", nome='" + nome + '\'' +
                        ", salario=" + salario +
                        ", cargo='" + cargo + '\'' +
                        '}';
            }
        }

    }

