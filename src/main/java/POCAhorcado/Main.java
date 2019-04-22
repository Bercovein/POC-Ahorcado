package POCAhorcado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Main {

    static List<Character> abcdario = abcdario();

    public static void main ( String[]args) {

        try{

            Palabra palabra = palabraRandom();
            List<Jugador> jugadores = cargarJugadores();


            System.out.println("Abecedario: " + Objects.requireNonNull(abcdario()).toString());

            System.out.println("Palabra: " + palabra.toString());

            System.out.println("Jugadores: " + jugadores.toString());

            //jugar(jugadores,palabra);

            //me tira este error:
            // Client does not support authentication protocol requested by server; consider upgrading MySQL client

            //funcion jugar donde se printee la cantidad de letras que tiene la palabra
            //que cada jugador tire una letra random (ver como exlcluir las ya dichas)
            //si acierta, refresca las letras y sigue adivinando
            //sino sigue el otro y repite.
            //gana el que adivina la ultima letra..
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public static void jugar(Jugador player, Palabra palabra){

        if(player!=null && palabra != null){

            Random rand = new Random();
            char letraRandom = abcdario.remove(rand.nextInt(27));
            System.out.println(letraRandom);
            
        }


    }

    public static List<Character> abcdario(){

        try{
            List<Character> abc = new ArrayList<Character>();
            char letra = 'a';

            for (int i = 0; i < 26; i++){
                abc.add(letra);
                letra++;
            }
            return abc;

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Palabra palabraRandom(){

        Palabra palabra = new Palabra("otorrinolaringologo");

        return palabra;
    }

    /*
    public static Palabra palabraRandom(){

        try{

            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcado", "root", "fusah222");
            Statement myStatement = myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("select palabra from palabras order by rand() limit 1");

            Palabra palabra = new Palabra(myResult.getString("palabra"));

            myResult.close();
            myStatement.close();
            myConnection.close();

            return palabra;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<Jugador> cargarJugadores(){

        try{
            List<Jugador> listado = new ArrayList<Jugador>();

            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcado", "root", "fusah222");
            Statement myStatement = myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("select nombre_jugador from jugadores order by rand() limit 2");

            while(myResult.next()){

                Jugador player = new Jugador
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

    public static List<Jugador> cargarJugadores(){

        try{
            List<Jugador> players = new ArrayList<Jugador>();

            Jugador readyPlayerOne = new Jugador(1,"Milhouse");
            Jugador readyPlayerTwo = new Jugador(2,"Bart");

            players.add(readyPlayerOne);
            players.add(readyPlayerTwo);

            return players;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
