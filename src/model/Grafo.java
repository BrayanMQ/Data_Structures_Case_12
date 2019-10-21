
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Grafo <T> implements IConstants{
    
    private ArrayList<Nodo<T>> nodos;
    private int cantidadNodos;


    public Grafo() {
        this.nodos = new ArrayList<>();
        this.cantidadNodos = 0;
    }

    public boolean insertNode(Nodo<T> pNodo ) { //
        this.cantidadNodos = this.cantidadNodos + 1;
        return this.nodos.add(pNodo);  
    }
   
    //Recorre el grafo en anchura
    public Stack<Nodo<T>> travelGraph (Nodo<T> pDestino, Nodo<T> pPuntoPartida){
        
        resetMarcados();
        
        if (pPuntoPartida == null) {
            return null;
        }
        
        Queue<Nodo<T>> cola = new LinkedList<>();
        
        pPuntoPartida.setMarcado(true); // El punto de partida queda marcado
        cola.add(pPuntoPartida);
        
        while (!cola.isEmpty()){ 
            Nodo<T> nodoExtraido = cola.poll();
            
            for(Nodo<T> nodoAdyacente : nodoExtraido.getListaAdyacentes()) {
                
                if (!nodoAdyacente.isMarcado()) {
                    nodoAdyacente.setNodoAnterior(nodoExtraido);
                    cola.add(nodoAdyacente);
                    nodoAdyacente.setMarcado(true);
                    
                    if (nodoAdyacente.equals(pDestino)) {
                        return obtenerRecorrido(pDestino);
                    }
                }
            }         
        } 
        return null;    
    }
    
    public Stack<Nodo<T>> obtenerRecorrido (Nodo<T> pDestino){
        Nodo<T> nodoAnterior = pDestino.getNodoAnterior();
        Stack<Nodo<T>> pilaRecorrido = new Stack<Nodo<T>>();      
        pilaRecorrido.add(pDestino);
        
        while(nodoAnterior != null){
            
            pilaRecorrido.add(nodoAnterior);
            
            nodoAnterior = nodoAnterior.getNodoAnterior();
        }
        
        return pilaRecorrido;
    }
    
    public void resetMarcados(){
        for (Nodo<T> nodo : nodos) {
            nodo.setMarcado(false);
        }
    }
    
    public void clearGraph(){
        this.nodos.clear();
    }

}
