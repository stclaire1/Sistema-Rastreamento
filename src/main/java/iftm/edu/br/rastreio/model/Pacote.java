package iftm.edu.br.rastreio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacote;
    private String id;
    private String destinatario;
    private Long codigoRastreio;

    @ManyToOne
    private Endereco endereco;

    private String status;

    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL)
    private List<Rastreamento> rastreamentos = new ArrayList<Rastreamento>();

    public void atualizarStatus(Date dataHora, String novoStatus, String localizacao) {
        this.status = novoStatus;
        Rastreamento rastreamento = new Rastreamento();
        rastreamento.setDataHora(dataHora);
        rastreamento.setStatus(novoStatus);
        rastreamento.setLocalizacao(localizacao);
        rastreamento.setPacote(this);
    }

    public String consultarInformacoes() {
        return "Pacote: " + id + "\n" + "Destinatário: " + destinatario + "\n" + "Código de rastreio: " + codigoRastreio
                + "\n" + "Endereço: " + endereco.getEnderecoCompleto() + "\n" + "Status: " + status + "\n"
                + "Histórico de rastreamento: " + rastreamentos;
    }
}
