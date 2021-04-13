
package clases;

/**
 *
 * @author nbauchi
 */
public class Colocacion {
    private Ficha ficha;
    private Posicion posicion;

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Colocacion(Ficha ficha, Posicion posicion) {
        this.ficha = ficha;
        this.posicion = posicion;
    }
    
    
}
