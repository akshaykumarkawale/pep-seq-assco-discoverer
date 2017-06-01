/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psc.servlet.modal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import psc.util.Util;

/**
 *
 * @author AksHaY
 */
public class FuzzyModal {

    private String seq;
    private double total_length;
    private int total_seq;
    private Double[][] count;
    private List<String> itemsetList;
    private Map<String, Integer> aa;
    private Map<String, Double> support;

    public FuzzyModal(String seq, double total_length, int total_seq, Double[][] count) {
        System.out.println(seq);
        this.count = count;
        this.total_length = total_length;
        this.total_seq = total_seq;
        this.itemsetList = new ArrayList<String>();
        this.support = new HashMap<String, Double>();
        this.aa = new HashMap<String, Integer>();
        this.seq = seq;
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

    public List<String> generateCandidate(int itr) {
        List<String> tmpList = new ArrayList<String>();
        String tmp[] = this.seq.split(",");
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
                            System.out.println(tmp_str);
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
                tmpList.add(this.count[i][this.aa.get(tmpArr[j])]);
            }
            tmp.add(getMinimumValue(tmpList));
            tmpList.clear();

        }
        //System.out.println((getTotalSum(tmp) / this.total_seq) * 100);
        if ((getTotalSum(tmp) / this.total_seq) * 100 >= 5) {
            this.support.put(candidate, (getTotalSum(tmp) / this.total_seq) * 100);
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Double> getSupport() {
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
}
