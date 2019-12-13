package ListaSimplementeLigada;

import Arbol.NodoArbol;

/**
 * Clase que contiene atributos y métodos de una lista ligada.
 *
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class ListaLigada {

    private String nombreLista;
    private NodoListaLigada primerNodo;

    /**
     * Método constructor de la lista ligada. Inicializando nombre de la lista y
     * el primer nodo.
     *
     * @param nombre Se le da el nombre a la lista a través de este constructor.
     */
    public ListaLigada(String nombre) {
        this.nombreLista = nombre;
        this.primerNodo = null;
    }

    /**
     * Método que dice si la lista es vacía o no.
     *
     * @return Se retorna el valor booleano.
     */
    public boolean esVacia() {
        return this.primerNodo == null;
    }

    /**
     * Método para insertar el nodo cabeza.
     *
     * @param d Representa el dato a insertar.
     */
    public void insertarNodoCabezaLista(NodoArbol d) {
        if (!esVacia()) {
            NodoListaLigada nuevo = new NodoListaLigada(d);
            nuevo.setEnlace(this.primerNodo);
            this.primerNodo = nuevo;
        } else {
            this.primerNodo = new NodoListaLigada(d);
        }
    }

    /**
     * Método para imprimir una lista.
     */
    public void imprimirLista() {

        if (!esVacia()) {
            System.out.println("La lista " + this.nombreLista + " es:");
            NodoListaLigada actual = this.primerNodo;
            while (actual != null) {
                System.out.print(actual.getDato() + "\t");
                actual = actual.getEnlace();
            }

        } else {
            System.out.println("La lista " + this.nombreLista + " esta vacia");
        }
    }

    /**
     * Método para obtener el nodo cola (el último.)
     *
     * @return Se retorna el último nodo de la lista.
     */
    public NodoListaLigada nodoCola() {
        NodoListaLigada nodoActual = this.primerNodo;

        while (nodoActual.getEnlace() != null) {
            nodoActual = nodoActual.getEnlace();
        }

        return nodoActual;
    }

    /**
     * Método para insertar un dato, que es de tipo NodoArbol en la cola de la
     * lista.
     *
     * @param dato Representa el dato que se introduce en la cola de la lista.
     */
    public void insertarCola(NodoArbol dato) {
        if (!esVacia()) {
            NodoListaLigada ultimo;
            ultimo = this.nodoCola();
            ultimo.setEnlace(new NodoListaLigada(dato));
        } else {
            this.primerNodo = new NodoListaLigada(dato);
        }
    }

    /**
     * Método para buscar un NodoArbol en una lista.
     *
     * @param datoABuscar Se entra como parámetro para ser buscado en la lista.
     * @return Se retorna la dirección de memoria del nodo encontrado en la
     * lista.
     */
    public NodoListaLigada buscarNodo(NodoArbol datoABuscar) {

        NodoListaLigada nodoActual = this.primerNodo;
        NodoListaLigada nodoEncontrado = null;
        while (nodoActual != null) {
            if (nodoActual.getDato().equals(datoABuscar)) {
                nodoEncontrado = nodoActual;
            }
            nodoActual = nodoActual.getEnlace();
        }
        return nodoEncontrado;
    }

    /**
     * Método para insertar un nodo de tipo NodoArbol dentro de la lista.
     *
     * @param datoNuevo Representa el dato que se va a introducir de tipo
     * NodoArbol.
     * @param datoABuscar Representa la dirección de memoria del dato a buscar.
     */
    public void insertarNodoLista(NodoArbol datoNuevo, NodoArbol datoABuscar) {

        if (esVacia()) {
            this.primerNodo = new NodoListaLigada(datoNuevo);
        }
        NodoListaLigada encontrado = buscarNodo(datoABuscar);
        if (encontrado == null) {
            System.out.println("No se ha encontrado el dato en donde se va a insertar");
        } else {
            NodoListaLigada nuevo = new NodoListaLigada(datoNuevo, encontrado.getEnlace());
            encontrado.setEnlace(nuevo);
        }
    }

    /**
     * Constructor vacío de la clase donde se le asigna el nombre "Lista."
     */
    public ListaLigada() {
        this("Lista");
    }

    /**
     * Método que remueve o elimina el nodo que está en la cola de la lista (el
     * último.)
     */
    public void removerCola() {

        NodoListaLigada nodocola = nodoCola();
        NodoListaLigada nodoActual = this.primerNodo;
        while (nodoActual != null) {
            if (nodoActual.getEnlace().equals(nodocola)) {
                nodoActual.setEnlace(null);
            }
            nodoActual = nodoActual.getEnlace();
        }
    }

    /**
     * Método que remueve o elimina el nodo cabeza de la lista ligada.
     */
    public void removerCabeza() {
        this.primerNodo = this.primerNodo.getEnlace();
    }

    /**
     * Método para obtener el el primer nodo de la lista ligada.
     *
     * @return Se retorna el primer nodo de la lista ligada.
     */
    public NodoListaLigada getPrimerNodo() {
        return primerNodo;
    }

}
