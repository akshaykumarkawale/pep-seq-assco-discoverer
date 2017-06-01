/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psc.util;

import java.io.Serializable;

/**
 *
 * @author AksHaY
 */
public class ProteinSequences implements Serializable{

    private String sequence;

    public ProteinSequences(String str) {
        this.sequence = str;
    }

    @Override
    public String toString() {
        return this.sequence;
    }

}
