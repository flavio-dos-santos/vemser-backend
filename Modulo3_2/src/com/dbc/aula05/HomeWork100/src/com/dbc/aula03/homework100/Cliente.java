package com.dbc.aula03.homework100;


import java.util.ArrayList;
import java.util.Arrays;

public class Cliente {
   private String nome;
   private String cpf;
   private ArrayList<Contato> contatos = new ArrayList<>();
   private ArrayList<Endereco> enderecos =new ArrayList<>();



    public Cliente(String nome, String cpf, Contato contato, Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        contatos.add(contato);
        enderecos.add(endereco);
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

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }


    public void imprimirEnderecos() {
        for(int i = 0;!contatos.isEmpty(); i++) {
            System.out.println("Endereco" + (i+1));
            }
        }


//    public void imprimirContatos() {
//        for(int i = 0; i < this.contatos.length; ++i) {
//            if (this.contatos != null) {
//                this.contatos.imprimirContato();
//            }
//        }
//
//    }
    public void imprimirCliente() {
        System.out.println(this);
//        this.imprimirContatos();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", contatos=" + contatos +
                ", enderecos=" + enderecos +
                '}';
    }
}



