/*
 * Proyecto: Proyecto
 * Paquete:  Modelos
 * Clase:    Nodo
 */
package Modelos;
/**
 * @author David González
 */
public class Nodo {
    /*VARIABLES DE INSTANCIA*/
    private String nombre;
    private Integer numAristas;
    private Integer index;
    private double distance;
    
    private double x;   //Usadas para Modelo Geográfico Simple
    private double y;   //Usadas para Modelo Geográfico Simple
    
    
    /*Constructor que toma una cadena como nombre del vértice*/
    public Nodo (String nombre){
        this.nombre = nombre;
        this.numAristas = 0;
    }
    
    /*Constructor que toma en entero como argumento, Asigna la variable
    de instancia "name" la cadena formada por la letra "n" concatenada con
    la representación en cadena del numero entero que tomó como argumento*/
    public Nodo (int nombre) {
        this.index = nombre;
        this.nombre = "n" + String.valueOf(nombre);
        this.numAristas = 0;
    }
    
    /*Constructor usado en el modelo grográfico simple. Toma un entero que sirve
    como nombre del vértice y dos números de punto flotante como coordenadas
    del vértice. El modelo geofráfico simple toma coordenadas en un cuadrado
    unitario*/
    public Nodo (int name, double x, double y){
        this.index = name;
        this.nombre = "n" + String.valueOf(nombre);
        this.x = x;
        this.y = y;
    }
    
    /*getters de variables de instancia*/
    public String getName(){
        return nombre;
    }
    
    public Integer getNumEdges(){
        return numAristas;
    }
    
    public Integer getIndex(){
        return index;
    }
    
    public double getDistance(){
        return distance;
    }
    
    public void setDistance(double d){
        this.distance = d;
    }
    
    /*Variables de instancia usadas en el modelo geográfico simple*/
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
}
