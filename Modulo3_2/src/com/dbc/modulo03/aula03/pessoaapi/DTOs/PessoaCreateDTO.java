package br.com.dbc.vemser.pessoaapi.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;


@Data
public class PessoaCreateDTO {
    @NotEmpty
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @CPF
    String cpf;
    @Email
    private String email;
}
