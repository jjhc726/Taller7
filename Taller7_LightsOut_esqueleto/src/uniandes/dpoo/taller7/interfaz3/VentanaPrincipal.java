package uniandes.dpoo.taller7.interfaz3;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame {
    
	private PanelTablero panelTablero;
	
    public VentanaPrincipal() {
        super("Lights Out");
        
        setSize(800, 600);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PanelSuperior panelSuperior = new PanelSuperior();
        PanelDerecha panelDerecha = new PanelDerecha();
        PanelInferior panelInferior = new PanelInferior();
        panelTablero = new PanelTablero(5);
        
        setLayout(new BorderLayout());

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecha, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelTablero, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public static void notificarCambioTamano(PanelSuperior panelSuperior) {
        VentanaPrincipal ventana = (VentanaPrincipal) SwingUtilities.getWindowAncestor(panelSuperior);
        
        String tamanoSeleccionado = panelSuperior.getTamanoSeleccionado();

        int nuevoTamano = Integer.parseInt(tamanoSeleccionado.split("x")[0]);

        ventana.panelTablero.actualizarTamanoTablero(nuevoTamano);
    }
    
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
    }
}
