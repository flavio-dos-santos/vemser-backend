package com.dbc.aula03.exercicios3;

public class Main {

    public static void main(String[] args) {
        Endereco teste = new Endereco();
        teste.tipo = 2;
        teste.numero = 25;
        teste.logradouro = "qnm 20 conjunto N";
        teste.complemento = "casa 25";
        teste.cep = "72210-214";
        teste.cidade = "ceilândia";
        teste.estado = "distrito Federal";
        teste.pais = "Brasil";

        Contato teste1 = new Contato();
        teste1.descricao = "residencial";
        teste1.telefone = "33710769";
        teste1.tipo = 2;




        teste1.imprimiContato();
        teste.imprimirEndereco();
    }

}
