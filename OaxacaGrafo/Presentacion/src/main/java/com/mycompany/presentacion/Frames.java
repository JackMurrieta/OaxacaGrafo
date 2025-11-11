/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.presentacion;

import FRMs.PnlGrafo;
import Grafo.Grafo;
import GrafoOaxaca.GrafoOaxaca;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Jack Murrieta
 */
public class Frames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Obtener Grafo Oaxaca
        GrafoOaxaca oaxaca = new GrafoOaxaca();
        Grafo grafo = oaxaca.getGrafo();

        // Crear frame principal
        JFrame frame = new JFrame("Visualizador de Grafo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800); // más grande para mejor visualización
        frame.setLayout(new BorderLayout());

        // Crear panel del grafo
        PnlGrafo pnlGrafo = new PnlGrafo(grafo);

        // Hacerlo desplazable
        JScrollPane scroll = new JScrollPane(pnlGrafo);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Agregar el scroll al frame
        frame.add(scroll, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null); // Centrar ventana
        frame.setVisible(true);
    }
}
