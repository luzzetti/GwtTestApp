package it.luzzetti.client.model;

public class Utente {

    private String nome;
    private String cognome;
    private Boolean attivo;

    public Utente(String nome, String cognome, Boolean attivo) {
        this.nome = nome;
        this.cognome = cognome;
        this.attivo = attivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", attivo=" + attivo +
                '}';
    }
}
