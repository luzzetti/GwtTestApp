package it.luzzetti.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnagraficaUtenti {

    public List<Utente> utenti = new ArrayList<>();
    public Date istanteUltimaModifica;

    public void aggiungiUtente(Utente utenteDaAggiungere) {
        this.utenti.add(utenteDaAggiungere);
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }

    public Date getIstanteUltimaModifica() {
        return istanteUltimaModifica;
    }

    public void setIstanteUltimaModifica(Date istanteUltimaModifica) {
        this.istanteUltimaModifica = istanteUltimaModifica;
    }

    @Override
    public String toString() {
        return "AnagraficaUtenti{" +
                "utenti=" + utenti +
                ", istanteUltimaModifica=" + istanteUltimaModifica +
                '}';
    }
}
