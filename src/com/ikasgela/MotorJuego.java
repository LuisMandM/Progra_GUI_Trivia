package com.ikasgela;

public class MotorJuego {
    private int[][] tablero = new int[3][3];
    private int jugador;
    private int tiradas;

    //Constructor
    public MotorJuego() {
        reset();
    }


    //Llenar tablero inicial
    public void reset() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = -1;
            }
        }
        this.jugador = 0;
        this.tiradas = 0;
    }

    //tirada
    public String tirada(int fila, int columna) {
        String caracter;
        if (tiradas < 9 && hayGanador() == -1 && !empate()) {
            tablero[fila][columna] = jugador;
            if (jugador == 0) {
                caracter = "O";
                jugador = 1;
            } else {
                caracter = "X";
                jugador = 0;
            }
            tiradas++;

        } else {
            caracter = "";
        }
        return caracter;
    }


    //ComprobarGanador
    public int hayGanador() {
        if (comprobarJugada()) return this.jugador;
        else return -1;
    }

    //Empate
    public boolean empate() {
        return tiradas == 9 && hayGanador() == -1;
    }

    private boolean comprobarJugada() {
        if (tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]
                && tablero[0][0] != -1) {
            return true;
        } else if (tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]
                && tablero[0][2] != -1) {
            return true;
        } else {

            for (int i = 0; i < tablero.length; i++) {
                if (tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]
                        && tablero[i][0] != -1) {
                    return true;
                } else if (tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i]
                        && tablero[0][i] != -1) {
                    return true;
                }
            }
        }
        return false;
    }
}
