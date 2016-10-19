/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GenteEnBar;

/**
 *
 * @author Miguel D
 */

//Esta clase sería como la clase Paso, la que controla el tráfico de hilos
public class Puertas {
    
    private int numPersonas = 0; //Para ir controlando el número de personas
    private boolean cerrado = false; //Para los botones de abrir/cerrar el bar
    
    //Se asoma la persona para ver si esta lleno o no
    public synchronized void asomar(){
        //Va comprobando si está cerrado: en caso afirmativo, se bloquea
        while(cerrado){
            try{wait();} catch(InterruptedException ie){}
        }
        
    }
    
    //Mira si el bar está lleno o no
    public synchronized void mirarSiLLeno(){
        //System.out.println("Numero de personas: "+numPersonas);
        while(numPersonas>=10){
            try {
                wait();
            } catch (InterruptedException ex) {}       
       }
    }
    
    //Después de que salga la persona, tiene que dejar hueco para que entren otros
    public synchronized void dejarHueco(){
        notifyAll();
    }
    
    //Estos dos metodos para el boton que para el tránsito de personas por el bar
    public synchronized void abrirBar(){
        cerrado = false;
        notifyAll();
        System.out.println("Puertas abiertas");
    }
    
    public synchronized void cerrarBar(){
        cerrado = true;
        System.out.println("Puertas cerradas");
      
    }

    
    //Necesarios para ir cambiando el número de personas en el bar
    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }
}
