package POCAhorcado;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static POCAhorcado.Conector.palabraRandom;

final class GameData {

    static List<String> abcdario = abcdario();
    static Palabra palabra = palabraRandom();
    static Jugador ganador = null;

    static List<String> abcdario(){

        return new LinkedList<String>(Arrays.asList("a","b","c","d","e","f","g","h","i","j",
                "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
    }
}
