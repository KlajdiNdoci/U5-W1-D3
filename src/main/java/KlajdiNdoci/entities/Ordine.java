package KlajdiNdoci.entities;

import KlajdiNdoci.enums.StatoOrdine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@ToString
@PropertySource("application.properties")
public class Ordine {
    private long numeroOrdine;
    private LocalTime orarioAcquisizione;
    private List<Pizza> pizze;
    private List<Bevanda> bevande;
    private Tavolo tavolo;
    private StatoOrdine statoOrdine;
    private int numeroCoperti;
    private double importoTotale;

    public Ordine(List<Pizza> pizze, List<Bevanda> bevande,int numeroCoperti,@Value("${costo.coperto}")int costoCoperto, Tavolo tavolo ) {
        Random rndm = new Random();
        this.numeroOrdine = rndm.nextInt();
        this.orarioAcquisizione = LocalTime.now();
        this.pizze = pizze;
        this.bevande = bevande;
        this.tavolo = tavolo;
        if (numeroCoperti > tavolo.getNumeroCopertiMax()) {
            throw new IllegalArgumentException("Il numero di coperti supera il massimo consentito.");
        } else {
            this.numeroCoperti = numeroCoperti;
        }
        this.statoOrdine = StatoOrdine.IN_CORSO;
        double importoPizze = 0;
        double importoBevande = 0;
        for (Pizza pizza: pizze) {
            importoPizze += pizza.getPrezzo();
        }
        for (Bevanda bevanda: bevande) {
            importoBevande += bevanda.getPrezzo();
        }
        int totCoperti = numeroCoperti * costoCoperto;;
        this.importoTotale = importoPizze + importoBevande + totCoperti;
    }
}
