package Principal;

import Arbol.Arbol;
import Arbol.NodoArbol;
import Datos.DatosDeNodoActual;
import ListaSimplementeLigada.ListaLigada;
import java.util.Random;

/**
 * Clase que contiene los recursos necesarios para poder modelar el laberinto,
 * crearlo y posteriormente dar la solución de este.
 *
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class Laberinto {

    private NodoArbol[][] matrizDeNodos;
    private int numeroFilasYColumnas;
    private Arbol arbol;

    /**
     * Constructor Asigna numero de filas y columnas del laberinto, se le asigna
     * el tamaño de la matriz de nodos, se ejecuta el metodo colocarNodos y se
     * crea el arbol.
     *
     * @param numeroFilasYColumnas cantidad de filas y columnas que va a tener
     * el laberinto.
     */
    public Laberinto(int numeroFilasYColumnas) {
        this.numeroFilasYColumnas = numeroFilasYColumnas;
        this.matrizDeNodos = new NodoArbol[numeroFilasYColumnas][numeroFilasYColumnas];
        colocarNodos();
        this.arbol = new Arbol(matrizDeNodos[0][0]);
    }

    /**
     * Constructor sin parámetro, es el constructor por defecto del laberinto.
     */
    public Laberinto() {
        this.numeroFilasYColumnas = 2;
        this.matrizDeNodos = new NodoArbol[2][2];
        colocarNodos();
        this.arbol = new Arbol(matrizDeNodos[0][0]);
    }

    /**
     * *Identifica el nodo que se envía como parámetro y retorna los datos de
     * este.
     *
     * @param nodoActual Nodo del arbol en el cual se encuentra.
     * @return DatosDeNodoActual
     */
    public DatosDeNodoActual datos(NodoArbol nodoActual) {
        Random aleatorio = new Random();

        DatosDeNodoActual datosNodo = new DatosDeNodoActual();

        if (nodoActual == matrizDeNodos[0][0]) {
            datosNodo.setTipoDeNodo("primernodo");
            datosNodo.setNodoSiguiente(aleatorio.nextInt(2) + 2);
            datosNodo.setFilaActual(0);
            datosNodo.setColumnaActual(0);
            return datosNodo;

        } else if (nodoActual == matrizDeNodos[0][numeroFilasYColumnas - 1]) {
            int num = aleatorio.nextInt(2);
            if (num == 0) {
                datosNodo.setNodoSiguiente(0);
            }
            if (num == 1) {
                datosNodo.setNodoSiguiente(3);
            }
            datosNodo.setTipoDeNodo("segundonodo");
            datosNodo.setFilaActual(0);
            datosNodo.setColumnaActual(numeroFilasYColumnas - 1);
            return datosNodo;
        } else if (nodoActual == matrizDeNodos[numeroFilasYColumnas - 1][0]) {
            datosNodo.setNodoSiguiente(aleatorio.nextInt(2) + 1);
            datosNodo.setTipoDeNodo("tercernodo");
            datosNodo.setFilaActual(numeroFilasYColumnas - 1);
            datosNodo.setColumnaActual(0);
            return datosNodo;
        } else if (nodoActual == matrizDeNodos[numeroFilasYColumnas - 1][numeroFilasYColumnas - 1]) {
            datosNodo.setNodoSiguiente(aleatorio.nextInt(2));
            datosNodo.setTipoDeNodo("cuartonodo");
            datosNodo.setFilaActual(numeroFilasYColumnas - 1);
            datosNodo.setColumnaActual(numeroFilasYColumnas - 1);
            return datosNodo;
        }
        for (int i = 0; i < matrizDeNodos.length; i++) {
            for (int j = 0; j < matrizDeNodos[0].length; j++) {
                if (nodoActual == matrizDeNodos[0][j]) {
                    int num = aleatorio.nextInt(3);
                    if (num == 0) {
                        datosNodo.setNodoSiguiente(0);
                    }
                    if (num == 1) {
                        datosNodo.setNodoSiguiente(2);
                    }
                    if (num == 2) {
                        datosNodo.setNodoSiguiente(3);
                    }
                    datosNodo.setTipoDeNodo("quintonodo");
                    datosNodo.setFilaActual(0);
                    datosNodo.setColumnaActual(j);
                    return datosNodo;
                } else if (nodoActual == matrizDeNodos[i][0]) {
                    datosNodo.setNodoSiguiente(aleatorio.nextInt(3) + 1);
                    datosNodo.setTipoDeNodo("sextonodo");
                    datosNodo.setFilaActual(i);
                    datosNodo.setColumnaActual(0);
                    return datosNodo;
                } else if (nodoActual == matrizDeNodos[i][numeroFilasYColumnas - 1]) {
                    int num = aleatorio.nextInt(3);
                    if (num == 0) {
                        datosNodo.setNodoSiguiente(1);
                    }
                    if (num == 1) {
                        datosNodo.setNodoSiguiente(0);
                    }
                    if (num == 2) {
                        datosNodo.setNodoSiguiente(3);
                    }
                    datosNodo.setTipoDeNodo("octavonodo");
                    datosNodo.setFilaActual(i);
                    datosNodo.setColumnaActual(numeroFilasYColumnas - 1);
                    return datosNodo;
                } else if (nodoActual == matrizDeNodos[numeroFilasYColumnas - 1][j]) {
                    datosNodo.setNodoSiguiente(aleatorio.nextInt(3));
                    datosNodo.setTipoDeNodo("septimonodo");
                    datosNodo.setFilaActual(numeroFilasYColumnas - 1);
                    datosNodo.setColumnaActual(j);
                    return datosNodo;
                } else if (nodoActual == matrizDeNodos[i][j]) {
                    datosNodo.setNodoSiguiente(aleatorio.nextInt(4));
                    datosNodo.setTipoDeNodo("normalnodo");
                    datosNodo.setFilaActual(i);
                    datosNodo.setColumnaActual(j);
                    return datosNodo;
                }
            }
        }
        return datosNodo;
    }

    /**
     * Retorna el numero de filas y columnas.
     *
     * @return Dato de tipo int.
     */
    public int getNumeroFilasYColumnas() {
        return numeroFilasYColumnas;
    }

    /**
     * Asigna el numero de filas y columnas del laberinto.
     *
     * @param numeroFilasYColumnas Dato de tipo int.
     */
    public void setNumeroFilasYColumnas(int numeroFilasYColumnas) {
        this.numeroFilasYColumnas = numeroFilasYColumnas;
    }

    /**
     * Retorna el arbol que representa el laberinto.
     *
     * @return Dato de la clase Arbol.
     */
    public Arbol getArbol() {
        return arbol;
    }

    /**
     * Asigna los nodos en la matriz matrizDeNodos.
     */
    private void colocarNodos() {
        for (int i = 0; i < matrizDeNodos.length; i++) {
            for (int j = 0; j < matrizDeNodos[0].length; j++) {
                matrizDeNodos[i][j] = new NodoArbol();
            }
        }
    }

    /**
     * Retorna la matriz de nodos.
     *
     * @return Matriz de 2 dimensiones de la clase NodoArbol.
     */
    public NodoArbol[][] getMatrizDeNodos() {
        return matrizDeNodos;
    }

    /**
     * Asigna el arbol enviado como parametro al arbol que representa el
     * laberinto.
     *
     * @param arbol Dato de la clase Arbol
     */
    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    /**
     * Busca el camino de solucion del laberinto recorriendo el arbol que
     * representa el laberinto y retorna la lista ligada correspondiente.
     *
     * @param nodoActual nodo en el que se encuentra
     * @return Dato de la clase ListaLigada
     */
    public ListaLigada listaSolucion(NodoArbol nodoActual) {
        nodosSinVisitar(nodoActual);
        ListaLigada listaDeSolucion = new ListaLigada();
        nodoActual.setVisitado(true);

        while (nodoActual != arbol.getNodoHojaFin()) {
            if (nodoActual.getEnlaceAbajo() != null) {
                if (nodoActual.getEnlaceAbajo().isVisitado()) {
                } else {
                    listaDeSolucion.insertarCola(nodoActual);
                    nodoActual = nodoActual.getEnlaceAbajo();
                    nodoActual.setVisitado(true);
                    continue;
                }
            }
            if (nodoActual.getEnlaceArriba() != null) {
                if (nodoActual.getEnlaceArriba().isVisitado()) {
                } else {
                    listaDeSolucion.insertarCola(nodoActual);
                    nodoActual = nodoActual.getEnlaceArriba();
                    nodoActual.setVisitado(true);
                }
            }
            if (nodoActual.getEnlaceDerecho() != null) {
                if (nodoActual.getEnlaceDerecho().isVisitado()) {
                } else {
                    listaDeSolucion.insertarCola(nodoActual);
                    nodoActual = nodoActual.getEnlaceDerecho();
                    nodoActual.setVisitado(true);
                    continue;
                }
            }
            if (nodoActual.getEnlaceIzquierdo() != null) {
                if (nodoActual.getEnlaceIzquierdo().isVisitado()) {
                } else {
                    listaDeSolucion.insertarCola(nodoActual);
                    nodoActual = nodoActual.getEnlaceIzquierdo();
                    nodoActual.setVisitado(true);
                    continue;
                }
            } else {
                listaDeSolucion.removerCola();
                nodoActual = nodoActual.getAnterior();
            }
        }
        listaDeSolucion.insertarCola(matrizDeNodos[numeroFilasYColumnas - 1][numeroFilasYColumnas - 1]);
        listaDeSolucion.imprimirLista();
        return listaDeSolucion;
    }

    /**
     * Algoritmo recursivo que mira los nodos sin visitar empezando por el nodo
     * en el que se encuentra y pasando por los nodos de los lados.
     *
     * @param nodoActual Dato de la clase NodoArbol
     */
    public void nodosSinVisitar(NodoArbol nodoActual) {
        if (nodoActual != null) {
            nodoActual.setVisitado(false);
            nodosSinVisitar(nodoActual.getEnlaceAbajo());
            nodosSinVisitar(nodoActual.getEnlaceArriba());
            nodosSinVisitar(nodoActual.getEnlaceIzquierdo());
            nodosSinVisitar(nodoActual.getEnlaceDerecho());
        }
    }

    /**
     * Recorre el árbol que representa el laberinto empezando por la raiz del
     * arbol y dependiendo del tipo de nodo que sea se generan los enlaces que
     * crean el laberinto.
     *
     */
    public void crearLaberinto() {
        NodoArbol nodoActual = arbol.getNodoRaiz();
        nodoActual.setVisitado(true);
        DatosDeNodoActual datosNodo;
        int numeroVisitados = 1;
        while (numeroVisitados != numeroFilasYColumnas * numeroFilasYColumnas) {
            datosNodo = datos(nodoActual);
            switch (datosNodo.getTipoDeNodo()) {
                case "primernodo":
                    if (matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() + 1].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() + 1][datosNodo.getColumnaActual()].isVisitado()) {
                        nodoActual = nodoActual.getAnterior();
                        continue;
                    }
                    break;
                case "segundonodo":
                    if (matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() - 1].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() + 1][datosNodo.getColumnaActual()].isVisitado()) {
                        nodoActual = nodoActual.getAnterior();
                        continue;
                    }
                    break;
                case "tercernodo":
                    if (matrizDeNodos[datosNodo.getFilaActual() - 1][datosNodo.getColumnaActual()].isVisitado() && matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() + 1].isVisitado()) {
                        nodoActual = nodoActual.getAnterior();
                        continue;
                    }
                    break;
                case "cuartonodo":
                    if (matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() - 1].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() - 1][datosNodo.getColumnaActual()].isVisitado()) {
                        nodoActual = nodoActual.getAnterior();
                        continue;
                    }
                    break;
                case "quintonodo":
                    if (matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() - 1].isVisitado() && matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() + 1].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() + 1][datosNodo.getColumnaActual()].isVisitado()) {
                        nodoActual = nodoActual.getAnterior();
                        continue;
                    }
                    break;
                case "sextonodo":
                    if (matrizDeNodos[datosNodo.getFilaActual() - 1][datosNodo.getColumnaActual()].isVisitado() && matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() + 1].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() + 1][datosNodo.getColumnaActual()].isVisitado()) {
                        nodoActual = nodoActual.getAnterior();
                        continue;
                    }
                    break;
                case "septimonodo":
                    if (matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() - 1].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() - 1][datosNodo.getColumnaActual()].isVisitado() && matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() + 1].isVisitado()) {
                        nodoActual = nodoActual.getAnterior();
                        continue;
                    }
                    break;
                case "octavonodo":
                    if (matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() - 1].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() - 1][datosNodo.getColumnaActual()].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() + 1][datosNodo.getColumnaActual()].isVisitado()) {
                        nodoActual = nodoActual.getAnterior();
                        continue;
                    }
                    break;
                case "normalnodo":
                    if (matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() - 1].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() - 1][datosNodo.getColumnaActual()].isVisitado() && matrizDeNodos[datosNodo.getFilaActual() + 1][datosNodo.getColumnaActual()].isVisitado() && matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() + 1].isVisitado()) {
                        nodoActual = nodoActual.getAnterior();
                        continue;
                    }
                    break;
            }
            switch (datosNodo.getNodoSiguiente()) {
                case 0:
                    if (matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() - 1].isVisitado()) {
                        continue;
                    } else {
                        nodoActual.setEnlaceIzquierdo(matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() - 1]);
                        NodoArbol nodoAnterior = nodoActual;
                        nodoActual = nodoActual.getEnlaceIzquierdo();
                        nodoActual.setAnterior(nodoAnterior);
                        nodoActual.setVisitado(true);
                        numeroVisitados++;
                    }
                    break;
                case 1:
                    if (matrizDeNodos[datosNodo.getFilaActual() - 1][datosNodo.getColumnaActual()].isVisitado()) {
                        continue;
                    } else {
                        nodoActual.setEnlaceArriba(matrizDeNodos[datosNodo.getFilaActual() - 1][datosNodo.getColumnaActual()]);
                        NodoArbol nodoAnterior = nodoActual;
                        nodoActual = nodoActual.getEnlaceArriba();
                        nodoActual.setAnterior(nodoAnterior);
                        nodoActual.setVisitado(true);
                        numeroVisitados++;
                    }
                    break;
                case 2:
                    if (matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() + 1].isVisitado()) {
                        continue;
                    } else {
                        nodoActual.setEnlaceDerecho(matrizDeNodos[datosNodo.getFilaActual()][datosNodo.getColumnaActual() + 1]);
                        NodoArbol nodoAnterior = nodoActual;
                        nodoActual = nodoActual.getEnlaceDerecho();
                        nodoActual.setAnterior(nodoAnterior);
                        nodoActual.setVisitado(true);
                        numeroVisitados++;
                    }
                    break;
                case 3:
                    if (matrizDeNodos[datosNodo.getFilaActual() + 1][datosNodo.getColumnaActual()].isVisitado()) {
                        continue;
                    } else {
                        nodoActual.setEnlaceAbajo(matrizDeNodos[datosNodo.getFilaActual() + 1][datosNodo.getColumnaActual()]);
                        NodoArbol nodoAnterior = nodoActual;
                        nodoActual = nodoActual.getEnlaceAbajo();
                        nodoActual.setAnterior(nodoAnterior);
                        nodoActual.setVisitado(true);
                        numeroVisitados++;
                    }
                    break;
                default:
                    break;
            }
        }
        arbol.setFin(matrizDeNodos[numeroFilasYColumnas - 1][numeroFilasYColumnas - 1]);
    }
}
