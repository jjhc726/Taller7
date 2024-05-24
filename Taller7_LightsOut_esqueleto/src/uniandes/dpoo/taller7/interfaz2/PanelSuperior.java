package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {

    public PanelSuperior() {

        JLabel labelTamano = new JLabel("Tamaño:");
        String[] opcionesTamano = {"5x5", "6x6", "7x7", "8x8"};
        JComboBox<String> comboBoxTamano = new JComboBox<>(opcionesTamano);
        JLabel labelDificultad = new JLabel("Dificultad:");
        JRadioButton radioButtonFacil = new JRadioButton("Facil");
        JRadioButton radioButtonMedio = new JRadioButton("Medio");
        JRadioButton radioButtonDificil = new JRadioButton("Dificil");

        ButtonGroup grupoDificultad = new ButtonGroup();
        grupoDificultad.add(radioButtonFacil);
        grupoDificultad.add(radioButtonMedio);
        grupoDificultad.add(radioButtonDificil);

        add(labelTamano);
        add(comboBoxTamano);
        add(labelDificultad);
        add(radioButtonFacil);
        add(radioButtonMedio);
        add(radioButtonDificil);
    }
}
