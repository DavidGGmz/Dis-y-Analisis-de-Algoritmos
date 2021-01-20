/*
 * Proyecto: Proyecto
 * Paquete:  Modelos
 * Clase:    Proyecto3
 */
package Modelos;
import Modelos.GenerarGrafos;
/**
 * @author David GonzÃ¡lez
 */
public class Proyecto3 {

    public static void main(String[] args) {
    /*Se crean dos salidas por cada modelo de grafo aleatorio.
    Todos las creaciones de objetos toman como argumento el número de vértices
    con excepción del modelo geográfico, que también toma la cadena que
    especifica que ese modelo. Esto para que cuando se creen los nodos, se creen
    con coordenadas aleatorias en el intervalo [0.0,1.0]
    Además se calculas árboles por cada grafo: un Dijkstra*/

    GenerarGrafos uno = new GenerarGrafos(30);
    uno.modeloER(90); //número de aristas
    GenerarGrafos unoPesado = uno.EdgeValues(1.0, 15.0);
    unoPesado.escribirArchivo("Salidas\\GV\\01ER030_3.gv");
    GenerarGrafos unoDijkstra = unoPesado.Dijkstra(0);
    unoDijkstra.escribirArchivo("Salidas\\GV\\01ER030_3Dijkstra.gv");

    GenerarGrafos dos = new GenerarGrafos(200);
    dos.modeloER(1000); //número de aristas
    GenerarGrafos dosPesado = dos.EdgeValues(1.0, 15.0);
    dosPesado.escribirArchivo("Salidas\\GV\\01ER200_3.gv");
    GenerarGrafos dosDijkstra = dosPesado.Dijkstra(0);
    dosDijkstra.escribirArchivo("Salidas\\GV\\01ER200_3Dijkstra.gv");

    GenerarGrafos tres = new GenerarGrafos(30);
    tres.modeloGilbert(0.25); //probabilidad
    GenerarGrafos tresPesado = tres.EdgeValues(1.0, 15.0);
    tresPesado.escribirArchivo("Salidas\\GV\\02Gilbert030_3.gv");
    GenerarGrafos tresDijkstra = tresPesado.Dijkstra(0);
    tresDijkstra.escribirArchivo("Salidas\\GV\\02Gilbert030_3Dijkstra.gv");

    GenerarGrafos cuatro = new GenerarGrafos(200);
    cuatro.modeloGilbert(0.25); //probabilidad
    GenerarGrafos cuatroPesado = cuatro.EdgeValues(1.0, 15.0);
    cuatroPesado.escribirArchivo("Salidas\\GV\\02Gilbert200_3.gv");
    GenerarGrafos cuatroDijkstra = cuatroPesado.Dijkstra(0);
    cuatroDijkstra.escribirArchivo("Salidas\\GV\\02Gilbert200_3Dijkstra.gv");

    GenerarGrafos cinco = new GenerarGrafos(30, "geo-uniforme");
    cinco.modeloGeoSimple(0.3);  //distancia a la que se deben conectar nodos
    GenerarGrafos cincoPesado = cinco.EdgeValues(1.0, 15.0);
    cincoPesado.escribirArchivo("Salidas\\GV\\03Geo030_3.gv");
    GenerarGrafos cincoDijkstra = cincoPesado.Dijkstra(0);
    cincoDijkstra.escribirArchivo("Salidas\\GV\\03Geo030_3Dijkstra.gv");

    GenerarGrafos seis = new GenerarGrafos(200, "geo-uniforme");
    seis.modeloGeoSimple(0.3); //distancia a la que se deben conectar nodos
    GenerarGrafos seisPesado = seis.EdgeValues(1.0, 15.0);
    seisPesado.escribirArchivo("Salidas\\GV\\03Geo200_3.gv");
    GenerarGrafos seisDijkstra = seisPesado.Dijkstra(0);
    seisDijkstra.escribirArchivo("Salidas\\GV\\03Geo200_3Dijkstra.gv");

    GenerarGrafos siete = new GenerarGrafos(30);
    siete.modeloBA(7);  //parámetro 'd' del modelo
    GenerarGrafos sietePesado = siete.EdgeValues(1.0, 15.0);
    sietePesado.escribirArchivo("Salidas\\GV\\04BA030_3.gv");
    GenerarGrafos sieteDijkstra = sietePesado.Dijkstra(0);
    sieteDijkstra.escribirArchivo("Salidas\\GV\\04BA030_3Dijkstra.gv");

    GenerarGrafos ocho = new GenerarGrafos(200);
    ocho.modeloBA(100); //parámetro 'd' del modelo
    GenerarGrafos ochoPesado = ocho.EdgeValues(1.0, 15.0);
    ochoPesado.escribirArchivo("Salidas\\GV\\04BA200_3.gv");
    GenerarGrafos ochoDijkstra = ochoPesado.Dijkstra(0);
    ochoDijkstra.escribirArchivo("Salidas\\GV\\04BA200_3Dijkstra.gv");
    
    }
    
}
