/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitores;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Miguel D
 */
public class Libro {

    
    String texto = ""; //Contenido del libro
    
    /*Indicamos la cantidad de lecturas que hay, para que un escritor sepa que 
    el libro se está leyendo o no. Las peticiones de escritura es cuando un escritor
    desea escribir y lo notifica, asi los lectores se bloquearán.
    */
    int numLecturas = 0, peticionesEscritura = 0;
    //Indicar si está siendo usado o no por un escritor
    boolean usadoPorEscritor = false;
    
    //Para la interfaz
    JTextField textEscr, textLect, contLibro;
    JLabel lecturaFinal;
    ArrayList<Integer> lectores = new ArrayList();

    public Libro(JTextField textEscr, JTextField textLect, JTextField contLibro, JLabel lecturaFinal) {
        this.textEscr = textEscr;
        this.textLect = textLect;
        this.contLibro = contLibro;
        this.lecturaFinal = lecturaFinal;

    }


    //Llamamos a la función escribir
    public synchronized void escribir(int id) {
        

        peticionesEscritura++; //Indicamos que queremos escribir
        
        /*Si está siendo usado por un escritor, o hay un lector o más, tiene
        que esperarse
        */
        while (usadoPorEscritor || (numLecturas > 0)) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Como hemos accedido, decimos que lo estamos usando
        usadoPorEscritor = true;
        //Cambiamos el contenido del libro
        texto = texto + id;
        textEscr.setText("" + id);
        contLibro.setText(texto);
        //Quitamos la petición de escritura
        peticionesEscritura--;
        //Ponemos que ya no estamos usando el libro
        usadoPorEscritor = false;
        //Despertamos a todos los hilos
        notifyAll();
    }

    //Llamamos a la función leer
    public synchronized void leer(int id) {

        /*Si está siendo usado por un escritor o hay escritores pendientes, se 
        espera
        */
        while (usadoPorEscritor || (peticionesEscritura > 0)) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String textoLectores = "";
        //Ya estamos leyendo, lo indicamos
        numLecturas++;

        //Nos metemos en el arrayList
        lectores.add(id);

        //Capturamos su contenido y lo actualizamos
        for (int i = 0; i < lectores.size(); i++) {
            textoLectores += lectores.get(i) + ",";
        }
        textLect.setText(textoLectores);

    }

    public synchronized void dejarDeLeer(int id) {

        
        String textoLectores = "";
        String contenido = "Leido por " + id + ": " + texto;
        //Quitamos que estamos leyendo
        numLecturas--;
        //Nos quitamos del arrayList
        if (lectores.contains(id)) {
            lectores.remove((Integer) id);

            for (int i = 0; i < lectores.size(); i++) {
                textoLectores += lectores.get(i) + " ";
            }

            System.out.println("Lectores leyendo: " + textoLectores);
            textLect.setText(textoLectores);
        }
        //Si el arrayList esta vacío (o no quedan lecturas), despertamos hilos
        if (numLecturas == 0) {
            notifyAll();
        }
        //So el texto está acabado, ponemos el texto final
        if (texto.length() == 50) {
            lecturaFinal.setText(contenido);
        }
    }

    public String getTexto() {
        return texto;
    }

    public boolean isLleno() {
        return texto.length() == 50;
    }

}
