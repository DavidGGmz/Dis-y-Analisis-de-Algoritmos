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
public class Proyecto2 {

    public static void main(String s[]) {
        
        /*Cálculo de árboles por cada grafo: un BFS y dos DFS*/

        GenerarGrafos uno = new GenerarGrafos(30);
        uno.modeloER(8); //número de aristas
        GenerarGrafos unoBFS = uno.BFS(0);
        unoBFS.escribirArchivo("Modelo-Erdös y Rényi-030_BFS.gv");
        GenerarGrafos unoDFS_R = uno.DFS_R(0);
        unoDFS_R.escribirArchivo("Modelo-Erdös y Rényi-030_DFS_R.gv");
        GenerarGrafos unoDFS_I = uno.DFS_I(0);
        unoDFS_I.escribirArchivo("Modelo-Erdös y Rényi-030_DFS_I.gv");

        GenerarGrafos dos = new GenerarGrafos(100);
        dos.modeloER(25); //número de aristas
        GenerarGrafos dosBFS = dos.BFS(0);
        dosBFS.escribirArchivo("Modelo-Erdös y Rényi-100_BFS.gv");
        GenerarGrafos dosDFS_R = dos.DFS_R(0);
        dosDFS_R.escribirArchivo("Modelo-Erdös y Rényi-100_DFS_R.gv");
        GenerarGrafos dosDFS_I = dos.DFS_I(0);
        dosDFS_I.escribirArchivo("Modelo-Erdös y Rényi-100_DFS_I.gv");
        
        GenerarGrafos tres = new GenerarGrafos(500);
        tres.modeloER(75); //número de aristas
        GenerarGrafos tresBFS = tres.BFS(0);
        tresBFS.escribirArchivo("Modelo-Erdös y Rényi-500_BFS.gv");
        GenerarGrafos tresDFS_R = tres.DFS_R(0);
        tresDFS_R.escribirArchivo("Modelo-Erdös y Rényi-500_DFS_R.gv");
        GenerarGrafos tresDFS_I = tres.DFS_I(0);
        tresDFS_I.escribirArchivo("Modelo-Erdös y Rényi-500_DFS_I.gv");

        GenerarGrafos cuatro = new GenerarGrafos(30);
        cuatro.modeloGilbert(0.25); //probabilidad
        GenerarGrafos cuatroBFS = cuatro.BFS(0);
        cuatroBFS.escribirArchivo("Modelo-Gilbert-030_BFS.gv");
        GenerarGrafos cuatroDFS_R = cuatro.DFS_R(0);
        cuatroDFS_R.escribirArchivo("Modelo-Gilbert-030_DFS_R.gv");
        GenerarGrafos cuatroDFS_I = cuatro.DFS_I(0);
        cuatroDFS_I.escribirArchivo("Modelo-Gilbert-030_DFS_I.gv");
        
        GenerarGrafos cinco = new GenerarGrafos(100);
        cinco.modeloGilbert(0.25); //probabilidad
        GenerarGrafos cincoBFS = cinco.BFS(0);
        cincoBFS.escribirArchivo("Modelo-Gilbert-100_BFS.gv");
        GenerarGrafos cincoDFS_R = cinco.DFS_R(0);
        cincoDFS_R.escribirArchivo("Modelo-Gilbert-100_DFS_R.gv");
        GenerarGrafos cincoDFS_I = cinco.DFS_I(0);
        cincoDFS_I.escribirArchivo("Modelo-Gilbert-100_DFS_I.gv");
        
        GenerarGrafos seis = new GenerarGrafos(500);
        seis.modeloGilbert(0.25); //probabilidad
        GenerarGrafos seisBFS = seis.BFS(0);
        seisBFS.escribirArchivo("Modelo-Gilbert-500_BFS.gv");
        GenerarGrafos seisDFS_R = seis.DFS_R(0);
        seisDFS_R.escribirArchivo("Modelo-Gilbert-500_DFS_R.gv");
        GenerarGrafos seisDFS_I = seis.DFS_I(0);
        seisDFS_I.escribirArchivo("Modelo-Gilbert-500_DFS_I.gv");

        GenerarGrafos siete = new GenerarGrafos(30, "geo-uniforme");
        siete.modeloGeoSimple(0.3);  //distancia a la que se deben conectar nodos
        GenerarGrafos sieteBFS = siete.BFS(0);
        sieteBFS.escribirArchivo("Modelo-GeoSimple-030_BFS.gv");
        GenerarGrafos sieteDFS_R = siete.DFS_R(0);
        sieteDFS_R.escribirArchivo("Modelo-GeoSimple-030_DFS_R.gv");
        GenerarGrafos sieteDFS_I = siete.DFS_I(0);
        sieteDFS_I.escribirArchivo("Modelo-GeoSimple-030_DFS_I.gv");
        
        GenerarGrafos ocho = new GenerarGrafos(100, "geo-uniforme");
        ocho.modeloGeoSimple(0.3);  //distancia a la que se deben conectar nodos
        GenerarGrafos ochoBFS = ocho.BFS(0);
        ochoBFS.escribirArchivo("Modelo-GeoSimple-100_BFS.gv");
        GenerarGrafos ochoDFS_R = ocho.DFS_R(0);
        ochoDFS_R.escribirArchivo("Modelo-GeoSimple-100_DFS_R.gv");
        GenerarGrafos ochoDFS_I = ocho.DFS_I(0);
        ochoDFS_I.escribirArchivo("Modelo-GeoSimple-100_DFS_I.gv");

        GenerarGrafos nueve = new GenerarGrafos(500, "geo-uniforme");
        nueve.modeloGeoSimple(0.3); //distancia a la que se deben conectar nodos
        GenerarGrafos nueveBFS = nueve.BFS(0);
        nueveBFS.escribirArchivo("Modelo-GeoSimple-500_BFS.gv");
        GenerarGrafos nueveDFS_R = nueve.DFS_R(0);
        nueveDFS_R.escribirArchivo("Modelo-GeoSimple-500_DFS_R.gv");
        GenerarGrafos nueveDFS_I = nueve.DFS_I(0);
        nueveDFS_I.escribirArchivo("Modelo-GeoSimple-500_DFS_I.gv");

        GenerarGrafos diez = new GenerarGrafos(30);
        diez.modeloBA(7);  //parámetro 'd' del modelo
        GenerarGrafos diezBFS = diez.BFS(0);
        diezBFS.escribirArchivo("Modelo-BarabasiAlbert-030_BFS.gv");
        GenerarGrafos diezDFS_R = diez.DFS_R(0);
        diezDFS_R.escribirArchivo("Modelo-BarabasiAlbert-030_DFS_R.gv");
        GenerarGrafos diezDFS_I = diez.DFS_I(0);
        diezDFS_I.escribirArchivo("Modelo-BarabasiAlbert-030_DFS_I.gv");
        
        GenerarGrafos once = new GenerarGrafos(100);
        once.modeloBA(25);  //parámetro 'd' del modelo
        GenerarGrafos onceBFS = once.BFS(0);
        onceBFS.escribirArchivo("Modelo-BarabasiAlbert-100_BFS.gv");
        GenerarGrafos onceDFS_R = once.DFS_R(0);
        onceDFS_R.escribirArchivo("Modelo-BarabasiAlbert-100_DFS_R.gv");
        GenerarGrafos onceDFS_I = once.DFS_I(0);
        onceDFS_I.escribirArchivo("Modelo-BarabasiAlbert-100_DFS_I.gv");

        GenerarGrafos doce = new GenerarGrafos(500);
        doce.modeloBA(100); //parámetro 'd' del modelo
        GenerarGrafos doceBFS = doce.BFS(0);
        doceBFS.escribirArchivo("Modelo-BarabasiAlbert-500_BFS.gv");
        GenerarGrafos doceDFS_R = doce.DFS_R(0);
        doceDFS_R.escribirArchivo("Modelo-BarabasiAlbert-500_DFS_R.gv");
        GenerarGrafos doceDFS_I = doce.DFS_I(0);
        doceDFS_I.escribirArchivo("Modelo-BarabasiAlbert-500_DFS_I.gv");
        
        }
    }
        