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

//Esta clase será los hilos, luego ponemos "extends Thread"
public class Persona extends Thread{
    private int identificador; //Id de cada persona
    private Bar bar; //Para poder entrar y salir
    private Puertas p; //Para poder asomarnos, ver si está lleno o no

    
    public Persona(int identificador, Bar bar, Puertas p) {
        this.identificador = identificador;
        this.bar = bar;
        this.p = p;
        start();
    }
    
    public void run(){
            
            //Esperamos un rato entre 200ms y 500ms
            try {
                sleep(200 +(int)(300*Math.random()));
            } catch (InterruptedException ex) {}            
            
            //Miramos si el bar está cerrado o no
            p.asomar(); 
            
            //Si estamos aquí es que no está cerrado. Miramos si está lleno
            p.mirarSiLLeno();
            
            /*Si llegamos aquí es que podemos entrar a él. Aumentamos el número 
            de personas que tiene*/        
            p.setNumPersonas(p.getNumPersonas()+1);
            
            //Entramos al bar (con id para añadirlo al ArrayList)
            bar.entrar(identificador);
            
            //Nos tomamos algo: esperamos entre 0'5 y 1 segundos
            try {
                sleep(500 +(int)(500*Math.random()));
                /*Por si le damos al botón de cerrar el bar y hay gente dentro, 
                que a estos les pare la ejecución también
                */
                p.asomar();
            } catch (InterruptedException ex) {}
            
            /*Ya nos hemos tomado algo, luego salimos del bar. Pasamos el id para
            buscarlo en el ArrayList y eliminarlo
            */
            bar.salir(identificador);
            
            //Decrementamos el número de personas que hay dentro del bar
            p.setNumPersonas(p.getNumPersonas()-1);
            
            //Dejamos hueco para que entre otro: desbloqueamos a todos los hilos
            p.dejarHueco();
                      
            System.out.println("La persona "+identificador+" se ha ido");
    }
    
    
    
}
