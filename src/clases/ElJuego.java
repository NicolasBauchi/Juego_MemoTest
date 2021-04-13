package clases;

import java.util.Scanner;

/**
 *
 * @author nbauchi
 */
public class ElJuego {

    private Puntaje puntaje = new Puntaje();
    private Scanner sc = new Scanner(System.in);
    private Tablero tablero = new Tablero(6, 6);
    private int finJugada = 0;
    private int col = 0;
    private int fil = 0;
    private int contJugada = 0;
    private Colocacion memoria = new Colocacion(null, null);

    public void Arranque() {
        System.out.println("");
        System.out.println("***********************************");
        System.out.println("** Bienvenido al Juego MemoTest! **");
        System.out.println("***********************************");
        System.out.println("");

        do {

            System.out.println("      Seleccione una opción ");
            System.out.println("      1_ Jugar ");
            System.out.println("      2_ Ver tablero destapado ");
            System.out.println("      3_ Cerrar juego ");
            System.out.println("");
            System.out.print("      Opcion -> ");
            int opcion = sc.nextInt();
            if (opcion == 1) {
                puntaje.setPuntos(0);
                Jugar();
            }
            if (opcion == 2) {
                tablero.DestaparFichas();
                tablero.MostrarTablero();
            }
            if (opcion == 3) {
                System.exit(0);
            }

        } while (true);
    }

    public void Jugar() {
        tablero.SeteoInicial();
        tablero.setPuntaje(puntaje);
        tablero.MostrarTablero();
        int puntajeMaximo = (tablero.getFilas() * tablero.getColumnas()) / 2;

        do {
            IngresoDatos();
            ControlJugada();

        } while (puntaje.getPuntos() < puntajeMaximo && finJugada == 0);
        if (finJugada == 0) {
            System.out.println(" ¡Ganador! ");
            System.out.println("Con " + puntaje.getPuntos() + " puntos ganados!");
        }

    }

    private void IngresoDatos() {
        col = 0;
        fil = 0;

        System.out.print(" Elegir fila: ");
        fil = sc.nextInt();
        System.out.println("");
        System.out.print(" Elegir columna: ");
        col = sc.nextInt();

    }

    private void ControlJugada() {

        if (col > -1 && fil > -1) {
            if (col == 99 && fil == 99) {
                finJugada = 1;
            }
            Posicion posicion = new Posicion(fil, col);
            tablero.Destapar(posicion);

            if (contJugada == 0) {
                memoria = tablero.retornarFicha(posicion);
                contJugada++;

            } else if (contJugada == 1) {
                if (memoria.getFicha().getNombreFicha().equals(tablero.retornarFicha(posicion).getFicha().getNombreFicha())) { // hay cmatch
                    puntaje.SumarPunto();
                    System.out.println("");
                    System.out.println("Ganaste 1 punto.");
                    memoria.getFicha().setEncontrado(true);
                    tablero.retornarFicha(posicion).getFicha().setEncontrado(true);

                } else if (!memoria.getFicha().equals(tablero.retornarFicha(posicion).getFicha())) { // no hay match

                    tablero.setPuntaje(puntaje);
                    tablero.MostrarTablero();
                    HagoTiempo();
                    //Con lo siguiente controlo que no tape fichas que ya fueron encontradas.
                    if (tablero.retornarFicha(posicion).getFicha().isEncontrado() == false) {
                        tablero.Tapar(posicion);
                    }
                    if (memoria.getFicha().isEncontrado() == false) {
                        tablero.Tapar(memoria.getPosicion());
                    }
                    //
                    System.out.println("");
                    System.out.println("No hubo coincidencia.");
                    memoria.setFicha(null);
                    memoria.setPosicion(null);
                }
                contJugada = 0;
            }
            tablero.setPuntaje(puntaje);
            tablero.MostrarTablero();

        } else {
            System.out.println("Reintentar. EScriba SOLO números mayor que -1.");

        }
    }

    private void HagoTiempo() {
        try {
            Thread.sleep(2500); // 2500 ms = 2,5 seg.
        } catch (InterruptedException e) {
            System.out.println("el catch de interrupted exepcion hago tiempo");
        }

    }
}
