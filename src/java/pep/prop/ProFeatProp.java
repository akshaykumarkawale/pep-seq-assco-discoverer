package pep.prop;


import java.text.DecimalFormat;
import java.util.Map;
import org.biojava.nbio.aaproperties.profeat.IProfeatProperties.ATTRIBUTE;
import org.biojava.nbio.aaproperties.profeat.IProfeatProperties.GROUPING;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AksHaY
 */
public class ProFeatProp {

    public static String getSecondaryStructure(String c) {

        switch (c) {
            case "E":
            case "A":
            case "L":
            case "M":
            case "Q":
            case "K":
            case "R":
            case "H":
                return "Helix";
            case "V":
            case "I":
            case "Y":
            case "C":
            case "W":
            case "F":
            case "T":
                return "Strand";
            case "G":
            case "N":
            case "P":
            case "S":
            case "D":
                return "Coil";
            default:
                return "Unknown";
        }

    }

    public static String getSolventAccessibility(String c) {
        switch (c) {
            case "A":
            case "L":
            case "F":
            case "C":
            case "G":
            case "I":
            case "V":
            case "W":
                return "Buried";//Buried
            case "R":
            case "K":
            case "Q":
            case "E":
            case "N":
            case "D":
                return "Exposed";//Exposed
            case "M":
            case "P":
            case "S":
            case "T":
            case "H":
            case "Y":
                return "Intermediate";//Intermediate
            default:
                return "Unknown";//Non-standard AA
        }
    }

    public static String getPolarizability(String c) {
        switch (c) {
            case "G":
            case "A":
            case "S":
            case "D":
            case "T":
                return "0-0.08";//Polarizability value 0-0.08
            case "C":
            case "P":
            case "N":
            case "V":
            case "E":
            case "Q":
            case "I":
            case "L":
                return "0.128-0.186";//Polarizability value 0.128-0.186
            case "K":
            case "M":
            case "H":
            case "F":
            case "R":
            case "Y":
            case "W":
                return "0.219-0.409";//Polarizability value 0.219-0.409
            default:
                return "Unknown";//Non-standard AA
        }
    }

    public static String getPolarity(String c) {
        switch (c) {
            case "L":
            case "I":
            case "F":
            case "W":
            case "C":
            case "M":
            case "V":
            case "Y":
                return "4.9-6.2";//Polarity value 4.9-6.2
            case "P":
            case "A":
            case "T":
            case "G":
            case "S":
                return "8.0-9.2";//Polarity value 8.0-9.2
            case "H":
            case "Q":
            case "R":
            case "K":
            case "N":
            case "E":
            case "D":
                return "10.4-13.0";//Polarity value 10.4-13.0
            default:
                return "Unknown";//Non-standard AA
        }
    }

    public static String getNormalizedVanDerVolumes(String c) {
        switch (c) {
            case "G":
            case "A":
            case "S":
            case "T":
            case "P":
            case "D":
            case "C":
                return "0-2.78";//Volume Range 0-2.78
            case "N":
            case "V":
            case "E":
            case "Q":
            case "I":
            case "L":
                return "2.95-4.0";//Volume Range 2.95-4.0
            case "M":
            case "H":
            case "K":
            case "F":
            case "R":
            case "Y":
            case "W":
                return "4.03-8.08";//Volume Range 4.03-8.08
            default:
                return "Unknown";//Non-standard AA
        }

    }

    public static String getHydrophobicity(String c) {
        switch (c) {
            case "R":
            case "K":
            case "E":
            case "D":
            case "Q":
            case "N":
                return "Polar";//Polar
            case "G":
            case "A":
            case "S":
            case "T":
            case "H":
            case "P":
            case "Y":
                return "Neutral";//Neutral
            case "C":
            case "L":
            case "V":
            case "I":
            case "M":
            case "F":
            case "W":
                return "Hydrophobicity";//Hydrophobicity
            default:
                return "Unknown";//Non-standard AA
        }
    }

    public static String getCharge(String c) {
        switch (c) {
            case "K":
            case "R":
                return "Positive";//Positive
            case "A":
            case "N":
            case "C":
            case "Q":
            case "G":
            case "H":
            case "I":
            case "L":
            case "M":
            case "F":
            case "P":
            case "S":
            case "T":
            case "W":
            case "Y":
            case "V":
                return "Neutral";//Neutral
            case "D":
            case "E":
                return "Negative";//Negative
            default:
                return "Unknown";//Non-standard AA
        }
    }
    
     public static String getMolecularWeight(String c) {
        switch (c) {
            case "K":
                return "146.1882 g/mol";
            case "R":
                return "174.2017 g/mol";//Positive
            case "A":
                return "89.0935 g/mol";
            case "N":
                return "132.1184 g/mol";
            case "C":
                return "121.1590 g/mol";
            case "Q":
                return "146.1451 g/mol";
            case "G":
                return "75.0669 g/mol";
            case "H":
                return "15.1552 g/mol";
            case "I":
                return "131.1736 g/mol";
            case "L":
                return "131.1736 g/mol";
            case "M":
                return "149.2124 g/mol";
            case "F":
                return "165.1900 g/mol";
            case "P":
                return "115.1310 g/mol";
            case "S":
                return "105.0930 g/mol";
            case "T":
                return "119.1197 g/mol";
            case "W":
                return "204.2262 g/mol";
            case "Y":
                return "181.1894 g/mol";
            case "V":
                return "117.1469 g/mol";
            case "D":
                return "133.1032 g/mol";
            case "E":
                return "147.1299 g/mol";//Negative
            default:
                return "Unknown";//Non-standard AA
        }
    }

}
