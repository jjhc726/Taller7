package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel {

    private JTextField textFieldJugadas;
    private JTextField textFieldJugador;

    public PanelInferior() {
        JLabel labelJugadas = new JLabel("Jugadas:");
        textFieldJugadas = new JTextField(5);
        JLabel labelJugador = new JLabel("Jugador:");
        textFieldJugador = new JTextField(15);
        textFieldJugadas.setText("0");
        textFieldJugadas.setEditable(false);
        textFieldJugador.setEditable(false);

        add(labelJugadas);
        add(textFieldJugadas);
        add(labelJugador);
        add(textFieldJugador);
    }

    public void actualizarNombreJugador(String nombre) {
        textFieldJugador.setText(nombre);
    }

    public void actualizarNumeroJugadas(int jugadas) {
        textFieldJugadas.setText(String.valueOf(jugadas));
    }
}
