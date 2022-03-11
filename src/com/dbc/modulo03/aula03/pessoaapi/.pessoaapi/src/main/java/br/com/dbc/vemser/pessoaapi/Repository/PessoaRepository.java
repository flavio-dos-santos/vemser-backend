package br.com.dbc.vemser.pessoaapi.Repository;

import br.com.dbc.vemser.pessoaapi.Entidades.Pessoa;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PessoaRepository {
    private static List<Pessoa> listaPessoa = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


    public PessoaRepository(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //dia/mes/ano
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*1*/, "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910"));
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*2*/, "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911"));
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*3*/, "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912"));
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*4*/, "Rafael Lazzari", LocalDate.parse("01/07/1990", formatter), "12345678916"));
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*5*/, "Ana", LocalDate.parse("01/07/1990", formatter), "12345678917"));
    }

    public Pessoa create(Pessoa pessoa){
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoa.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> list(){
        return listaPessoa;
    }

    public Pessoa update(Integer id,Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = listaPessoa.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada! "));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public Pessoa delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = listaPessoa.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada "));
        listaPessoa.remove(pessoaRecuperada);
        return pessoaRecuperada;
    }

    public List<Pessoa> listByName(String nome){
        return listaPessoa.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

}
