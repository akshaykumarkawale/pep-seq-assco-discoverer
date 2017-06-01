/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psc.servlet.modal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import psc.util.ProteinSequences;
import psc.util.Util;

/**
 *
 * @author AksHaY
 */
public class CrispSoftModal {

    private Integer[][] countAminoAcid;
    private Map<String, ProteinSequences> proteinSequence;
    private String frqSeq;
    private List<String> itemsetList;
    private Map<String, Integer> aa;
    private Map<String, Double> support;
    private int total_length;
    private int total_seq;

    public CrispSoftModal(Map<String, ProteinSequences> proteinSequence) {
        this.proteinSequence = proteinSequence;
        this.countAminoAcid = new Integer[this.proteinSequence.size()][20];
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
            countAminoAcid[count][0] = A;
            int R = (int) Util.countMatches(proteinSequence.get(key).toString(), 'R');
            countAminoAcid[count][1] = R;
            int N = (int) Util.countMatches(proteinSequence.get(key).toString(), 'N');
            countAminoAcid[count][2] = N;
            int D = (int) Util.countMatches(proteinSequence.get(key).toString(), 'D');
            countAminoAcid[count][3] = D;
            int C = (int) Util.countMatches(proteinSequence.get(key).toString(), 'C');
            countAminoAcid[count][4] = C;
            int E = (int) Util.countMatches(proteinSequence.get(key).toString(), 'E');
            countAminoAcid[count][5] = E;
            int Q = (int) Util.countMatches(proteinSequence.get(key).toString(), 'Q');
            countAminoAcid[count][6] = Q;
            int G = (int) Util.countMatches(proteinSequence.get(key).toString(), 'G');
            countAminoAcid[count][7] = G;
            int H = (int) Util.countMatches(proteinSequence.get(key).toString(), 'H');
            countAminoAcid[count][8] = H;
            int I = (int) Util.countMatches(proteinSequence.get(key).toString(), 'I');
            countAminoAcid[count][9] = I;
            int L = (int) Util.countMatches(proteinSequence.get(key).toString(), 'L');
            countAminoAcid[count][10] = L;
            int K = (int) Util.countMatches(proteinSequence.get(key).toString(), 'K');
            countAminoAcid[count][11] = K;
            int M = (int) Util.countMatches(proteinSequence.get(key).toString(), 'M');
            countAminoAcid[count][12] = M;
            int F = (int) Util.countMatches(proteinSequence.get(key).toString(), 'F');
            countAminoAcid[count][13] = F;
            int P = (int) Util.countMatches(proteinSequence.get(key).toString(), 'P');
            countAminoAcid[count][14] = P;
            int S = (int) Util.countMatches(proteinSequence.get(key).toString(), 'S');
            countAminoAcid[count][15] = S;
            int T = (int) Util.countMatches(proteinSequence.get(key).toString(), 'T');
            countAminoAcid[count][16] = T;
            int W = (int) Util.countMatches(proteinSequence.get(key).toString(), 'W');
            countAminoAcid[count][17] = W;
            int Y = (int) Util.countMatches(proteinSequence.get(key).toString(), 'Y');
            countAminoAcid[count][18] = Y;
            int V = (int) Util.countMatches(proteinSequence.get(key).toString(), 'V');
            countAminoAcid[count][19] = V;
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
            count++;
        }

        String frqSeq = "";

        if ((((float) total_A / total_len) * 100) >= 5) {
            frqSeq += "A,";
        }
        if ((((float) total_R / total_len) * 100) >= 5) {
            frqSeq += "R,";
        }
        if ((((float) total_N / total_len) * 100) >= 5) {
            frqSeq += "N,";
        }
        if ((((float) total_D / total_len) * 100) >= 5) {
            frqSeq += "D,";
        }
        if ((((float) total_C / total_len) * 100) >= 5) {
            frqSeq += "C,";
        }
        if ((((float) total_Q / total_len) * 100) >= 5) {
            frqSeq += "Q,";
        }
        if ((((float) total_E / total_len) * 100) >= 5) {
            frqSeq += "E,";
        }
        if ((((float) total_G / total_len) * 100) >= 5) {
            frqSeq += "G,";
        }
        if ((((float) total_H / total_len) * 100) >= 5) {
            frqSeq += "H,";
        }
        if ((((float) total_I / total_len) * 100) >= 5) {
            frqSeq += "I,";
        }
        if ((((float) total_L / total_len) * 100) >= 5) {
            frqSeq += "L,";
        }
        if ((((float) total_K / total_len) * 100) >= 5) {
            frqSeq += "K,";
        }
        if ((((float) total_M / total_len) * 100) >= 5) {
            frqSeq += "M,";
        }
        if ((((float) total_F / total_len) * 100) >= 5) {
            frqSeq += "F,";
        }
        if ((((float) total_P / total_len) * 100) >= 5) {
            frqSeq += "P,";
        }
        if ((((float) total_S / total_len) * 100) >= 5) {
            frqSeq += "S,";
        }
        if ((((float) total_T / total_len) * 100) >= 5) {
            frqSeq += "T,";
        }
        if ((((float) total_W / total_len) * 100) >= 5) {
            frqSeq += "W,";
        }
        if ((((float) total_Y / total_len) * 100) >= 5) {
            frqSeq += "Y,";
        }
        if ((((float) total_V / total_len) * 100) >= 5) {
            frqSeq += "V,";
        }
        this.frqSeq = frqSeq.substring(0, frqSeq.length() - 1);
        this.total_length = total_len;
        this.total_seq = proteinSequence.size();
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
        List<Integer> tmpList = new ArrayList<Integer>();
        List<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < this.total_seq; i++) {
            for (int j = 0; j < tmpArr.length; j++) {
                tmpList.add(this.countAminoAcid[i][this.aa.get(tmpArr[j])]);
            }
            tmp.add(getMinimumValue(tmpList));
            tmpList.clear();

        }
        if ((getTotalSum(tmp) / this.total_length) * 100 >= 5) {
            this.support.put(candidate, (getTotalSum(tmp) / this.total_length) * 100);
            return true;
        } else {
            return false;
        }
    }

    private Map<String, Double> getSupport() {
        return support;
    }

    private int getMinimumValue(List<Integer> list) {
        int min = list.get(0);
        for (int value : list) {
            min = min < value ? min : value;
        }
        return min;
    }

    private double getTotalSum(List<Integer> list) {
        double total = 0;
        for (int value : list) {
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
}
