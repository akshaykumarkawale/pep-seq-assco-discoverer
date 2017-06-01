/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psc.servlet.modal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import pep.prop.PhysiochemicalProp;
import psc.util.ProteinSequences;
import psc.util.Util;

/**
 *
 * @author AksHaY
 */
public class DoublyFuzzySoftModal {

    private Double[][] countAminoAcid;
    private Map<String, ProteinSequences> proteinSequence;
    private String frqSeq;
    private List<String> itemsetList;
    private Map<String, Integer> aa;
    private Map<String, Double> support;
    private int total_length;
    private int total_seq;
    private String details;

    public DoublyFuzzySoftModal(String detail, Map<String, ProteinSequences> proteinSequence) {
        this.details = detail;
        this.proteinSequence = proteinSequence;
        this.countAminoAcid = new Double[this.proteinSequence.size()][20];
        this.itemsetList = new ArrayList<String>();
        this.support = new HashMap<String, Double>();
        this.aa = new HashMap<String, Integer>();
        this.aa.put("A", 0);
        this.aa.put("R", 1);
        this.aa.put("N", 2);
        this.aa.put("D", 3);
        this.aa.put("C", 4);
        this.aa.put("E", 5);
        this.aa.put("Q", 6);
        this.aa.put("G", 7);
        this.aa.put("H", 8);
        this.aa.put("I", 9);
        this.aa.put("L", 10);
        this.aa.put("K", 11);
        this.aa.put("M", 12);
        this.aa.put("F", 13);
        this.aa.put("P", 14);
        this.aa.put("S", 15);
        this.aa.put("T", 16);
        this.aa.put("W", 17);
        this.aa.put("Y", 18);
        this.aa.put("V", 19);

    }

    private void compute() {

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
        int total_len = 0;
        for (String key : proteinSequence.keySet()) {
            int total = proteinSequence.get(key).toString().length();
            double A = (double) Util.countMatches(proteinSequence.get(key).toString(), 'A') / total;
            countAminoAcid[count][0] = A;
            double R = (double) Util.countMatches(proteinSequence.get(key).toString(), 'R') / total;
            countAminoAcid[count][1] = R;
            double N = (double) Util.countMatches(proteinSequence.get(key).toString(), 'N') / total;
            countAminoAcid[count][2] = N;
            double D = (double) Util.countMatches(proteinSequence.get(key).toString(), 'D') / total;
            countAminoAcid[count][3] = D;
            double C = (double) Util.countMatches(proteinSequence.get(key).toString(), 'C') / total;
            countAminoAcid[count][4] = C;
            double E = (double) Util.countMatches(proteinSequence.get(key).toString(), 'E') / total;
            countAminoAcid[count][5] = E;
            double Q = (double) Util.countMatches(proteinSequence.get(key).toString(), 'Q') / total;
            countAminoAcid[count][6] = Q;
            double G = (double) Util.countMatches(proteinSequence.get(key).toString(), 'G') / total;
            countAminoAcid[count][7] = G;
            double H = (double) Util.countMatches(proteinSequence.get(key).toString(), 'H') / total;
            countAminoAcid[count][8] = H;
            double I = (double) Util.countMatches(proteinSequence.get(key).toString(), 'I') / total;
            countAminoAcid[count][9] = I;
            double L = (double) Util.countMatches(proteinSequence.get(key).toString(), 'L') / total;
            countAminoAcid[count][10] = L;
            double K = (double) Util.countMatches(proteinSequence.get(key).toString(), 'K') / total;
            countAminoAcid[count][11] = K;
            double M = (double) Util.countMatches(proteinSequence.get(key).toString(), 'M') / total;
            countAminoAcid[count][12] = M;
            double F = (double) Util.countMatches(proteinSequence.get(key).toString(), 'F') / total;
            countAminoAcid[count][13] = F;
            double P = (double) Util.countMatches(proteinSequence.get(key).toString(), 'P') / total;
            countAminoAcid[count][14] = P;
            double S = (double) Util.countMatches(proteinSequence.get(key).toString(), 'S') / total;
            countAminoAcid[count][15] = S;
            double T = (double) Util.countMatches(proteinSequence.get(key).toString(), 'T') / total;
            countAminoAcid[count][16] = T;
            double W = (double) Util.countMatches(proteinSequence.get(key).toString(), 'W') / total;
            countAminoAcid[count][17] = W;
            double Y = (double) Util.countMatches(proteinSequence.get(key).toString(), 'Y') / total;
            countAminoAcid[count][18] = Y;
            double V = (double) Util.countMatches(proteinSequence.get(key).toString(), 'V') / total;
            countAminoAcid[count][19] = V;

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
            count++;
        }

        this.total_seq = proteinSequence.size();
        String frqSeq = "";

        if (((total_A / this.total_seq) * 100) >= 5) {
            frqSeq += "A,";
        }
        if (((total_R / this.total_seq) * 100) >= 5) {
            frqSeq += "R,";
        }
        if (((total_N / this.total_seq) * 100) >= 5) {
            frqSeq += "N,";
        }
        if (((total_D / this.total_seq) * 100) >= 5) {
            frqSeq += "D,";
        }
        if (((total_C / this.total_seq) * 100) >= 5) {
            frqSeq += "C,";
        }
        if (((total_Q / this.total_seq) * 100) >= 5) {
            frqSeq += "Q,";
        }
        if (((total_E / this.total_seq) * 100) >= 5) {
            frqSeq += "E,";
        }
        if (((total_G / this.total_seq) * 100) >= 5) {
            frqSeq += "G,";
        }
        if (((total_H / this.total_seq) * 100) >= 5) {
            frqSeq += "H,";
        }
        if (((total_I / this.total_seq) * 100) >= 5) {
            frqSeq += "I,";
        }
        if (((total_L / this.total_seq) * 100) >= 5) {
            frqSeq += "L,";
        }
        if (((total_K / this.total_seq) * 100) >= 5) {
            frqSeq += "K,";
        }
        if (((total_M / this.total_seq) * 100) >= 5) {
            frqSeq += "M,";
        }
        if (((total_F / this.total_seq) * 100) >= 5) {
            frqSeq += "F,";
        }
        if (((total_P / this.total_seq) * 100) >= 5) {
            frqSeq += "P,";
        }
        if (((total_S / this.total_seq) * 100) >= 5) {
            frqSeq += "S,";
        }
        if (((total_T / this.total_seq) * 100) >= 5) {
            frqSeq += "T,";
        }
        if (((total_W / this.total_seq) * 100) >= 5) {
            frqSeq += "W,";
        }
        if (((total_Y / this.total_seq) * 100) >= 5) {
            frqSeq += "Y,";
        }
        if (((total_V / this.total_seq) * 100) >= 5) {
            frqSeq += "V,";
        }
        this.frqSeq = frqSeq.substring(0, frqSeq.length() - 1);
        this.total_length = total_len;

    }

    private List<String> generateCandidate(int itr) {
        List<String> tmpList = new ArrayList<String>();
        String tmp[] = this.frqSeq.split(",");
        if (itr == 2) {
            for (int i = 0; i < tmp.length; i++) {
                for (int j = i + 1; j < tmp.length; j++) {
                    String tmp_str = tmp[i] + " " + tmp[j];
                    if (getValidate(tmp_str)) {
                        tmpList.add(tmp_str);
                    }
                }
            }
        } else {

            for (int i = 0; i < itemsetList.size(); i++) {
                for (int j = i + 1; j < itemsetList.size(); j++) {
                    String str1 = "";
                    String str2 = "";

                    String[] tmp_i = itemsetList.get(i).split(" ");
                    String[] tmp_j = itemsetList.get(j).split(" ");

                    int s = 0;
                    for (s = 0; s < itr - 2; s++) {
                        str1 = str1 + " " + tmp_i[s];
                        str2 = str2 + " " + tmp_j[s];
                    }
                    if (str1.equalsIgnoreCase(str2)) {
                        String tmp_str = str1.trim() + " " + tmp_i[s].trim() + " " + tmp_j[s].trim();
                        if (getValidate(tmp_str)) {
                            tmpList.add(tmp_str);
                        }
                    }
                }
            }

        }
        itemsetList.clear();
        itemsetList = Util.cloneList(tmpList);
        tmpList.clear();
        return itemsetList;
    }

    private boolean getValidate(String candidate) {
        String[] tmpArr = candidate.split(" ");
        List<Double> tmpList = new ArrayList<Double>();
        List<Double> tmp = new ArrayList<Double>();
        for (int i = 0; i < this.total_seq; i++) {
            for (int j = 0; j < tmpArr.length; j++) {
                tmpList.add(this.countAminoAcid[i][this.aa.get(tmpArr[j])]);
            }
            tmp.add(getMinimumValue(tmpList));
            tmpList.clear();

        }
        if ((getTotalSum(tmp) / this.total_seq) * 100 >= 5) {
            this.support.put(candidate, (getTotalSum(tmp) / this.total_seq) * 100);
            return true;
        } else {
            return false;
        }
    }

    private Map<String, Double> getSupport() {
        return support;
    }

    private double getMinimumValue(List<Double> list) {
        double min = list.get(0);
        for (double value : list) {
            min = min < value ? min : value;
        }
        return min;
    }

    private double getTotalSum(List<Double> list) {
        double total = 0;
        for (double value : list) {
            total += value;
        }
        return total;
    }

    public Map<String, String> getResult() {
        compute();
        Map<String, String> result = new HashMap<String, String>();
        int iteration = 2;
        List<String> freq = new ArrayList<String>();
        List<String> tmpFreq = new ArrayList<String>();

        for (int i = 0; i < total_seq; i++) {
            while (iteration <= frqSeq.split(",").length) {
                tmpFreq = this.generateCandidate(iteration);
                if (tmpFreq.size() == 0) {
                    break;
                } else {
                    freq.clear();
                    freq = Util.cloneList(tmpFreq);
                }
                iteration++;
            }
            tmpFreq.clear();
        }

        Map<String, Double> support = this.getSupport();

        StringBuilder conf = new StringBuilder("<br>");
        StringBuilder supp = new StringBuilder("<br>");
        StringBuilder res = new StringBuilder("");
        if (freq.size() != 0) {

            for (String str : freq) {
                res.append(str).append(", ");
                conf.append("{").append(str).append(" => ").append(str.substring(0, str.length() - 2)).append("} = ");
                conf.append(Util.getConfidence(str, str.substring(0, str.length() - 2), support)).append("%");
                conf.append("<br>");

                supp.append(str).append(" = ");
                supp.append(new DecimalFormat("#0.000").format(support.get(str))).append("<br>");
            }
        } else {
            conf.append("Can't calculate CONFIDENCE for single Itemset!!!!!!!");
            System.out.println(this.frqSeq);
            for (String str : this.frqSeq.split(",")) {
                supp.append(str).append(" = ");
                supp.append(new DecimalFormat("#0.000").format(support.get(str))).append("<br>");
            }
        }
        if (res.toString().equalsIgnoreCase("")) {
            res.append(this.frqSeq);
        }
        result.put("SEQUENCE", res.toString().substring(0, res.toString().length() - 2));
        result.put("CONFIDENCE", conf.toString());
        result.put("SUPPORT", supp.toString());

        return result;
    }

    public void printResult(String filePath,Map<String, String> res, HttpServletResponse response) throws IOException, Exception {
        PrintWriter out = response.getWriter();
        out.println("<div class='panel panel-default'>");
        out.println("<div class='panel-heading'><Strong>" + this.details + "</strong></div>");
        out.println("<div class='panel-body'>");
        out.println("<br><Strong>The Frequent Amino Acid are : </strong><br>");
        for (int i = 0; i < 50; i++) {
            out.println('=');
        }

        out.println("<br></Strong>");
        out.println(res.get("SEQUENCE") + "<br><br><Strong>Confidence :</Strong><br>");

        for (int i = 0; i < 50; i++) {

            out.println("=");
        }
        out.println(res.get("CONFIDENCE"));
        out.println("<br><Strong>Support :</Strong><br>");

        for (int i = 0; i < 50; i++) {
            out.println("=");
        }
        out.println(res.get("SUPPORT") + "<br>");
        out.println("</div></div>");
        List<String> frqs = new ArrayList<String>();
        String strr[] = res.get("SEQUENCE").replace(",", "").split(" ");

        for (String s : strr) {
            if (!frqs.contains(s)) {
                frqs.add(s);
            }
        }
        PhysiochemicalProp.printProp(filePath, response, frqs);
    }
}
