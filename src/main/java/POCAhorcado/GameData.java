package POCAhorcado;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

final class GameData {

    static List<String> abcdario = abcdario();
    static Palabra palabra = palabraRandom();

    static List<String> abcdario(){

        List<String> abc = new LinkedList<String>(Arrays.asList("a","b","c","d","e","f","g","h","i","j",
                "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));

        return abc;
    }

    static Palabra palabraRandom(){

        return new Palabra("otorrinolaringologo");
    }

    /*
    public static Palabra palabraRandom(){

        try{

            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcado", "root", "fusah222");
            Statement myStatement = myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("select palabra from palabras order by rand() limit 1");

            Palabra palabra = new Palabra(myResult.getString("palabra"));

            //hacer que la palabra sea tolower()

            myResult.close();
            myStatement.close();
            myConnection.close();

            return palabra;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    */
}
