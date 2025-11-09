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
        // --- Agregar vértices ---
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
        grafo.agregarVertice("Heroica Ciudad de Ejutla de Crespo");
        grafo.agregarVertice("Santa Catarina Juquila");
        grafo.agregarVertice("Santiago Pinotepa Nacional");
        grafo.agregarVertice("Putla Villa de Guerrero");
        grafo.agregarVertice("Tlaxiaco");

        // --- Conexiones ---
        grafo.conectarVertices("Oaxaca de Juárez", "Tuxtepec", 219);
        grafo.conectarVertices("Oaxaca de Juárez", "Huajuapan de León", 171);
        grafo.conectarVertices("Oaxaca de Juárez", "Santa Cruz Xoxocotlán", 12);
        grafo.conectarVertices("Oaxaca de Juárez", "Santo Domingo Tehuantepec", 249);
        grafo.conectarVertices("Oaxaca de Juárez", "Ixtepec", 280);

        grafo.conectarVertices("Ixtepec", "Romero Avendaño", 69);
        grafo.conectarVertices("Ixtepec", "Juchitán de Zaragoza", 17);

        grafo.conectarVertices("Juchitán de Zaragoza", "Domingo Ingenio", 44);
        grafo.conectarVertices("Juchitán de Zaragoza", "Salina Cruz", 72.0);
        grafo.conectarVertices("Santo Domingo Tehuantepec", "Juchitán de Zaragoza", 29.0);
        grafo.conectarVertices("Salina Cruz", "Santo Domingo Tehuantepec", 15.0);

        grafo.conectarVertices("Salina Cruz", "Santa María Huatulco", 166);
        grafo.conectarVertices("Santa María Huatulco", "Miahuatlán de Porfirio Díaz", 130.0);
        grafo.conectarVertices("Santa María Huatulco", "Puerto Escondido", 97.0);

        grafo.conectarVertices("Miahuatlán de Porfirio Díaz", "Heroica Ciudad de Ejutla de Crespo", 38.0);
        grafo.conectarVertices("Heroica Ciudad de Ejutla de Crespo", "Puerto Escondido", 127.0);
        grafo.conectarVertices("Heroica Ciudad de Ejutla de Crespo", "Santa Cruz Xoxocotlán", 63.0);
        grafo.conectarVertices("Heroica Ciudad de Ejutla de Crespo", "Santa Catarina Juquila", 153.0);

        grafo.conectarVertices("Santa Catarina Juquila", "Santa Cruz Xoxocotlán", 193.0);
        grafo.conectarVertices("Santa Catarina Juquila", "Puerto Escondido", 96.0);
        grafo.conectarVertices("Santa Catarina Juquila", "Santiago Pinotepa Nacional", 137.0);

        grafo.conectarVertices("Heroica Ciudad de Ejutla de Crespo", "Putla Villa de Guerrero", 139.0);
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Puerto Escondido", 139.0);
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Putla Villa de Guerrero", 129.0);

        grafo.conectarVertices("Putla Villa de Guerrero", "Santiago Pinotepa Nacional", 129.0);
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Huajuapan de León", 286.0);
        grafo.conectarVertices("Tlaxiaco", "Huajuapan de León", 121.0);
    }
}
