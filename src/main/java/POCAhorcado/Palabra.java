package POCAhorcado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Palabra {

    private String palabra;
    private List<Letra> letras = new ArrayList<Letra>();


    Palabra(String palabra) {
        this.palabra = palabra;

        char[] caracteres = palabra.toCharArray();

        for (int i = 0; i < caracteres.length; i++){

            Letra L = new Letra(caracteres[i]);
            letras.add(L);
        }
    }

    public void toStringLetters(){

        this.letras.stream().forEach(letra->{
           if(letra.isBool()){
               System.out.print(letra.getLetra());
           }else{
               System.out.print("_");
           }
        });
    }

    public boolean letterIsHere(char letter){

        Letra newsletter = new Letra(letter);
        boolean bool = false;


        if(this.letras.contains(newsletter)){ //tal vez de siempre false?

            //poner en true la letra

            this.letras.stream().filter(letra->letra.getLetra()==letter); ///are you sure?
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
