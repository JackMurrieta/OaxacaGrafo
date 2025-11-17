/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FRMs;

import Algoritmos.Kruskal;
import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;

/**
 *
 * @author Maryr
 */
public class VisualizadorMST extends JPanel {

    private Grafo grafo;
    private Map<String, Point2D> posiciones;
    private Kruskal kruskal;
    private java.util.List<Kruskal.PasoKruskal> pasos;
    private int pasoActual;
    private Set<String> aristasMST;
    private Set<String> aristasDescartadas;
    private boolean fin = false;
    private static final Color COLOR_VERTICE = new Color(18, 44, 74);
    private static final Color COLOR_ARISTA_NORMAL = Color.BLACK;
    private static final Color COLOR_ARISTA_MST = new Color(0, 102, 153);
    private static final Color COLOR_ARISTA_DESCARTADA = new Color(255, 102, 102);
    private static final Color COLOR_ACTUAL = new Color(255, 255, 153);

    public VisualizadorMST(Grafo grafo) {
        this.grafo = grafo;
        this.posiciones = new HashMap<>();
        this.pasoActual = 0;
        this.aristasMST = new HashSet<>();
        this.aristasDescartadas = new HashSet<>();
        setPreferredSize(new Dimension(1000, 624));
        setBackground(new Color(204, 204, 255));
        calcularPosiciones();
        kruskal = new Kruskal(grafo);
        pasos = kruskal.getPasos();
        new javax.swing.Timer(650, e -> {
            if (pasoActual < pasos.size()) {
                pasoActual++;
            }
            if (pasoActual >= pasos.size()) {
                fin = true;
                ((javax.swing.Timer) e.getSource()).stop();
            }
            repaint();
        }).start();
    }

    private void calcularPosiciones() {
        Map<String, Point2D> pos = new HashMap<>();

        pos.put("San Juan Bautista Tuxtepec", new Point2D.Double(500, 150));
        pos.put("Loma Bonita", new Point2D.Double(750, 50));
        pos.put("Matías Romero Avendaño", new Point2D.Double(900, 120));
        pos.put("Heroica Ciudad de Huajuapan de León", new Point2D.Double(150, 200));
        pos.put("Asunción Nochixtlán", new Point2D.Double(280, 170));
        pos.put("Heroica Ciudad de Tlaxiaco", new Point2D.Double(80, 350));
        pos.put("Oaxaca", new Point2D.Double(450, 280));
        pos.put("Santa Cruz Xoxocotlán", new Point2D.Double(380, 320));
        pos.put("Santa Lucía del Camino", new Point2D.Double(520, 260));
        pos.put("San Antonio de la Cal", new Point2D.Double(410, 360));
        pos.put("Santa Maria Atzompa", new Point2D.Double(520, 210));
        pos.put("San Jacinto Amilpas", new Point2D.Double(560, 300));
        pos.put("Santa Cruz Amilpas", new Point2D.Double(600, 330));
        pos.put("Villa de Zaachila", new Point2D.Double(340, 400));
        pos.put("Vicente Guerrero", new Point2D.Double(300, 440));
        pos.put("Cuilápam de Guerrero", new Point2D.Double(380, 380));
        pos.put("Zimatlán de Álvarez", new Point2D.Double(340, 480));
        pos.put("Ocotlán de Morelos", new Point2D.Double(520, 430));
        pos.put("Tlacolula de Matamoros", new Point2D.Double(620, 270));
        pos.put("Ciudad Ixtepec", new Point2D.Double(820, 250));
        pos.put("Santo Domingo Tehuantepec", new Point2D.Double(750, 320));
        pos.put("Heroica Ciudad de Juchitán de Zaragoza", new Point2D.Double(900, 320));
        pos.put("Unión Hidalgo (Oaxaca)", new Point2D.Double(970, 360));
        pos.put("Salina Cruz", new Point2D.Double(750, 440));
        pos.put("Miahuatlán de Porfirio Díaz", new Point2D.Double(450, 520));
        pos.put("Crucecita", new Point2D.Double(670, 560));
        pos.put("San Pedro Pochutla", new Point2D.Double(560, 560));
        pos.put("Puerto Escondido", new Point2D.Double(300, 600));
        pos.put("Santiago Pinotepa Nacional", new Point2D.Double(150, 520));
        pos.put("Río Grande o Piedra Parada", new Point2D.Double(220, 600));

        this.posiciones = pos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (pasoActual >= 1 && pasoActual <= pasos.size()) {
            dibujarGrafo(g2d, pasos.get(pasoActual - 1));
        }
        if (fin) {
            mostrarLeyenda(g2d);
        }
    }

    private void dibujarGrafo(Graphics2D g2d, Kruskal.PasoKruskal paso) {
        String claveArista = crearClaveArista(
                paso.getArista().getOrigen().getNombre(),
                paso.getArista().getDestino().getNombre()
        );
        boolean aceptada = paso.getMensaje().contains("AGREGADA");
        if (aceptada) {
            aristasMST.add(claveArista);
        } else if (paso.getMensaje().contains("DESCARTADA")) {
            aristasDescartadas.add(claveArista);
        }
        Set<String> aristasDibujadas = new HashSet<>();
        for (Map.Entry<String, Vertice> entry : grafo.getVertices().entrySet()) {
            String nombreOrigen = entry.getKey();
            Vertice vOrigen = entry.getValue();
            Point2D posOrigen = posiciones.get(nombreOrigen);
            if (posOrigen == null) {
                continue;
            }
            for (Arista a : vOrigen.getAristas()) {
                String nombreDestino = a.getDestino().getNombre();
                Point2D posDestino = posiciones.get(nombreDestino);
                if (posDestino == null) {
                    continue;
                }
                String clave = crearClaveArista(nombreOrigen, nombreDestino);
                if (aristasDibujadas.contains(clave)) {
                    continue;
                }
                boolean esMST = aristasMST.contains(clave);
                boolean esDescartada = aristasDescartadas.contains(clave);
                boolean esActual = !fin && clave.equals(claveArista);
                dibujarArista(g2d, posOrigen, posDestino, esMST, esDescartada, esActual, aceptada, a.getPeso());
                aristasDibujadas.add(clave);
            }
        }
        for (Map.Entry<String, Point2D> entry : posiciones.entrySet()) {
            String nombre = entry.getKey();
            Point2D pos = entry.getValue();
            dibujarNodo(g2d, pos, nombre);
        }
    }

    private void dibujarNodo(Graphics2D g2d, Point2D pos, String nombre) {
        int x = (int) pos.getX();
        int y = (int) pos.getY();
        int r = 18;
        g2d.setColor(COLOR_VERTICE);
        g2d.fillOval(x - r, y - r, r * 2, r * 2);
        g2d.setFont(new Font("Arial", Font.PLAIN, 7));
        String txt = nombre.length() > 20 ? nombre.substring(0, 17) + "..." : nombre;
        int w = g2d.getFontMetrics().stringWidth(txt);
        g2d.drawString(txt, x - w / 2, y - r - 6);
    }

    private void dibujarArista(Graphics2D g2d, Point2D p1, Point2D p2, boolean esMST, boolean esDescartada, boolean esActual, boolean aceptadaActual, double peso) {
        int x1 = (int) p1.getX();
        int y1 = (int) p1.getY();
        int x2 = (int) p2.getX();
        int y2 = (int) p2.getY();
        if (esActual) {
            g2d.setColor(aceptadaActual ? COLOR_ARISTA_MST : COLOR_ACTUAL);
            g2d.setStroke(new BasicStroke(3));
        } else if (esMST) {
            g2d.setColor(COLOR_ARISTA_MST);
            g2d.setStroke(new BasicStroke(3));
        } else if (esDescartada) {
            g2d.setColor(COLOR_ARISTA_DESCARTADA);
            g2d.setStroke(new BasicStroke(2));
        } else {
            g2d.setColor(COLOR_ARISTA_NORMAL);
            g2d.setStroke(new BasicStroke(1.5f));
        }
        g2d.drawLine(x1, y1, x2, y2);
        int mx = (x1 + x2) / 2;
        int my = (y1 + y2) / 2;
        String pesoTexto = String.format("%.0f", peso);
        g2d.setFont(new Font("Arial", Font.BOLD, 7));
        g2d.setColor(COLOR_VERTICE);
        int anchoTexto = g2d.getFontMetrics().stringWidth(pesoTexto);
        g2d.drawString(pesoTexto, mx - anchoTexto / 2, my - 5);
    }

    private void mostrarLeyenda(Graphics2D g2d) {
        g2d.setColor(COLOR_VERTICE);
        g2d.fillRoundRect(10, 10, 320, 110, 15, 15);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.setColor(new Color(204, 204, 255));
        g2d.drawString("Árbol de Expansión Mínima", 25, 35);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(new Color(204, 204, 255));
        g2d.drawLine(25, 42, 305, 42);
        g2d.setFont(new Font("Arial", Font.BOLD, 13));
        g2d.setColor(new Color(204, 204, 255));
        g2d.drawString("Fin de algoritmo.", 25, 65);
    }

    private String crearClaveArista(String v1, String v2) {
        return v1.compareTo(v2) < 0 ? v1 + "|" + v2 : v2 + "|" + v1;
    }
}
