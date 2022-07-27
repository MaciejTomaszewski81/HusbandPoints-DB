package pl.tomaszewski.demo.engine;

public enum Tasks {

    PIWO("Piwo"),
    GRA("Gra"),
    RZYGANIE_NA_SCIANE("Haftowanie po ścianch"),
    SEX("Rącze pącze"),
    PIERD("Bąki");

    private String translation;

    Tasks(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return translation;
    }
}