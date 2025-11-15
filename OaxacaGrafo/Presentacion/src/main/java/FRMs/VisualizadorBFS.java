/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FRMs;

import Algoritmos.BFS;
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
public class VisualizadorBFS extends JPanel {

    private Grafo grafo;
    private Map<String, Point2D> posiciones;
    private BFS bfs;
    private java.util.List<BFS.PasoBFS> pasos;
    private int pasoActual;

    private static final Color COLOR_WHITE = Color.WHITE;
    private static final Color COLOR_GRAY = Color.GRAY;
    private static final Color COLOR_BLACK = Color.BLACK;
    private static final Color COLOR_ACTUAL = new Color(18, 44, 74); 
    private static final Color COLOR_VECINO = new Color(255, 220, 130); 
    private static final Color COLOR_ARISTA_NORMAL = new Color(146, 36, 40);
    private static final Color COLOR_ARISTA_ARBOL = new Color(0, 85, 40);

    public VisualizadorBFS(Grafo grafo, String origen) {
        this.grafo = grafo;
        this.posiciones = new HashMap<>();
        this.pasoActual = 0;
        setPreferredSize(new Dimension(1000, 800));
        setBackground(new Color(204, 204, 255));
        calcularPosiciones();
        bfs = new BFS(grafo.getVertices());
        bfs.ejecutar(origen);
        pasos = bfs.getPasos();
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
            BFS.PasoBFS paso = pasos.get(pasoActual);
            dibujarGrafo(g2d, paso);
        }
    }

    private void dibujarGrafo(Graphics2D g2d, BFS.PasoBFS paso) {
        Set<String> aristasArbol = obtenerAristasArbol(paso);
        Set<String> aristasDibujadas = new HashSet<>();
        for (Map.Entry<String, Vertice> entry : grafo.getVertices().entrySet()) {
            String nombreOrigen = entry.getKey();
            Vertice verticeOrigen = entry.getValue();
            Point2D posOrigen = posiciones.get(nombreOrigen);
            if (posOrigen == null) {
                continue;
            }
            for (Arista arista : verticeOrigen.getAristas()) {
                String nombreDestino = arista.getDestino().getNombre();
                Point2D posDestino = posiciones.get(nombreDestino);
                if (posDestino == null) {
                    continue;
                }
                String clave = crearClaveArista(nombreOrigen, nombreDestino);
                if (!aristasDibujadas.contains(clave)) {
                    boolean esAristaArbol = aristasArbol.contains(clave);
                    dibujarArista(g2d, posOrigen, posDestino, esAristaArbol);
                    aristasDibujadas.add(clave);
                }
            }
        }
        for (Map.Entry<String, Point2D> entry : posiciones.entrySet()) {
            String nombre = entry.getKey();
            Point2D pos = entry.getValue();
            BFS.InfoVertice info = paso.estadoVertices.get(nombre);
            if (info != null) {
                Color colorNodo = obtenerColorNodo(nombre, paso, info);
                dibujarNodo(g2d, pos, nombre, colorNodo, info);
            }
        }
    }

    private Set<String> obtenerAristasArbol(BFS.PasoBFS paso) {
        Set<String> aristasArbol = new HashSet<>();
        for (Map.Entry<String, BFS.InfoVertice> entry : paso.estadoVertices.entrySet()) {
            String vertice = entry.getKey();
            BFS.InfoVertice info = entry.getValue();
            if (info.predecesor != null) {
                String clave = crearClaveArista(vertice, info.predecesor);
                aristasArbol.add(clave);
            }
        }
        return aristasArbol;
    }

    private Color obtenerColorNodo(String nombre, BFS.PasoBFS paso, BFS.InfoVertice info) {
        if (nombre.equals(paso.verticeActual)) {
            return COLOR_ACTUAL;
        } else if (nombre.equals(paso.vecinoExplorado)) {
            return COLOR_VECINO;
        } else if (info.color == BFS.Color.WHITE) {
            return COLOR_WHITE;
        } else if (info.color == BFS.Color.GRAY) {
            return COLOR_GRAY;
        } else {
            return COLOR_BLACK;
        }
    }

    private void dibujarNodo(Graphics2D g2d, Point2D pos, String nombre, Color color, BFS.InfoVertice info) {
        int x = (int) pos.getX();
        int y = (int) pos.getY();
        int radio = 18;
        g2d.setColor(color);
        g2d.fillOval(x - radio, y - radio, radio * 2, radio * 2);
        g2d.setFont(new Font("Arial", Font.BOLD, 8));
        String nombreCorto = nombre.length() > 20 ? nombre.substring(0, 17) + "..." : nombre;
        int anchoTexto = g2d.getFontMetrics().stringWidth(nombreCorto);
        g2d.drawString(nombreCorto, x - anchoTexto / 2, y - radio - 8);
        String distStr = info.distancia != Integer.MAX_VALUE ? "d:" + info.distancia : "d:∞";
        g2d.setFont(new Font("Arial", Font.PLAIN, 7));
        int anchoInfo = g2d.getFontMetrics().stringWidth(distStr);
        g2d.drawString(distStr, x - anchoInfo / 2, y + radio + 12);
    }

    private void dibujarArista(Graphics2D g2d, Point2D pos1, Point2D pos2, boolean esAristaArbol) {
        int x1 = (int) pos1.getX();
        int y1 = (int) pos1.getY();
        int x2 = (int) pos2.getX();
        int y2 = (int) pos2.getY();
        g2d.setColor(esAristaArbol ? COLOR_ARISTA_ARBOL : COLOR_ARISTA_NORMAL);
        g2d.setStroke(new BasicStroke(esAristaArbol ? 3 : 1.5f));
        g2d.drawLine(x1, y1, x2, y2);
    }

    private void dibujarItemLeyenda(Graphics2D g2d, int x, int y, int radio, Color color, String texto) {
        g2d.setColor(color);
        g2d.fillOval(x, y, radio * 2, radio * 2);
        g2d.drawString(texto, x + radio * 2 + 8, y + radio + 4);
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
