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
        grafo.agregarVertice("Heroica Ciudad de Ejutla de Crespo"); //20
        grafo.agregarVertice("Santa Catarina Juquila"); //19
        grafo.agregarVertice("Santiago Pinotepa Nacional");
        grafo.agregarVertice("Putla Villa de Guerrero");//18
        grafo.agregarVertice("Tlaxiaco");
        grafo.agregarVertice("Santiago Juxtlahuaca");

        //Nodos
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

        // --- Conexiones (aristas con distancias) ---
        grafo.conectarVertices("Oaxaca de Juárez", "Tuxtepec", 219);
        grafo.conectarVertices("Oaxaca de Juárez", "Huajuapan de León", 171);
        grafo.conectarVertices("Oaxaca de Juárez", "Santa Cruz Xoxocotlán", 12);
        grafo.conectarVertices("Oaxaca de Juárez", "Santo Domingo Tehuantepec", 249);
        grafo.conectarVertices("Oaxaca de Juárez", "Ixtepec", 280);

        grafo.conectarVertices("Ixtepec", "Romero Avendaño", 69);
        grafo.conectarVertices("Ixtepec", "Juchitán de Zaragoza", 17);

        grafo.conectarVertices("Juchitán de Zaragoza", "Domingo Ingenio", 44);
        grafo.conectarVertices("Juchitán de Zaragoza", "Salina Cruz", 72);
        grafo.conectarVertices("Juchitán de Zaragoza", "Romero Avendaño", 61);
        grafo.conectarVertices("Santo Domingo Tehuantepec", "Juchitán de Zaragoza", 29);
        grafo.conectarVertices("Salina Cruz", "Santo Domingo Tehuantepec", 15);

        grafo.conectarVertices("Salina Cruz", "Santa María Huatulco", 166);
        grafo.conectarVertices("Santa María Huatulco", "Miahuatlán de Porfirio Díaz", 130);
        grafo.conectarVertices("Santa María Huatulco", "Puerto Escondido", 97);

        grafo.conectarVertices("Miahuatlán de Porfirio Díaz", "Heroica Ciudad de Ejutla de Crespo", 38);
        grafo.conectarVertices("Heroica Ciudad de Ejutla de Crespo", "Puerto Escondido", 127);
        grafo.conectarVertices("Heroica Ciudad de Ejutla de Crespo", "Santa Cruz Xoxocotlán", 63);
        grafo.conectarVertices("Heroica Ciudad de Ejutla de Crespo", "Santa Catarina Juquila", 153);

        grafo.conectarVertices("Santa Catarina Juquila", "Santa Cruz Xoxocotlán", 193);
        grafo.conectarVertices("Santa Catarina Juquila", "Puerto Escondido", 96);
        grafo.conectarVertices("Santa Catarina Juquila", "Santiago Pinotepa Nacional", 137);
        grafo.conectarVertices("Santa Catarina Juquila", "Heroica Ciudad de Ejutla de Crespo", 60);

        grafo.conectarVertices("Santiago Juxtlahuaca", "Putla Villa de Guerrero", 59);
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Puerto Escondido", 139);
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Putla Villa de Guerrero", 129);

        grafo.conectarVertices("Tlaxiaco", "Putla Villa de Guerrero", 87);

        grafo.conectarVertices("Tlaxiaco", "Huajuapan de León", 121);
        //
        grafo.conectarVertices("Santiago Juxtlahuaca", "Huajuapan de León", 100);
        grafo.conectarVertices("San Pedro Tapanatepec", "Domingo Ingenio", 72);

        //CONEXIONES
        //NOCHIXTLAN
        grafo.conectarVertices("Asunción Nochixtlán", "Oaxaca de Juárez", 81);
        grafo.conectarVertices("Asunción Nochixtlán", "Huajuapan de León", 120);
        grafo.conectarVertices("Asunción Nochixtlán", "Tlaxiaco", 100);

        //RIO GRANDE(PIEDRA PARADA)
        grafo.conectarVertices("Río Grande (Piedra Parada)", "Puerto Escondido", 40);
        grafo.conectarVertices("Río Grande (Piedra Parada)", "Santa Catarina Juquila", 70);
        grafo.conectarVertices("Río Grande (Piedra Parada)", "Santiago Pinotepa Nacional", 95);
        //SANTA LUCIA DEL CAMINO
        grafo.conectarVertices("Santa Lucía del Camino", "Oaxaca de Juárez", 4);
        grafo.conectarVertices("Santa Lucía del Camino", "Santa Cruz Xoxocotlán", 9.2);
        //SAN ANTONIO DE LA CAL
        grafo.conectarVertices("San Antonio de la Cal", "Santa Cruz Xoxocotlán", 12);
        grafo.conectarVertices("San Antonio de la Cal", "Villa de Zaachila", 20);
        //VILLA DE ZAACHILA
        grafo.conectarVertices("Villa de Zaachila", "Santa María Atzompa", 15);
        grafo.conectarVertices("Villa de Zaachila", "Oaxaca de Juárez", 18);
        //SANTA MARI ATZOMPA
        grafo.conectarVertices("Santa María Atzompa", "Oaxaca de Juárez", 10);
        grafo.conectarVertices("Santa María Atzompa", "Santa María Huatulco", 200);
        //ZIMATLN DE ALVAREZ
        grafo.conectarVertices("Zimatlán de Álvarez", "Oaxaca de Juárez", 35);
        grafo.conectarVertices("Zimatlán de Álvarez", "Ocotlán de Morelos", 30);
        //OCOTLAN DE MORELOS
        grafo.conectarVertices("Ocotlán de Morelos", "Villa de Zaachila", 40);
        grafo.conectarVertices("Ocotlán de Morelos", "Miahuatlán de Porfirio Díaz", 60);
        //LOMA BONITA
        grafo.conectarVertices("Loma Bonita", "San Juan Bautista Tuxtepec", 45);
        grafo.conectarVertices("Loma Bonita", "Matías Romero Avendaño", 90);
        //UNION HIDALGO
        grafo.conectarVertices("Unión Hidalgo", "Juchitán de Zaragoza", 20);
        grafo.conectarVertices("Unión Hidalgo", "Salina Cruz", 30);
        //SAN PEDRO POCHUTLA
        grafo.conectarVertices("San Pedro Pochutla", "Santa María Huatulco", 22);
        grafo.conectarVertices("San Pedro Pochutla", "Puerto Escondido", 73);

    }

}
