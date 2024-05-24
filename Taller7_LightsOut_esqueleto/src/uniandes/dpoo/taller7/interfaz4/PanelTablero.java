package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelTablero extends JPanel {
    private int tamanoTablero;
    private boolean[][] estadoLuces;
    private int jugadas;

    public PanelTablero(int tamanoTablero) {
        this.tamanoTablero = tamanoTablero;
        this.estadoLuces = new boolean[tamanoTablero][tamanoTablero];
        this.jugadas = 0;
        generarEstadoAleatorio();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int click_x = e.getX();
                int click_y = e.getY();
                int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
                cambiarEstadoCasilla(casilla[0], casilla[1]);
                repaint();
                jugadas++;
                if (tableroCompleto()) {
                    VentanaPrincipal ventana = (VentanaPrincipal) SwingUtilities.getWindowAncestor(PanelTablero.this);
                    ventana.juegoTerminado(jugadas);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        int anchoCelda = anchoPanel / tamanoTablero;
        int altoCelda = altoPanel / tamanoTablero;

        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                int x = j * anchoCelda;
                int y = i * altoCelda;

                if (estadoLuces[i][j]) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(x, y, anchoCelda, altoCelda);

                g.setColor(Color.GRAY);
                g.drawRect(x, y, anchoCelda, altoCelda);
            }
        }
    }
    
    private int[] convertirCoordenadasACasilla(int x, int y) {
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / tamanoTablero;
        int anchoCasilla = anchoPanelTablero / tamanoTablero;
        int fila = y / altoCasilla;
        int columna = x / anchoCasilla;
        return new int[]{fila, columna};
    }

    private void cambiarEstadoCasilla(int fila, int columna) {
        if (fila >= 0 && fila < tamanoTablero && columna >= 0 && columna < tamanoTablero) {
            estadoLuces[fila][columna] = !estadoLuces[fila][columna];
            cambiarEstadoVecinos(fila, columna);
        }
    }

    private void cambiarEstadoVecinos(int fila, int columna) {
        int[][] vecinos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] vecino : vecinos) {
            int nuevaFila = fila + vecino[0];
            int nuevaColumna = columna + vecino[1];
            if (nuevaFila >= 0 && nuevaFila < tamanoTablero && nuevaColumna >= 0 && nuevaColumna < tamanoTablero) {
                estadoLuces[nuevaFila][nuevaColumna] = !estadoLuces[nuevaFila][nuevaColumna];
            }
        }
    }

    public void actualizarTamanoTablero(int nuevoTamano) {
        this.tamanoTablero = nuevoTamano;
        this.estadoLuces = new boolean[tamanoTablero][tamanoTablero];
        generarEstadoAleatorio();
        repaint();
    }

    public void actualizarTablero(boolean[][] nuevoTablero) {
        this.tamanoTablero = nuevoTablero.length;
        this.estadoLuces = new boolean[tamanoTablero][tamanoTablero];
        for (int i = 0; i < tamanoTablero; i++) {
            System.arraycopy(nuevoTablero[i], 0, this.estadoLuces[i], 0, tamanoTablero);
        }
        repaint();
    }

    private void generarEstadoAleatorio() {
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                estadoLuces[i][j] = Math.random() < 0.5;
            }
        }
    }

    private boolean tableroCompleto() {
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                if (!estadoLuces[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
