package tresenraya;

public class Tablero {
    //atributos

    private int tablero[][];
    //constructor

    public Tablero() {
        this.tablero = new int[3][3];
        int fila = 0;
        int columna = 0;

        //bucle para y crearlo vacio.
        while (fila <= 2) {
            while (columna <= 2) {
                this.tablero[fila][columna] = -1;
                columna++;
            }
            columna = 0;
            fila++;
        }
    }

    //metodos
    public boolean celdaVacia(int fila, int columna) {
        if (this.tablero[fila][columna] != -1) {
            return false;
        }
        return true;
    }

    public boolean comprobarEmp() {
        if (tablero[0][0] == tablero[0][1] && tablero[0][1] == tablero[0][2]) {
            return false;
        }
        if (tablero[1][0] == tablero[1][1] && tablero[1][1] == tablero[1][2]) {
            return false;
        }
        if (tablero[2][0] == tablero[2][1] && tablero[2][1] == tablero[2][2]) {
            return false;
        }
        if (tablero[0][0] == tablero[1][0] && tablero[1][0] == tablero[2][0]) {
            return false;
        }
        if (tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1]) {
            return false;
        }
        if (tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2]) {
            return false;
        }
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return false;
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return false;
        }

        return true;
    }

    
    public boolean comprobarLleno() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (tablero[fila][columna] == -1) {
                    return false;
                    
                }
            }
        }
        return true;
    }

    public int comprobarVictoria() {
        if (tablero[0][0] == tablero[0][1] && tablero[0][1] == tablero[0][2] && tablero[0][2] != -1) {
            return tablero[0][0];
        }
        if (tablero[1][0] == tablero[1][1] && tablero[1][1] == tablero[1][2] && tablero[1][2] != -1) {
            return tablero[1][1];
        }
        if (tablero[2][0] == tablero[2][1] && tablero[2][1] == tablero[2][2] && tablero[2][2] != -1) {
            return tablero[2][1];
        }
        if (tablero[0][0] == tablero[1][0] && tablero[1][1] == tablero[2][0] && tablero[2][0] != -1) {
            return tablero[1][1];
        }
        if (tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1] && tablero[2][1] != -1) {
            return tablero[1][1];
        }
        if (tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2] && tablero[2][2] != -1) {
            return tablero[1][2];
        }
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[2][2] != -1) {
            return tablero[1][1];
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[2][0] != -1) {
            return tablero[1][1];
        }
        return -1;
    }

    public int getCelda(int fila, int columna) {
        return this.tablero[fila][columna];
    }

    public void mostrarTablero() {
        int fila = 0;
        int columna = 0;
        while (fila <= 2) {
            while (columna <= 2) {
                if(this.tablero[fila][columna] != -1){
                    if(this.tablero[fila][fila] == 0){
                        System.out.print("[X]");
                    } else {
                        System.out.print("[O]");
                    }  
                } else {
                    System.out.print("[ ]");
                }
                
                columna++;
            }
            columna = 0;
            fila++;
            System.out.println();
        }

    }

public void mover(Movimiento mov) {

        if (mov.getCruces()) {
            tablero[mov.getFila()][mov.getColumna()] = 0;

        } else {
            tablero[mov.getFila()][mov.getColumna()] = 1;
        }

    }

    public boolean validarMovimiento(Movimiento mov) {
        if (tablero[mov.getFila()][mov.getColumna()] != -1) {
            return false;

        }
        return true;
    }
}