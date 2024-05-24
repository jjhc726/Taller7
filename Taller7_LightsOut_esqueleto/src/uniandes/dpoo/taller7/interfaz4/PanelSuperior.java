package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelSuperior extends JPanel {

    private static JComboBox<String> comboBoxTamano;
    private static JRadioButton radioButtonFacil;
    private static JRadioButton radioButtonMedio;
    private JRadioButton radioButtonDificil;

    private ComboBoxListener comboBoxListener;

    public PanelSuperior() {
        JLabel labelTamano = new JLabel("Tamaño:");
        String[] opcionesTamano = {"5x5", "6x6", "7x7", "8x8"};
        comboBoxTamano = new JComboBox<>(opcionesTamano);
        JLabel labelDificultad = new JLabel("Dificultad:");
        radioButtonFacil = new JRadioButton("Facil");
        radioButtonMedio = new JRadioButton("Medio");
        radioButtonDificil = new JRadioButton("Dificil");

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

        comboBoxListener = new ComboBoxListener();
        
        comboBoxTamano.addActionListener(comboBoxListener);
    }

    public static String getTamanoSeleccionado() {
        return (String) comboBoxTamano.getSelectedItem();
    }

    public static int getDificultadSeleccionada() {
        if (radioButtonFacil.isSelected()) {
            return 1;
        } else if (radioButtonMedio.isSelected()) {
            return 2;
        } else {
            return 3;
        }
    }
    

    private class ComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VentanaPrincipal.notificarCambioTamano(PanelSuperior.this);
        }
    }
}
