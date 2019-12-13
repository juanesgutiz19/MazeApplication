package Principal;

import Arbol.Arbol;
import Arbol.NodoArbol;
import Datos.DatosParaPintar;
import ListaSimplementeLigada.ListaLigada;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que se encarga de realizar los dibujos sobre el panel donde está
 * ubicado el laberinto.
 *
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class PanelLaberinto extends javax.swing.JPanel {

    private int renglones;
    private boolean solucionar;
    private Laberinto laberinto;

    /**
     * Creates new form PanelLaberinto
     */
    public PanelLaberinto() {
        this.laberinto = new Laberinto();
        this.renglones = 539;
        initComponents();
    }

    /**
     * Pinta los componentes del laberinto teniendo en cuenta los datos que
     * elija el usuario como por ejemplo el numero de renglones.
     *
     * @param g Objeto de la clase Graphics para poder realizar todos los dibujos necesarios.
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        int espacio = renglones / laberinto.getNumeroFilasYColumnas();
        Arbol arbol = this.laberinto.getArbol();
        g.setColor(new Color(0, 204, 0));
        g.fillRect(1, 1, espacio - 1, espacio / 4);
        g.setColor(new Color(0, 204, 0));
        g.fillRect(espacio * (laberinto.getNumeroFilasYColumnas() - 1), espacio * laberinto.getNumeroFilasYColumnas() - espacio / 4, espacio, espacio / 4);
        g.setColor(new Color(0, 0, 0));

        for (int i = 0; i <= laberinto.getNumeroFilasYColumnas(); i++) {
            for (int j = 0; j < laberinto.getNumeroFilasYColumnas(); j++) {
                g.drawLine(espacio * j, espacio * i, espacio * (j + 1), espacio * i);
            }
        }
        for (int i = 0; i <= laberinto.getNumeroFilasYColumnas(); i++) {
            for (int j = 0; j < laberinto.getNumeroFilasYColumnas(); j++) {
                g.drawLine(espacio * i, espacio * j, espacio * i, espacio * (j + 1));
            }
        }

        g.setColor(new Color(255, 255, 0));

        if (arbol.getNodoHojaFin() != null) {
            int x = 1;
            int y = 1;

            DatosParaPintar datos = new DatosParaPintar(x, y, espacio);
            dibujarLaberinto(g, arbol.getNodoRaiz(), datos, laberinto.getMatrizDeNodos());
        }
        if (solucionar) {
            dibujarSolucion(g);
        }

    }

    /**
     * Dibuja el laberinto de forma recursiva teniendo en cuenta los datos del mismo.
     *
     * @param g Objeto de la clase Graphics.
     * @param nodoActual Objeto de la clase NodoArbol
     * @param datosParaPintar Objeto de la clase DatosParaPintar
     * @param nodos Matriz de dos dimensiones de la clase NodoArbol
     */
    public void dibujarLaberinto(Graphics g, NodoArbol nodoActual, DatosParaPintar datosParaPintar, NodoArbol[][] nodos) {

        if (nodoActual != null) {
            for (int i = 0; i < nodos.length; i++) {
                for (int j = 0; j < nodos[0].length; j++) {
                    if (nodoActual == nodos[i][j]) {
                        datosParaPintar.coordenadasX = j + 1;
                        datosParaPintar.coordenadasY = i + 1;
                        break;
                    }
                }
            }

            if (nodoActual.getEnlaceAbajo() != null) {
                g.drawLine(datosParaPintar.espacio * (datosParaPintar.coordenadasX - 1) + 1, datosParaPintar.espacio * (datosParaPintar.coordenadasY), datosParaPintar.espacio * (datosParaPintar.coordenadasX) - 1, datosParaPintar.espacio * (datosParaPintar.coordenadasY));
            }
            if (nodoActual.getEnlaceArriba() != null) {
                g.drawLine(datosParaPintar.espacio * (datosParaPintar.coordenadasX - 1) + 1, datosParaPintar.espacio * (datosParaPintar.coordenadasY - 1), datosParaPintar.espacio * datosParaPintar.coordenadasX - 1, datosParaPintar.espacio * (datosParaPintar.coordenadasY - 1));
            }
            if (nodoActual.getEnlaceDerecho() != null) {
                g.drawLine(datosParaPintar.espacio * datosParaPintar.coordenadasX, datosParaPintar.espacio * (datosParaPintar.coordenadasY - 1) + 1, datosParaPintar.espacio * datosParaPintar.coordenadasX, datosParaPintar.espacio * datosParaPintar.coordenadasY - 1);
            }
            if (nodoActual.getEnlaceIzquierdo() != null) {
                g.drawLine(datosParaPintar.espacio * (datosParaPintar.coordenadasX - 1), datosParaPintar.espacio * (datosParaPintar.coordenadasY - 1) + 1, datosParaPintar.espacio * (datosParaPintar.coordenadasX - 1), datosParaPintar.espacio * datosParaPintar.coordenadasY - 1);
            }

            dibujarLaberinto(g, nodoActual.getEnlaceAbajo(), datosParaPintar, nodos);
            dibujarLaberinto(g, nodoActual.getEnlaceArriba(), datosParaPintar, nodos);
            dibujarLaberinto(g, nodoActual.getEnlaceIzquierdo(), datosParaPintar, nodos);
            dibujarLaberinto(g, nodoActual.getEnlaceDerecho(), datosParaPintar, nodos);
        }
    }

    /**
     * Dibuja la solucion del laberinto teniendo en cuenta el arbol que
     * representa el laberinto y se utiliza el algoritmo de búsqueda en
     * profundidad.
     *
     * @param g Objeto de la clase Graphics
     */
    public void dibujarSolucion(Graphics g) {

        Arbol arbol = laberinto.getArbol();
        NodoArbol[][] matrizNodos = laberinto.getMatrizDeNodos();
        NodoArbol nodoActual = arbol.getNodoRaiz();
        g.setColor(new Color(51, 51, 55));
        int espacio = renglones / laberinto.getNumeroFilasYColumnas();
        laberinto.nodosSinVisitar(arbol.getNodoRaiz());
        ListaLigada listaSolucion = new ListaLigada();
        nodoActual.setVisitado(true);

        while (nodoActual != arbol.getNodoHojaFin()) {
            if (nodoActual.getEnlaceAbajo() == null && nodoActual.getEnlaceArriba() == null && nodoActual.getEnlaceDerecho() == null && nodoActual.getEnlaceIzquierdo() == null) {
                g.setColor(new Color(153, 153, 153));
            }

            if (nodoActual.getEnlaceAbajo() != null) {
                if (nodoActual.getEnlaceAbajo().isVisitado()) {
                    g.setColor(new Color(153, 153, 153));
                } else {
                    g.setColor(new Color(153, 0, 0));
                }
            }

            if (nodoActual.getEnlaceArriba() != null) {
                if (nodoActual.getEnlaceArriba().isVisitado()) {
                    g.setColor(new Color(153, 153, 153));
                } else {
                    g.setColor(new Color(153, 0, 0));
                }
            }

            if (nodoActual.getEnlaceDerecho() != null) {
                if (nodoActual.getEnlaceDerecho().isVisitado()) {
                    g.setColor(new Color(153, 153, 153));
                } else {
                    g.setColor(new Color(153, 0, 0));
                }
            }

            if (nodoActual.getEnlaceIzquierdo() != null) {
                if (nodoActual.getEnlaceIzquierdo().isVisitado()) {
                    g.setColor(new Color(153, 153, 153));
                } else {
                    g.setColor(new Color(153, 0, 0));

                }
            }

            int i;
            int j = 0;
            BuclePrincipal:

            for (i = 0; i < matrizNodos.length; i++) {
                for (j = 0; j < matrizNodos[0].length; j++) {
                    if (nodoActual == matrizNodos[i][j]) {
                        g.fillRect(j * espacio + espacio / 4, i * espacio + espacio / 4, espacio / 2, espacio / 2);
                        break BuclePrincipal;
                    }
                }
            }

            if (nodoActual.getEnlaceAbajo() != null) {
                if (nodoActual.getEnlaceAbajo().isVisitado()) {
                } else {
                    listaSolucion.insertarCola(nodoActual);
                    g.fillRect(j * espacio + espacio / 4, i * espacio + espacio / 4, espacio / 2, espacio);
                    nodoActual = nodoActual.getEnlaceAbajo();
                    nodoActual.setVisitado(true);
                    continue;
                }
            }
            if (nodoActual.getEnlaceArriba() != null) {
                if (nodoActual.getEnlaceArriba().isVisitado()) {
                } else {
                    listaSolucion.insertarCola(nodoActual);
                    g.fillRect(j * espacio + espacio / 4, (i - 1) * espacio + espacio / 4, espacio / 2, espacio);
                    nodoActual = nodoActual.getEnlaceArriba();
                    nodoActual.setVisitado(true);
                    continue;
                }
            }
            if (nodoActual.getEnlaceDerecho() != null) {
                if (nodoActual.getEnlaceDerecho().isVisitado()) {
                } else {
                    listaSolucion.insertarCola(nodoActual);
                    g.fillRect(j * espacio + espacio / 4, i * espacio + espacio / 4, espacio, espacio / 2);
                    nodoActual = nodoActual.getEnlaceDerecho();
                    nodoActual.setVisitado(true);
                    continue;
                }
            }

            if (nodoActual.getEnlaceIzquierdo() != null) {
                if (nodoActual.getEnlaceIzquierdo().isVisitado()) {
                } else {
                    listaSolucion.insertarCola(nodoActual);
                    g.fillRect((j - 1) * espacio + espacio / 4, i * espacio + espacio / 4, espacio, espacio / 2);
                    nodoActual = nodoActual.getEnlaceIzquierdo();
                    nodoActual.setVisitado(true);
                    continue;
                }
            }
            listaSolucion.removerCola();
            nodoActual = nodoActual.getAnterior();
        }
        listaSolucion.insertarCola(nodoActual);
        g.fillRect((laberinto.getNumeroFilasYColumnas() - 1) * espacio + espacio / 4, (laberinto.getNumeroFilasYColumnas() - 1) * espacio + espacio / 4, espacio / 2, espacio / 2);
    }

    /**
     * Crea un laberinto de n columnas y filas.
     *
     * @param n Dato de la clase int que representa la cantidad de filas y
     * columnas del laberinto.
     */
    public void setLaberinto(int n) {
        Laberinto laberint = new Laberinto(n);
        this.laberinto = laberint;
    }

    /**
     * Retorna el valor de la variable solucionar.
     *
     * @return Dato de la clase boolean.
     */
    public boolean isSolucionar() {
        return solucionar;
    }

    /**
     * Retorna el laberinto del panel.
     *
     * @return Objeto de la clase Laberinto.
     */
    public Laberinto getLaberinto() {
        return laberinto;
    }

    /**
     * Asigna un valor booleano a la variable solucionar.
     *
     * @param solucionar Dato de la clase boolean.
     */
    public void setSolucionar(boolean solucionar) {
        this.solucionar = solucionar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /*

     */
}
