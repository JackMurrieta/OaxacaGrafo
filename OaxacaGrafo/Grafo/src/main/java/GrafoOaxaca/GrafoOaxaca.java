/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafoOaxaca;

import Grafo.Grafo;

/**
 *
 * @author Jack Murrieta
 */
public class GrafoOaxaca {

    private Grafo grafo;

    public GrafoOaxaca() {
        grafo = new Grafo();
        inicializarGrafo();
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void mostrarGrafo() {
        System.out.println("=== GRAFO OAXACA ===");
        grafo.mostrarGrafo();
    }

    private void inicializarGrafo() {
        grafo.agregarVertice("Oaxaca de Juárez");
        grafo.agregarVertice("Tuxtepec");
        grafo.agregarVertice("Huajuapan de León");
        grafo.agregarVertice("Santa Cruz Xoxocotlán");
        grafo.agregarVertice("Santo Domingo Tehuantepec");
        grafo.agregarVertice("Ixtepec");
        grafo.agregarVertice("Romero Avendaño");
        grafo.agregarVertice("Juchitán de Zaragoza");
        grafo.agregarVertice("Domingo Ingenio");
        grafo.agregarVertice("San Pedro Tapanatepec");
        grafo.agregarVertice("Salina Cruz");
        grafo.agregarVertice("Santa María Huatulco");
        grafo.agregarVertice("Miahuatlán de Porfirio Díaz");
        grafo.agregarVertice("Puerto Escondido");
        grafo.agregarVertice("Heroica Ciudad de Ejutla de Crespo"); // 20
        grafo.agregarVertice("Santa Catarina Juquila"); // 19
        grafo.agregarVertice("Santiago Pinotepa Nacional");
        grafo.agregarVertice("Putla Villa de Guerrero");// 18
        grafo.agregarVertice("Tlaxiaco");
        grafo.agregarVertice("Santiago Juxtlahuaca");

        // Nodos
        grafo.agregarVertice("Asunción Nochixtlán");
        grafo.agregarVertice("Río Grande (Piedra Parada)");
        grafo.agregarVertice("Santa Lucía del Camino");
        grafo.agregarVertice("San Antonio de la Cal");
        grafo.agregarVertice("Villa de Zaachila");

        grafo.agregarVertice("Zimatlán de Álvarez");

        grafo.agregarVertice("Ocotlán de Morelos");
        grafo.agregarVertice("Loma Bonita");
        grafo.agregarVertice("Unión Hidalgo");

        grafo.agregarVertice("San Pedro Pochutla");

        // checar villa
        conectarAristasOaxaca();
        conectarAristasTuxtepec();
        conectarAristasLomaBonita();
        conectarAristasXoxocotlan();
        conectarAristasDomingoIngenio();
        conectarAristasOcotlanMorelos();
        conectarAristasSanAntonioCal();
        conectarAristasSantaLuciaCamino();
        conectarAristasUnionHidalgo();
        conectarAristasVillaZaachila();
        conectarAristasZimatlanAlvarez();
        conectarAristasPinotepaNacional();
        conectarAristasRioGrande();
        conectarAristasNochixtlan();
        conectarAristasPochutla();

        grafo.conectarVertices("Juchitán de Zaragoza", "Salina Cruz", 72);
        grafo.conectarVertices("Juchitán de Zaragoza", "Romero Avendaño", 61);

        grafo.conectarVertices("Santo Domingo Tehuantepec", "Juchitán de Zaragoza", 29);

        grafo.conectarVertices("Salina Cruz", "Santo Domingo Tehuantepec", 15);
        grafo.conectarVertices("Salina Cruz", "Santa María Huatulco", 166);
        //checar aqui

        grafo.conectarVertices("Santa María Huatulco", "Miahuatlán de Porfirio Díaz", 130);
        grafo.conectarVertices("Santa María Huatulco", "San Pedro Pochutla", 5);

        grafo.conectarVertices("Miahuatlán de Porfirio Díaz", "Heroica Ciudad de Ejutla de Crespo", 38);
        grafo.conectarVertices("Heroica Ciudad de Ejutla de Crespo", "Puerto Escondido", 127);

        grafo.conectarVertices("Santa Catarina Juquila", "Puerto Escondido", 96);
        grafo.conectarVertices("Santa Catarina Juquila", "Santiago Pinotepa Nacional", 137);
        grafo.conectarVertices("Santa Catarina Juquila", "Río Grande (Piedra Parada)", 50);

        grafo.conectarVertices("Santiago Juxtlahuaca", "Putla Villa de Guerrero", 59);

        grafo.conectarVertices("Tlaxiaco", "Putla Villa de Guerrero", 87);

        grafo.conectarVertices("Tlaxiaco", "Huajuapan de León", 121);
        //
        grafo.conectarVertices("Santiago Juxtlahuaca", "Huajuapan de León", 100);

        conectarAristasIxtepec();
        // CONEXIONES
        // NOCHIXTLAN
        // RIO GRANDE(PIEDRA PARADA)
        // SAN PEDRO POCHUTLA
    }

    private void conectarAristasOaxaca() {
        grafo.conectarVertices("Oaxaca de Juárez", "Tuxtepec", 219);
        grafo.conectarVertices("Oaxaca de Juárez", "Santa Cruz Xoxocotlán", 12);
        grafo.conectarVertices("Oaxaca de Juárez", "Asunción Nochixtlán", 82);
        grafo.conectarVertices("Oaxaca de Juárez", "Santa Lucía del Camino", 5);
        grafo.conectarVertices("Oaxaca de Juárez", "San Antonio de la Cal", 7);
    }

    private void conectarAristasTuxtepec() {
        grafo.conectarVertices("Tuxtepec", "Loma Bonita", 63);
    }

    private void conectarAristasLomaBonita() {
        grafo.conectarVertices("Loma Bonita", "Romero Avendaño", 48);
    }

    private void conectarAristasUnionHidalgo() {
        grafo.conectarVertices("Unión Hidalgo", "Romero Avendaño", 38);
        grafo.conectarVertices("Unión Hidalgo", "Domingo Ingenio", 24);
        grafo.conectarVertices("Unión Hidalgo", "Juchitán de Zaragoza", 14);
    }

    private void conectarAristasDomingoIngenio() {
        grafo.conectarVertices("Domingo Ingenio", "San Pedro Tapanatepec", 52);
        grafo.conectarVertices("Juchitán de Zaragoza", "Domingo Ingenio", 44);

    }

    private void conectarAristasXoxocotlan() {
        grafo.conectarVertices("Santa Cruz Xoxocotlán", "Villa de Zaachila", 10);
        //
        grafo.conectarVertices("Santa Cruz Xoxocotlán", "San Antonio de la Cal", 7);
    }

    private void conectarAristasSantaLuciaCamino() {
        grafo.conectarVertices("Santa Lucía del Camino", "San Antonio de la Cal", 6);
        grafo.conectarVertices("Santa Lucía del Camino", "Santa Cruz Xoxocotlán", 8);
        grafo.conectarVertices("Santa Lucía del Camino", "Santo Domingo Tehuantepec", 245);
        grafo.conectarVertices("Santa Lucía del Camino", "Ixtepec", 230);
    }

    private void conectarAristasSanAntonioCal() {
        grafo.conectarVertices("San Antonio de la Cal", "Villa de Zaachila", 12);
        grafo.conectarVertices("San Antonio de la Cal", "Ocotlán de Morelos", 10);
    }

    private void conectarAristasVillaZaachila() {
        grafo.conectarVertices("Villa de Zaachila", "Ocotlán de Morelos", 17);
        grafo.conectarVertices("Villa de Zaachila", "Zimatlán de Álvarez", 11);
    }

    private void conectarAristasZimatlanAlvarez() {
        grafo.conectarVertices("Zimatlán de Álvarez", "Ocotlán de Morelos", 15);
        grafo.conectarVertices("Zimatlán de Álvarez", "Santa Catarina Juquila", 160);
    }

    private void conectarAristasOcotlanMorelos() {
        grafo.conectarVertices("Ocotlán de Morelos", "Heroica Ciudad de Ejutla de Crespo", 19);
    }

    private void conectarAristasPinotepaNacional() {
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Río Grande (Piedra Parada)", 95);
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Putla Villa de Guerrero", 129);
    }

    private void conectarAristasRioGrande() {
        grafo.conectarVertices("Río Grande (Piedra Parada)", "Puerto Escondido", 40);
        grafo.conectarVertices("Río Grande (Piedra Parada)", "Santa Catarina Juquila", 50);
    }

    private void conectarAristasNochixtlan() {
        grafo.conectarVertices("Asunción Nochixtlán", "Huajuapan de León", 93);
        grafo.conectarVertices("Asunción Nochixtlán", "Tlaxiaco", 86);
    }

    private void conectarAristasPochutla() {
        grafo.conectarVertices("San Pedro Pochutla", "Santa María Huatulco", 22);
        grafo.conectarVertices("San Pedro Pochutla", "Puerto Escondido", 73);
    }

    private void conectarAristasIxtepec() {
        grafo.conectarVertices("Ixtepec", "Romero Avendaño", 69);
        grafo.conectarVertices("Ixtepec", "Santo Domingo Tehuantepec", 39);

        grafo.conectarVertices("Ixtepec", "Juchitán de Zaragoza", 20);

    }
}
