# Diseño y Análisis de Algoritmos
## Proyecto 1 Biblioteca de generación y manejo de grafos
###### Escribir una biblioteca en Java para generar grafos aleatorios con los siguientes modelos de generación:
* **Modelo Gn,m de Erdös y Rényi.** Crear n vértices y elegir uniformemente al azar m distintos pares de distintos vértices.
* **Modelo Gn,p de Gilbert.** Crear m aristas crear n vértices y poner una arista entre cada par independiente y uniformemente con probabilidad p.
* **Modelo Gn,r geográfico simple.** Colocar n vértices en un rectángulo unitario con coordenadas uniformes (o normales) y colocar una arista entre cada par que queda en distancia r o menor.
* **Variante del modelo Gn,d Barabási-Albert.** Colocar n vértices uno por uno, asignando a cada uno d aristas a vértices distintos de tal manera que la probabilidad de que el vértice nuevo se conecte a un vértice existente v es proporcional a la cantidad de aristas que v tiene actualmente - los primeros d vértices se conecta todos a todos.
###### Entregar:
* Link del proyecto en un servidor GIT (sugerido GITLab)
* Archivos GV generados, 3 por cada modelo; uno con 30 nodos, otro con 100 y el tercero con 500.
* Imágenes de los grafos generados. 12 en total, se sugiere utilizar Gephi.

## Proyecto 2 Algoritmos BFS y DFS
###### Utilizando la biblioteca de grafos desarrollada en el proyecto 1, implementar los algoritmos BFS y DFS (recursivo e iterativo) de tal forma que dado un nodo fuente, calculen el árbol inducido por los algoritmos mencionados; es decir, desarrollar los métodos en la clase Grafo:
* **Grafo BFS(Nodo s) { ... }**
* **Grafo DFS_R(Nodo s) { ... }**
* **Grafo DFS_I(Nodo s) { ... }**

## Ejecución:
* 1. Se Genera el `Proyecto1` con el paquete `Modelos`.
* 2. Se necesita compliar las clases `Nodo`, `Arsita` y `Generación de Grafos`.
* 3. Las clases `GeneracionDeArchivoGV` y `Ejemplos` se deben compilar entre si por main.
