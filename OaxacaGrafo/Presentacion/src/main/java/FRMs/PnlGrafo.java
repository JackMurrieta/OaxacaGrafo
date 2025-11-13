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
        moverVertice("Santa Cruz Xoxocotlán", centroX - 150, centroY + 150); // izquierda abajo
        moverVertice("Santa Lucía del Camino", centroX + 150, centroY - 150); // derecha arriba
        moverVertice("Asunción Nochixtlán", centroX - 150, centroY - 150);
        
        moverVertice("Ixtepec", centroX + 450, centroY - 120);
        moverVertice("Santo Domingo Tehuantepec", centroX + 399, centroY);
        moverVertice("San Antonio de la Cal", centroX + 150, centroY + 150);

        //Loma Bonita
        int centroXNodoA = centroX + 350;
        moverVertice("Loma Bonita", centroX, centroY - 350);
        moverVertice("Romero Avendaño", centroXNodoA + 350, centroY - 120); // Arriba a la derecha de ixtepec
        moverVertice("Juchitán de Zaragoza", centroXNodoA + 400, centroY + 30); // abajo a la derecha de ixtepec
        moverVertice("Domingo Ingenio", centroXNodoA + 530, centroY - 120);// arriba de juchitlan de zaragoza
        moverVertice("San Pedro Tapanatepec", centroXNodoA + 700, centroY - 50);// al lado derecho de Domingo ingenio
        moverVertice("Unión Hidalgo", centroXNodoA + 600, centroY + 30);
        moverVertice("Salina Cruz", centroXNodoA + 300, centroY + 150); // abajo de tehuantepec

        moverVertice("Santa María Huatulco", centroXNodoA + 250, centroY + 400);
        // abajo a la izquierda de salina cruz
        moverVertice("Miahuatlán de Porfirio Díaz", centroXNodoA - 100, centroY + 400);

        //villa zaachila
        moverVertice("Villa de Zaachila", centroX - 150, centroY + 300);
        moverVertice("Ocotlán de Morelos", centroX + 150, centroY + 300);
        moverVertice("Heroica Ciudad de Ejutla de Crespo", centroX + 400, centroY + 300);
        moverVertice("San Pedro Pochutla", centroXNodoA, centroY + 550);
        moverVertice("Zimatlán de Álvarez", centroX - 150, centroY + 400);
        
        int centroXB = centroX - 150;
        moverVertice("Puerto Escondido", centroX - 150, centroY + 550); // al lado izquierdo de porfirio diaz
        moverVertice("Santa Catarina Juquila", centroXB - 250, centroY + 200); // arriba del puerto escondido
//
        moverVertice("Santiago Pinotepa Nacional", centroXB - 450, centroY + 250);
        moverVertice("Putla Villa de Guerrero", centroXB - 450, centroY + 100);
        
        moverVertice("Tlaxiaco", centroXB - 250, centroY);
        moverVertice("Santiago Juxtlahuaca", centroXB - 430, centroY - 100);

        //mover nodos faltantes
        moverVertice("Río Grande (Piedra Parada)", centroXB - 450, centroY + 400);
        moverVertice("Huajuapan de León", centroX - 300, centroY - 220);
        
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
    
    public void dibujarAristasOaxacaDeJuarez(Graphics2D g2d) {
        dibujarArista("Oaxaca de Juárez", "Tuxtepec", g2d);
        dibujarArista("Oaxaca de Juárez", "Santa Cruz Xoxocotlán", g2d);
        dibujarArista("Oaxaca de Juárez", "Asunción Nochixtlán", g2d);
        dibujarArista("Oaxaca de Juárez", "Santa Lucía del Camino", g2d); //5.3
        dibujarArista("Oaxaca de Juárez", "San Antonio de la Cal", g2d);
        
    }
    
    public void dibujarAristaTuxtepex(Graphics2D g2d) {
        dibujarArista("Tuxtepec", "Loma Bonita", g2d);
        
    }
    
    public void dibujarAristaLomaBonita(Graphics2D g2d) {
        dibujarArista("Loma Bonita", "Romero Avendaño", g2d);
    }
    
    public void dibujarAristaUnionHidalgo(Graphics2D g2d) {
        dibujarArista("Unión Hidalgo", "Romero Avendaño", g2d);
        dibujarArista("Unión Hidalgo", "Domingo Ingenio", g2d);
        
        dibujarArista("Unión Hidalgo", "Juchitán de Zaragoza", g2d);
        
    }
    
    public void dibujarAristasDomingoINgenio(Graphics2D g2d) {
        dibujarArista("Domingo Ingenio", "San Pedro Tapanatepec", g2d);
        
    }
    
    public void dibujarAristaXoxocotlan(Graphics2D g2d) {
        dibujarArista("Santa Cruz Xoxocotlán", "Villa de Zaachila", g2d);
        dibujarArista("Santa Cruz Xoxocotlán", "San Antonio de la Cal", g2d);
        
    }
    
    public void dibujarAristasSantaLuciaCamino(Graphics2D g2d) {
        dibujarArista("Santa Lucía del Camino", "San Antonio de la Cal", g2d); //6.2
        dibujarArista("Santa Lucía del Camino", "Santa Cruz Xoxocotlán", g2d);
        dibujarArista("Santa Lucía del Camino", "Santo Domingo Tehuantepec", g2d);
        dibujarArista("Santa Lucía del Camino", "Ixtepec", g2d);
        
    }
    
    public void dibujarAristaSanAntonioCal(Graphics2D g2d) {
        dibujarArista("San Antonio de la Cal", "Villa de Zaachila", g2d);
        dibujarArista("San Antonio de la Cal", "Ocotlán de Morelos", g2d);
    }
    
    public void dibujarAristasVillaZaachila(Graphics2D g2d) {
        dibujarArista("Villa de Zaachila", "Ocotlán de Morelos", g2d);
        dibujarArista("Villa de Zaachila", "Zimatlán de Álvarez", g2d);
    }
    
    public void dibujarAristasZimatlanAlvarez(Graphics2D g2d) {
        dibujarArista("Zimatlán de Álvarez", "Ocotlán de Morelos", g2d);
        dibujarArista("Zimatlán de Álvarez", "Santa Catarina Juquila", g2d);
        
    }
    
    public void dibujarAristasOcotlanMorelos(Graphics2D g2d) {
        dibujarArista("Ocotlán de Morelos", "Heroica Ciudad de Ejutla de Crespo", g2d);
    }
    
    public void dibujarAristaJuchitan(Graphics2D g2d) {
        dibujarArista("Juchitán de Zaragoza", "Salina Cruz", g2d);
        dibujarArista("Juchitán de Zaragoza", "Romero Avendaño", g2d);
        
    }
    
    public void dibujarAristasSalinaCruz(Graphics2D g2d) {
        dibujarArista("Salina Cruz", "Santo Domingo Tehuantepec", g2d);
        dibujarArista("Salina Cruz", "Santa María Huatulco", g2d);
    }
    
    public void dibujarAristasTehuantepec(Graphics2D g2d) {
        dibujarArista("Santo Domingo Tehuantepec", "Juchitán de Zaragoza", g2d);
    }
    
    public void dibujarAristaMariaHuatulco(Graphics2D g2d) {
        dibujarArista("Santa María Huatulco", "Miahuatlán de Porfirio Díaz", g2d);
        dibujarArista("Santa María Huatulco", "San Pedro Pochutla", g2d);
    }
    
    public void dibujarAristasCrespo(Graphics2D g2d) {
        dibujarArista("Heroica Ciudad de Ejutla de Crespo", "Miahuatlán de Porfirio Díaz", g2d);
        
    }
//

    public void dibujarAristaPorfirioDiaz(Graphics2D g2d) {
        dibujarArista("Miahuatlán de Porfirio Díaz", "Heroica Ciudad de Ejutla de Crespo", g2d);
        
    }

// --- Santa Catarina Juquila ---
    public void dibujarAristasSantaCatarinaJuquila(Graphics2D g2d) {
        dibujarArista("Santa Catarina Juquila", "Puerto Escondido", g2d);
        dibujarArista("Santa Catarina Juquila", "Santiago Pinotepa Nacional", g2d);
        dibujarArista("Santa Catarina Juquila", "Río Grande (Piedra Parada)", g2d);
    }

// --- Puerto Escondido ---
    public void dibujarAristasPuertoEscondido(Graphics2D g2d) {
        dibujarArista("Puerto Escondido", "Heroica Ciudad de Ejutla de Crespo", g2d);
        dibujarArista("Puerto Escondido", "Santa Catarina Juquila", g2d);
        dibujarArista("San Pedro Pochutla", "Puerto Escondido", g2d);
        dibujarArista("Río Grande (Piedra Parada)", "Puerto Escondido", g2d);
    }

// --- Santiago Pinotepa Nacional ---
    public void dibujarAristasPinotepa(Graphics2D g2d) {
        dibujarArista("Santiago Pinotepa Nacional", "Santa Catarina Juquila", g2d);
        dibujarArista("Santiago Pinotepa Nacional", "Putla Villa de Guerrero", g2d);
        
    }

// --- Río Grande (Piedra Parada) ---
    public void dibujarAristasRioGrande(Graphics2D g2d) {
        dibujarArista("Río Grande (Piedra Parada)", "Santa Catarina Juquila", g2d);
    }

// --- Santiago Juxtlahuaca ---
    public void dibujarAristasJuxtlahuaca(Graphics2D g2d) {
        dibujarArista("Santiago Juxtlahuaca", "Putla Villa de Guerrero", g2d);
        dibujarArista("Santiago Juxtlahuaca", "Huajuapan de León", g2d);
    }

// --- Putla Villa de Guerrero ---
    public void dibujarAristasPutla(Graphics2D g2d) {
        dibujarArista("Putla Villa de Guerrero", "Santiago Juxtlahuaca", g2d);
        dibujarArista("Putla Villa de Guerrero", "Tlaxiaco", g2d);
    }

// --- Tlaxiaco ---
    public void dibujarAristasTlaxiaco(Graphics2D g2d) {
        dibujarArista("Tlaxiaco", "Putla Villa de Guerrero", g2d);
        dibujarArista("Tlaxiaco", "Huajuapan de León", g2d);
    }

// --- Huajuapan de León ---
    public void dibujarAristasHuajuapan(Graphics2D g2d) {
        dibujarArista("Huajuapan de León", "Tlaxiaco", g2d);
        dibujarArista("Huajuapan de León", "Santiago Juxtlahuaca", g2d);
    }

// --- San Pedro Pochutla ---
    public void dibujarAristasSanPedroPochutla(Graphics2D g2d) {
        dibujarArista("San Pedro Pochutla", "Santa María Huatulco", g2d);
    }

// --- Romero Avendaño ---
    public void dibujarAristasRomeroAvendano(Graphics2D g2d) {
        dibujarArista("Romero Avendaño", "Juchitán de Zaragoza", g2d);
        dibujarArista("Romero Avendaño", "Loma Bonita", g2d);
        dibujarArista("Romero Avendaño", "Unión Hidalgo", g2d);
    }

// --- Santo Domingo Tehuantepec ---
    public void dibujarAristasSantoDomingoTehuantepec(Graphics2D g2d) {
        dibujarArista("Santo Domingo Tehuantepec", "Salina Cruz", g2d);
        dibujarArista("Santo Domingo Tehuantepec", "Juchitán de Zaragoza", g2d);
    }
    
    public void dibujarAristasIxtepec(Graphics2D g2d) {
        dibujarArista("Ixtepec", "Romero Avendaño", g2d);
        dibujarArista("Ixtepec", "Santo Domingo Tehuantepec", g2d);
        dibujarArista("Ixtepec", "Juchitán de Zaragoza", g2d);
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
        dibujarAristasOaxacaDeJuarez(g2d);
        dibujarAristaLomaBonita(g2d);
        dibujarAristaSanAntonioCal(g2d);
        dibujarAristaTuxtepex(g2d);
        dibujarAristaUnionHidalgo(g2d);
        dibujarAristaXoxocotlan(g2d);
        dibujarAristasDomingoINgenio(g2d);
        dibujarAristasOcotlanMorelos(g2d);
        dibujarAristasSantaLuciaCamino(g2d);
        dibujarAristasVillaZaachila(g2d);
        dibujarAristasZimatlanAlvarez(g2d);
        //juchitan
        dibujarAristaJuchitan(g2d);
        dibujarAristasSalinaCruz(g2d);
        dibujarAristasTehuantepec(g2d);
        dibujarAristaMariaHuatulco(g2d);
        dibujarAristasCrespo(g2d);
        dibujarAristaPorfirioDiaz(g2d);
        //
        dibujarAristasSantaCatarinaJuquila(g2d);
        dibujarAristasPuertoEscondido(g2d);
        
        dibujarAristasPinotepa(g2d);
        dibujarAristasJuxtlahuaca(g2d);
        dibujarAristasPutla(g2d);
        dibujarAristasTlaxiaco(g2d);
        dibujarAristasHuajuapan(g2d);
        dibujarAristasSanPedroPochutla(g2d);
        dibujarAristasRomeroAvendano(g2d);
        dibujarArista("Santiago Pinotepa Nacional", "Río Grande (Piedra Parada)", g2d);
        dibujarArista("Huajuapan de León", "Asunción Nochixtlán", g2d);
        dibujarAristasIxtepec(g2d);
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
