package Datos;

/**
 * En la clase se guardan los datos del nodo que se va procesando.
 *
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class DatosDeNodoActual {

    private int nodoSiguiente;
    private int filaActual;
    private String tipoDeNodo;
    private int columnaActual;

    /**
     * Método para establecer o modificar la columna actual.
     *
     * @param columnaActual Se entra como parámetro para determinar la columna
     * que se está procesando.
     */
    public void setColumnaActual(int columnaActual) {
        this.columnaActual = columnaActual;
    }

    /**
     * Método para establecer o modificar la fila actual.
     *
     * @param filaActual Se entra como parámetro para determinar la fila que se
     * está procesando.
     */
    public void setFilaActual(int filaActual) {
        this.filaActual = filaActual;
    }

    /**
     * Método para establecer o modificar el nodo siguiente.
     *
     * @param nodoSiguiente Se entra como parámetro para determinar el nodo
     * siguiente del nodo actual.
     */
    public void setNodoSiguiente(int nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    /**
     * Método para establecer o modificar el tipo de nodo.
     *
     * @param tipoDeNodo Se entra como parámetro para determinar el tipo de nodo
     * que corresponde al actual.
     */
    public void setTipoDeNodo(String tipoDeNodo) {
        this.tipoDeNodo = tipoDeNodo;
    }

    /**
     * Método para obtener la columna actual.
     *
     * @return Se retorna el valor de la columna actual.
     */
    public int getColumnaActual() {
        return columnaActual;
    }

    /**
     * Método para obtener la fila actual.
     *
     * @return Se retorna el valor de la fila actual.
     */
    public int getFilaActual() {
        return filaActual;
    }

    /**
     * Método para obtener el nodo siguiente del nodo actual.
     *
     * @return Se retorna el nodo siguiente.
     */
    public int getNodoSiguiente() {
        return nodoSiguiente;
    }

    /**
     * Método para obtener el tipo de nodo que corresponde al nodo actual.
     *
     * @return Se retorna el tipo de nodo.
     */
    public String getTipoDeNodo() {
        return tipoDeNodo;
    }
}
