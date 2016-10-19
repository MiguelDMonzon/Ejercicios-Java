/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Miguel D
 */
public class Libro {

    
    String texto = ""; //Contenido del libro
    
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock lockEscr = lock.writeLock();
    Lock lockLect = lock.readLock();
    
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

            
        try {
            lockEscr.lock();
            //Cambiamos el contenido del libro
            texto = texto + id;
            textEscr.setText("" + id);
            contLibro.setText(texto);
        } finally {
            lockEscr.unlock();
        }
    }

    

    //Llamamos a la función leer
    public void leer(int id) {
        lockLect.lock();
        
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
        //Si el texto está acabado, ponemos el texto final
        if (texto.length() == 50) {
            lecturaFinal.setText(contenido);
        }
        lockLect.unlock();
    }

    public String getTexto() {
        return texto;
    }

    public boolean isLleno() {
        return texto.length() == 50;
    }

}
