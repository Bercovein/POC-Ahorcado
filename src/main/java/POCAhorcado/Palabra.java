package POCAhorcado;

import java.util.List;
import java.util.Objects;

public class Palabra {

    private String palabra;
    private List<Letra> letras;


    public Palabra(String palabra) {
        this.palabra = palabra;
        char [] letras = palabra.toCharArray();

        for(int i=0; i<letras.length; i++){
            Letra letra = new Letra(letras[i]);
            this.letras.add(letra);
        }
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra( String palabra ) {
        this.palabra = palabra;
    }

    public List<Letra> getLetras() {
        return letras;
    }

    public void setLetras( List<Letra> letras ) {
        this.letras = letras;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palabra palabra1 = (Palabra) o;
        return Objects.equals(palabra, palabra1.palabra) &&
                Objects.equals(letras, palabra1.letras);
    }

    @Override
    public int hashCode() {

        return Objects.hash(palabra, letras);
    }

    @Override
    public String toString() {
        return palabra;
    }
}
