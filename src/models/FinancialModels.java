/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author alex
 */
public class FinancialModels {
    

    /**
     * Funktion til at beregne rentefod
     * @param futureCapital angiver Kn = slutvÃ¦rdien
     * @param presentCapital angiver K0 = startvÃ¦rdien
     * @param periods angiver n = antallet af terminer
     * @return r = den beregnede rentefod over den givne periode og kapitalforÃ¸gelse/formindskelse
     */
    public double calculateInterest(double futureCapital, double presentCapital, double periods) {
        return -1+Math.pow((futureCapital/presentCapital),(1/periods));
    }   
    
    public double calculatePresentCapital(double futureCapital, double interest, double periods) {
        return 0;
    }
    
     /**
     * Funktion til at beregne fremtidig vÃ¦rdi
     * @param presentCapital angiver K0 = startvÃ¦rdien
     * @param interest angiver r = rentefoden
     * @param periods angiver n = antallet af terminer
     * @return Kn = slutvÃ¦rdien efter en given mÃ¦ngde terminer med en bestmt rentefod og kapital
     */
    public double calculateFutureCapital(double presentCapital, double interest, double periods) {
        double result = presentCapital*Math.pow((1+interest),periods);
        return result;
    }
    
    public double calculatePeriods(double futureCapital, double presentCapital, double interest) {
        double result;
        result = (Math.log(futureCapital/presentCapital))/(Math.log(1+interest));
        return result;
    }
}

