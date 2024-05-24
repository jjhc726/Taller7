package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelSuperior extends JPanel {

    private JComboBox<String> comboBoxTamano;
    private JRadioButton radioButtonFacil;
    private JRadioButton radioButtonMedio;
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

    public String getTamanoSeleccionado() {
        return (String) comboBoxTamano.getSelectedItem();
    }

    public String getDificultadSeleccionada() {
        if (radioButtonFacil.isSelected()) {
            return "Facil";
        } else if (radioButtonMedio.isSelected()) {
            return "Medio";
        } else {
            return "Dificil";
        }
    }

    private class ComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VentanaPrincipal.notificarCambioTamano(PanelSuperior.this);
        }
    }
}
