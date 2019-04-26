package POCAhorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import static POCAhorcado.GameData.abcdario;
import static POCAhorcado.GameData.palabra;
import static java.lang.Thread.sleep;

public class Palabra {

    private Integer id_palabra;
    private String palabra;
    private List<Letra> letras = new ArrayList<Letra>();
    private boolean gameOver = Boolean.FALSE;
    boolean playing = Boolean.FALSE;


    Palabra(Integer id_palabra, String palabra) {

        this.palabra = palabra;
        this.id_palabra = id_palabra;

        for(char ch: palabra.toCharArray()){
            Letra L = new Letra(Character.toString(ch));
            letras.add(L);
        }
    }

    public Integer getId_palabra() {
        return id_palabra;
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

        System.out.println("La palabra es: " + this.toStringLetters());

        this.winOrLose();

        if(this.isGameOver()){ //si el juego terminó, no deja que el jugador siga jugando.
            playAgain = Boolean.FALSE;
        }

        return playAgain;
    }

    synchronized void play(Jugador jugador){

        while(playing){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        playing  = Boolean.TRUE;

        if(!isGameOver()){

            Random rand = new Random();
            boolean playAgain = Boolean.FALSE;

            do{
                if(abcdario.size()!=0) {
                    String letraRandom = abcdario.remove(rand.nextInt(abcdario.size()));
                    System.out.println(jugador.getNombre_jugador() + " elijo la letra " + letraRandom);
                    playAgain = letterIsHere(letraRandom);
                    System.out.println("-----------------------------------------------------");
                }
            }while(playAgain);

            if(isGameOver()){
                GameData.ganador = jugador;
            }
        }

        playing = Boolean.FALSE;
        notifyAll();

        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void winOrLose(){

        List<Letra> result = this.letras.stream()
                .filter(letra -> !letra.isBool())
                .collect(Collectors.toList());

        if(result.size() == 0){
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
