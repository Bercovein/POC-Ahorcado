package POCAhorcado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main ( String[]args) {

        List<Thread> jugadores = cargarJugadores();

        //System.out.println("Abecedario: " + Objects.requireNonNull(GameData.abcdario).toString());

        //System.out.println("Palabra: " + GameData.palabra.toString());

        jugadores.get(0).stop();
        jugadores.get(1).stop();

        GameData.palabra.winOrLose();
/*
        assert jugadores != null;
        System.out.println("Jugadores: " + jugadores.toString());

        jugadores.get(0).start();
        jugadores.get(1).start();*/


    }

/*
    public static List<Thread> cargarJugadores(){

        try{
            List<Thread> listado = new ArrayList<Thread>();

            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcado", "root", "fusah222");
            Statement myStatement = myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("select nombre_jugador from jugadores order by rand() limit 2");

            while(myResult.next()){

                Thread player = new Jugador
                        (myResult.getInt("id_jugador"),
                        myResult.getString("nombre_jugador"));

                listado.add(player);
            }
            return listado;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
*/

    public static List<Thread> cargarJugadores(){

        try{
            List<Thread> players = new ArrayList<Thread>();

            Thread readyPlayerOne = new Jugador(1,"Milhouse");
            Thread readyPlayerTwo = new Jugador(2,"Bart");

            players.add(readyPlayerOne);
            players.add(readyPlayerTwo);

            return players;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
