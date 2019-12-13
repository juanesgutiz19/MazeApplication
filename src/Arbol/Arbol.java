package Arbol;

/**
 * Clase que contiene atributos y métodos relacionados con un árbol.
 *
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class Arbol {

    private NodoArbol nodoHojaFin;
    private NodoArbol nodoRaiz;
    int informacion;

    /**
     * Método constructor vacío del árbol inicializando la raíz y el último nodo
     * hoja en null.
     */
    public Arbol() {
        this.nodoHojaFin = null;
        this.nodoRaiz = null;
    }

    /**
     * Método constructor con un parámetro inicializando el nodo raíz.
     *
     * @param raiz Representa la raíz del arbol.
     */
    public Arbol(NodoArbol raiz) {
        this.nodoRaiz = raiz;
    }

    /**
     * Método para obtener la raíz del árbol.
     *
     * @return Se retorna el nodoRaiz.
     */
    public NodoArbol getNodoRaiz() {
        return nodoRaiz;
    }

    /**
     * Método para establecer o modificar el nodo raíz.
     *
     * @param nodoRaiz Representa el nodo raíz del árbol. Donde empieza el
     * recorrido.
     */
    public void setNodoRaiz(NodoArbol nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }

    /**
     * Método para establecer o modificar el nodo final del árbol.
     *
     * @param fin Representa la última hoja del árbol, también llamado hoja fin.
     */
    public void setFin(NodoArbol fin) {
        this.nodoHojaFin = fin;
    }

    /**
     * Método para obtener el nodo final del árbol.
     *
     * @return Se retorna el nodo hoja final.
     */
    public NodoArbol getNodoHojaFin() {
        return nodoHojaFin;
    }

}
