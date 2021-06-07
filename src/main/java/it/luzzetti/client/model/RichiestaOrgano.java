package it.luzzetti.client.model;

import it.luzzetti.client.coda.IsElementoCoda;

import java.util.Date;
import java.util.Random;

public class RichiestaOrgano implements IsElementoCoda {

    private static Random random = new Random();

    private Long id = random.nextLong();
    private TipoRichiesta tipoRichiesta;
    private Long idUtenteCreazione = random.nextLong();
    private Date istanteCreazione = new Date();
    private String note = "";

    public RichiestaOrgano() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUtenteCreazione() {
        return idUtenteCreazione;
    }

    public void setIdUtenteCreazione(Long idUtenteCreazione) {
        this.idUtenteCreazione = idUtenteCreazione;
    }

    public Date getIstanteCreazione() {
        return istanteCreazione;
    }

    public void setIstanteCreazione(Date istanteCreazione) {
        this.istanteCreazione = istanteCreazione;
    }

    @Override
    public String getIdValue() {
        return id != null ? id.toString() : null;
    }

    @Override
    public void setIdValue(String id) {
        this.id = Long.valueOf(id);
    }

    @Override
    public TipoRichiesta getTipoRichiesta() {
        return this.tipoRichiesta;
    }

    @Override
    public void setTipoRichiesta(TipoRichiesta tipoRichiesta) {
        this.tipoRichiesta = tipoRichiesta;
    }

    @Override
    public String getIdUtenteCreazioneValue() {
        return this.idUtenteCreazione != null ? this.idUtenteCreazione.toString() : null;
    }

    @Override
    public void setIdUtenteCreazioneValue(String idUtenteCreazione) {
        this.idUtenteCreazione = Long.valueOf(idUtenteCreazione);
    }

    @Override
    public String getNote() {
        return this.note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String getIstanteCreazioneValue() {
        return this.istanteCreazione != null ? this.istanteCreazione.toString() : null;
    }

    @Override
    public void setIstanteCreazioneValue(String istanteCreazione) {
        this.istanteCreazione = new Date();
    }

    @Override
    public String toString() {
        return "RichiestaOrgano{" +
                "id=" + id +
                ", tipoRichiesta=" + tipoRichiesta +
                ", idUtenteCreazione=" + idUtenteCreazione +
                ", istanteCreazione=" + istanteCreazione +
                ", note='" + note + '\'' +
                '}';
    }
}
