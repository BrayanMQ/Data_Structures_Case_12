
package model;

import java.util.ArrayList;

public class Nodo <T>{ //hacer nodo generico
    private T dato;
    private ArrayList<Nodo<T>> listaAdyacentes;
    private Nodo<T> nodoAnterior;
    private boolean marcado;

    public Nodo(T pPosicion) {
        this.dato = pPosicion;
        this.listaAdyacentes = new ArrayList<>();
        this.nodoAnterior = null;
        this.marcado = false;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
    
    public ArrayList<Nodo<T>> getListaAdyacentes() {
        return listaAdyacentes;
    }

    public void setListaAdyacentes(ArrayList<Nodo<T>> listaAdyacentes) {
        this.listaAdyacentes = listaAdyacentes;
    }

    public Nodo<T> getNodoAnterior() {
        return nodoAnterior;
    }

    public void setNodoAnterior(Nodo<T> nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }
}
