package KlajdiNdoci.entities;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Bevanda extends MenúItem {
    private final double litri;

    public Bevanda(String nome, int calorie, double prezzo, double litri) {
        super(nome, calorie, prezzo);
        this.litri = litri;
    }
}

