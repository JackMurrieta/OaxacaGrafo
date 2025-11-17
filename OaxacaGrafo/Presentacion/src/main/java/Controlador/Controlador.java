/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import FRMs.FrmBFS;
import FRMs.FrmDFS;
import FRMs.FrmMenu;
import FRMs.FrmMostrarGrafo;
import FRMs.FrmSeleccion;
import FRMs.FrmTabla;
import FRMs.VisualizadorGrafo;
import Grafo.Grafo;
import javax.swing.JFrame;

/**
 *
 * @author Jack Murrieta
 */
public class Controlador {

    private static JFrame frameActual;
    private static Grafo grafo;

    //pasar el Frm menu y grafo en el main
    public static void inicializar(JFrame frame, Grafo grafoInicial) {
        frameActual = frame;
        grafo = grafoInicial;
    }

    public static void mostrarMenu() {
        cambiarVentana(new FrmMenu());
    }

    public static void mostrarFrmTabla() {

        cambiarVentana(new FrmTabla(grafo));
    }

    public static void mostrarFrmMostrarGrafo() {
        cambiarVentana(new FrmMostrarGrafo(grafo));
    }

    public static void mostrarFrmDFS(String ciudadInicial) {
        cambiarVentana(new FrmDFS(grafo, ciudadInicial));
    }

    public static void mostrarFrmSeleccionCiudadSemilla(String recorrido) {
        cambiarVentana(new FrmSeleccion(grafo, recorrido));
    }

    public static void mostrarFrmBFS(String ciudadInicial) {
        cambiarVentana(new FrmBFS(grafo, ciudadInicial));
    }

    public static void mostrarError(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(
                frameActual,
                mensaje,
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }

    // Método genérico para cambiar de ventana
    private static void cambiarVentana(JFrame nuevaVentana) {
        if (frameActual != null || !frameActual.isShowing()) {
            //ceerrar frms
            frameActual.dispose();
        }
        frameActual = nuevaVentana;
        frameActual.setLocationRelativeTo(null);
        frameActual.setVisible(true);
    }

}
