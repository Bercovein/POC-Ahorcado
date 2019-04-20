package POCAhorcado;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main ( String[]args) {

        try {
            Palabra palabra = palabraRandom();;
            List<Jugador> jugadores = cargarJugadores();

            System.out.println(palabra.toString());
            System.out.println(jugadores.toString());

            //me tira este error:
            // Client does not support authentication protocol requested by server; consider upgrading MySQL client

            //funcion jugar donde se printee la cantidad de letras que tiene la palabra
            //que cada jugador tire una letra random (ver como exlcluir las ya dichas)
            //si acierta, refresca las letras y sigue adivinando
            //sino sigue el otro y repite.
            //gana el que adivina la ultima letra..

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
            List<Jugador> listado = null;

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


}
