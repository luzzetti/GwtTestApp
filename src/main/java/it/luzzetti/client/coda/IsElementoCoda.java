package it.luzzetti.client.coda;

import it.luzzetti.client.model.TipoRichiesta;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;

public interface IsElementoCoda {

    String getIdValue();

    void setIdValue(String id);

    TipoRichiesta getTipoRichiesta();

    void setTipoRichiesta(TipoRichiesta tipoRichiesta);

    String getIdUtenteCreazioneValue();

    void setIdUtenteCreazioneValue(String idUtenteCreazione);

    String getNote();

    void setNote(String note);

    void setIstanteCreazioneValue(String istanteCreazione);

    String getIstanteCreazioneValue();

//    Instant getIstanteCreazione();

//    void setIstanteCreazione(Instant istanteCreazione);

}
