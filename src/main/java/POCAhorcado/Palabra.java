package POCAhorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Palabra {

    private String palabra;
    private List<Letra> letras = new ArrayList<Letra>();
    private static boolean gameOver = Boolean.FALSE;


    Palabra(String palabra) {

        this.palabra = palabra;

        for(char ch: palabra.toCharArray()){
            Letra L = new Letra(Character.toString(ch));
            letras.add(L);
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver( boolean finJuego ) {
        gameOver = finJuego;
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

        boolean playAgain = false;

        List<Letra> filtro = this.letras.stream().filter(letra-> letra.getLetra().equals(letter)).collect(Collectors.toList());

        if(filtro.size()!=0){
            this.letras.stream()
                    .filter(letra-> letra.getLetra().equals(letter))
                    .forEach(letra -> letra.setBool(Boolean.TRUE));
            System.out.println("Acertaste la letra " + letter + "!");
            playAgain = Boolean.TRUE;
        }

        System.out.println("La palabra es: " + this.toStringLetters()); //printea la palabra con guiones

        this.winOrLose(); //verifica que con el ultimo acierto, no haya terminado el juego

        if(this.isGameOver()){ //si el juego terminó, no deja que el jugador siga jugando.
            playAgain = Boolean.FALSE;
        }

        return playAgain;
    }

    public void winOrLose(){

        List<Letra> result = this.letras.stream()
                .filter(letra -> !letra.isBool())
                .collect(Collectors.toList());

        System.out.println("RESULT1: " + result.toString());

        if(result.size() == 0){
            System.out.println("RESULT2: " + result.toString());
            setGameOver(Boolean.TRUE);
            System.out.println(" xXx Game Over xXx ");
        }
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
