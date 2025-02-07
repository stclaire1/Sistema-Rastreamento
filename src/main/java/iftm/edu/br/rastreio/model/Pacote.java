package iftm.edu.br.rastreio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"rastreamentos"})
@EqualsAndHashCode(of = {"idPacote"})
@Entity
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idPacote;
    private String destinatario;

    @ManyToOne
    private Endereco endereco;

    private String status;

    @OneToMany
    private List<Rastreamento> rastreamentos = new ArrayList<Rastreamento>();

    public void atualizarStatus(Date dataHora, String novoStatus, String localizacao) {
        this.status = novoStatus;
        Rastreamento rastreamento = new Rastreamento();
        rastreamento.setDataHora(dataHora);
        rastreamento.setStatus(novoStatus);
        rastreamento.setLocalizacao(localizacao);
    }

    public String consultarInformacoes() {
        return "Pacote: " + id + "\n" + "Destinatário: " + destinatario + "\n" + "\n" + "Endereço: " + endereco.getEnderecoCompleto() + "\n" + "Status: " + status + "\n"
                + "Histórico de rastreamento: " + rastreamentos;
    }
}
