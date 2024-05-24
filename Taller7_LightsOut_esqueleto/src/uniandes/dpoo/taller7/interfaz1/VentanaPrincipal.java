package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
    
    public VentanaPrincipal() {
        super("Lights Out");
        
        setSize(400, 400);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
    }
}

