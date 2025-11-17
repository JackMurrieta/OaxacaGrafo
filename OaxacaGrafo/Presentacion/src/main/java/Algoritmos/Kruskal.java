/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Maryr
 */
public class Kruskal {

    public static class PasoKruskal {

        private Arista arista;
        private String mensaje;

        public PasoKruskal(Arista arista, String mensaje) {
            this.arista = arista;
            this.mensaje = mensaje;
        }

        public Arista getArista() {
            return arista;
        }

        public String getMensaje() {
            return mensaje;
        }
    }

    private Grafo grafo;
    private List<PasoKruskal> pasos;
    private List<Arista> aristasMST;
    private Map<String, String> padre;

    public Kruskal(Grafo grafo) {
        this.grafo = grafo;
        pasos = new ArrayList<>();
        aristasMST = new ArrayList<>();
        padre = new HashMap<>();
        generarPasos();
    }

    public List<PasoKruskal> getPasos() {
        return pasos;
    }

    public List<Arista> obtenerAristasMST() {
        return aristasMST;
    }

    private void generarPasos() {
        for (Vertice v : grafo.getVertices().values()) {
            padre.put(v.getNombre(), v.getNombre());
        }
        List<Arista> aristas = obtenerAristas();
        ordenarAristas(aristas);
        for (Arista a : aristas) {
            pasos.add(new PasoKruskal(a, "Analizando arista " + a.toString()));
            String origen = a.getOrigen().getNombre();
            String destino = a.getDestino().getNombre();
            if (unir(origen, destino)) {
                aristasMST.add(a);
                pasos.add(new PasoKruskal(a, "Arista AGREGADA al MST"));
            } else {
                pasos.add(new PasoKruskal(a, "Arista DESCARTADA (forma ciclo)"));
            }
        }
    }

    private String encontrar(String vertice) {
        if (padre.get(vertice).equals(vertice)) {
            return vertice;
        }
        String raiz = encontrar(padre.get(vertice));
        padre.put(vertice, raiz);
        return raiz;
    }

    private boolean unir(String v1, String v2) {
        String raiz1 = encontrar(v1);
        String raiz2 = encontrar(v2);
        if (!raiz1.equals(raiz2)) {
            padre.put(raiz2, raiz1);
            return true;
        }
        return false;
    }

    private List<Arista> obtenerAristas() {
        List<Arista> lista = new ArrayList<>();
        Set<String> usadas = new HashSet<>();
        for (Vertice v : grafo.getVertices().values()) {
            for (Arista a : v.getAristas()) {
                String id1 = a.getOrigen().getNombre() + "-" + a.getDestino().getNombre();
                String id2 = a.getDestino().getNombre() + "-" + a.getOrigen().getNombre();
                if (!usadas.contains(id1) && !usadas.contains(id2)) {
                    usadas.add(id1);
                    usadas.add(id2);
                    lista.add(a);
                }
            }
        }
        return lista;
    }

    private void ordenarAristas(List<Arista> aristas) {
        for (int i = 0; i < aristas.size() - 1; i++) {
            for (int j = i + 1; j < aristas.size(); j++) {
                if (aristas.get(j).getPeso() < aristas.get(i).getPeso()) {
                    Arista temp = aristas.get(i);
                    aristas.set(i, aristas.get(j));
                    aristas.set(j, temp);
                }
            }
        }
    }
}
