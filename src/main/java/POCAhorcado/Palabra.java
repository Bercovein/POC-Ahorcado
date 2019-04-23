package POCAhorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Palabra {

    private String palabra;
    private List<Letra> letras = new ArrayList<Letra>();


    Palabra(String palabra) {
        this.palabra = palabra;

        char[] caracteres = palabra.toCharArray();

        for (char caractere : caracteres) {

            Letra L = new Letra(caractere);
            letras.add(L);
        }
    }

    public boolean winOrLose(){

        for (Letra le: letras) {
            le.isBool();
        }

        return boolean;
    }


    public String toStringLetters(){

        String palabra = "";

        this.letras.forEach(letra->{
           if(letra.isBool()){
               palabra.concat(Character.toString(letra.getLetra()));
           }else{
               palabra.concat("_");
           }
        });

        return palabra;
    }

    public boolean letterIsHere(char letter){

        Letra newsletter = new Letra(letter);
        boolean bool = false;

        if(this.letras.contains(newsletter)){

            this.letras.stream().filter(letra->letra.getLetra()==letter).forEach(letra -> letra.setBool(true));
            bool = true;
        }
        return bool;
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
        return this.palabra +
                ", letras = " /* + this.letras +*/;
    }
}
