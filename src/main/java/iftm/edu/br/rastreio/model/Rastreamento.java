package iftm.edu.br.rastreio.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
public class Rastreamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataHora;
    private String status;
    private String localizacao;

    public String getResumo() {
        return "Data e hora: " + dataHora + "\n" + "Status: " + status + "\n" + "Localização: " + localizacao;
    }
}
