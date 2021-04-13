package clases;

/**
 *
 * @author nbauchi
 */
public class Posicion {

    private int ejeX;
    private int ejeY;

    public int getEjeX() {
        return ejeX;
    }

    public void setEjeX(int ejeX) {
        this.ejeX = ejeX;
    }

    public int getEjeY() {
        return ejeY;
    }

    public void setEjeY(int ejeY) {
        this.ejeY = ejeY;
    }

    public Posicion(int ejeX, int ejeY) {
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }

    @Override
    public String toString() {
        return "Eje X: " + getEjeX() + ", Eje Y: " + getEjeY();
    }

}
