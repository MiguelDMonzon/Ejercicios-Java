/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Miguel D
 */
public class Biblioteca {
    
    private boolean cerrado = false;
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock lockEscr = lock.writeLock();
    
    
    public void comprobarCerrado(){
        if(cerrado){
            try{
                lockEscr.lock();
            }
            finally{
                lockEscr.unlock();
            }
        }
    }
    
    
    public void abrirBiblioteca(){
        cerrado = false;
        lockEscr.unlock();
    }
    
    public void cerrarBiblioteca(){
        cerrado = true;
        lockEscr.lock();
      
    }


}


