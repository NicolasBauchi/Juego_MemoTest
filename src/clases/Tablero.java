package clases;

import java.util.ArrayList;
import java.util.Collections;

public class Tablero {

    private Puntaje puntaje = new Puntaje();
    private int filas;
    private int columnas;
    public ArrayList<Colocacion> fichasColocar = new ArrayList();
    private Ficha[][] ubicacion;

    private ArrayList<Ficha> listaFichas = new ArrayList(); //para crear cantidad de fichas para jugar.

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Puntaje puntaje) {
        this.puntaje = puntaje;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    private void AgregarFicha(Ficha ficha, Posicion posicion) {
        Colocacion nuevaFicha = new Colocacion(ficha, posicion);
        fichasColocar.add(nuevaFicha);
    }

    public void Tapar(Posicion posicion) {

        for (int i = 0; i < fichasColocar.size(); i++) {

            if (fichasColocar.get(i).getPosicion().getEjeX() == posicion.getEjeX()
                    && fichasColocar.get(i).getPosicion().getEjeY() == posicion.getEjeY()) {
                if (fichasColocar.get(i).getFicha().isTapado() == false) {
                    fichasColocar.get(i).getFicha().setTapado(true);
                } else {
                    System.out.println("La ficha está tapada.");
                }

            }

        }

    }

    public void Destapar(Posicion posicion) {
        for (int i = 0; i < fichasColocar.size(); i++) {

            if (fichasColocar.get(i).getPosicion().getEjeX() == (posicion.getEjeX())
                    && fichasColocar.get(i).getPosicion().getEjeY() == (posicion.getEjeY())) {

                if (fichasColocar.get(i).getFicha().isTapado() == true) {
                    fichasColocar.get(i).getFicha().setTapado(false);

                } else {
                    System.out.println("La ficha ya está destapada.");
                }

            }
        }
    }

    public Colocacion retornarFicha(Posicion posicion) {
        Colocacion memoria = new Colocacion(null, null);

        for (int i = 0; i < fichasColocar.size(); i++) {

            if (fichasColocar.get(i).getPosicion().getEjeX() == posicion.getEjeX()
                    && fichasColocar.get(i).getPosicion().getEjeY() == posicion.getEjeY()) {
                memoria.setFicha(fichasColocar.get(i).getFicha());
                memoria.setPosicion(posicion);

            }
        }
        return memoria;
    }

    public void SeteoInicial() {
        ubicacion = new Ficha[filas][columnas];
        FichasParaTablero();
        RellenarTablero();

    }

    public void MostrarTablero() {
        System.out.println("\n \n ");
        System.out.println("Puntaje: " + puntaje.getPuntos()+" puntos.");
        System.out.println("----------------------");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(ubicacion[i][j].toString());
            }
            System.out.println("");
        }
        System.out.println("----------------------");
        System.out.println("\n \n");

    }

    public void DestaparFichas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                ubicacion[i][j].setTapado(false);
            }
        }

    }

    private void FichasParaTablero() {
        int FichasTotal = (filas * columnas) / 2;
        //Creo N° fichas.
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < FichasTotal + 1; i++) {
                Ficha ficha = new Ficha("F" + i, true, false);
//                System.out.print(ficha.getNombreFicha() + ", ");
                listaFichas.add(ficha);
            }
        }
        System.out.println("");

    }

    private void RellenarTablero() {
        int cantFichas = listaFichas.size() - 1;
        Collections.shuffle(listaFichas); // Mezclo las fichas.

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {
//                if (cantFichas == 0) {
//                    cantFichas = listaFichas.size();// - 1;
//                }
                Posicion posicion = new Posicion(i, j);
                AgregarFicha(listaFichas.get(cantFichas), posicion);
                cantFichas--;
            }

        }

        for (int i = 0; i < fichasColocar.size(); i++) {
            ubicacion[fichasColocar.get(i).getPosicion().getEjeX()][fichasColocar.get(i).getPosicion().getEjeY()] = fichasColocar.get(i).getFicha();
        }

    }

}
