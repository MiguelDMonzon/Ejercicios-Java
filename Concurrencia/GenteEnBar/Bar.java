/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GenteEnBar;

import java.util.ArrayList;
import javax.swing.JTextField;


/**
 *
 * @author Miguel D
 */
public class Bar {
    
    /*Necesitamos una lista que vaya almacenando los identificadores de todas las
    personas que están dentro del bar. Esta lista puede ser variable, luego usaré
    un ArrayList de enteros que contendrán los identificadores.
    */
    private ArrayList<Integer> listaPersonas = new ArrayList();
    
    //Para ir modificando los jTextField del Swing
    private JTextField t, n, c;
    //Contaremos todas las personas que han pasado por el bar
    private int contador = 0;
   
    public Bar(JTextField textField, JTextField numPersonasField, JTextField contadorField) {
        t = textField; //Contendrá el ArrayList
        n = numPersonasField; //Nos informará del número de personas que hay dentro
        c = contadorField; //Nos dirá las personas que han pasado por el bar
    }
    
    
    //Entra al bar: se añade a la lista de personas que están en el bar
    public synchronized void entrar(int id){
        
        String texto = ""; //Inicializamos así para luego sobreescribirlo
        
        /*Solo podemos hacer los cambios en el ArrayList si éste no contiene
        ninguna réplica del id (cosa que no debería pasar, pero no está de más
        comprobarlo)
        */
        if(!listaPersonas.contains(id)){
            listaPersonas.add(id); //Añadimos el id a la lista
            contador++; //Aumentamos el contador
            /*Sobreescribimos el texto con todos los id's que ya tiene el 
            ArrayList, para ello hacemos listaPersonas.get(i), y como lo hemos
            añadido antes, ahora estará la persona y además en un orden de entrada
            */
            for (int i = 0; i < listaPersonas.size(); i++) {
                texto += listaPersonas.get(i)+ " "; 
            }
            //Modificamos los jTextField
            t.setText(texto);
            n.setText(""+listaPersonas.size());
            c.setText(""+contador);
        }
    }
    
    /*Sale del bar: lo mismo que entrar() solo que ahora borramos el id
    si la lista lo contiene, y restamos 1 al numero de Personas. Actualizamos
    la información de los jTextField.
    */
    public synchronized void salir(int id){
        String texto = "";
        if(listaPersonas.contains(id)){
            listaPersonas.remove((Integer) id);
        
            for (int i = 0; i < listaPersonas.size(); i++) {
                texto += listaPersonas.get(i)+ " "; 
            }
            t.setText(texto);
            n.setText(""+listaPersonas.size());
        }
        
    }

    public ArrayList<Integer> getListaPersonas() {
        return listaPersonas;
    }
    
    
    
}
