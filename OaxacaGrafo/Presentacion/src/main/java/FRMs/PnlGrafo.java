/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FRMs;

import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jack Murrieta
 */
public class PnlGrafo extends javax.swing.JPanel {

    private Grafo grafo;
    private Color colorFondo = new Color(204, 204, 255);
    private PnlVertice pnlOaxaca;
    private Map<String, PnlVertice> vertices;
    private Map<String, Vertice> verticesGrafo;

    /**
     * Creates new form PnlGrafo
     */
    public PnlGrafo(Grafo grafo) {
        this.grafo = grafo;
        verticesGrafo = grafo.getVertices();
        initComponents();
        setBackground(colorFondo);
        setPreferredSize(new java.awt.Dimension(2000, 1200));
        setLayout(null); // Posicionamiento absoluto

        crearPnlVertices();
        //mover los pnl en direcciones

        // Posición base (centro del panel)
        int centroX = 600;
        int centroY = 350;
        moverVertice("Oaxaca de Juárez", centroX, centroY);
        moverVertice("Tuxtepec", centroX, centroY - 200); // arriba
        moverVertice("Huajuapan de León", centroX - 250, centroY - 200); // arriba izquierda
        moverVertice("Santa Cruz Xoxocotlán", centroX, centroY + 150); // izquierda abajo
        moverVertice("Santo Domingo Tehuantepec", centroX + 250, centroY + 100); // derecha abajo
        moverVertice("Ixtepec", centroX + 250, centroY - 50); // derecha arriba

        moverVertice("Romero Avendaño", centroX + 350, centroY - 120); // Arriba a la derecha de ixtepec
        moverVertice("Juchitán de Zaragoza", centroX + 400, centroY + 30); // abajo a la derecha de ixtepec
        moverVertice("Domingo Ingenio", centroX + 530, centroY - 120);// arriba de juchitlan de zaragoza
        moverVertice("San Pedro Tapanatepec", centroX + 700, centroY - 50);// al lado derecho de Domingo ingenio

        moverVertice("Salina Cruz", centroX + 350, centroY + 250); // abajo de tehuantepec

        moverVertice("Santa María Huatulco", centroX + 250, centroY + 400);
        // abajo a la izquierda de salina cruz
        moverVertice("Miahuatlán de Porfirio Díaz", centroX, centroY + 450);
// arriba de Huatulco 12
        moverVertice("Puerto Escondido", centroX - 250, centroY + 350); // al lado izquierdo de porfirio diaz
        moverVertice("Heroica Ciudad de Ejutla de Crespo", centroX + 130, centroY + 250);//arriba de porfirio diaz
        moverVertice("Santa Catarina Juquila", centroX - 250, centroY + 200); // arriba del puerto escondido

        moverVertice("Santiago Pinotepa Nacional", centroX - 450, centroY + 250);
        moverVertice("Putla Villa de Guerrero", centroX - 450, centroY + 100);

        moverVertice("Tlaxiaco", centroX - 250, centroY);
        moverVertice("Santiago Juxtlahuaca", centroX - 430, centroY - 100);

        //Crear Arista
    }

    public void moverVertice(String nombre, int x, int y) {
        PnlVertice pnl = vertices.get(nombre);
        pnl.setPosicion(x, y);

        pnl.setBounds(x, y, pnl.getPreferredSize().width, pnl.getPreferredSize().height);
        repaint();
    }

    //obtener el peso de la arista 
    public double obtenerPesoArista(String origen, String destino) {
        PnlVertice pnlOrigen = vertices.get(origen);
        PnlVertice pnlDestino = vertices.get(destino);
        Vertice verticeOrigen = pnlOrigen.getVertice();
        Vertice verticeDestino = pnlDestino.getVertice();

        List<Arista> aristas = verticeOrigen.getAristas();
        for (Arista arista : aristas) {
            if (arista.getDestino().equals(verticeDestino)) {
                return arista.getPeso();
            }

        }
        return -1;

    }

    public void dibujarArista(String origen, String destino, Graphics2D g2d) {
        PnlVertice pnlOrigen = vertices.get(origen);
        PnlVertice pnlDestino = vertices.get(destino);
        Vertice vertice = pnlOrigen.getVertice();
        List<Arista> arista = vertice.getAristas();

        if (pnlOrigen != null && pnlDestino != null) {
            int x1 = pnlOrigen.getPosX();
            int y1 = pnlOrigen.getPosY();
            int x2 = pnlDestino.getPosX();
            int y2 = pnlDestino.getPosY();

            g2d.setColor(Color.BLACK);
            g2d.drawLine(x1, y1, x2, y2);
            // Dibujar la línea
            g2d.setColor(Color.BLACK);
            g2d.drawLine(x1, y1, x2, y2);

            // Obtener peso de la arista
            double peso = obtenerPesoArista(origen, destino);
            if (peso != -1) {
                // Calcular el punto medio
                int midX = (x1 + x2) / 2;
                int midY = (y1 + y2) / 2;

                // Dibujar el peso como etiqueta
                g2d.setColor(Color.BLUE);
                g2d.drawString(String.valueOf(peso), midX + 5, midY - 5);
            }
        }
    }

    public void crearPnlVertices() {
        if (vertices == null) {
            vertices = new java.util.HashMap<>();
        }

        removeAll();

        for (Map.Entry<String, Vertice> entry : verticesGrafo.entrySet()) {
            String nombre = entry.getKey();
            Vertice v = entry.getValue();
            PnlVertice pnlVertice = new PnlVertice(v, false);

            pnlVertice.setBounds(0, 0, pnlVertice.getPreferredSize().width, pnlVertice.getPreferredSize().height);

            add(pnlVertice);

            vertices.put(nombre, pnlVertice);
        }

        revalidate();
        repaint();

    }

    @Override
    public void doLayout() {
        super.doLayout();

        if (pnlOaxaca != null) {
            int ancho = pnlOaxaca.getPreferredSize().width;
            int alto = pnlOaxaca.getPreferredSize().height;
            int x = (getWidth() - ancho) / 2;
            int y = (getHeight() - alto) / 2;
            pnlOaxaca.setBounds(x, y, ancho, alto);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Activamos suavizado
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Color de fondo personalizado
        g2d.setColor(colorFondo);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        //aristas
        dibujarArista("Oaxaca de Juárez", "Tuxtepec", g2d);
        dibujarArista("Oaxaca de Juárez", "Huajuapan de León", g2d);
        dibujarArista("Oaxaca de Juárez", "Santa Cruz Xoxocotlán", g2d);
        dibujarArista("Oaxaca de Juárez", "Santo Domingo Tehuantepec", g2d);
        dibujarArista("Oaxaca de Juárez", "Ixtepec", g2d);

        dibujarArista("Ixtepec", "Romero Avendaño", g2d);
        dibujarArista("Romero Avendaño", "Juchitán de Zaragoza", g2d);
        dibujarArista("Ixtepec", "Juchitán de Zaragoza", g2d);

        dibujarArista("Juchitán de Zaragoza", "Domingo Ingenio", g2d);
        dibujarArista("Juchitán de Zaragoza", "Salina Cruz", g2d);

        dibujarArista("Santo Domingo Tehuantepec", "Juchitán de Zaragoza", g2d);
        dibujarArista("Salina Cruz", "Santo Domingo Tehuantepec", g2d);

        dibujarArista("Salina Cruz", "Santa María Huatulco", g2d);
        dibujarArista("Santa María Huatulco", "Miahuatlán de Porfirio Díaz", g2d);
        dibujarArista("Santa María Huatulco", "Puerto Escondido", g2d);

        dibujarArista("Miahuatlán de Porfirio Díaz", "Heroica Ciudad de Ejutla de Crespo", g2d);
        dibujarArista("Heroica Ciudad de Ejutla de Crespo", "Puerto Escondido", g2d);
        dibujarArista("Heroica Ciudad de Ejutla de Crespo", "Santa Cruz Xoxocotlán", g2d);
        dibujarArista("Heroica Ciudad de Ejutla de Crespo", "Santa Catarina Juquila", g2d);

        dibujarArista("Santa Catarina Juquila", "Santa Cruz Xoxocotlán", g2d);
        dibujarArista("Santa Catarina Juquila", "Puerto Escondido", g2d);
        dibujarArista("Santa Catarina Juquila", "Santiago Pinotepa Nacional", g2d);
        dibujarArista("Santa Catarina Juquila", "Heroica Ciudad de Ejutla de Crespo", g2d);

        dibujarArista("Santiago Pinotepa Nacional", "Puerto Escondido", g2d);
        dibujarArista("Santiago Pinotepa Nacional", "Putla Villa de Guerrero", g2d);

        dibujarArista("Tlaxiaco", "Huajuapan de León", g2d);
        dibujarArista("Domingo Ingenio", "San Pedro Tapanatepec", g2d);

        dibujarArista("Putla Villa de Guerrero", "Santiago Juxtlahuaca", g2d);
        dibujarArista("Putla Villa de Guerrero", "Tlaxiaco", g2d);
        dibujarArista("Santiago Juxtlahuaca", "Huajuapan de León", g2d);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
