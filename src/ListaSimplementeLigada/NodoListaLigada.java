package ListaSimplementeLigada;

import Arbol.NodoArbol;

/**
 * Clase que representa el modelo de un nodo perteneciente a una lista
 * simplemente ligada.
 *
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class NodoListaLigada {

    private NodoListaLigada enlace;
    private NodoArbol dato;

    /**
     * Método constructor del nodo, el cual invoca el otro método constructor
     * con dos parámetros.
     *
     * @param d Representa el dato del árbol.
     */
    public NodoListaLigada(NodoArbol d) {
        this(d, null);
    }

    /**
     * Método constructor donde se inicializa el dato y enlace de un nodo.
     *
     * @param dato Representa el dato del nodo.
     * @param enlace Representa el enlace de un nodo.
     */
    public NodoListaLigada(NodoArbol dato, NodoListaLigada enlace) {
        this.dato = dato;
        this.enlace = enlace;
    }

    /**
     * Método para obtener el dato de un nodo de la lista.
     *
     * @return Se retorna el dato.
     */
    public NodoArbol getDato() {
        return this.dato;
    }

    /**
     * Método para obtener el enlace de un nodo de la lista.
     *
     * @return Se retorna el enlace de un nodo de la lista.
     */
    public NodoListaLigada getEnlace() {
        return this.enlace;
    }

    /**
     * Método para establecer o modificar el enlace de un nodo.
     *
     * @param enlace Representa el enlace de un nodo de la lista creada.
     */
    public void setEnlace(NodoListaLigada enlace) {
        this.enlace = enlace;
    }
}
