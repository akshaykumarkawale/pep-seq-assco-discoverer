package pep.prop;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AksHaY
 */
public class ChemicalProperties {

    private double isotopicMass;
    private double gravy;
    private double hpl;
    private double hpb;
    private double grantham;

    public ChemicalProperties(double isotopic_mass, double gravy, double hpl, double hpb, double grantham) {
        this.isotopicMass = isotopic_mass;
        this.gravy = gravy;
        this.hpl = hpl;
        this.hpb = hpb;
        this.grantham = grantham;
    }

    public double getIsotopicMass() {
        return isotopicMass;
    }

    public double getGravy() {
        return gravy;
    }

    public double getHpl() {
        return hpl;
    }

    public double getHpb() {
        return hpb;
    }

    public double getGrantham() {
        return grantham;
    }

    

}
