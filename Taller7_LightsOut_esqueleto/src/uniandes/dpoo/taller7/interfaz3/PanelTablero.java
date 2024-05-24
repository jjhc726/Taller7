package uniandes.dpoo.taller7.interfaz3;
import javax.swing.*;
import java.awt.*;

public class PanelTablero extends JPanel {
    private int tamanoTablero;
    private boolean[][] estadoLuces;

    public PanelTablero(int tamanoTablero) {
        this.tamanoTablero = tamanoTablero;
        this.estadoLuces = new boolean[tamanoTablero][tamanoTablero];

        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                estadoLuces[i][j] = Math.random() < 0.5;
            }
        }
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

                g.setColor(Color.YELLOW);
                g.fillRect(x, y, anchoCelda, altoCelda);

                g.setColor(Color.GRAY);
                g.drawRect(x, y, anchoCelda, altoCelda);
            }
        }
    }
    
    public void actualizarTamanoTablero(int nuevoTamano) {
        this.tamanoTablero = nuevoTamano;
        this.estadoLuces = new boolean[tamanoTablero][tamanoTablero];
        repaint();
    }

    
}
