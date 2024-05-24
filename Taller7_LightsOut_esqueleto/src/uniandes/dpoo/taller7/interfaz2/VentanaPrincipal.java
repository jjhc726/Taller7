package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
    
    public VentanaPrincipal() {
        super("Lights Out");
        
        setSize(800, 600);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PanelSuperior panelSuperior = new PanelSuperior();
        PanelDerecha panelDerecha = new PanelDerecha();
        PanelInferior panelInferior = new PanelInferior();

        setLayout(new BorderLayout());

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecha, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
    }
}


