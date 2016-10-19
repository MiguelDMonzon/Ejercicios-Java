/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete;

import java.util.Stack;

/**
 *
 * @author Miguel D
 */
public class storeClass {

    private String regName;

    private boolean group;

    private Integer bitSize;

    private String bitCode;
// in java.util.Stack and 

    public Stack use; // represents a last-in-first-out (LIFO) stack

    public Stack registers; //registers in a group

    public storeClass(String r, Stack u, Integer i) {

        regName = r;

        bitSize = i;

        use = u;

    }

    public storeClass(String r, Stack s, Integer i, String bc) {

        regName = r;
        use = s;
        bitSize = i;
        bitCode = bc;

    }

    public storeClass(String r, Integer i, Stack s, Stack n) {
 
        regName = r;
        use = s;
        bitSize = i;
        registers = n;

    }
    
    public storeClass(String r, Integer i, String bc, Stack s, Stack n) {
 
        regName = r;
        use = s;
        bitSize = i;
        bitCode = bc;
        registers = n;

    }
    
    
    public void setRegName(String n) {

        regName = new String(n);

    }

    public void setGroup() {

        group = true;

    }

    public void setRegister() {

        group = false;

    }

    public void setBitSize(Integer i) {

        bitSize = new Integer(i);

    }

    public void setBitCode(String b) {

        bitCode = new String(b);

    }

    public String getRegName() {

        return regName;

    }

    public boolean isGroup() {

        return group;

    }

    public String toString() {

        String s = "Register: " + regName
                + "\n\tUse: " + use.toString()
                + "\n\tBisize: " + bitSize
                + "\n\tBinary code: " + bitCode;

        if (group) {
            s = s + "\n\tRegisters grouped: "
                    + registers.toString();
        }

        s = s + "\n";

        return s;

    
}
    
}
