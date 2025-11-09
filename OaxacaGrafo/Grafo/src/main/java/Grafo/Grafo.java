/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jack Murrieta
 */
public class Grafo {

    private Map<String, Vertice> vertices;

    public Grafo() {
        this.vertices = new HashMap<>();
    }

    // Agrega un vértice al grafo
    public void agregarVertice(String nombre) {
        vertices.putIfAbsent(nombre, new Vertice(nombre));
    }

    // Conecta dos vértices con una arista ponderada (bidireccional)
    public void conectarVertices(String nombre1, String nombre2, double peso) {
        Vertice v1 = vertices.get(nombre1);
        Vertice v2 = vertices.get(nombre2);

        if (v1 == null || v2 == null) {
            System.out.println("Uno o ambos vértices no existen.");
            return;
        }

        Arista arista = new Arista(v1, v2, peso);
        Arista aristaInversa = new Arista(v2, v1, peso);

        v1.agregarArista(arista);
        v2.agregarArista(aristaInversa);
    }

    public Map<String, Vertice> getVertices() {
        return vertices;
    }

    // Mostrar el grafo
    public void mostrarGrafo() {
        for (Vertice v : vertices.values()) {
            System.out.print(v.getNombre() + " -> ");
            for (Arista a : v.getAristas()) {
                System.out.print(a.getDestino().getNombre() + "(" + a.getPeso() + ") ");
            }
            System.out.println();
        }
    }
}
