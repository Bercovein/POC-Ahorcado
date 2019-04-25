package POCAhorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Palabra {

    private String palabra;
    private List<Letra> letras = new ArrayList<Letra>();
    private boolean finJuego = Boolean.FALSE;


    Palabra(String palabra) {

        this.palabra = palabra;

        for(char ch: palabra.toCharArray()){
            Letra L = new Letra(Character.toString(ch));
            letras.add(L);
        }
    }

    public boolean winOrLose(){


        List<Letra> result = this.letras.stream()
                .filter(letra -> !letra.isBool())
                .collect(Collectors.toList());

        if(result.size() == 0){
            this.setFinJuego(Boolean.TRUE);
        }

        return this.isFinJuego();
    }

    public boolean isFinJuego() {
        return finJuego;
    }

    public void setFinJuego( boolean finJuego ) {
        this.finJuego = finJuego;
    }

    public StringBuffer toStringLetters(){

        StringBuffer palabra = new StringBuffer();

        this.letras.forEach(letra->{
           if(letra.isBool()){
               palabra.append(letra.getLetra());

           }else{
               palabra.append("_");

           }
            palabra.append(" ");
        });
        return palabra;
    }

    public boolean letterIsHere(String letter){

        boolean bool = false;

        List<Letra> filtro = this.letras.stream().filter(letra-> letra.getLetra().equals(letter)).collect(Collectors.toList());

        if(filtro.size()!=0){
            this.letras.stream().filter(letra-> letra.getLetra().equals(letter)).forEach(letra -> letra.setBool(true));
            System.out.println("Acertaste la letra " + letter + "!");
            bool = true;
        }

        System.out.println("La palabra es: " + this.toStringLetters());

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
        return "Palabra: " + this.palabra + ", Letras: " +  letras.toString();
    }
}
