/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author Maryr
 */
public class BFS {

    public enum Color {
        WHITE, GRAY, BLACK
    }

    public static class InfoVertice {

        public Color color;
        public int distancia;  // d
        public String predecesor; // π

        public InfoVertice() {
            this.color = Color.WHITE;
            this.distancia = Integer.MAX_VALUE;
            this.predecesor = null;
        }
    }

    public static class PasoBFS {

        public String verticeActual;
        public Map<String, InfoVertice> estadoVertices;
        public Queue<String> cola;
        public String accion;
        public String vecinoExplorado;
        public int linea;

        public PasoBFS(String verticeActual, Map<String, InfoVertice> estadoVertices, Queue<String> cola, String accion, String vecinoExplorado, int linea) {
            this.verticeActual = verticeActual;
            this.estadoVertices = copiarEstado(estadoVertices);
            this.cola = new LinkedList<>(cola);
            this.accion = accion;
            this.vecinoExplorado = vecinoExplorado;
            this.linea = linea;
        }

        private static Map<String, InfoVertice> copiarEstado(Map<String, InfoVertice> original) {
            Map<String, InfoVertice> copia = new HashMap<>();
            for (Map.Entry<String, InfoVertice> entry : original.entrySet()) {
                InfoVertice info = entry.getValue();
                InfoVertice nuevaInfo = new InfoVertice();
                nuevaInfo.color = info.color;
                nuevaInfo.distancia = info.distancia;
                nuevaInfo.predecesor = info.predecesor;
                copia.put(entry.getKey(), nuevaInfo);
            }
            return copia;
        }
    }

    private Map<String, Vertice> vertices;
    private List<PasoBFS> pasos;
    private Map<String, InfoVertice> infoVertices;

    public BFS(Map<String, Vertice> vertices) {
        this.vertices = vertices;
        this.pasos = new ArrayList<>();
        this.infoVertices = new HashMap<>();
    }

    public void ejecutar(String origen) {
        if (!vertices.containsKey(origen)) {
            return;
        }
        Queue<String> Q = new LinkedList<>();
        for (String nombreVertice : vertices.keySet()) {
            if (!nombreVertice.equals(origen)) {
                InfoVertice info = new InfoVertice();
                info.color = Color.WHITE;
                info.distancia = Integer.MAX_VALUE;
                info.predecesor = null;
                infoVertices.put(nombreVertice, info);
            }
        }
        InfoVertice infoOrigen = new InfoVertice();
        infoOrigen.color = Color.GRAY;
        infoOrigen.distancia = 0;
        infoOrigen.predecesor = null;
        infoVertices.put(origen, infoOrigen);
        Q.add(origen);
        pasos.add(new PasoBFS(origen, infoVertices, Q, "inicio", null, 9));
        while (!Q.isEmpty()) {
            String u = Q.poll();
            pasos.add(new PasoBFS(u, infoVertices, Q, "dequeue", null, 11));
            Vertice verticeU = vertices.get(u);
            if (verticeU == null) {
                continue;
            }
            for (Arista arista : verticeU.getAristas()) {
                String v = arista.getDestino().getNombre();
                InfoVertice infoV = infoVertices.get(v);

                pasos.add(new PasoBFS(u, infoVertices, Q, "explorando", v, 12));
                if (infoV != null && infoV.color == Color.WHITE) {
                    infoV.color = Color.GRAY;
                    InfoVertice infoU = infoVertices.get(u);
                    infoV.distancia = infoU.distancia + 1;
                    infoV.predecesor = u;
                    Q.add(v);
                    pasos.add(new PasoBFS(u, infoVertices, Q, "enqueue", v, 17));
                }
            }
            InfoVertice infoU = infoVertices.get(u);
            if (infoU != null) {
                infoU.color = Color.BLACK;
            }
            pasos.add(new PasoBFS(u, infoVertices, Q, "black", null, 18));
        }

        pasos.add(new PasoBFS(null, infoVertices, Q, "fin", null, 0));
    }

    public List<PasoBFS> getPasos() {
        return pasos;
    }

    public Map<String, InfoVertice> getInfoVertices() {
        return infoVertices;
    }
}
