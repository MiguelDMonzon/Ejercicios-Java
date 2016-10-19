/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Paquete;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Miguel D
 */
public class descrClass {
    
    private String ident;
    private String fecha;
    private boolean contieneFecha;
    
    public descrClass(String identE, String fechaE){
        ident = identE;
        fecha = fechaE;
        if(!validarFecha(fecha)) System.out.println("AVISO: FECHA NO VÁLIDA");
        contieneFecha = true;
        
    }
    
    public descrClass(String identE){
        ident = identE;
        contieneFecha = false;
        
    }
    
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public String toString() {

        String s;
        
        if(contieneFecha)
        s =  "Identificador: " + ident.toString()
                + "\n\tFecha: " + fecha.toString();
        else
        s =  "Identificador: " + ident.toString();   
        return s;
    }
    
}
