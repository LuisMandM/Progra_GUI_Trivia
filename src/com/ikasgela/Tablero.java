package com.ikasgela;

import javax.swing.*;

public class Tablero {


    private JButton b1;
    private JButton b4;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b6;
    private JButton b3;
    private JButton b2;
    private JButton b5;
    private JPanel tablero;

    private static final MotorJuego current = new MotorJuego();

    public Tablero() {
        b1.addActionListener(e -> {
            String jugada = jugar(0, 0);
            if (!jugada.equals("")) b1.setText(jugada);
            else clean();
        });
        b2.addActionListener(e -> {
            String jugada = jugar(0, 1);
            if (!jugada.equals("")) b2.setText(jugada);
            else clean();

        });
        b3.addActionListener(e -> {
            String jugada = jugar(0, 2);
            if (!jugada.equals("")) b3.setText(jugada);
            else clean();
        });
        b4.addActionListener(e -> {
            String jugada = jugar(1, 0);
            if (!jugada.equals("")) b4.setText(jugada);
            else clean();
        });
        b5.addActionListener(e -> {
            String jugada = jugar(1, 1);
            if (!jugada.equals("")) b5.setText(jugada);
            else clean();
        });
        b6.addActionListener(e -> {
            String jugada = jugar(1, 2);
            if (!jugada.equals("")) b6.setText(jugada);
            else clean();
        });
        b7.addActionListener(e -> {
            String jugada = jugar(2, 0);
            if (!jugada.equals("")) b7.setText(jugada);
            else clean();

        });
        b8.addActionListener(e -> {
            String jugada = jugar(2, 1);
            if (!jugada.equals("")) b8.setText(jugada);
            else clean();

        });
        b9.addActionListener(e -> {
            String jugada = jugar(2, 2);
            if (!jugada.equals("")) b9.setText(jugada);
            else clean();
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tablero");
        frame.setContentPane(new Tablero().tablero);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static String jugar(int fila, int columna) {
        String caracter;
        caracter = current.tirada(fila, columna);

        if (current.empate()) {
            JOptionPane.showMessageDialog(null, "EMPATE", "Resultado",
                    JOptionPane.ERROR_MESSAGE);
            current.reset();
            caracter = "";
        } else if (current.hayGanador() != -1) {
            if (current.hayGanador() == 0) {
                JOptionPane.showMessageDialog(null, "Ganador jugador 2", "Resultado",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ganador jugador 1", "Resultado",
                        JOptionPane.ERROR_MESSAGE);
            }
            current.reset();
            caracter = "";

        }
        return caracter;

    }

    public void clean() {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }

}
