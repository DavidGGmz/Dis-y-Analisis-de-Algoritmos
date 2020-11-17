/*
 * Proyecto: Proyecto1
 * Paquete:  Modelos
 * Clase:    Arista
 */
package Modelos;
/**
 * @author David González
 */
public class Arista {
    
    /*VARIABLES DE INSTANCIA*/
    private Integer n1;    //Nodo inicial
    private Integer n2;    //Nodo Final
    private double peso;   //Valor de Interconexión
    
    /*Constructor que toma números de los nodos que conecta y su peso*/
    public Arista (int n1, int n2, double peso){
        this.n1 = n1;
        this.n2 = n2;
        this.peso = peso;
    }
    
    /*GETTERS (DEVUELVE EL VALOR DE UNA VARIABLE) Y VARIABLES DE INSTANCIA*/
    public String getNode1(){
        return "n" + n1.toString();
    }
    
    public String getNode2(){
        return "n" + n2.toString();
    }
    
    public int getIntN1(){
        return n1;
    }
    
    public int getIntN2(){
        return n2;
    }
    
    public double getWeight(){
        return peso;
    }
}
