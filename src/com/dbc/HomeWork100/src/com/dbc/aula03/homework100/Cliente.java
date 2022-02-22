package com.dbc.aula03.homework100;


import java.util.Arrays;

public class Cliente {
   private String nome;
   private String cpf;
   private Contato contatos[] = new Contato[2];
   private Endereco enderecos[] = new Endereco[2];



    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.contatos[0] = new Contato("whats","(61)98894512",1);
        this.contatos[1] = new Contato("whats Empresa","(61)98854123", 2);
        this.enderecos[0] = new Endereco(1,"qnk 14 conj k", 48,"casa","78451221","tabuao","SP","Brasil");
        this.enderecos[1] = new Endereco(2,"qnk 16 cj J", 64,"loja","78541237","maua","SP","Brasil");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }


    public void imprimirEnderecos() {
        for(int i = 0; i < this.enderecos.length; ++i) {
            if (this.enderecos[i] != null) {
                this.enderecos[i].imprimirEndereco();
            }
        }

    }
    public void imprimirContatos() {
        for(int i = 0; i < this.contatos.length; ++i) {
            if (this.contatos[i] != null) {
                this.contatos[i].imprimirContato();
            }
        }

    }
    public void imprimirCliente() {
        System.out.println(this);
        this.imprimirContatos();
        this.imprimirEnderecos();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' + "\n" +
                ", cpf='" + cpf + '\'' + "\n" +
                ", contatos=" + Arrays.toString(contatos) + "\n " +
                ", enderecos=" + Arrays.toString(enderecos) + "\n"+
                '}';
    }
}


