package POCAhorcado;

import java.util.Objects;
import java.util.Random;

import static POCAhorcado.GameData.abcdario;
import static POCAhorcado.GameData.palabra;

public class Jugador extends Thread{

    private Integer id_jugador;
    private String nombre_jugador;
    static boolean playing = Boolean.FALSE;

    Jugador( Integer id_jugador, String nombre_jugador ) {
        this.id_jugador = id_jugador;
        this.nombre_jugador = nombre_jugador;
    }

    synchronized void play(){

        while(playing || !palabra.isGameOver()){
            try {
                System.out.println("Soy " + this.getNombre_jugador() + " y me voy a dormir");
                wait();
                System.out.println("Soy " + this.getNombre_jugador() + " y me desperté!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        setPlaying(Boolean.TRUE);

        palabra.winOrLose();

        if(!palabra.isGameOver()){

            Random rand = new Random();
            boolean playAgain = Boolean.FALSE;

            do{
                if(abcdario.size()!=0) {
                    String letraRandom = abcdario.remove(rand.nextInt(abcdario.size()));
                    System.out.println(this.getNombre_jugador() + " elijo la letra " + letraRandom);
                    playAgain = palabra.letterIsHere(letraRandom);
                }
            }while(playAgain);

        }else{
            System.out.println("Ganador: " + this.getNombre_jugador());
            //aca deberia guardar el ganador
        }

        setPlaying(Boolean.FALSE);

        Thread.currentThread().notify();

        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPlaying() {
        return playing;
    }

    public static void setPlaying( boolean playing ) {
        Jugador.playing = playing;
    }

    public void run(){

        while(!palabra.isGameOver()) play();
    }


    public String getNombre_jugador() {
        return nombre_jugador;
    }


    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(id_jugador, jugador.id_jugador) &&
                Objects.equals(nombre_jugador, jugador.nombre_jugador);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_jugador, nombre_jugador);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id_jugador=" + id_jugador +
                ", nombre_jugador='" + nombre_jugador + '\'' +
                '}';
    }
}
