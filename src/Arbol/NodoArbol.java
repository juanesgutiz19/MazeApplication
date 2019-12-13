package Arbol;

/**
 * Clase que contiene atributos y métodos de un nodo perteneciente a un árbol.
 *
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class NodoArbol {

    private boolean visitado;
    private NodoArbol enlaceArriba;
    private NodoArbol enlaceAbajo;
    private NodoArbol enlaceIzquierdo;
    private NodoArbol enlaceDerecho;
    private NodoArbol anterior;

    /**
     * Constructor del nodo perteneciente al árbol, se inicializan en null los
     * enlaces, el nodo anterior y la variable booleana visitado como false.
     */
    public NodoArbol() {
        visitado = false;
        enlaceArriba = null;
        enlaceAbajo = null;
        enlaceIzquierdo = null;
        enlaceDerecho = null;
        anterior = null;
    }

    /**
     * Método para establecer o modificar el enlace de abajo.
     *
     * @param enlaceAbajo Representa el nodo del árbol para hacer una conexión
     * hacia abajo.
     */
    public void setEnlaceAbajo(NodoArbol enlaceAbajo) {
        this.enlaceAbajo = enlaceAbajo;
    }

    /**
     * Método para establecer o modificar el enlace de arriba.
     *
     * @param enlaceArriba Representa el nodo del árbol para realizar una
     * conexión hacia arriba.
     */
    public void setEnlaceArriba(NodoArbol enlaceArriba) {
        this.enlaceArriba = enlaceArriba;
    }

    /**
     * Método para establecer o modificar el enlace de la derecha.
     *
     * @param enlaceDerecho Representa el nodo del árbol para realizar una
     * conexión hacia la derecha.
     */
    public void setEnlaceDerecho(NodoArbol enlaceDerecho) {
        this.enlaceDerecho = enlaceDerecho;
    }

    /**
     * Método para establecer o modificar el enlace izquerdo.
     *
     * @param enlaceIzquierdo Representa el nodo del árbol para realizar una
     * conexión hacia la izquierda.
     */
    public void setEnlaceIzquierdo(NodoArbol enlaceIzquierdo) {
        this.enlaceIzquierdo = enlaceIzquierdo;
    }

    /**
     * Método para obtener la conexión de abajo.
     *
     * @return Se retorna el enlace de abajo.
     */
    public NodoArbol getEnlaceAbajo() {
        return enlaceAbajo;
    }

    /**
     * Método para obtener la conexión de arriba.
     *
     * @return Se retorna el enlace de arriba.
     */
    public NodoArbol getEnlaceArriba() {
        return enlaceArriba;
    }

    /**
     * Método para obtener la conexión de la derecha.
     *
     * @return Se retorna el enlace de la derecha.
     */
    public NodoArbol getEnlaceDerecho() {
        return enlaceDerecho;
    }

    /**
     * Método para obtener la conexión de la izquierda.
     *
     * @return Se retorna el enlace de la izquierda.
     */
    public NodoArbol getEnlaceIzquierdo() {
        return enlaceIzquierdo;
    }

    /**
     * Método para establecer o modificar el estado de la variable visitado.
     *
     * @param visitado La variable nos dice si el nodo ya ha sido visitado.
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    /**
     * Método para obtener el nodo anterior al nodo actual.
     *
     * @return Se retorna el nodo anterior.
     */
    public NodoArbol getAnterior() {
        return anterior;
    }

    /**
     * Método para establecer o modificar el nodo anterior.
     *
     * @param anterior Indica cuál es el nodo anterior al nodo actual.
     */
    public void setAnterior(NodoArbol anterior) {
        this.anterior = anterior;
    }

    /**
     * Método para obtener la respuesta de si un nodo ya fue visitado o no.
     *
     * @return Se retorna la variable booleana visitado.
     */
    public boolean isVisitado() {
        return visitado;
    }

}
