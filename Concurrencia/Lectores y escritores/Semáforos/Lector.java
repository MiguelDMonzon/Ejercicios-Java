/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semáforos;

/**
 *
 * @author Miguel D
 */
public class Lector extends Thread {

    int id;
    Biblioteca b;
    Libro libro;

    public Lector(int id, Biblioteca b, Libro libro) {
        this.id = id;
        this.b = b;
        this.libro = libro;
        start();
    }

    
    @Override
    public void run() {
        

        //Van repitiendo hasta que el libro esté lleno (50 carac)
        while (!libro.isLleno()) {
            

            //Pasean durante 1-2 segundos
            try {
                sleep(1000 + (int) (1000 * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Interrumpido");
            }

            
            
            b.comprobarCerrado();
            //Leemos el libro
            libro.leer(id);
            
            try {
                sleep(500 + (int) (1000 * Math.random()));
                b.comprobarCerrado();
            } catch (InterruptedException ex) {
                System.out.println("Interrumpido");
            }

            //Dejamos el libro
            libro.dejarDeLeer(id);
            b.comprobarCerrado();
        }
       

    }

}
