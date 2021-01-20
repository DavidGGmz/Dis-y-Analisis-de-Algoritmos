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

    GenerarGrafos uno = new GenerarGrafos(30);
    uno.modeloER(90); //número de aristas
    GenerarGrafos unoPesado = uno.EdgeValues(1.0, 15.0);
    unoPesado.escribirArchivo("Modelo-ErdösYRenyi-030.gv");
    GenerarGrafos unoDijkstra = unoPesado.Dijkstra(0);
    unoDijkstra.escribirArchivo("Modelo-ErdösYRenyi-030_Dijkstra.gv");

    GenerarGrafos dos = new GenerarGrafos(200);
    dos.modeloER(1000); //número de aristas
    GenerarGrafos dosPesado = dos.EdgeValues(1.0, 15.0);
    dosPesado.escribirArchivo("Modelo-ErdösYRenyi-200.gv");
    GenerarGrafos dosDijkstra = dosPesado.Dijkstra(0);
    dosDijkstra.escribirArchivo("Modelo-ErdösYRenyi-200_Dijkstra.gv");

    GenerarGrafos tres = new GenerarGrafos(30);
    tres.modeloGilbert(0.25); //probabilidad
    GenerarGrafos tresPesado = tres.EdgeValues(1.0, 15.0);
    tresPesado.escribirArchivo("Modelo-Gilbert-030.gv");
    GenerarGrafos tresDijkstra = tresPesado.Dijkstra(0);
    tresDijkstra.escribirArchivo("Modelo-Gilbert-030_Dijkstra.gv");

    GenerarGrafos cuatro = new GenerarGrafos(200);
    cuatro.modeloGilbert(0.25); //probabilidad
    GenerarGrafos cuatroPesado = cuatro.EdgeValues(1.0, 15.0);
    cuatroPesado.escribirArchivo("Modelo-Gilbert-200.gv");
    GenerarGrafos cuatroDijkstra = cuatroPesado.Dijkstra(0);
    cuatroDijkstra.escribirArchivo("Modelo-Gilbert-200_Dijkstra.gv");

    GenerarGrafos cinco = new GenerarGrafos(30, "geo-uniforme");
    cinco.modeloGeoSimple(0.3);  //distancia a la que se deben conectar nodos
    GenerarGrafos cincoPesado = cinco.EdgeValues(1.0, 15.0);
    cincoPesado.escribirArchivo("Modelo-GeoSimple-030.gv");
    GenerarGrafos cincoDijkstra = cincoPesado.Dijkstra(0);
    cincoDijkstra.escribirArchivo("Modelo-GeoSimple-030_Dijkstra.gv");

    GenerarGrafos seis = new GenerarGrafos(200, "geo-uniforme");
    seis.modeloGeoSimple(0.3); //distancia a la que se deben conectar nodos
    GenerarGrafos seisPesado = seis.EdgeValues(1.0, 15.0);
    seisPesado.escribirArchivo("Modelo-GeoSimple-200.gv");
    GenerarGrafos seisDijkstra = seisPesado.Dijkstra(0);
    seisDijkstra.escribirArchivo("Modelo-GeoSimple-200_Dijkstra.gv");

    GenerarGrafos siete = new GenerarGrafos(30);
    siete.modeloBA(7);  //parámetro 'd' del modelo
    GenerarGrafos sietePesado = siete.EdgeValues(1.0, 15.0);
    sietePesado.escribirArchivo("Modelo-BarabasiAlbert-030.gv");
    GenerarGrafos sieteDijkstra = sietePesado.Dijkstra(0);
    sieteDijkstra.escribirArchivo("Modelo-BarabasiAlbert-030_Dijkstra.gv");

    GenerarGrafos ocho = new GenerarGrafos(200);
    ocho.modeloBA(100); //parámetro 'd' del modelo
    GenerarGrafos ochoPesado = ocho.EdgeValues(1.0, 15.0);
    ochoPesado.escribirArchivo("Modelo-BarabasiAlbert-200.gv");
    GenerarGrafos ochoDijkstra = ochoPesado.Dijkstra(0);
    ochoDijkstra.escribirArchivo("Modelo-BarabasiAlbert-200_Dijkstra.gv");
    
    }
    
}
