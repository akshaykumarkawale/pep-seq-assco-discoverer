/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psc.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AksHaY
 */
public class Util {

    private static Integer[][] countAminoAcid = null;

    public static void deleteFiles(File folder) throws IOException {
        if (folder.exists()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                } else if (file.isDirectory()) {
                    deleteFiles(file);
                }
            }
        }
    }

    public static int countMatches(final String str, final char ch) {
        if (str.length() == 0) {
            return 0;
        }
        int count = 0;
        for (char c : str.toCharArray()) {

            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    public static int getMinimumValue(List<Integer> list) {
        int min = list.get(0);
        for (int value : list) {
            min = min < value ? min : value;
        }
        return min;
    }

    public static int getMaxmumValue(List<Integer> list) {
        int max = list.get(0);
        for (int value : list) {
            max = max > value ? max : value;
        }
        return max;
    }

    public static List<String> cloneList(List<String> list) {
        List<String> clone = new ArrayList<String>(list.size());
        for (String item : list) {
            clone.add(item);
        }
        return clone;
    }

    public static String getConfidence(String str1, String str2, Map<String, Double> supp) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format((supp.get(str1) / supp.get(str2)) * 100);
    }

    public static List<Integer> getTotalLenArray(Map<String, ProteinSequences> proteinSequence) {
        List<Integer> totalLenArray = new ArrayList<Integer>();
        for (String key : proteinSequence.keySet()) {
            int total = proteinSequence.get(key).toString().length();
            totalLenArray.add(total);
        }
        return totalLenArray;

    }

    public static void printCategory(String category, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        if (category != null) {
            out.println("<div class='panel panel-default'>");
            out.println("<div class='panel-heading'><Strong>" + category + "</strong></div>");
            out.println("<div class='panel-body'>");
        }

    }

    public static void printDiv(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        out.println("</div></div>");

    }

    public static void printSoftSet(boolean category, String detail, Map<String, ProteinSequences> proteinSequence, HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        out.println("<div class='panel panel-default'>");

        if (detail.equalsIgnoreCase("LOW")) {
            out.println("<div class='panel-heading'><Strong>LOW_VALUE_RANGE</strong></div>");
        } else if (detail.equalsIgnoreCase("MID")) {
            out.println("<div class='panel-heading'><Strong>MID_VALUE_RANGE</strong></div>");
        } else if (detail.equalsIgnoreCase("HIGH")) {
            out.println("<div class='panel-heading'><Strong>HIGH_VALUE_RANGE</strong></div>");
        }
        out.println("<div class='panel-body'>");
        out.println("<table class='table'>");
        out.println("<thead class='thead-default'>");
        out.println("<tr>");
        out.println("<th>Sequence Number</th>");
        out.println("<th>Accession Number</th>");
        out.println("<th>A</th>");
        out.println("<th>R</th>");
        out.println("<th>N</th>");
        out.println("<th>D</th>");
        out.println("<th>C</th>");
        out.println("<th>Q</th>");
        out.println("<th>E</th>");
        out.println("<th>G</th>");
        out.println("<th>H</th>");
        out.println("<th>I</th>");
        out.println("<th>L</th>");
        out.println("<th>K</th>");
        out.println("<th>M</th>");
        out.println("<th>F</th>");
        out.println("<th>P</th>");
        out.println("<th>S</th>");
        out.println("<th>T</th>");
        out.println("<th>W</th>");
        out.println("<th>Y</th>");
        out.println("<th>V</th>");
        out.println("<th>Total Length</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        int count = 0;
        int total_A = 0;
        int total_R = 0;
        int total_N = 0;
        int total_D = 0;
        int total_C = 0;
        int total_E = 0;
        int total_Q = 0;
        int total_G = 0;
        int total_H = 0;
        int total_I = 0;
        int total_L = 0;
        int total_K = 0;
        int total_M = 0;
        int total_F = 0;
        int total_P = 0;
        int total_S = 0;
        int total_T = 0;
        int total_W = 0;
        int total_Y = 0;
        int total_V = 0;
        int total_len = 0;
        for (String key : proteinSequence.keySet()) {
            int A = (int) Util.countMatches(proteinSequence.get(key).toString(), 'A');
            int R = (int) Util.countMatches(proteinSequence.get(key).toString(), 'R');
            int N = (int) Util.countMatches(proteinSequence.get(key).toString(), 'N');
            int D = (int) Util.countMatches(proteinSequence.get(key).toString(), 'D');
            int C = (int) Util.countMatches(proteinSequence.get(key).toString(), 'C');
            int E = (int) Util.countMatches(proteinSequence.get(key).toString(), 'E');
            int Q = (int) Util.countMatches(proteinSequence.get(key).toString(), 'Q');
            int G = (int) Util.countMatches(proteinSequence.get(key).toString(), 'G');
            int H = (int) Util.countMatches(proteinSequence.get(key).toString(), 'H');
            int I = (int) Util.countMatches(proteinSequence.get(key).toString(), 'I');
            int L = (int) Util.countMatches(proteinSequence.get(key).toString(), 'L');
            int K = (int) Util.countMatches(proteinSequence.get(key).toString(), 'K');
            int M = (int) Util.countMatches(proteinSequence.get(key).toString(), 'M');
            int F = (int) Util.countMatches(proteinSequence.get(key).toString(), 'F');
            int P = (int) Util.countMatches(proteinSequence.get(key).toString(), 'P');
            int S = (int) Util.countMatches(proteinSequence.get(key).toString(), 'S');
            int T = (int) Util.countMatches(proteinSequence.get(key).toString(), 'T');
            int W = (int) Util.countMatches(proteinSequence.get(key).toString(), 'W');
            int Y = (int) Util.countMatches(proteinSequence.get(key).toString(), 'Y');
            int V = (int) Util.countMatches(proteinSequence.get(key).toString(), 'V');
            int total = proteinSequence.get(key).toString().length();
            total_A += A;
            total_R += R;
            total_N += N;
            total_D += D;
            total_C += C;
            total_E += E;
            total_Q += Q;
            total_G += G;
            total_H += H;
            total_I += I;
            total_L += L;
            total_K += K;
            total_M += M;
            total_F += F;
            total_P += P;
            total_S += S;
            total_T += T;
            total_W += W;
            total_Y += Y;
            total_V += V;
            total_len += total;
            out.println("<td> " + (++count) + "</td>");
            out.println("<td><a href=\"https://www.ncbi.nlm.nih.gov/protein/" + (FastaUtil.getAccessionNumber(key)) + "\"onclick=\"window.open(this.href, 'Snopzer',\n"
                    + "                                   'toolbar=1,resizable=0');"
                    + "                           return false;\">" + (FastaUtil.getAccessionNumber(key)) + "</a></td>");

            out.println("<td> " + A + "</td>");
            out.println("<td> " + R + "</td>");
            out.println("<td> " + N + "</td>");
            out.println("<td> " + D + "</td>");
            out.println("<td> " + C + "</td>");
            out.println("<td> " + Q + "</td>");
            out.println("<td> " + E + "</td>");
            out.println("<td> " + G + "</td>");
            out.println("<td> " + H + "</td>");
            out.println("<td> " + I + "</td>");
            out.println("<td> " + L + "</td>");
            out.println("<td> " + K + "</td>");
            out.println("<td> " + M + "</td>");
            out.println("<td> " + F + "</td>");
            out.println("<td> " + P + "</td>");
            out.println("<td> " + S + "</td>");
            out.println("<td> " + T + "</td>");
            out.println("<td> " + W + "</td>");
            out.println("<td> " + Y + "</td>");
            out.println("<td> " + V + "</td>");
            out.println("<td> " + total + "</td>");
            out.println("</tr>");
        }
        out.println("<tr>");
        out.println("<td>----</td>");
        out.println("<td>----</td>");
        out.println("<td> " + total_A + "</td>");
        out.println("<td> " + total_R + "</td>");
        out.println("<td> " + total_N + "</td>");
        out.println("<td> " + total_D + "</td>");
        out.println("<td> " + total_C + "</td>");
        out.println("<td> " + total_Q + "</td>");
        out.println("<td> " + total_E + "</td>");
        out.println("<td> " + total_G + "</td>");
        out.println("<td> " + total_H + "</td>");
        out.println("<td> " + total_I + "</td>");
        out.println("<td> " + total_L + "</td>");
        out.println("<td> " + total_K + "</td>");
        out.println("<td> " + total_M + "</td>");
        out.println("<td> " + total_F + "</td>");
        out.println("<td> " + total_P + "</td>");
        out.println("<td> " + total_S + "</td>");
        out.println("<td> " + total_T + "</td>");
        out.println("<td> " + total_W + "</td>");
        out.println("<td> " + total_Y + "</td>");
        out.println("<td> " + total_V + "</td>");
        out.println("<td> " + total_len + "</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</div></div>");

    }

    public static void printSoftFuzzy(String detail, Map<String, ProteinSequences> proteinSequence, HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        out.println("<div class='panel panel-default'>");

        DecimalFormat df = new DecimalFormat("#0.000");
        if (detail.equalsIgnoreCase("LOW")) {
            out.println("<div class='panel-heading'><Strong>LOW_VALUE_RANGE</strong></div>");
        } else if (detail.equalsIgnoreCase("MID")) {
            out.println("<div class='panel-heading'><Strong>MID_VALUE_RANGE</strong></div>");
        } else if (detail.equalsIgnoreCase("HIGH")) {
            out.println("<div class='panel-heading'><Strong>HIGH_VALUE_RANGE</strong></div>");
        }
        out.println("<div class='panel-body'>");
        out.println("<table class='table'>");
        out.println("<thead class='thead-default'>");
        out.println("<tr>");
        out.println("<th>Sequence Number</th>");
        out.println("<th>Accession Number</th>");
        out.println("<th>A</th>");
        out.println("<th>R</th>");
        out.println("<th>N</th>");
        out.println("<th>D</th>");
        out.println("<th>C</th>");
        out.println("<th>Q</th>");
        out.println("<th>E</th>");
        out.println("<th>G</th>");
        out.println("<th>H</th>");
        out.println("<th>I</th>");
        out.println("<th>L</th>");
        out.println("<th>K</th>");
        out.println("<th>M</th>");
        out.println("<th>F</th>");
        out.println("<th>P</th>");
        out.println("<th>S</th>");
        out.println("<th>T</th>");
        out.println("<th>W</th>");
        out.println("<th>Y</th>");
        out.println("<th>V</th>");
        out.println("<th>Total Length</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        int count = 0;
        double total_A = 0;
        double total_R = 0;
        double total_N = 0;
        double total_D = 0;
        double total_C = 0;
        double total_E = 0;
        double total_Q = 0;
        double total_G = 0;
        double total_H = 0;
        double total_I = 0;
        double total_L = 0;
        double total_K = 0;
        double total_M = 0;
        double total_F = 0;
        double total_P = 0;
        double total_S = 0;
        double total_T = 0;
        double total_W = 0;
        double total_Y = 0;
        double total_V = 0;
        double total_len = 0;
        for (String key : proteinSequence.keySet()) {
            int total = proteinSequence.get(key).toString().length();
            double A = (double) Util.countMatches(proteinSequence.get(key).toString(), 'A') / total;
            double R = (double) Util.countMatches(proteinSequence.get(key).toString(), 'R') / total;
            double N = (double) Util.countMatches(proteinSequence.get(key).toString(), 'N') / total;
            double D = (double) Util.countMatches(proteinSequence.get(key).toString(), 'D') / total;
            double C = (double) Util.countMatches(proteinSequence.get(key).toString(), 'C') / total;
            double E = (double) Util.countMatches(proteinSequence.get(key).toString(), 'E') / total;
            double Q = (double) Util.countMatches(proteinSequence.get(key).toString(), 'Q') / total;
            double G = (double) Util.countMatches(proteinSequence.get(key).toString(), 'G') / total;
            double H = (double) Util.countMatches(proteinSequence.get(key).toString(), 'H') / total;
            double I = (double) Util.countMatches(proteinSequence.get(key).toString(), 'I') / total;
            double L = (double) Util.countMatches(proteinSequence.get(key).toString(), 'L') / total;
            double K = (double) Util.countMatches(proteinSequence.get(key).toString(), 'K') / total;
            double M = (double) Util.countMatches(proteinSequence.get(key).toString(), 'M') / total;
            double F = (double) Util.countMatches(proteinSequence.get(key).toString(), 'F') / total;
            double P = (double) Util.countMatches(proteinSequence.get(key).toString(), 'P') / total;
            double S = (double) Util.countMatches(proteinSequence.get(key).toString(), 'S') / total;
            double T = (double) Util.countMatches(proteinSequence.get(key).toString(), 'T') / total;
            double W = (double) Util.countMatches(proteinSequence.get(key).toString(), 'W') / total;
            double Y = (double) Util.countMatches(proteinSequence.get(key).toString(), 'Y') / total;
            double V = (double) Util.countMatches(proteinSequence.get(key).toString(), 'V') / total;
            total_A += A;
            total_R += R;
            total_N += N;
            total_D += D;
            total_C += C;
            total_E += E;
            total_Q += Q;
            total_G += G;
            total_H += H;
            total_I += I;
            total_L += L;
            total_K += K;
            total_M += M;
            total_F += F;
            total_P += P;
            total_S += S;
            total_T += T;
            total_W += W;
            total_Y += Y;
            total_V += V;
            total_len += total;
            out.println("<td> " + (++count) + "</td>");
            out.println("<td><a href=\"https://www.ncbi.nlm.nih.gov/protein/" + (FastaUtil.getAccessionNumber(key)) + "\"onclick=\"window.open(this.href, 'Snopzer',\n"
                    + "                                   'toolbar=1,resizable=0');"
                    + "                           return false;\">" + (FastaUtil.getAccessionNumber(key)) + "</a></td>");

            out.println("<td> " + df.format(A) + "</td>");
            out.println("<td> " + df.format(R) + "</td>");
            out.println("<td> " + df.format(N) + "</td>");
            out.println("<td> " + df.format(D) + "</td>");
            out.println("<td> " + df.format(C) + "</td>");
            out.println("<td> " + df.format(Q) + "</td>");
            out.println("<td> " + df.format(E) + "</td>");
            out.println("<td> " + df.format(G) + "</td>");
            out.println("<td> " + df.format(H) + "</td>");
            out.println("<td> " + df.format(I) + "</td>");
            out.println("<td> " + df.format(L) + "</td>");
            out.println("<td> " + df.format(K) + "</td>");
            out.println("<td> " + df.format(M) + "</td>");
            out.println("<td> " + df.format(F) + "</td>");
            out.println("<td> " + df.format(P) + "</td>");
            out.println("<td> " + df.format(S) + "</td>");
            out.println("<td> " + df.format(T) + "</td>");
            out.println("<td> " + df.format(W) + "</td>");
            out.println("<td> " + df.format(Y) + "</td>");
            out.println("<td> " + df.format(V) + "</td>");
            out.println("<td> " + total + "</td>");
            out.println("</tr>");
        }
        out.println("<tr>");
        out.println("<td>----</td>");
        out.println("<td>----</td>");
        out.println("<td> " + df.format(total_A) + "</td>");
        out.println("<td> " + df.format(total_R) + "</td>");
        out.println("<td> " + df.format(total_N) + "</td>");
        out.println("<td> " + df.format(total_D) + "</td>");
        out.println("<td> " + df.format(total_C) + "</td>");
        out.println("<td> " + df.format(total_Q) + "</td>");
        out.println("<td> " + df.format(total_E) + "</td>");
        out.println("<td> " + df.format(total_G) + "</td>");
        out.println("<td> " + df.format(total_H) + "</td>");
        out.println("<td> " + df.format(total_I) + "</td>");
        out.println("<td> " + df.format(total_L) + "</td>");
        out.println("<td> " + df.format(total_K) + "</td>");
        out.println("<td> " + df.format(total_M) + "</td>");
        out.println("<td> " + df.format(total_F) + "</td>");
        out.println("<td> " + df.format(total_P) + "</td>");
        out.println("<td> " + df.format(total_S) + "</td>");
        out.println("<td> " + df.format(total_T) + "</td>");
        out.println("<td> " + df.format(total_W) + "</td>");
        out.println("<td> " + df.format(total_Y) + "</td>");
        out.println("<td> " + df.format(total_V) + "</td>");
        out.println("<td> " + df.format(total_len) + "</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</div></div>");
    }

    public static String printCrispSet(String frqSeq, HttpServletResponse respose, List<String> freq, Map<String, Double> support) throws IOException {
        PrintWriter out = respose.getWriter();
        DecimalFormat df = new DecimalFormat("#0.000");
        StringBuilder conf = new StringBuilder("<br>");
        StringBuilder supp = new StringBuilder("<br>");
        StringBuilder res = new StringBuilder("");
        out.println("<center><br><Strong>The Frequent Amino Acid are : </strong><br>");
        if (freq.size() != 0) {

            for (String str : freq) {
                res.append(str).append(", ");
                conf.append("{").append(str).append(" => ").append(str.substring(0, str.length() - 2)).append("} = ");
                conf.append(Util.getConfidence(str, str.substring(0, str.length() - 2), support)).append("%");
                conf.append("<br>");

                supp.append(str).append(" = ");
                supp.append(df.format(support.get(str))).append("<br>");
            }
        } else {
            conf.append("Can't calculate CONFIDENCE for single Itemset!!!!!!!");
            for (String str : frqSeq.split(",")) {
                supp.append(str).append(" = ");
                supp.append(df.format(support.get(str))).append("<br>");
            }
        }

        if (res.toString().equalsIgnoreCase("")) {
            res.append(frqSeq);
        }

        for (int i = 0; i < 50; i++) {
            out.println('=');
        }

        out.println("<br></Strong>");
        out.println(res.toString().substring(0, res.length() - 2) + "<br><br><Strong>Confidence :</Strong><br>");

        for (int i = 0; i < 50; i++) {

            out.println("=");
        }
        out.println(conf.toString());
        out.println("<br><br><Strong>Support :</Strong><br>");

        for (int i = 0; i < 50; i++) {
            out.println("=");
        }
        out.println(supp.toString() + "<br></center>");
        return res.toString().substring(0, res.length() - 2);
    }

    public static void printSoftSet(HttpServletResponse response, String sequence, String Confidence, String support, String desp) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<center>");
        out.println("<div class='panel panel-default'>");
        out.println("<div class='panel-heading'><Strong>" + desp + "</strong></div>");
        out.println("<div class='panel-body'>");
        out.println("<br><Strong>The Frequent Amino Acid are : </strong><br>");
        for (int i = 0; i < 50; i++) {
            out.println('=');
        }

        out.println("<br></Strong>");
        out.println(sequence + "<br><br><Strong>Confidence :</Strong><br>");

        for (int i = 0; i < 50; i++) {

            out.println("=");
        }
        out.println(Confidence);
        out.println("<br><br><Strong>Support :</Strong><br>");

        for (int i = 0; i < 50; i++) {
            out.println("=");
        }
        out.println(support + "<br>");
        out.println("</div></div>");
        out.println("</center>");
    }
}
