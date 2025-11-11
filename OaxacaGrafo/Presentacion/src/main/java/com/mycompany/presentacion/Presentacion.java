/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.presentacion;

import FRMs.FrmMenu;
import Grafo.Grafo;
import GrafoOaxaca.GrafoOaxaca;

/**
 *
 * @author Jack Murrieta
 */
public class Presentacion {

    public static void main(String[] args) {
        //obtener Grafo Oaxaca
        GrafoOaxaca oaxaca = new GrafoOaxaca();
        Grafo grafo = oaxaca.getGrafo();
        //abrir menu
        FrmMenu menu = new FrmMenu();
        Controlador.Controlador.inicializar(menu, grafo);
        menu.setVisible(true);

    }
}
