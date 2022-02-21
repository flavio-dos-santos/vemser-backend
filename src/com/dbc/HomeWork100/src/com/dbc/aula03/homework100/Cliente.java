package com.dbc.aula03.homework100;


public class Cliente {
    String nome;
    String cpf;
    Contato contatos[] = new Contato[2];
    Endereco enderecos[] = new Endereco[2];



    public void imprimirCliente(){
        System.out.println("nome: " + this.nome + "\ncpf: " + this.cpf);
        this.imprimirContatos();
        this.imprimirEnderecos();
    }



    public void contato1(String desc1, String tel1, int tipo) {
        this.contatos[0] = new Contato();
        this.contatos[0].descricao = desc1;
        this.contatos[0].telefone = tel1;
        this.contatos[0].tipo = tipo;
    }

    public void contato2(String desc1, String tel1, int tipo) {
        this.contatos[1] = new Contato();
        this.contatos[1].descricao = desc1;
        this.contatos[1].telefone = tel1;
        this.contatos[1].tipo = tipo;

    }
    public void endereco1(int tipo ,String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais){
        this.enderecos[0] = new Endereco();
        this.enderecos[0].tipo = tipo;
        this.enderecos[0].logradouro = logradouro;
        this.enderecos[0].numero = numero;
        this.enderecos[0].complemento = complemento;
        this.enderecos[0].cep = cep;
        this.enderecos[0].cidade = cidade;
        this.enderecos[0].estado = estado;
        this.enderecos[0].pais = pais;
    }
    public void endereco2(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.enderecos[1] = new Endereco();
        this.enderecos[1].tipo = tipo;
        this.enderecos[1].logradouro = logradouro;
        this.enderecos[1].numero = numero;
        this.enderecos[1].complemento = complemento;
        this.enderecos[1].cep = cep;
        this.enderecos[1].cidade = cidade;
        this.enderecos[1].estado = estado;
        this.enderecos[1].pais = pais;
    }
    public void imprimirContatos(){
        contatos[0].imprimiContato();
        contatos[1].imprimiContato();
    }
    public void imprimirEnderecos(){
        enderecos[0].imprimirEndereco();
        enderecos[1].imprimirEndereco();
    }
}


