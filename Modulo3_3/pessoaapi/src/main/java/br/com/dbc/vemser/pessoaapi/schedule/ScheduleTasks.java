package br.com.dbc.vemser.pessoaapi.schedule;


import br.com.dbc.vemser.pessoaapi.entity.pessoa.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleTasks {
    private final EmailService emailService;
    private final PessoaRepository pessoaRepository;
    private final PessoaService pessoaService;



    @Scheduled(cron = "0 0 8,20 * * *")
    public void emailSemTeto(){
    pessoaRepository.findByPessoaSemEnderecoSQLNativo().forEach(pessoa-> emailService.sendSimpleMessage("\nOlá, "+ pessoa.getNome()+ "\n" +
            "\n" +
            "Estamos muito felizes que você está em nosso sistema.\n" +
            "Para que possamos enviá-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro.\n" +
            "\n" +
            "Muito obrigado,\n" +
            "Sistema de Pessoas.\n\nAtt,\nEu.", pessoa.getEmail()));
    }

    @Scheduled(cron = "0 0 0 1 * *")
    public void emailFindAllMensal(){
        pessoaService.list().forEach(pessoas-> emailService.sendSimpleMessage("Olá, "+ pessoas.getNome()+"\n" +
                "\n" +
                "Selecionamos alguns dos nossos melhores produtos e criamos esta super promoção na nossa\n" +
                "plataforma especialmente para você:\n" +
                "\n" +
                "- Na compra de 1 CDs do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico.\n" +
                "- Na locação de um filme em VHS, a outra locação é grátis\n" +
                "- Fita de Super Nintendo com 50% de desconto.\n" +
                "\n" +
                "Aproveite!\n" +
                "Magazine OldSchool.\n" +
                "\n" +
                "«VEM SER\n" +
                "DBC",pessoas.getEmail()));
    }

    @Scheduled(cron = "0 0 * * * *")
    public void emailAniversario(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate now = LocalDate.now();
    pessoaService.list().stream().filter(pessoa-> pessoa.getDataNascimento().getMonth().equals(now)
            && pessoa.getDataNascimento().getDayOfMonth()==now.getDayOfMonth()).forEach(p->emailService.sendSimpleMessage("Olá,"+p.getNome()+"\n" +
            "\n" +
            "Essa data de "+ dateTimeFormatter.format(p.getDataNascimento()) + " também é especial para nós do\n" +
            "Vem Ser. Estamos comemorando junto com você. lo/\n" +
            "\n" +
            "Desejamos um feliz aniversário, que sejam (idade, exemplo: 32J anos de muitos. Sucesso, alegria,\n" +
            "felicidade e muitas realizações.\n" +
            "\n" +
            "Forte abraço,\n" +
            "VemSerDBC |!", p.getEmail()));
    }
}
