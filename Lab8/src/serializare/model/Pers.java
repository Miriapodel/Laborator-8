package serializare.model;

import java.io.Serializable;

public class Pers implements Serializable {
    private String nume;
    private String prenume;
    private int varsta;
    private int suma;
    private String valuta;

    public Pers(String nume, String prenume, int varsta, int suma, String valuta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.suma = suma;
        this.valuta = valuta;
    }


    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", suma=" + suma +
                ", valuta='" + valuta + '\'' +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public int getSuma() {
        return suma;
    }

    public String getValuta() {
        return valuta;
    }
}
