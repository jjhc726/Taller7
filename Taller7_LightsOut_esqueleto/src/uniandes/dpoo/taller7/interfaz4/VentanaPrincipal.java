package uniandes.dpoo.taller7.interfaz4;
import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class VentanaPrincipal extends JFrame {
    
	private static PanelTablero panelTablero;
	private Top10 top10;
	private PanelInferior panelInferior;
	private String nombreJugadorActual = "";
	
    public VentanaPrincipal() {
        super("Lights Out");
        
        setSize(800, 600);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelInferior = new PanelInferior();
        PanelSuperior panelSuperior = new PanelSuperior();
        Tablero tablero = new Tablero(5);
        panelTablero = new PanelTablero(5); 
        top10 = new Top10();
        File archivo = new File(".\\data\\top10.csv");
        top10.cargarRecords(archivo);
        
        PanelDerecha panelDerecha = new PanelDerecha(panelSuperior, tablero, panelTablero, top10, this);
        
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
    
    public static PanelTablero getPanelTablero()
    {
    	return panelTablero;
    }
    
    public void actualizarNombreJugador(String nombre) {
        this.nombreJugadorActual = nombre;
        panelInferior.actualizarNombreJugador(nombre);
    }

    public String getNombreJugadorActual() {
        return nombreJugadorActual;
    }
    
    public void juegoTerminado(int puntaje) {
        String nombreJugador = getNombreJugadorActual();
        top10.agregarRegistro(nombreJugador, puntaje);
        try {
            File archivoCSV = new File(".\\data\\top10.csv");
            top10.salvarRecords(archivoCSV);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "¡Felicitaciones " + nombreJugador + "! Completaste el tablero con " + puntaje + " puntos.");
    }
    
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
    }
}
