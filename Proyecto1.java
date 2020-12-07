/*
 * Proyecto: Proyecto
 * Paquete:  Modelos
 * Clase:    Proyecto1
 */
package Modelos;
import Modelos.GenerarGrafos;
/**
 * @author David González
 */
public class Proyecto1 {

    public static void main(String s[]) {
        
        GenerarGrafos uno = new GenerarGrafos(30);
        uno.modeloER(8); //número de aristas
        uno.escribirArchivo("Modelo-Erdös y Rényi-030.gv");
        
        GenerarGrafos dos = new GenerarGrafos(100);
        dos.modeloER(25); //número de aristas
        dos.escribirArchivo("Modelo-Erdös y Rényi-100.gv");
        
        GenerarGrafos tres = new GenerarGrafos(500);
        tres.modeloER(75); //número de aristas
        tres.escribirArchivo("Modelo-Erdös y Rényi-500.gv");
        
        GenerarGrafos cuatro = new GenerarGrafos(30);
        cuatro.modeloGilbert(0.25); //probabilidad
        cuatro.escribirArchivo("Modelo-Gilbert-030.gv");
        
        GenerarGrafos cinco = new GenerarGrafos(100);
        cinco.modeloGilbert(0.25); //probabilidad
        cinco.escribirArchivo("Modelo-Gilbert-100.gv");
        
        GenerarGrafos seis = new GenerarGrafos(500);
        seis.modeloGilbert(0.25); //probabilidad
        seis.escribirArchivo("Modelo-Gilbert-500.gv");
        
        GenerarGrafos siete = new GenerarGrafos(30, "geo-uniforme");
        siete.modeloGeoSimple(0.3);  //distancia a la que se deben conectarnodos
        siete.escribirArchivo("Modelo-GeoSimple-030.gv");

        GenerarGrafos ocho = new GenerarGrafos(100, "geo-uniforme");
        ocho.modeloGeoSimple(.3); //distancia a la que se deben conectar nodos
        ocho.escribirArchivo("Modelo-GeoSimple-100.gv");

        GenerarGrafos nueve = new GenerarGrafos(500, "geo-uniforme");
        nueve.modeloGeoSimple(0.3); //distancia a la que se deben conectar nodos
        nueve.escribirArchivo("Modelo-GeoSimple-500.gv");

        GenerarGrafos diez = new GenerarGrafos(30);
        diez.modeloBA(7);  //parámetro 'd' del modelo
        diez.escribirArchivo("Modelo-BarabasiAlbert-030.gv");

        GenerarGrafos once = new GenerarGrafos(100);
        once.modeloBA(25); //parámetro 'd' del modelo
        once.escribirArchivo("Modelo-BarabasiAlbert-100.gv");

        GenerarGrafos doce = new GenerarGrafos(500);
        doce.modeloBA(100); //parámetro 'd' del modelo
        doce.escribirArchivo("Modelo-BarabasiAlbert-500.gv");

    }
    
}
