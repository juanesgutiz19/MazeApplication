package Datos;

/**
 * Clase que se encarga de almacenar los datos para poder pintar y hacer un uso
 * correcto de la clase Graphics.
 *
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class DatosParaPintar {

    public int coordenadasX;
    public int coordenadasY;
    public int espacio;

    /**
     * Constructor en dondese inicializan las coordenadas y el espacio.
     *
     * @param x Representa el valor en X en el espacio.
     * @param y Representa el valor en Y en el espacio.
     * @param espacio Representa la extensión del lugar donde se va a pintar.
     */
    public DatosParaPintar(int x, int y, int espacio) {
        this.coordenadasX = x;
        this.coordenadasY = y;
        this.espacio = espacio;
    }
}
