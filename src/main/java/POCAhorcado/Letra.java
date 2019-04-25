package POCAhorcado;

public class Letra {

    private String letra;
    private boolean bool;

    Letra(String letra) {
        this.letra = letra;
        this.bool = false;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra( String letra ) {
        this.letra = letra;
    }

    public boolean isBool() {
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
