package tresenraya;

public class Movimiento {

//Atributos
    public boolean cruces;
    private int fila;
    private int columna;
    private Jugador jugador;

    public Movimiento() {

    }

    public Movimiento(boolean cruces, int fila, int columna, Jugador jugador) {
        this.cruces = cruces;
        this.fila = fila;
        this.columna = columna;
        this.jugador = jugador;
    }
//getters

    public boolean getCruces() {
        return this.cruces;
    }

    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    //seters
    public void setCruces(boolean cruces) {
        this.cruces = cruces;
    }

    public boolean setFila(int fila) {
        if (fila < 0 || fila > 2) {
            return false;
            //movimiento Invalido
        } else {
            //movimiento Valido
            
            this.fila = fila;
            return true;
        }
    }

    public boolean setColumna(int columna) {
        if (columna < 0 || columna > 2) {
            return false;
            //movimiento Invalido
        } else {
            //movimiento Valido

            this.columna = columna;
            return true;
        }
    }

    public void setJugador(Jugador jugador) {
        if (jugador != null) {
            this.jugador = jugador;
        }
    }
}
