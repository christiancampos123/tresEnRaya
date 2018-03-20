package tresenraya;

public class IA0 extends Jugador {

    private Tablero tablero;

    public IA0() {
        super("IA0");
    }

    @Override
    public Movimiento movimiento() {
        Movimiento mov;
        mov = new Movimiento();

        mov.setJugador(this);
        mov.setCruces(this.getCruces());

        for (int fila = 0; fila <= 2; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (this.tablero.celdaVacia(fila, columna) == true) {
                    mov.setFila(fila);
                    mov.setColumna(columna);
                    return mov;
                }
            }
        }
        return null;
    }

    public void setTablero(Tablero tab) {
        if (tab != null) {
            this.tablero = tab;
        }
    }
}
