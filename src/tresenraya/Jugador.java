package tresenraya;

import java.util.Scanner;

public class Jugador {

    //atributos
    private String nombre;
    private boolean cruces;

    //constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public boolean getCruces() {
        return this.cruces;
    }

    public void setCruces(boolean cruces) {
        this.cruces = cruces;
    }

    public Movimiento movimiento() {
        int fila;
        int columna;
        Movimiento movment;
        movment = new Movimiento();
        Scanner sc = new Scanner(System.in);
        movment.setCruces(this.cruces);
        movment.setJugador(this);

        System.out.println("Introduce Fila:");
        fila = sc.nextInt();
        while (!movment.setFila(fila)) {
            System.out.println("Error");
            fila = sc.nextInt();
        }
        System.out.println("Introduce Columna:");
        columna = sc.nextInt();
        while (!movment.setColumna(columna)) {
            System.out.println("Error");
            columna = sc.nextInt();
        }
        return movment;
    }
}
