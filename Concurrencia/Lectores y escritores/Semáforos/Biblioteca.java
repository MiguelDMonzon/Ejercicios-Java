/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Semáforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel D
 */
public class Biblioteca {
    
    private boolean cerrado = false;
    Semaphore semaforo = new Semaphore(1, true);
    
    public void comprobarCerrado(){
        if(cerrado){
            try{semaforo.acquire();}catch(InterruptedException ie){}
        }
        semaforo.release();
    }
    
    
    public void abrirBiblioteca(){
        cerrado = false;
        semaforo.release();
    }
    
    public void cerrarBiblioteca(){
        
        try {
            cerrado = true;
            semaforo.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Monitores.Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    

}


