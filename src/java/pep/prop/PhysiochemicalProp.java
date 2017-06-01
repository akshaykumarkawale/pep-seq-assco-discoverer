package pep.prop;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.yeastrc.fasta.FASTAEntry;
import org.yeastrc.fasta.FASTAReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class PhysiochemicalProp {

    public static void printProp(String fileName, HttpServletResponse response, List<String> frqSeq) throws Exception {

        Map<String, Double> gravMap = new HashMap<String, Double>();
        PrintWriter out = response.getWriter();
        FASTAReader reader = FASTAReader.getInstance(fileName);
        FASTAEntry entry = reader.readNext();
        int A = 0;
        int R = 0;
        int N = 0;
        int D = 0;
        int C = 0;
        int E = 0;
        int Q = 0;
        int G = 0;
        int H = 0;
        int I = 0;
        int L = 0;
        int K = 0;
        int M = 0;
        int F = 0;
        int P = 0;
        int S = 0;
        int T = 0;
        int W = 0;
        int Y = 0;
        int V = 0;
        String seq = "";
        while (entry != null) {

            seq = entry.getSequence();
            A += countMatches(seq, 'A');
            R += countMatches(seq, 'R');
            N += countMatches(seq, 'N');
            D += countMatches(seq, 'D');
            C += countMatches(seq, 'C');
            E += countMatches(seq, 'E');
            Q += countMatches(seq, 'Q');
            G += countMatches(seq, 'G');
            H += countMatches(seq, 'H');
            I += countMatches(seq, 'I');
            L += countMatches(seq, 'L');
            K += countMatches(seq, 'K');
            M += countMatches(seq, 'M');
            F += countMatches(seq, 'F');
            P += countMatches(seq, 'P');
            S += countMatches(seq, 'S');
            T += countMatches(seq, 'T');
            W += countMatches(seq, 'W');
            Y += countMatches(seq, 'Y');
            V += countMatches(seq, 'V');
            entry = reader.readNext();
        }

        DecimalFormat df = new DecimalFormat("#0.000");
        
        gravMap.put("A", (A * ((ChemicalProperties) getProperties().get("A")).getGravy()) / seq.length());
        gravMap.put("R", (R * ((ChemicalProperties) getProperties().get("R")).getGravy()) / seq.length());
        gravMap.put("N", (N * ((ChemicalProperties) getProperties().get("N")).getGravy()) / seq.length());
        gravMap.put("D", (D * ((ChemicalProperties) getProperties().get("D")).getGravy()) / seq.length());
        gravMap.put("C", (C * ((ChemicalProperties) getProperties().get("C")).getGravy()) / seq.length());
        gravMap.put("Q", (Q * ((ChemicalProperties) getProperties().get("Q")).getGravy()) / seq.length());
        gravMap.put("E", (E * ((ChemicalProperties) getProperties().get("E")).getGravy()) / seq.length());
        gravMap.put("G", (G * ((ChemicalProperties) getProperties().get("G")).getGravy()) / seq.length());
        gravMap.put("H", (H * ((ChemicalProperties) getProperties().get("H")).getGravy()) / seq.length());
        gravMap.put("I", (I * ((ChemicalProperties) getProperties().get("I")).getGravy()) / seq.length());
        gravMap.put("L", (L * ((ChemicalProperties) getProperties().get("L")).getGravy()) / seq.length());
        gravMap.put("K", (K * ((ChemicalProperties) getProperties().get("K")).getGravy()) / seq.length());
        gravMap.put("M", (M * ((ChemicalProperties) getProperties().get("M")).getGravy()) / seq.length());
        gravMap.put("F", (F * ((ChemicalProperties) getProperties().get("F")).getGravy()) / seq.length());
        gravMap.put("P", (P * ((ChemicalProperties) getProperties().get("P")).getGravy()) / seq.length());
        gravMap.put("S", (S * ((ChemicalProperties) getProperties().get("S")).getGravy()) / seq.length());
        gravMap.put("T", (T * ((ChemicalProperties) getProperties().get("T")).getGravy()) / seq.length());
        gravMap.put("W", (W * ((ChemicalProperties) getProperties().get("W")).getGravy()) / seq.length());
        gravMap.put("Y", (Y * ((ChemicalProperties) getProperties().get("Y")).getGravy()) / seq.length());
        gravMap.put("V", (V * ((ChemicalProperties) getProperties().get("V")).getGravy()) / seq.length());

        out.println("<H3>Physiochemical Properties</H3><br>");

        out.println("<table class='table'>");
        out.println("<thead class='thead-default'>");
        out.println("<tr>");
        out.println("<th>Amino Acid</th>");
        out.println("<th>Molecular Weight</th>");
        out.println("<th>Gravy Value</th>");
        out.println("<th>Hydrophobicity</th>");
        out.println("<th>Charge</th>");
        out.println("<th>Secondary Structure</th>");
        out.println("<th>Solvent Accessibility</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        Iterator it = frqSeq.iterator();

        while (it.hasNext()) {
            out.println("<tr>");
            String aa = (String) it.next();
            out.println("<td>" + aa + "</td>");
            out.println("<td>" + ProFeatProp.getMolecularWeight(aa) + "</td>");
            out.println("<td>" + df.format(gravMap.get(aa)) + "</td>");
            out.println("<td>" + ProFeatProp.getHydrophobicity(aa) + "</td>");
            out.println("<td>" + ProFeatProp.getCharge(aa) + "</td>");
            out.println("<td>" + ProFeatProp.getSecondaryStructure(aa) + "</td>");
            out.println("<td>" + ProFeatProp.getSolventAccessibility(aa) + "</td>");
            out.println("</tr>");
        }

        out.println("</tbody></table>");

    }

    public static int countMatches(final CharSequence str, final char ch) {
        if (str.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static Map getProperties() {
        Map<String, ChemicalProperties> map = new HashMap<String, ChemicalProperties>();
        map.put("A", new ChemicalProperties(71.0788, 1.8, -0.5, 0.20, 8.100));
        map.put("R", new ChemicalProperties(156.1875, -4.5, 3.0, 1.40, 10.500));
        map.put("N", new ChemicalProperties(114.1038, -3.5, 0.2, -0.50, 11.600));
        map.put("D", new ChemicalProperties(115.0886, 2.5, 3.0, -3.10, 13.000));
        map.put("C", new ChemicalProperties(103.1388, 2.5, -1.0, 4.10, 5.500));
        map.put("E", new ChemicalProperties(129.1155, -3.5, 3.0, -1.80, 12.300));
        map.put("Q", new ChemicalProperties(128.1307, -3.5, 0.20, -2.80, 10.500));
        map.put("G", new ChemicalProperties(57.0519, -0.4, 0.0, 0.0, 9.000));
        map.put("H", new ChemicalProperties(137.1411, -3.2, -0.5, 0.5, 10.400));
        map.put("I", new ChemicalProperties(113.1594, 4.5, -1.8, 4.80, 5.200));
        map.put("L", new ChemicalProperties(113.1594, 3.8, -1.8, 5.70, 4.900));
        map.put("K", new ChemicalProperties(128.1741, -3.9, 3.0, -3.10, 11.300));
        map.put("M", new ChemicalProperties(131.1926, 1.9, -1.3, 4.20, 5.700));
        map.put("F", new ChemicalProperties(147.1766, 2.8, -2.5, 4.40, 5.200));
        map.put("P", new ChemicalProperties(97.1167, -1.6, 0.0, -2.20, 8.000));
        map.put("S", new ChemicalProperties(87.0782, -0.8, 0.3, -0.50, 9.200));
        map.put("T", new ChemicalProperties(101.1051, -0.7, -0.4, -1.90, 8.600));
        map.put("W", new ChemicalProperties(186.2132, -0.9, -3.4, 1.0, 5.400));
        map.put("Y", new ChemicalProperties(163.1760, -1.3, -2.3, 3.2, 6.200));
        map.put("V", new ChemicalProperties(99.1326, 4.2, -1.5, 4.70, 5.900));
        return map;
    }

}
