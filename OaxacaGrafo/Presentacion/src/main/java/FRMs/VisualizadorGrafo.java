/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FRMs;

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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Maryr
 */
public class VisualizadorGrafo extends JPanel {

    private Grafo grafo;
    private Map<String, Point2D> puntitos;

    public VisualizadorGrafo(Grafo grafo) {
        this.grafo = grafo;
        this.puntitos = new HashMap<>();
        setPreferredSize(new Dimension(1000, 600));
        setBackground(new Color(204, 204, 255));
        calcularPosiciones();
    }

    private void calcularPosiciones() {
        Map<String, Point2D> pos = new HashMap<>();

        pos.put("San Juan Bautista Tuxtepec", new Point2D.Double(450, 120));
        pos.put("Loma Bonita", new Point2D.Double(700, 60));
        pos.put("Matías Romero Avendaño", new Point2D.Double(880, 100));
        pos.put("Heroica Ciudad de Huajuapan de León", new Point2D.Double(120, 150));
        pos.put("Asunción Nochixtlán", new Point2D.Double(240, 120));
        pos.put("Heroica Ciudad de Tlaxiaco", new Point2D.Double(80, 280));
        pos.put("Oaxaca", new Point2D.Double(450, 220));
        pos.put("Santa Cruz Xoxocotlán", new Point2D.Double(370, 250));
        pos.put("Santa Lucía del Camino", new Point2D.Double(520, 210));
        pos.put("San Antonio de la Cal", new Point2D.Double(400, 290));
        pos.put("Santa Maria Atzompa", new Point2D.Double(520, 150));
        pos.put("San Jacinto Amilpas", new Point2D.Double(560, 235));
        pos.put("Santa Cruz Amilpas", new Point2D.Double(610, 265));
        pos.put("Villa de Zaachila", new Point2D.Double(320, 320));
        pos.put("Vicente Guerrero", new Point2D.Double(270, 360));
        pos.put("Cuilápam de Guerrero", new Point2D.Double(370, 300));
        pos.put("Zimatlán de Álvarez", new Point2D.Double(320, 400));
        pos.put("Ocotlán de Morelos", new Point2D.Double(520, 350));
        pos.put("Tlacolula de Matamoros", new Point2D.Double(650, 210));
        pos.put("Ciudad Ixtepec", new Point2D.Double(820, 190));
        pos.put("Santo Domingo Tehuantepec", new Point2D.Double(740, 260));
        pos.put("Heroica Ciudad de Juchitán de Zaragoza", new Point2D.Double(900, 260));
        pos.put("Unión Hidalgo (Oaxaca)", new Point2D.Double(950, 300));
        pos.put("Salina Cruz", new Point2D.Double(740, 370));
        pos.put("Miahuatlán de Porfirio Díaz", new Point2D.Double(450, 440));
        pos.put("Crucecita", new Point2D.Double(680, 500));
        pos.put("San Pedro Pochutla", new Point2D.Double(560, 500));
        pos.put("Puerto Escondido", new Point2D.Double(280, 520));
        pos.put("Santiago Pinotepa Nacional", new Point2D.Double(120, 440));
        pos.put("Río Grande o Piedra Parada", new Point2D.Double(200, 530));

        this.puntitos = pos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //primero las aristas para q las rayitas queden atras
        dibujarAristas(g2d);
        dibujarNodos(g2d);
    }

    private void dibujarAristas(Graphics2D g2d) {
        Set<String> aristasYaDibujadas = new HashSet<>();
        int contadorAristas = 0;
        int aristasOmitidas = 0;
        for (Map.Entry<String, Vertice> entry : grafo.getVertices().entrySet()) {
            String nombreOrigen = entry.getKey();
            Vertice verticeOrigen = entry.getValue();
            Point2D posOrigen = puntitos.get(nombreOrigen);
            if (posOrigen == null) {
                System.out.println("Posición NULL para: " + nombreOrigen);
                continue;
            }
            for (Arista arista : verticeOrigen.getAristas()) {
                String nombreDestino = arista.getDestino().getNombre();
                Point2D posDestino = puntitos.get(nombreDestino);
                if (posDestino == null) {
                    continue;
                }
                String clave = crearClaveArista(nombreOrigen, nombreDestino);
                if (!aristasYaDibujadas.contains(clave)) {
                    dibujarArista(g2d, posOrigen, posDestino, arista.getPeso());
                    aristasYaDibujadas.add(clave);
                    contadorAristas++;
                } else {
                    aristasOmitidas++;
                }
            }
        }
    }

    private void dibujarArista(Graphics2D g2d, Point2D pos1, Point2D pos2, double peso) {
        int x1 = (int) pos1.getX();
        int y1 = (int) pos1.getY();
        int x2 = (int) pos2.getX();
        int y2 = (int) pos2.getY();
        g2d.setColor(new Color(100, 100, 100, 180));
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.drawLine(x1, y1, x2, y2);
        int xMedio = (x1 + x2) / 2;
        int yMedio = (y1 + y2) / 2;
        String texto = String.format("%.0f km", peso);
        g2d.setFont(new Font("Arial", Font.BOLD, 9));
        int anchoTexto = g2d.getFontMetrics().stringWidth(texto);
        int altoTexto = g2d.getFontMetrics().getHeight();
        g2d.setColor(new Color(255, 255, 255, 200));
        g2d.fillRoundRect(xMedio - anchoTexto / 2 - 2, yMedio - altoTexto / 2 - 1, anchoTexto + 4, altoTexto, 4, 4);
        g2d.setColor(new Color(50, 50, 50));
        g2d.drawString(texto, xMedio - anchoTexto / 2, yMedio + 3);
    }

    private void dibujarNodos(Graphics2D g2d) {
        for (Map.Entry<String, Point2D> entry : puntitos.entrySet()) {
            String nombre = entry.getKey();
            Point2D pos = entry.getValue();
            if (pos == null) {
                continue;
            }
            int x = (int) pos.getX();
            int y = (int) pos.getY();
            int radio = 18;
            g2d.setColor(new Color(0, 0, 0, 50));
            g2d.fillOval(x - radio + 2, y - radio + 2, radio * 2, radio * 2);
            g2d.setColor(new Color(18, 44, 74));
            g2d.fillOval(x - radio, y - radio, radio * 2, radio * 2);
            g2d.setFont(new Font("Arial", Font.BOLD, 9));
            int anchoNombre = g2d.getFontMetrics().stringWidth(nombre);
            int altoNombre = g2d.getFontMetrics().getHeight();
            g2d.setColor(new Color(255, 255, 255, 220));
            g2d.fillRoundRect(x - anchoNombre / 2 - 3, y - radio - altoNombre - 2, anchoNombre + 6, altoNombre + 2, 5, 5);
            g2d.setColor(new Color(18, 44, 74, 100));
            g2d.setStroke(new BasicStroke(1));
            g2d.drawRoundRect(x - anchoNombre / 2 - 3, y - radio - altoNombre - 2, anchoNombre + 6, altoNombre + 2, 5, 5);
            g2d.setColor(new Color(18, 44, 74));
            g2d.drawString(nombre, x - anchoNombre / 2, y - radio - 5);
        }
    }

    private String crearClaveArista(String v1, String v2) {
        if (v1.compareTo(v2) < 0) {
            return v1 + "|" + v2;
        } else {
            return v2 + "|" + v1;
        }
    }

    public static void mostrarVentana(Grafo grafo) {
        JFrame frame = new JFrame("Grafo de Oaxaca");
        VisualizadorGrafo panel = new VisualizadorGrafo(grafo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new JScrollPane(panel));
        frame.setSize(1400, 900);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
