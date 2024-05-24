package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel {

    public PanelInferior() {
        JLabel labelJugadas = new JLabel("Jugadas:");
        JTextField textFieldJugadas = new JTextField(5);
        JLabel labelJugador = new JLabel("Jugador:");
        JTextField textFieldJugador = new JTextField(15);
        textFieldJugadas.setText("0");
        textFieldJugadas.setEditable(false);

        add(labelJugadas);
        add(textFieldJugadas);
        add(labelJugador);
        add(textFieldJugador);
    }
}
