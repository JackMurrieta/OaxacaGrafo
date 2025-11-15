/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FRMs;

import Algoritmos.DFS;
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
 * @author Jack Murrieta
 */
public class VisualizadorDFS extends JPanel {

    private Grafo grafo;
    private Map<String, Point2D> posiciones;

    private DFS dfs;
    private java.util.List<DFS.PasoDFS> pasos;
    private int pasoActual;

    // Colores
    private static final Color COLOR_WHITE = Color.WHITE;
    private static final Color COLOR_GRAY = Color.GRAY;
    private static final Color COLOR_BLACK = Color.BLACK;
    private static final Color COLOR_ACTUAL = new Color(18, 44, 74);
    private static final Color COLOR_VECINO = new Color(255, 220, 130);
    private static final Color COLOR_ARISTA_NORMAL = new Color(146, 36, 40);
    private static final Color COLOR_ARISTA_ARBOL = new Color(0, 85, 40);

    public VisualizadorDFS(Grafo grafo, String origen) {
        this.grafo = grafo;
        this.posiciones = new HashMap<>();
        this.pasoActual = 0;

        setPreferredSize(new Dimension(1000, 800));
        setBackground(new Color(204, 204, 255));

        calcularPosiciones();

        dfs = new DFS(grafo.getVertices());
        dfs.ejecutar(origen);      // ← DFS!
        pasos = dfs.getPasos();    // ← pasos DFS

        new javax.swing.Timer(600, e -> {
            pasoActual++;
            if (pasoActual >= pasos.size()) {
                pasoActual = pasos.size() - 1;
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

        if (pasoActual < pasos.size()) {
            DFS.PasoDFS paso = pasos.get(pasoActual);
            dibujarGrafo(g2d, paso);
        }
    }

    private void dibujarGrafo(Graphics2D g2d, DFS.PasoDFS paso) {
        Set<String> aristasArbol = obtenerAristasArbol(paso);
        Set<String> aristasDibujadas = new HashSet<>();

        for (Map.Entry<String, Vertice> entry : grafo.getVertices().entrySet()) {
            String origen = entry.getKey();
            Vertice vert = entry.getValue();
            Point2D p1 = posiciones.get(origen);

            if (p1 == null) {
                continue;
            }

            for (Arista arista : vert.getAristas()) {
                String destino = arista.getDestino().getNombre();
                Point2D p2 = posiciones.get(destino);

                if (p2 == null) {
                    continue;
                }

                String clave = crearClaveArista(origen, destino);
                if (!aristasDibujadas.contains(clave)) {

                    boolean esArbol = aristasArbol.contains(clave);
                    dibujarArista(g2d, p1, p2, esArbol);

                    aristasDibujadas.add(clave);
                }
            }
        }

        for (Map.Entry<String, Point2D> entry : posiciones.entrySet()) {
            String nombre = entry.getKey();
            Point2D pos = entry.getValue();

            DFS.InfoVertice info = paso.estadoVertices.get(nombre);
            if (info != null) {
                Color colorNodo = obtenerColorNodo(nombre, paso, info);
                dibujarNodo(g2d, pos, nombre, colorNodo, info);
            }
        }
    }

    private Set<String> obtenerAristasArbol(DFS.PasoDFS paso) {
        Set<String> aristas = new HashSet<>();

        for (Map.Entry<String, DFS.InfoVertice> entry : paso.estadoVertices.entrySet()) {
            String v = entry.getKey();
            DFS.InfoVertice info = entry.getValue();

            if (info.predecesor != null) {
                String clave = crearClaveArista(v, info.predecesor);
                aristas.add(clave);
            }
        }
        return aristas;
    }

    private Color obtenerColorNodo(String nombre, DFS.PasoDFS paso, DFS.InfoVertice info) {

        if (nombre.equals(paso.verticeActual)) {
            return COLOR_ACTUAL;
        }

        if (nombre.equals(paso.vecinoExplorado)) {
            return COLOR_VECINO;
        }

        if (info.color == DFS.Color.WHITE) {
            return COLOR_WHITE;
        }
        if (info.color == DFS.Color.GRAY) {
            return COLOR_GRAY;
        }

        return COLOR_BLACK;
    }

    private void dibujarNodo(Graphics2D g2d, Point2D pos, String nombre, Color color, DFS.InfoVertice info) {
        int x = (int) pos.getX();
        int y = (int) pos.getY();
        int r = 18;

        g2d.setColor(color);
        g2d.fillOval(x - r, y - r, r * 2, r * 2);

        g2d.setFont(new Font("Arial", Font.BOLD, 8));
        String texto = nombre.length() > 20 ? nombre.substring(0, 17) + "..." : nombre;
        int w = g2d.getFontMetrics().stringWidth(texto);
        g2d.drawString(texto, x - w / 2, y - r - 8);

        // tiempos DFS
        g2d.setFont(new Font("Arial", Font.PLAIN, 7));
        String t = "t:" + info.tiempoDescubrimiento + "/" + info.tiempoFinalizacion;
        int wt = g2d.getFontMetrics().stringWidth(t);
        g2d.drawString(t, x - wt / 2, y + r + 12);
    }

    private void dibujarArista(Graphics2D g2d, Point2D p1, Point2D p2, boolean esArbol) {
        g2d.setColor(esArbol ? COLOR_ARISTA_ARBOL : COLOR_ARISTA_NORMAL);
        g2d.setStroke(new BasicStroke(esArbol ? 3 : 1.5f));
        g2d.drawLine((int) p1.getX(), (int) p1.getY(),
                (int) p2.getX(), (int) p2.getY());
    }

    private String crearClaveArista(String v1, String v2) {
        return v1.compareTo(v2) < 0 ? v1 + "|" + v2 : v2 + "|" + v1;
    }

    public void siguientePaso() {
        if (pasoActual < pasos.size() - 1) {
            pasoActual++;
            repaint();
        }
    }

    public void pasoAnterior() {
        if (pasoActual > 0) {
            pasoActual--;
            repaint();
        }
    }

    public void reiniciar() {
        pasoActual = 0;
        repaint();
    }

    public int getPasoActual() {
        return pasoActual;
    }

    public int getTotalPasos() {
        return pasos.size();
    }
}
