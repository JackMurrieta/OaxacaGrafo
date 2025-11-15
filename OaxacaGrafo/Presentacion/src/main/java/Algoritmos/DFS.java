/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import Grafo.Arista;
import Grafo.Vertice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Jack Murrieta
 */
public class DFS {

    public enum Color {
        WHITE, GRAY, BLACK
    }

    public static class InfoVertice {

        public Color color;
        public String predecesor;
        public int tiempoDescubrimiento;
        public int tiempoFinalizacion;

        public InfoVertice() {
            this.color = Color.WHITE;
            this.predecesor = null;
            this.tiempoDescubrimiento = -1;
            this.tiempoFinalizacion = -1;
        }
    }

    public static class PasoDFS {

        public String verticeActual;
        public Map<String, InfoVertice> estadoVertices;
        public Stack<String> pila;
        public String accion;
        public String vecinoExplorado;
        public int linea;

        public PasoDFS(String verticeActual, Map<String, InfoVertice> info, Stack<String> pila, String accion, String vecino, int linea) {
            this.verticeActual = verticeActual;
            this.estadoVertices = copiarEstado(info);
            this.pila = copiarPila(pila);
            this.accion = accion;
            this.vecinoExplorado = vecino;
            this.linea = linea;
        }

        private static Map<String, InfoVertice> copiarEstado(Map<String, InfoVertice> original) {
            Map<String, InfoVertice> copia = new HashMap<>();
            for (Map.Entry<String, InfoVertice> entry : original.entrySet()) {
                InfoVertice info = entry.getValue();
                InfoVertice nueva = new InfoVertice();
                nueva.color = info.color;
                nueva.predecesor = info.predecesor;
                nueva.tiempoDescubrimiento = info.tiempoDescubrimiento;
                nueva.tiempoFinalizacion = info.tiempoFinalizacion;
                copia.put(entry.getKey(), nueva);
            }
            return copia;
        }

        private static Stack<String> copiarPila(Stack<String> pilaOriginal) {
            return (Stack<String>) pilaOriginal.clone();
        }
    }

    private Map<String, Vertice> vertices;
    private Map<String, InfoVertice> infoVertices;
    private List<PasoDFS> pasos;
    private int tiempo;

    public DFS(Map<String, Vertice> vertices) {
        this.vertices = vertices;
        this.infoVertices = new HashMap<>();
        this.pasos = new ArrayList<>();
        this.tiempo = 0;
    }

    public void ejecutar(String origen) {
        if (!vertices.containsKey(origen)) {
            return;
        }

        // Inicializar info
        for (String nombre : vertices.keySet()) {
            infoVertices.put(nombre, new InfoVertice());
        }

        Stack<String> pila = new Stack<>();

        pila.push(origen);
        pasos.add(new PasoDFS(origen, infoVertices, pila, "push", null, 9));

        while (!pila.isEmpty()) {
            String u = pila.pop();
            pasos.add(new PasoDFS(u, infoVertices, pila, "pop", null, 11));

            InfoVertice infoU = infoVertices.get(u);

            if (infoU.color == Color.WHITE) {
                infoU.color = Color.GRAY;
                infoU.tiempoDescubrimiento = ++tiempo;

                pasos.add(new PasoDFS(u, infoVertices, pila, "discover", null, 15));

                Vertice verticeU = vertices.get(u);

                for (Arista arista : verticeU.getAristas()) {
                    String v = arista.getDestino().getNombre();
                    InfoVertice infoV = infoVertices.get(v);

                    pasos.add(new PasoDFS(u, infoVertices, pila, "exploring", v, 18));

                    if (infoV.color == Color.WHITE) {
                        infoV.predecesor = u;
                        pila.push(v);
                        pasos.add(new PasoDFS(u, infoVertices, pila, "push", v, 22));
                    }
                }

                infoU.color = Color.BLACK;
                infoU.tiempoFinalizacion = ++tiempo;

                pasos.add(new PasoDFS(u, infoVertices, pila, "finish", null, 26));
            }
        }

        pasos.add(new PasoDFS(null, infoVertices, pila, "fin", null, 0));
    }

    public List<PasoDFS> getPasos() {
        return pasos;
    }

    public Map<String, InfoVertice> getInfoVertices() {
        return infoVertices;
    }
}
