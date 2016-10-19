/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semáforos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
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
   
    Semaphore semaforo = new Semaphore(15, true);
    
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
    public void escribir(int id) {
            System.out.println("Numero de permisos(Escribir): "+semaforo.availablePermits());   
            try {
                semaforo.acquire(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //Cambiamos el contenido del libro
        texto = texto + id;
        textEscr.setText("" + id);
        contLibro.setText(texto);
        semaforo.release(15);
        System.out.println("Dejamos de escribir, devolvemos permisos");
    }

    //Llamamos a la función leer
    public void leer(int id) {
        
        System.out.println("Numero de permisos(Leer): "+semaforo.availablePermits());
        try {        
            System.out.println("Llamamos a leer: intentamos  quitar 1 permiso");
            semaforo.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String textoLectores = "";

        //Nos metemos en el arrayList
        lectores.add(id);

        //Capturamos su contenido y lo actualizamos
        for (int i = 0; i < lectores.size(); i++) {
            textoLectores += lectores.get(i) + ",";
        }
        textLect.setText(textoLectores);
    }

    public void dejarDeLeer(int id) {
        
        String textoLectores = "";
        String contenido = "Leido por " + id + ": " + texto;
        
        //Nos quitamos del arrayList
        if (lectores.contains(id)) {
            lectores.remove((Integer) id);

            for (int i = 0; i < lectores.size(); i++) {
                textoLectores += lectores.get(i) + " ";
            }

            System.out.println("Lectores leyendo: " + textoLectores);
            textLect.setText(textoLectores);
        }
        //So el texto está acabado, ponemos el texto final
        if (texto.length() == 50) {
            lecturaFinal.setText(contenido);
        }
        semaforo.release();
    }

    public String getTexto() {
        return texto;
    }

    public boolean isLleno() {
        return texto.length() == 50;
    }

}
