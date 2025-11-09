/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import FRMs.FrmMenu;
import FRMs.FrmTabla;
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

    // Método genérico para cambiar de ventana
    private static void cambiarVentana(JFrame nuevaVentana) {
        if (frameActual != null) {
            //ceerrar frms
            frameActual.dispose();
        }
        frameActual = nuevaVentana;
        frameActual.setLocationRelativeTo(null);
        frameActual.setVisible(true);
    }

}
