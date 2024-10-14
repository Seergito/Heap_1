/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.heapbinario;

import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class HeapBinario<E extends Comparable<E>> implements Heap<E>{
    
    private static final int CAPACIDAD= 50;
    private E [] arrayHeap;
    private E [] arrayTemp;
    private int numElemn;
    
    public HeapBinario(){
        this(CAPACIDAD);
        
    }
    public HeapBinario(int capacidad){
        if(capacidad < 0){
            throw new IllegalArgumentException("Capacidad superada");
        }
        arrayHeap = (E[]) new Comparable[capacidad +1];
        numElemn = 0;
    }
    
    

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Override
    public boolean esVacio() {
        if(numElemn == 0){
            return true;
        }else{
            return false;
        }
    }
    
  

    @Override
    public E recuperarMax() throws HeapVacioException {
        
        if(esVacio()){
            throw new HeapVacioException();
        }
        return arrayHeap[1];
    }

    @Override
    public E suprimirMax() throws HeapVacioException {
        
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

      /*
    COMPARE TO: obj1.compareTo(obj2)
    RETURN -1 = obj1<obj2
    return 0 = obj1=obj2
    return 1 = obj1 >obj2
    */
    
    @Override
    public void insertar(E e) throws NullPointerException {
        
        if(numElemn == CAPACIDAD){
            duplicar();
            //DUPLICAMOS EL ARRAY
        }else{
            
            insercion(e);
            
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void duplicar(){
        arrayTemp = (E[]) new Comparable[CAPACIDAD *2];
        
        for (int i = 1; i < arrayHeap.length; i++) {
            arrayTemp[i]= arrayHeap[i];
        }
        arrayHeap = arrayTemp;
        
    }
    
    private void insercion(E e) {
        
        int pos= ++numElemn;
        arrayHeap[pos] = e; //Inserta en la ultima pos
        
        
        //REORDENACION
        
        while( pos>1 && arrayHeap[pos/2].compareTo(e) >0 ){ //Comparamos constantemente el padre en la posición con el elemento a insertar
        arrayHeap[pos] = arrayHeap[pos/2]; //Subirmos al padre
        pos/=2; //Modificamos índice para apuntar el padre
        
            
        }
        arrayHeap[pos]=e; //Insertamos al salir del bucle
        
     //MIENTRAS EL PADRE SEA MAYOR
        
    }

    @Override
    public void anular() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
