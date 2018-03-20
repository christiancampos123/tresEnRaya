package tresenraya;

public class Ranking {

    //atributos
    int victoria;
    int jugadas;
    int empate;

    //constructor
    public Ranking() {
        this.victoria = 0;
        this.jugadas = 0;
        this.empate = 0;
    }
    //metodos

    public void mostrarRank() {
        System.out.println("Victorias = " + victoria);
        System.out.println("Empates = " + empate);
        System.out.println("Total Jugadas =" + jugadas);
    }

    public void addVictoria(boolean victoriaJ) {
        this.jugadas++;
        if (victoriaJ == true) {
            this.victoria++;
        }
    }

    public void addEmpate() {
        this.jugadas++;
        this.empate++;
    }
}
