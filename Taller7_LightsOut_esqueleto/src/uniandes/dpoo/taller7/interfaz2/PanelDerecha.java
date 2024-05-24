package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;

public class PanelDerecha extends JPanel {

    public PanelDerecha() {
        setLayout(new GridLayout(4, 1));

        JButton botonNuevo = new JButton("NUEVO");
        JButton botonReiniciar = new JButton("REINICIAR");
        JButton botonTop10 = new JButton("TOP-10");
        JButton botonCambiarJugador = new JButton("CAMBIAR JUGADOR");
        
        Dimension buttonSize = new Dimension(100, 30);
        botonNuevo.setPreferredSize(buttonSize);
        botonReiniciar.setPreferredSize(buttonSize);
        botonTop10.setPreferredSize(buttonSize);
        botonCambiarJugador.setPreferredSize(buttonSize);
        
        add(botonNuevo);
        add(botonReiniciar);
        add(botonTop10);
        add(botonCambiarJugador);
    }
}
