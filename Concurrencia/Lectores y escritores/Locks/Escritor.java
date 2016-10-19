/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

/**
 *
 * @author Miguel D
 */
public class Escritor extends Thread {

    int id;
    Biblioteca b;
    Libro libro;

    public Escritor(int id, Biblioteca b, Libro libro) {
        this.id = id;
        this.b = b;
        this.libro = libro;
        start();
    }

    @Override
    public void run() {

        //Repiten 5 veces
        for (int i = 0; i < 5; i++) {

            //Piensan durante 1-2 segundos
            try {
                sleep(1000 + (int) (1000 * Math.random()));
            } catch (InterruptedException ex) {
                System.out.println("Interrumpido");
            }

            
            //Escribimos y vamos comprobando si nos han congelado
                b.comprobarCerrado();
                libro.escribir(id);
                b.comprobarCerrado();
               
        }

    }

}
