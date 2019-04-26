package POCAhorcado;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conector {

    private Connection myConnection;

    public Conector() {

        try {
            myConnection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/ahorcado",
                            "root",
                            "fusah222");

            Class.forName("com.mysql.jdbc.Driver");

        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void guardarGanador(Jugador ganador, Palabra palabra) {

        try {
            Statement myStatement = myConnection.createStatement();
            myStatement.executeUpdate(String.format(
                    "insert into resultados (id_jugador, id_palabra, fecha) values('%s','%s',now())",
                    ganador.getId_jugador(), palabra.getId_palabra()));

            myStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConector()  {
        try {
            myConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Thread> cargarJugadores(){

        try{
            List<Thread> listado = new ArrayList<Thread>();

            Statement myStatement = myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("select nombre_jugador from jugadores order by rand() limit 2");

            while(myResult.next()){

                Thread player = new Jugador
                        (myResult.getInt("id_jugador"),
                                myResult.getString("nombre_jugador"));

                listado.add(player);
            }
            myResult.close();
            myStatement.close();

            return listado;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static Palabra palabraRandom(){

        try{

            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcado", "root", "fusah222");
            Statement myStatement = myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("select palabra from palabras order by rand() limit 1");

            Palabra palabra = new Palabra(myResult.getInt("id_palabra"),
                myResult.getString("palabra"));

            myResult.close();
            myStatement.close();

            return palabra;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    /*
    List<Thread> cargarJugadores(){

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

    static Palabra palabraRandom(){

        return new Palabra(1,"otorrinolaringologo");
    }
*/
}