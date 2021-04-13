package clases;

public class Ficha {

    private String nombreFicha;
    private boolean tapado;
    private boolean encontrado;

    public boolean isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }

    public String getNombreFicha() {
        return nombreFicha;
    }

    public void setNombreFicha(String nombreFicha) {
        this.nombreFicha = nombreFicha;
    }

    public Ficha(String nombreFicha, boolean tapado, boolean encontrado) {
        this.nombreFicha = nombreFicha;
        this.tapado = tapado;
        this.encontrado = encontrado;
    }

    public Ficha() {

    }

    public boolean isTapado() {
        return tapado;
    }

    public void setTapado(boolean tapado) {
        this.tapado = tapado;
    }

    @Override
    public String toString() {

        if (tapado == true) {
            return " [*] ";
        } else {
            return " " + nombreFicha + " ";
        }

    }

}
