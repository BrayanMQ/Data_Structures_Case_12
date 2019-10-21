/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Observable;
import java.util.Stack;
import model.Grafo;
import model.Nodo;
import model.Posicion;

/**
 *
 * @author curso
 */
public class MapManager extends Observable {
    private Nodo puntoPartida;
    private Nodo ultimoInsertado;
    private Grafo<Posicion> grafo; 
    private boolean iniciarRecorrido;

    public MapManager() {
        this.puntoPartida = null;
        this.ultimoInsertado = null;
        this.grafo = new Grafo<Posicion>();
        this.iniciarRecorrido = false;
    }

    public Grafo<Posicion> getGrafo() {
        return grafo;
    }

    public boolean isIniciarRecorrido() {
        return iniciarRecorrido;
    }

    public void setIniciarRecorrido(boolean iniciarRecorrido) {
        this.iniciarRecorrido = iniciarRecorrido;
    }
    
    public Nodo getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(Nodo puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public Nodo getUltimoInsertado() {
        return ultimoInsertado;
    }
    
    public boolean createNode(int pX, int pY){

        Posicion posicion = new Posicion(pX, pY);
        Nodo nodo = new Nodo(posicion);
        
        this.grafo.insertNode(nodo);
        
        if (this.puntoPartida == null) {
            this.puntoPartida = nodo;
            this.ultimoInsertado = this.puntoPartida;
            this.setChanged();
            this.notifyObservers(nodo);
            return true;
        }
        
        createEdge(ultimoInsertado, nodo);
        createEdge(nodo, ultimoInsertado);
        this.ultimoInsertado = nodo;
        
        this.setChanged();
        this.notifyObservers(nodo);
        return true;
    }
    
    public boolean createEdge(Nodo<Posicion> pOrigen, Nodo<Posicion> pDestino){
        
        if (!pOrigen.getListaAdyacentes().contains(pDestino)) {
            return pOrigen.getListaAdyacentes().add(pDestino);
        }
        return false;
    }
    
    public void iniciarRecorrido(Stack<Nodo> recorrido){
        
        
    }
    
}
