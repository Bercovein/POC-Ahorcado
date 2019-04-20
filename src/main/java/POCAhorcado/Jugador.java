package POCAhorcado;

import java.util.Objects;

public class Jugador {

    private Integer id_jugador;
    private String nombre_jugador;


    public Jugador( Integer id_jugador, String nombre_jugador ) {
        this.id_jugador = id_jugador;
        this.nombre_jugador = nombre_jugador;
    }

    public Integer getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador( Integer id_jugador ) {
        this.id_jugador = id_jugador;
    }

    public String getNombre_jugador() {
        return nombre_jugador;
    }

    public void setNombre_jugador( String nombre_jugador ) {
        this.nombre_jugador = nombre_jugador;
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
