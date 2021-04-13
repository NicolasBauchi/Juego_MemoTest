package clases;

/**
 *
 * @author Notebook Nico
 */
public class Puntaje {

    private int puntos;
//    String jugador;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Puntaje() {
        puntos = 0;
    }

    public void SumarPunto() {
        puntos++;
    }
}
