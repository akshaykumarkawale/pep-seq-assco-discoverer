/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AksHaY
 */
public class Ebola {

    private List<String> tai_forest = new ArrayList<String>();
    private List<String> zaire = new ArrayList<String>();
    private List<String> reston = new ArrayList<String>();
    private List<String> sudan = new ArrayList<String>();
    private List<String> bundibugyo = new ArrayList<String>();

    public Ebola() throws FileNotFoundException, IOException, URISyntaxException {
        String path = "/psc/util/file";
        URL url = Ebola.class.getResource(path + "\\Tai.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(url.toURI())));
        String line = br.readLine();
        while (line != null) {
            tai_forest.add(line.trim());
            line = br.readLine();
        }
        url = Ebola.class.getResource(path + "\\Sudan.txt");
        br = new BufferedReader(new FileReader(new File(url.toURI())));
        line = br.readLine();
        while (line != null) {
            sudan.add(line.trim());
            line = br.readLine();
        }
        url = Ebola.class.getResource(path + "\\Reston.txt");
        br = new BufferedReader(new FileReader(new File(url.toURI())));
        line = br.readLine();
        while (line != null) {
            reston.add(line.trim());
            line = br.readLine();
        }
        url = Ebola.class.getResource(path + "\\Bundibugyo.txt");
        br = new BufferedReader(new FileReader(new File(url.toURI())));
        line = br.readLine();
        while (line != null) {
            bundibugyo.add(line.trim());
            line = br.readLine();
        }
        url = Ebola.class.getResource(path + "\\Zaire.txt");
        br = new BufferedReader(new FileReader(new File(url.toURI())));
        line = br.readLine();
        while (line != null) {
            zaire.add(line.trim());
            line = br.readLine();
        }
    }

    public List<String> getTai_forest() {
        return tai_forest;
    }

    public List<String> getZaire() {
        return zaire;
    }

    public List<String> getReston() {
        return reston;
    }

    public List<String> getSudan() {
        return sudan;
    }

    public List<String> getBundibugyo() {
        return bundibugyo;
    }

}
