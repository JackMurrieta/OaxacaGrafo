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
 * @author AlexNieblas10
 */
public class Dijkstra {

    public static class PasoDijkstra {

        private String verticeActual;
        private String mensaje;
        private Map<String, Double> distanciasActuales;

        public PasoDijkstra(String verticeActual, String mensaje, Map<String, Double> distancias) {
            this.verticeActual = verticeActual;
            this.mensaje = mensaje;
            this.distanciasActuales = new HashMap<>(distancias);
        }

        public String getVerticeActual() {
            return verticeActual;
        }

        public String getMensaje() {
            return mensaje;
        }

        public Map<String, Double> getDistanciasActuales() {
            return distanciasActuales;
        }
    }

    private Grafo grafo;
    private String verticeInicio;
    private List<PasoDijkstra> pasos;
    private Map<String, Double> distancias;
    private Map<String, String> previos;

    public Dijkstra(Grafo grafo, String verticeInicio) {
        this.grafo = grafo;
        this.verticeInicio = verticeInicio;
        pasos = new ArrayList<>();
        distancias = new HashMap<>();
        previos = new HashMap<>();
        generarPasos();
    }

    public List<PasoDijkstra> getPasos() {
        return pasos;
    }

    public Map<String, Double> getDistancias() {
        return distancias;
    }

    public List<String> obtenerCamino(String verticeDestino) {
        List<String> camino = new ArrayList<>();
        String actual = verticeDestino;

        if (!previos.containsKey(actual) && !actual.equals(verticeInicio)) {
            return camino;
        }

        while (actual != null) {
            camino.add(0, actual);
            actual = previos.get(actual);
        }

        return camino;
    }

    private void generarPasos() {
        Set<String> visitados = new HashSet<>();

        for (String nombreVertice : grafo.getVertices().keySet()) {
            distancias.put(nombreVertice, Double.POSITIVE_INFINITY);
        }
        distancias.put(verticeInicio, 0.0);

        pasos.add(new PasoDijkstra(verticeInicio,
            "Inicializando: distancia a " + verticeInicio + " = 0, resto = ∞",
            distancias));

        while (visitados.size() < grafo.getVertices().size()) {
            String verticeActual = obtenerVerticeMenorDistancia(visitados);

            if (verticeActual == null || distancias.get(verticeActual) == Double.POSITIVE_INFINITY) {
                break;
            }

            visitados.add(verticeActual);
            pasos.add(new PasoDijkstra(verticeActual,
                "Visitando vértice: " + verticeActual + " (distancia: " + distancias.get(verticeActual) + ")",
                distancias));

            Vertice v = grafo.getVertices().get(verticeActual);
            for (Arista arista : v.getAristas()) {
                String vecino = arista.getDestino().getNombre();

                if (!visitados.contains(vecino)) {
                    double nuevaDistancia = distancias.get(verticeActual) + arista.getPeso();

                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                        previos.put(vecino, verticeActual);
                        pasos.add(new PasoDijkstra(verticeActual,
                            "Actualizando distancia a " + vecino + ": " +
                            nuevaDistancia + " (vía " + verticeActual + ")",
                            distancias));
                    } else {
                        pasos.add(new PasoDijkstra(verticeActual,
                            "Arista a " + vecino + " no mejora la distancia (actual: " +
                            distancias.get(vecino) + ", nueva: " + nuevaDistancia + ")",
                            distancias));
                    }
                }
            }
        }

        pasos.add(new PasoDijkstra(null,
            "Algoritmo completado. Distancias mínimas calculadas.",
            distancias));
    }

    private String obtenerVerticeMenorDistancia(Set<String> visitados) {
        String verticeMenor = null;
        double menorDistancia = Double.POSITIVE_INFINITY;

        for (Map.Entry<String, Double> entry : distancias.entrySet()) {
            String vertice = entry.getKey();
            double distancia = entry.getValue();

            if (!visitados.contains(vertice) && distancia < menorDistancia) {
                menorDistancia = distancia;
                verticeMenor = vertice;
            }
        }

        return verticeMenor;
    }
}
