package tresenraya;

public class Partida {

    //atributos
    private Jugador jugador[];
    private Tablero tablero;
    private int turno;
    private int victoriaJ;

    //constructor
    public Partida(Jugador Cruces, Jugador Circulos) {

        this.jugador = new Jugador[2];
        //Que jugador juega con cada figura.
        this.jugador[0] = Cruces;
        this.jugador[1] = Circulos;

        this.jugador[0].setCruces(true);
        this.jugador[1].setCruces(false);


        this.tablero = new Tablero();
        this.victoriaJ = -1;

        if (jugador[0] instanceof IA0) {
            ((IA0) jugador[0]).setTablero(this.tablero);
        } else {
            ((IA0) jugador[1]).setTablero(this.tablero);
        }

    }

    //Metodos
    public Tablero getTablero() {
        return tablero;
    }

    public void jugar() {
        //con ayuda
        Movimiento mov;
        int turnoJ;

        for (int turno = 0; !tablero.comprobarLleno() && tablero.comprobarVictoria() == -1; turno++) {
            turnoJ = turno % 2;
            if (turno == 0) {
                System.out.println("Juegan Cruces");
            }

            if (turno == 1) {
                System.out.println("Juegan Circulos");
            }

            mov = jugador[turnoJ].movimiento();

            if (!tablero.celdaVacia(mov.getFila(), mov.getColumna())) {
                victoriaJ = Math.abs(turnoJ - 1);
                break;
            }
            tablero.mover(mov);
            this.tablero.mostrarTablero();
        }
    }

    public boolean Ganador() {
        if (victoriaJ != -1) {
            System.out.println("Celda invalida");
            if (jugador[victoriaJ] instanceof IA0){
                return false;
            } else {
                return true;
            }   
        } 
        if(jugador[tablero.comprobarVictoria()] instanceof IA0){
            return false;
        }
        return true;
    }    
}
