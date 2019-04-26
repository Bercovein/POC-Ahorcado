package POCAhorcado;

import java.util.Objects;
import static POCAhorcado.GameData.palabra;

public class Jugador extends Thread{

    private Integer id_jugador;
    private String nombre_jugador;

    Jugador( Integer id_jugador, String nombre_jugador ) {
        this.id_jugador = id_jugador;
        this.nombre_jugador = nombre_jugador;
    }


    public void run(){
        while(!palabra.isGameOver()&& !palabra.playing)
        {
            palabra.play(this);
        }
    }

    public Integer getId_jugador() {
        return id_jugador;
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
