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
public class insClass {

    private String opCode;

    private Stack behaviour;

    private Stack binaryMasks;

    public insClass(String r, Stack tempUseStack, Stack t) {

        opCode = r;

        binaryMasks = tempUseStack;

        behaviour = t;

    }

    public insClass(String r, Stack t) {

        opCode = r;

        behaviour = t;

    }


    public void setOpCode(String tempUseStack) {

        opCode = new String(tempUseStack);

    }

    public String getOpCode() {

        return opCode;

    }

    public String toString() {

        return "Instruction: " + opCode
                + "\n\tDescription: " + behaviour.toString()
                + "\n\tBinary masks: " + binaryMasks.toString()
                + "\n";

    }
}
