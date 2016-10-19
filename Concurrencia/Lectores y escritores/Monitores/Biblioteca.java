/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Monitores;

/**
 *
 * @author Miguel D
 */
public class Biblioteca {
    
    
    //Variable para abrir/cerrar el paso
    private boolean cerrado = false;
    
    
    
    public synchronized void comprobarCerrado(){
        while(cerrado){
            try{wait();}catch(InterruptedException ie){}
        }
    }
    
    
    //Estos dos metodos para el boton que para el tránsito de personas por la biblioteca
    public synchronized void abrirBiblioteca(){
        cerrado = false;
        notifyAll();
    }
    
    public synchronized void cerrarBiblioteca(){
        cerrado = true;
      
    }



}


