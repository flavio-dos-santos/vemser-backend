package br.com.dbc.vemser.pessoaapi.dtos.pessoa;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaCreateDTO {
    @NotEmpty
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @NotNull
    @Size(min = 11,max = 11)
    String cpf;
    @Email
    private String email;
}
