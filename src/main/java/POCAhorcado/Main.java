package POCAhorcado;

import java.util.List;
import java.util.Objects;


public class Main {

    public static void main ( String[]args) {

        Conector conector = new Conector ();

        List<Thread> jugadores = conector.cargarJugadores();

        System.out.println("Abecedario: " + Objects.requireNonNull(GameData.abcdario).toString());

        System.out.println("Palabra: " + GameData.palabra.toString());

        GameData.palabra.winOrLose();

        assert jugadores != null;
        System.out.println("Jugadores: " + jugadores.toString());

        jugadores.get(0).start();
        jugadores.get(1).start();

        conector.guardarGanador(GameData.ganador,GameData.palabra);

        conector.closeConector();

        System.out.println(GameData.ganador.toString());
        System.out.println(GameData.palabra.toString());
    }
}
