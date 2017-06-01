/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psc.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.yeastrc.fasta.FASTAEntry;
import org.yeastrc.fasta.FASTAReader;

/**
 *
 * @author AksHaY
 */
public class FastaUtil {


    public static String getAccessionNumber(String sequenceDesp) {
        String acc_no = "";
        if (sequenceDesp.contains("|")) {
            String sub = sequenceDesp.substring(0, sequenceDesp.lastIndexOf("|"));
            acc_no = sub.substring(sub.lastIndexOf("|") + 1, sub.length());

        } else {
            acc_no = sequenceDesp.substring(0, sequenceDesp.indexOf(" ") + 1).trim();
        }

        return acc_no;
    }

    public static String getSequenceName(String sequenceDesp) {
        String seqeunceName = "";
        if (sequenceDesp.contains("|")) {
            seqeunceName = sequenceDesp.substring(sequenceDesp.lastIndexOf('|') + 1, sequenceDesp.length()).trim();

        } else {
            seqeunceName = sequenceDesp.substring(sequenceDesp.indexOf(' ') + 1, sequenceDesp.length()).trim();
            
        }
        return seqeunceName;
    }

    public static boolean validFile(String fileName) {
        return fileName.endsWith(".txt") || fileName.endsWith(".fna") || fileName.endsWith(".fasta") || fileName.endsWith(".TXT") || fileName.endsWith(".FNA") ||fileName.endsWith(".FASTA");
    }

    public static Map<String, ProteinSequences> readFile(File fastaFile) throws Exception {
        Map<String, ProteinSequences> sequences = new HashMap<String, ProteinSequences>();
        FASTAReader reader = FASTAReader.getInstance(fastaFile.getAbsolutePath());
        FASTAEntry entry = reader.readNext();
        while (entry != null) {
            sequences.put(entry.getHeaderLine().substring(1), new ProteinSequences(entry.getSequence()));
            entry = reader.readNext();
        }
        return sequences;
    }

}

class FastaException extends Exception {

    private String message;

    public FastaException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "FastaException" + this.message;
    }

}
