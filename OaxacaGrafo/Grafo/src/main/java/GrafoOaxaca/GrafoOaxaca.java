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
        grafo.mostrarGrafo();
    }

    private void inicializarGrafo() {
        grafo.agregarVertice("Asunción Nochixtlán");
        grafo.agregarVertice("Ciudad Ixtepec");
        grafo.agregarVertice("Crucecita");
        grafo.agregarVertice("Cuilápam de Guerrero");
        grafo.agregarVertice("Heroica Ciudad de Huajuapan de León");
        grafo.agregarVertice("Heroica Ciudad de Juchitán de Zaragoza");
        grafo.agregarVertice("Heroica Ciudad de Tlaxiaco");
        grafo.agregarVertice("Loma Bonita");
        grafo.agregarVertice("Matías Romero Avendaño");
        grafo.agregarVertice("Miahuatlán de Porfirio Díaz");
        grafo.agregarVertice("Oaxaca");
        grafo.agregarVertice("Ocotlán de Morelos");
        grafo.agregarVertice("Puerto Escondido");
        grafo.agregarVertice("Río Grande o Piedra Parada");
        grafo.agregarVertice("Salina Cruz");
        grafo.agregarVertice("San Antonio de la Cal");
        grafo.agregarVertice("San Jacinto Amilpas");
        grafo.agregarVertice("San Juan Bautista Tuxtepec");
        grafo.agregarVertice("San Pedro Pochutla");
        grafo.agregarVertice("Santa Cruz Amilpas");
        grafo.agregarVertice("Santa Cruz Xoxocotlán");
        grafo.agregarVertice("Santa Lucía del Camino");
        grafo.agregarVertice("Santa Maria Atzompa");
        grafo.agregarVertice("Santiago Pinotepa Nacional");
        grafo.agregarVertice("Santo Domingo Tehuantepec");
        grafo.agregarVertice("Tlacolula de Matamoros");
        grafo.agregarVertice("Unión Hidalgo (Oaxaca)");
        grafo.agregarVertice("Vicente Guerrero");
        grafo.agregarVertice("Villa de Zaachila");
        grafo.agregarVertice("Zimatlán de Álvarez");

        grafo.conectarVertices("Santo Domingo Tehuantepec", "Ciudad Ixtepec", 34);
        grafo.conectarVertices("Ciudad Ixtepec", "Matías Romero Avendaño", 69);
        grafo.conectarVertices("Santo Domingo Tehuantepec", "Oaxaca", 249);
        grafo.conectarVertices("Oaxaca", "Tlacolula de Matamoros", 31);
        grafo.conectarVertices("Oaxaca", "Asunción Nochixtlán", 89);
        grafo.conectarVertices("Asunción Nochixtlán", "Heroica Ciudad de Huajuapan de León", 99);
        grafo.conectarVertices("San Juan Bautista Tuxtepec", "Oaxaca", 219);
        grafo.conectarVertices("Oaxaca", "Miahuatlán de Porfirio Díaz", 103);
        grafo.conectarVertices("Miahuatlán de Porfirio Díaz", "San Pedro Pochutla", 105);
        grafo.conectarVertices("San Pedro Pochutla", "Puerto Escondido", 70);
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Puerto Escondido", 139);
        grafo.conectarVertices("Puerto Escondido", "San Pedro Pochutla", 70);
        grafo.conectarVertices("San Pedro Pochutla", "Crucecita", 32);
        grafo.conectarVertices("Crucecita", "Salina Cruz", 166);
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Río Grande o Piedra Parada", 48);
        grafo.conectarVertices("Matías Romero Avendaño", "Salina Cruz", 135);
        grafo.conectarVertices("Santo Domingo Tehuantepec", "Salina Cruz", 15);
        grafo.conectarVertices("Oaxaca", "Heroica Ciudad de Huajuapan de León", 171);
        grafo.conectarVertices("San Juan Bautista Tuxtepec", "Loma Bonita", 45);
        grafo.conectarVertices("Loma Bonita", "Matías Romero Avendaño", 145);
        grafo.conectarVertices("Heroica Ciudad de Tlaxiaco", "Asunción Nochixtlán", 76);
        grafo.conectarVertices("Heroica Ciudad de Tlaxiaco", "Santiago Pinotepa Nacional", 230);
        grafo.conectarVertices("Heroica Ciudad de Juchitán de Zaragoza", "Santo Domingo Tehuantepec", 29);
        grafo.conectarVertices("Heroica Ciudad de Juchitán de Zaragoza", "Ciudad Ixtepec", 17);
        grafo.conectarVertices("Heroica Ciudad de Juchitán de Zaragoza", "Unión Hidalgo (Oaxaca)", 12);
        grafo.conectarVertices("Oaxaca", "Santa Cruz Xoxocotlán", 4);
        grafo.conectarVertices("Oaxaca", "Santa Lucía del Camino", 3);
        grafo.conectarVertices("Oaxaca", "San Antonio de la Cal", 8);
        grafo.conectarVertices("Oaxaca", "Santa Maria Atzompa", 7);
        grafo.conectarVertices("Oaxaca", "San Jacinto Amilpas", 6);
        grafo.conectarVertices("Oaxaca", "Santa Cruz Amilpas", 9);
        grafo.conectarVertices("Santa Cruz Xoxocotlán", "San Antonio de la Cal", 7);
        grafo.conectarVertices("Santa Cruz Xoxocotlán", "Cuilápam de Guerrero", 10);
        grafo.conectarVertices("Santa Lucía del Camino", "San Jacinto Amilpas", 5);
        grafo.conectarVertices("San Jacinto Amilpas", "Santa Cruz Amilpas", 4);
        grafo.conectarVertices("Santa Maria Atzompa", "Santa Lucía del Camino", 6);
        grafo.conectarVertices("Oaxaca", "Villa de Zaachila", 17);
        grafo.conectarVertices("Santa Cruz Xoxocotlán", "Villa de Zaachila", 15);
        grafo.conectarVertices("Villa de Zaachila", "Cuilápam de Guerrero", 8);
        grafo.conectarVertices("Villa de Zaachila", "Vicente Guerrero", 3);
        grafo.conectarVertices("Oaxaca", "Zimatlán de Álvarez", 32);
        grafo.conectarVertices("Villa de Zaachila", "Zimatlán de Álvarez", 18);
        grafo.conectarVertices("Oaxaca", "Ocotlán de Morelos", 35);
        grafo.conectarVertices("Zimatlán de Álvarez", "Ocotlán de Morelos", 22);
        grafo.conectarVertices("Ocotlán de Morelos", "Tlacolula de Matamoros", 30);
        grafo.conectarVertices("Santiago Pinotepa Nacional", "Heroica Ciudad de Huajuapan de León", 286);
        grafo.conectarVertices("Heroica Ciudad de Huajuapan de León", "Heroica Ciudad de Tlaxiaco", 121);
        grafo.conectarVertices("Salina Cruz", "Miahuatlán de Porfirio Díaz", 181);
        grafo.conectarVertices("Zimatlán de Álvarez", "Miahuatlán de Porfirio Díaz", 72);
    }
}
