/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jack Murrieta
 */
public class Vertice {

    private String nombre;
    private List<Arista> aristas;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.aristas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    // Método para agregar una arista al vértice
    public void agregarArista(Arista arista) {
        aristas.add(arista);
    }

    @Override
    public String toString() {
        return nombre;
    }

}
