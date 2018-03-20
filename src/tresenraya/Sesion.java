package tresenraya;

import java.util.ArrayList;
import java.util.Scanner;

public class Sesion {

    //atributos
    private Jugador jugador;
    private IA0 jugadorA;
    private ArrayList<Partida> partidas;
    private Ranking ranking;

    //constructor
    public Sesion() {
        this.partidas = new ArrayList();
        this.jugadorA = new IA0();
        this.ranking = new Ranking();
    }

    //metodos
    public void newJugador() {
        System.out.println("Nombre:");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();  //aun ni idea
        this.jugador = new Jugador(nombre);
    }
    
    public void newPartida(){
        Partida part;
        int sorteo;
        sorteo = this.sorteo();
        
        if(sorteo == 0 ){
            part= new Partida(this.jugador, this.jugadorA);
            System.out.println("Empiezas Tu!");
        } else {
            part= new Partida(this.jugadorA, this.jugador);
            System.out.println("Vas Segundo!");
        }
        part.jugar();
        this.rankingAct(part);
    }
    
    private void rankingAct(Partida part){
        if (part.getTablero().comprobarEmp()){
            System.out.println("Empate");
            this.ranking.addEmpate(); //llamamos add empate
        }else {
        if (part.Ganador()){
            this.ranking.addVictoria(true);
            System.out.println("VICTORIA!");
        }else{
            this.ranking.addVictoria(false);
        }
    }
        
    }
    

     public void iniciarSesion() {
         this.newJugador();
        int opcion = 0;
        do {
            opcion = this.menu();
            switch (opcion) {

                case 1:

                    newPartida();
                    break;

                case 2:

                    this.ranking.mostrarRank();
                    break;
            }

        } while (opcion != 3);

    }
     
public int menu() {

        System.out.println("1 para jugar."
                + "2 ver el ranking."
                + "3 para salir.");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        return opcion;

    }     

    public int sorteo() {
        int numeraco;
        numeraco = (int) (Math.random() * 2);
        if(numeraco == 0){
            System.out.println("Empiezas tu!");
        } else {
            System.out.println ("Empieza la IA!");
        }
        
        return numeraco;
    }

    public static void main(String[] args) {
        Sesion sesion;
        sesion = new Sesion();
        sesion.iniciarSesion();
    }
}
