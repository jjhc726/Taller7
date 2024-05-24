package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDerecha extends JPanel {
    
    private JButton nuevoButton;
    private JButton botonReiniciar;
    private JButton botonTop10;
    private JButton botonCambiarJugador;
    private PanelSuperior panelSuperior;
    private Tablero tablero;
    private PanelTablero panelTablero;
    private boolean[][] tableroActual;
    private int contadorJugadas;
    private Top10 top10;
    private VentanaPrincipal ventanaPrincipal;

    public PanelDerecha(PanelSuperior panelSuperior, Tablero tablero, PanelTablero panelTablero, Top10 top10, VentanaPrincipal ventanaPrincipal) {
        this.panelSuperior = panelSuperior;
        this.tablero = tablero;
        this.panelTablero = panelTablero;
        this.tableroActual = null;
        this.contadorJugadas = 0;
        this.top10 = top10;
        this.ventanaPrincipal = ventanaPrincipal;

        setLayout(new GridLayout(4, 1));

        nuevoButton = new JButton("NUEVO");
        botonReiniciar = new JButton("REINICIAR");
        botonTop10 = new JButton("TOP-10");
        botonCambiarJugador = new JButton("CAMBIAR JUGADOR");

        Dimension buttonSize = new Dimension(150, 20);
        nuevoButton.setPreferredSize(buttonSize);
        botonReiniciar.setPreferredSize(buttonSize);
        botonTop10.setPreferredSize(buttonSize);
        botonCambiarJugador.setPreferredSize(buttonSize);

        add(nuevoButton);
        add(botonReiniciar);
        add(botonTop10);
        add(botonCambiarJugador);

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nuevoTamano = Integer.parseInt(panelSuperior.getTamanoSeleccionado().split("x")[0]);
                int nuevaDificultad = panelSuperior.getDificultadSeleccionada();

                Tablero tablero = new Tablero(nuevoTamano);
                tablero.desordenar(nuevaDificultad);
                
                tableroActual = tablero.darTablero();
                contadorJugadas = 0;
                panelTablero.actualizarTablero(tableroActual);
            }
        });
        
        botonReiniciar.addActionListener(new ActionListener()  {
        	@Override
            public void actionPerformed(ActionEvent e) {
                if (tableroActual != null) {
                    panelTablero.actualizarTablero(tableroActual);
                    contadorJugadas = 0; 
                }
            }
        });
        
        botonTop10.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                Top10Dialog dialog = new Top10Dialog((JFrame) SwingUtilities.getWindowAncestor(PanelDerecha.this), top10);
                dialog.setVisible(true);
            }
        });
        
        botonCambiarJugador.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                String nombreJugador = JOptionPane.showInputDialog("Ingrese su nombre (3 caracteres):");
                if (nombreJugador != null && !nombreJugador.trim().isEmpty()) {
                    nombreJugador = nombreJugador.toUpperCase();
                    if (nombreJugador.length() > 3) {
                        nombreJugador = nombreJugador.substring(0, 3);
                    }
                    ventanaPrincipal.actualizarNombreJugador(nombreJugador);
                }
            }
        });
    }
}
