package POCAhorcado;

public class Letra {

    private String letra;
    private boolean bool;

    Letra(String letra) {
        this.letra = letra;
        this.bool = false;
    }

    String getLetra() {
        return letra;
    }

    boolean isBool() {
        return bool;
    }

    public void setBool( boolean bool ) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return letra;
    }
}
