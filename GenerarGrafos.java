/*
 * Proyecto: Proyecto
 * Paquete:  Modelos
 * Clase:    Grafo
 */
package Modelos;
import Modelos.Nodo;
import Modelos.Arista;
import java.util.*;
import java.io.FileNotFoundException;
/**
 * @author David GonzÃ¡lez
 */
public class GenerarGrafos {
    /*VARIABLES DE INSTANCIA*/
    
    /*Arreglo de objetos "NODO". De esta forma nos podemos referir a cada
    vÃ©rtice por su posiciÃ³n en el arreglo*/
    private Nodo[] nodes;
    /*El grafo en si es un mapa Hash. Toma como llave el vÃ©rtice, que es mapeado
    a un conjunto Hash de vÃ©rtices con los cuales hay conexiÃ³n.*/
    private HashMap<Nodo, HashSet<Nodo>> graph;
    private HashMap<Nodo, HashSet<Arista>> incidencia; 
    private final int numeroVertices; //nÃºmero de vÃ©rtices del grafo
    private int numeroAristas;  //nÃºmero de aristas Ãºnicas del grafo
    private static Formatter output; //objeto para escribir a disco
    private Boolean weighted; //bandera a usar si grafo es pesado
    
    /*CONTRUCTORES*/
    public GenerarGrafos(int numVertices){
        this.graph = new HashMap<Nodo, HashSet<Nodo>>();
        this.incidencia = new HashMap<Nodo, HashSet<Arista>>();
        this. numeroVertices = numVertices;
        this.nodes = new Nodo [numVertices];
        for (int i = 0; i < numVertices; i++){
            Nodo n = new Nodo (i);
            this.nodes [i] = n;
            this.graph.put(n, new HashSet<Nodo>());
            this.incidencia.put(n, new HashSet<Arista>());
        }
        this.weighted = false;
    }
    
    /*Constructor usado para el modelo geofrÃ¡fico simple.
    Se le tienen que pasar el nÃºmero de vÃ©rtices y la cadena "geo-uniforme"*/
    public GenerarGrafos (int numVertices, String modelo){
        this.graph = new HashMap<Nodo, HashSet<Nodo>>();
        this.incidencia = new HashMap<Nodo, HashSet<Arista>>();
        this.numeroVertices = numVertices;
        this.nodes = new Nodo[numVertices];
        Random coorX = new Random();
        Random coorY = new Random();
        if (modelo == "geo-uniforme"){
            for (int i = 0; i < numVertices; i++){
                Nodo n = new Nodo(i, coorX.nextDouble(), coorY.nextDouble());
                this.nodes[i] = n;
                this.graph.put(n, new HashSet<Nodo>());
                this.incidencia.put(n, new HashSet<Arista>());
            }
        }
        this.weighted = false;
    }
    
    /*METODOS AUXILIARES*/
    //Regresa el grado (nÃºmero de aristas) de un vertice i
    public int gradoVertice (int i){
        Nodo n1 = this.getNode(i);
        return this.graph.get(n1).size();
    }
    
    //Conecta dos vÃ©rtices
    public void conectarVertices(int i, int j) {
        /*Se recuperan los vÃ©rtices de los Ã­ndices i y j*/
        Nodo n1 = this.getNode(i);
        Nodo n2 = this.getNode(j);
        /*Se recuperan las aristas de cada vÃ©rtice*/
        HashSet<Nodo> aristas1 = this.getEdges(i);
        HashSet<Nodo> aristas2 = this.getEdges(j);
        
        /*Se agregan los vÃ©rtices al conjunto del otro*/
        aristas1.add(n2);
        aristas2.add(n1);  //en Grafos dirigidos hay que quitar esta lÃ­nea
        this.numeroAristas +=1; //Para que sean aristas Ãºnicas (en lugar de 2)
    }
    
    //Regresa "True" si ya existe la arista
    private Boolean existeConexion (int i, int j){
        /*Se recuperan los vÃ©rtices de los Ã­ndices i y j*/
        Nodo n1 = this.getNode(i);
        Nodo n2 = this.getNode(j);
        
        /*Se recuperan las aristas de cada vÃ©rtice*/
        HashSet<Nodo> aristas1 = this.getEdges(i);
        HashSet<Nodo> aristas2 = this.getEdges(j);
        
        /*Se revisa que un nodo estÃ© en el conjunto de aristas del otro*/
        if (aristas1.contains(n2) || aristas2.contains(n1)) {
            return true;
        }
        
        else{
            return false;
        }
    }
    
    //Distancia L2 entre vÃ©rtices para el modelo geofrÃ¡fico
    private double distanciaVertices(Nodo n1, Nodo n2) {
        return Math.sqrt(Math.pow((n1.getX() - n2.getX()), 2)
                + Math.pow((n1.getY() - n2.getY()), 2));
    }
    
    //////////getters/setters de las variables de instancia//////////
    public int getNumNodes() {
        return numeroVertices;
    }
    
    public int getNumEdges() {
        return numeroAristas;
    }
    
    public Nodo getNode(int i) {
        return this.nodes[i];
    }
    
    public Boolean getWeightedFlag() {
        return this.weighted;
    }
    
    public HashSet<Nodo> getEdges(int i) {
        Nodo n = this.getNode(i);
        return this.graph.get(n);
    }
    
    public HashSet<Arista> getWeightedEdges(int i) {
        Nodo n = this.getNode(i);
        return this.incidencia.get(n);
    }
    
    public void setWeighted() {
        this.weighted = true;
    }
    
    public void setIncidencia(int i, HashSet<Arista> aristasPeso) {
        this.incidencia.put(this.getNode(i), aristasPeso);
    }
    
    public void setAristaPeso(int i, int j, double peso) {
        if (!this.existeConexion(i, j)) this.conectarVertices(i, j);
        Arista aristaNuevaij = new Arista(i, j, peso);
        Arista aristaNuevaji = new Arista(j, i, peso);
        HashSet<Arista> aristasNodoi = this.getWeightedEdges(i);
        HashSet<Arista> aristasNodoj = this.getWeightedEdges(j);
        aristasNodoi.add(aristaNuevaij);
        aristasNodoj.add(aristaNuevaji);
        this.setIncidencia(i, aristasNodoi);
        this.setIncidencia(j, aristasNodoj);
        if (!this.getWeightedFlag()) this.setWeighted();
    }
    
    //////////MÃ©todo toString para representaciÃ³n en String del Grafo//////////
    public String toString() {
        String salida;
        if (this.getWeightedFlag()) { //esta parte es para grafos pesados y con
            salida ="graph {\n";        // nodos etiquetados
            for (int i = 0; i < this.getNumNodes(); i++) {
                salida += this.getNode(i).getName() + " [label=\""
                        + this.getNode(i).getName() 
                        + " ("+ this.getNode(i).getDistance()+ ")\"];\n";         
            }
            for (int i = 0; i < this.getNumNodes(); i++) {
                HashSet<Arista> aristas = this.getWeightedEdges(i);
                for (Arista e : aristas) {
                    salida += e.getNode1() + " -- " + e.getNode2()
                            + " [weight=" + e.getWeight()+""
                            + " label="+e.getWeight()+""+ "];\n";
                }
            }
            salida += "}\n";
        }
        else { //esta es para grafos sin pesos ni etiquetas
            salida ="graph {\n";
            for (int i = 0; i < this.getNumNodes(); i++) {
                salida += this.getNode(i).getName() + ";\n";
            }
            for (int i = 0; i < this.getNumNodes(); i++) {
                HashSet<Nodo> aristas = this.getEdges(i);
                for (Nodo n : aristas) {
                    salida += this.getNode(i).getName() + " -- " + n.getName() 
                            + ";\n";
                }
            }
            salida += "}\n";
        }
        return salida;
    }
    
    //////////MÃ©todos de instancia de los modelos de generaciÃ³n//////////
    
    /*Modelo ErdÃ¶s-RÃ©nyi.*/
    /*Crea n vÃ©rtices y elige uniformemente al azar m distintos
    pares de distintos vÃ©rtices*/
    public void modeloER(int numAristas) {
        Random randomNum1 = new Random();
        Random randomNum2 = new Random();
        /*mientras el nÃºmero de aristas del grafo sea menor que el nÃºmero con el
        que se llamÃ³ este modelo se generan nÃºmeros al azar entre 0 y el nÃºmero
        de nodos -1. Se verifica si ya existe conexiÃ³n entre los nodos que
        corresponden a esos Ã­ndices y si no, se conectan. Se verifica que
        los nÃºmeros pseudoaleatorios no sean el mismo*/
        while (this.getNumEdges() < numAristas) {
            int num1 = randomNum1.nextInt(this.getNumNodes());
            int num2 = randomNum2.nextInt(this.getNumNodes());
            if (num1 != num2) {
                if (!existeConexion(num1, num2)) {
                    conectarVertices(num1, num2);
                }
            }
        }
    }
    
    
    /*Modelo de Gilbert.*/
    /*Crear m aristas crear n vÃ©rtices y poner una arista entre cada par
    independiente y uniformemente con probabilidad p*/
    public void modeloGilbert(double probabilidad) {
        Random randomNum = new Random();
        /*Para cada vÃ©rtice i se recorren todos los vÃ©rtices j con i<>j. En cada
        par se calcula un nÃºmero pseudoaleatorio entre 0.0 y 1.0 y se compara
        con la probabilidad que se le pasÃ³ como argumento al modelo. Si es menor
        que la probabilidad y no existe ya una conexiÃ³n, se 
        realiza la conexiÃ³n.*/
        for(int i = 0; i < this.getNumNodes(); i++) {
            for(int j = 0; j <this.getNumNodes(); j++) {
                if ((i != j) && (randomNum.nextDouble() <= probabilidad)) {
                    if (!existeConexion(i, j)) {
                        conectarVertices(i, j);
                    }
                }
            }
        }   
    }
    
    
    /*Modelo geogrÃ¡fico simple.*/
    /*Colocar n vÃ©rtices en un rectÃ¡ngulo unitario con coordenadas uniformes
    (o normales) y colocar una arista entre cada par que queda a una
    distancia r o menor*/
    public void modeloGeoSimple(double r) {
        /*Para cada vÃ©rtice i se compara con el resto de los vÃ©rtices con los
        que no se ha comparado y si estÃ¡n a una distancia r o menor se realiza
        la conexiÃ³n.*/
        for(int i = 0; i < this.getNumNodes(); i++) {
            for(int j = i + 1; j < this.getNumNodes(); j++) {
                double distancia = distanciaVertices(this.getNode(i), 
                        this.getNode(j));
                if (distancia <= r) {
                    conectarVertices(i, j);
                }
            }
        }
    }
    
    
    /*Modelo BarabÃ¡si-Albert.*/
    /*Colocar n vÃ©rtices uno por uno, asignando a cada uno d aristas a vÃ©rtices
    distintos de tal manera que la probabilidad de que el vÃ©rtice nuevo se
    conecte a un vÃ©rtice existente v es proporcional a la cantidad de aristas
    que v tiene actualmente - los primeros d vÃ©rtices se conecta todos a todos*/
    public void modeloBA(int d) {
        Random volado = new Random();
        /*Para los primeros d vÃ©rtices, se conecta el vÃ©rtice i con el vÃ©rtice j
        con i distinto de j y recorriendo todos los vÃ©rtices.*/
        for(int i = 0; i < d; i++){
            for(int j = 0; j < i; j++) {
                if (!existeConexion(i, j)) {
                    conectarVertices(i, j);
                }
            }
        }
        /*Del vÃ©rtice d en adelante hasta el vÃ©rtice n, el vÃ©rtice i de trata de
        emparejar con cada vÃ©rtice j desde el primero hasta i-1. La manera de
        hacer el emparejamiento es con probabilidad. La probabilidad de que el
        vÃ©rtice i se conecte con j es proporcional al nÃºmero de aristas del 
        vÃ©rtice j dividido por el nÃºmero total de aristas en el grafo hasta ese
        momento. Un nÃºmero pseudoaleatorio se compara con esa probabilidad, de
        ser menor, se realiza la conexiÃ³n. Antes de realizar la conexiÃ³n se 
        verifica que no exista ya y que el vÃ©rtice i no tenga ya d o mÃ¡s 
        conexiones.*/
        // i no se incrementa hasta que ese vÃ©rtice tiene d conexiones
        for(int i = d; i < this.getNumNodes();) {
            for(int j = 0; j < i; j++) {
                double probabilidad =
                        (double)gradoVertice(j)/(double)this.getNumEdges();
                if (volado.nextDouble() <= probabilidad) {
                    if (!existeConexion(i, j) && (gradoVertice(i) < d)) {
                        conectarVertices(i, j);
                    }
                }
            }
            if (gradoVertice(i) >= d) i++;
        }
    }
    
    
    /*MÃ©todo de instancia para escribir a disco en un formato GraphVis.*/
    /*El mÃ©todo toma como argumento, el nombre del archivo.*/
    public void escribirArchivo(String nombre) {
        try{
            output = new Formatter(nombre);
        }
        catch (SecurityException securityException) {
            System.err.println("No hay permiso de escritura.");
            System.exit(1);
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        }
        try{
            output.format("%s",this);
        }
        catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir al archivo");
        }
        if (output != null)
            output.close();
    }
    
    
  ////// SEGUNDA ENTREGA //////////

  /* MÃ©todo para generar el Ã¡rbol BFS del Grafo */
  /* Regresa otro grafo. Solo toma como entrada el nÃºmero
  de un nodo*/
  public GenerarGrafos BFS(int s) {
    GenerarGrafos arbol = new GenerarGrafos(this.getNumNodes());  // grafo de salida
    Boolean[] discovered = new Boolean[this.getNumNodes()];  // arreglo aux
    PriorityQueue<Integer> L = new PriorityQueue<Integer>();
    discovered[s] = true;  // se pone como descubierto el vÃ©rtice raÃ­z
    for (int i = 0; i < this.getNumNodes(); i++) {
      if (i != s) {   // el resto como no descubiertos
        discovered[i] = false;
      }
    }
    L.add(s);  // Se agrega a la cola de prioridad el nodo raÃ­z
    while (L.peek() != null) {  // se revisa que no estÃ© vacÃ­a la cola
      int u = L.poll();  // se extrae un elemento de la cola
      HashSet<Nodo> aristas = this.getEdges(u);  // aristas del nodo u
      for (Nodo n : aristas) {
        if(!discovered[n.getIndex()]) {
          // si no estÃ¡ descubierto, conectarlo, marcarlo como descubierto
          // y agregarlo a la cola.
          arbol.conectarVertices(u, n.getIndex());
          discovered[n.getIndex()] = true;
          L.add(n.getIndex());
        }
      }
    }
    return arbol;
  }

  /* MÃ©todo para generar el Ã¡rbol DFS del Grafo de forma recursiva  */
  /* Regresa otro grafo. Solo toma como entrada el nÃºmero de un nodo*/
  public GenerarGrafos DFS_R(int s) {
      GenerarGrafos arbol = new GenerarGrafos(this.getNumNodes());  // grafo de salida
      Boolean[] discovered = new Boolean[this.getNumNodes()];  // arreglo aux
      for (int i = 0; i < this.getNumNodes(); i++) {
          discovered[i] = false;  // se marcan todos como no decubierto
      }
      // se manda a llamar a la funciÃ³n recursiva de DFS
      recursivoDFS(s, discovered, arbol);
      return arbol;
   }
  
  private void recursivoDFS(int u, Boolean[] discovered, GenerarGrafos arbol) {
      discovered[u] = true;  // vÃ©rtice con el que se llamÃ³ se marca
      // aristas del vÃ©rtice u, con el que se llamÃ³ el mÃ©todo
      HashSet<Nodo> aristas = this.getEdges(u);
      for (Nodo n : aristas) {
          if (!discovered[n.getIndex()]) {
              // si no estÃ¡ descubierto, conectar el vÃ©rtice
              // y mandar a llamar recursivamente el mÃ©todo con este nuevo vÃ©rtice
              arbol.conectarVertices(u, n.getIndex());
              recursivoDFS(n.getIndex(), discovered, arbol);
          }
      }
   }
  
  /* MÃ©todo para generar el Ã¡rbol DFS del Grafo de forma iterativa  */
  /* Regresa otro grafo. Solo toma como entrada el nÃºmero de un nodo*/
  public GenerarGrafos DFS_I(int s) {
      GenerarGrafos arbol = new GenerarGrafos(this.getNumNodes());  // grafo de salida
      Boolean[] explored = new Boolean[this.getNumNodes()];  // arreglo aux
      Stack<Integer> S = new Stack<Integer>(); //pila para los vÃ©rtices
      Integer[] parent = new Integer[this.getNumNodes()]; //arreglo de padres
      for (int i = 0; i < this.getNumNodes(); i++) {
          explored[i] = false;  //se ponen todos los vÃ©rtices como no explorados
      }
      S.push(s);  //se manda a la pila al nodo raÃ­z
      while(!S.isEmpty()) {
          // mientras la pila no estÃ© vacÃ­a
          int u = S.pop();  // se extraen elementos de la pila
          if(!explored[u]) {
              explored[u] = true;  // si aÃºn no estaban explorados se marcan como tal
              if(u != s) {
                  arbol.conectarVertices(u, parent[u]); //se conecta con su padre
              }
              HashSet<Nodo> aristas = this.getEdges(u);  // aristas del nodo u
              for (Nodo n : aristas) {
                  S.push(n.getIndex());  // a la pila los vÃ©rtices conectados con u
                  parent[n.getIndex()] = u;  // se les marca como padre a u
              }
          }
      }
      return arbol;
   }
  
    ////////// TERCERA ENTREGA //////////

    ///////// Método para asignar pesos a las aristas entre dos valores /////////
    public GenerarGrafos EdgeValues(double min, double max) {
        GenerarGrafos grafoPesado = new GenerarGrafos(this.getNumNodes()); //grafo de salida
        Random rand = new Random();
        double peso;
        for (int i = 0; i < this.getNumNodes(); i++) {  //se recorre el grafo
            for (int j = i; j < this.getNumNodes(); j++) { //original
                if(this.existeConexion(i, j)) { //donde existe conexión entre nodos
                //se crea una arista con peso aleatorio en el grafo de salida
                peso = rand.nextFloat()*(max - min) + min;
                grafoPesado.setAristaPeso(i, j, peso);
                }   
            }
        }
        return grafoPesado;
    }

    public GenerarGrafos Dijkstra(int s) {
        GenerarGrafos arbol = new GenerarGrafos(this.getNumNodes()); //grafo de salida
        double inf = Double.POSITIVE_INFINITY;  // máxima distancia
        //arreglo donde se guarda el nodo padre de cada nodo
        Integer[] padres = new Integer[arbol.getNumNodes()];
        // Las distancias de todos los nodos a infinito y todos los padres a null
        for (int i = 0; i < arbol.getNumNodes(); i++) {
            this.getNode(i).setDistance(inf);
            padres[i] = null;
        }
        // la distancia del nodo fuente a 0.0 y a sí mismo como padre
        this.getNode(s).setDistance(0.0);
        padres[s] = s;
        // Cola de prioridad de los nodos. La llave es la distancia
        PriorityQueue<Nodo> distPQ = new PriorityQueue<>(vertexDistanceComp);
        for (int i = 0; i < this.getNumNodes(); i++) {
            distPQ.add(this.getNode(i));
        }
        //Se explora el grafo
        while (distPQ.peek() != null) {  // se revisa que no esté vacía la cola
            Nodo u = distPQ.poll();  // elemento de la cola de prioridad
            //aristas del nodo u
            HashSet<Arista> aristas = this.getWeightedEdges(u.getIndex());
            for (Arista e : aristas) {
                // actualizar padre y distancia si es menor a la que tenía
                if(this.getNode(e.getIntN2()).getDistance() > this.getNode(u.getIndex()).getDistance() + e.getWeight()) {
                    this.getNode(e.getIntN2()).setDistance(this.getNode(u.getIndex()).getDistance() + e.getWeight());
                    padres[e.getIntN2()] = u.getIndex();
                }
            }
        }
        //se conecta el árbol de salida con la lista de padres y se asigna la
        //distancia al nodo fuente a cada nodo
        for (int i = 0; i < arbol.getNumNodes(); i++) {
            arbol.setAristaPeso(i, padres[i], 1);
            arbol.getNode(i).setDistance(this.getNode(i).getDistance());
        }
        return arbol;
    }
    //comparador necesario para la cola de prioridad de objetos 'Vertice'
    Comparator<Nodo> vertexDistanceComp = new Comparator<Nodo>() {
              @Override
                public int compare(Nodo n1, Nodo n2) {
                  return Double.compare(n1.getDistance(), n2.getDistance());
                }
    };
  
}
