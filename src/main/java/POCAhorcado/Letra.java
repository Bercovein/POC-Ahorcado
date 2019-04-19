package POCAhorcado;

public class Letra {

    private char letra;
    private boolean bool;

    public Letra() {
    }

    public Letra( char letra) {
        this.letra = letra;
        this.bool = false;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra( char letra ) {
        this.letra = letra;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool( boolean bool ) {
        this.bool = bool;
    }
}
