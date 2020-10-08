/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.util.Scanner;
import models.FinancialModels;

/**
 * 
 * @author alex
 */
public class InputOutputTool {
    
    FinancialModels model = new FinancialModels();
    Scanner sc;
    
    public void welcome() {
        System.out.println(this.welcomeString);
        this.menu();
    }
    
    public void menu() {
        System.out.println(this.menuString);
        sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equals("1")) {
            this.futureCapitalChosen();
        }
        else if(input.equals("2")) {
            this.interestChosen();
        }
        else if(input.equals("3")) {
            this.numberOfPeriodsChosen();
        }
        else if(input.equals("4")) {
            System.out.println("Programmet afsluttes");
            return;
        }
        else {
            System.out.println("error 404: ukendt forespøgsel, prøv venligst igen");
        }
        menu();
    }
    
    public double collectInput(String message) {
        System.out.println(message);
        String input = sc.nextLine();
        double numericInput = 0;
        if(input.chars().allMatch(Character::isDigit)==false) {
            System.out.println(notANumberString);
            this.collectInput(message);
        } else {
            numericInput = (double) Double.parseDouble(input);
        }
        return numericInput;
    }
    
    public void futureCapitalChosen() {
        double capital = this.collectInput(startCapitalString);
        double interest = this.collectInput(interestString)/100;
        double periods = this.collectInput(numberOfPeriodsString);
        double result = model.calculateFutureCapital(capital, interest, periods);
        System.out.println("Om "+periods+" med følgende kapital: "+capital+" og renten: "+interest+" vil du nå følgende sum "+result+"\n");
    }
    
    public void numberOfPeriodsChosen() {
        double presentCapital = this.collectInput(startCapitalString);
        double interest = this.collectInput(interestString)/100;
        double futureCapital = this.collectInput(finalCapitalString);
        double result = model.calculatePeriods(futureCapital, presentCapital, interest);
        System.out.println("Med startkapital "+presentCapital+", renten "+interest+", og ønskede slutkapital på "+futureCapital+", vil du skulle vente "+result+" terminer\n");
    }
    
    public void interestChosen() {
        double presentCapital = this.collectInput(startCapitalString);
        double periods = this.collectInput(numberOfPeriodsString);
        double futureCapital = this.collectInput(finalCapitalString);
        double result = model.calculateInterest(futureCapital, presentCapital, periods);
        System.out.println("Med startkapital: "+presentCapital+", slutkapital: "+futureCapital+", og antallet af terminer: "+periods+", har du modtaget renten: "+result+"\n");
    }
    
    
            
    
    
    String startCapitalString = "Venligst indtast din start-kapital";
    String interestString = "Venligst indtast din rentefod";
    String finalCapitalString = "Venligst indtast din slut-kapital";
    String numberOfPeriodsString = "Venlist indtast antallet af terminer";
    
    String notANumberString = "Det var ikke et tal, prøv igen";

    String welcomeString = "\n\n\n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + " _______ _______ _______ _______ _______ _______ _______ _______ _______ \n"
            + "(_______|_______|_______|_______|_______|_______|_______|_______|_______)\n"
            + "                                                                         \n"
            + " _     _       _  _                                           _ _        \n"
            + "(_)   (_)     | || |                                      _  (_) |       \n"
            + " _     _ _____| || |  _ ___  ____  ____  _____ ____     _| |_ _| |       \n"
            + "| |   | | ___ | || |_/ ) _ \\|    \\|    \\| ___ |  _ \\   (_   _) | |       \n"
            + " \\ \\ / /| ____| ||  _ ( |_| | | | | | | | ____| | | |    | |_| | |       \n"
            + "  \\___/ |_____)\\_)_| \\_)___/|_|_|_|_|_|_|_____)_| |_|     \\__)_|\\_)      \n"
            + "                                                                         \n"
            + "     _                   ___ _                        _       _ _        \n"
            + "    | |                 / __|_)                      (_)     | | |       \n"
            + "  __| |_____ ____     _| |__ _ ____  _____ ____   ___ _ _____| | | _____ \n"
            + " / _  | ___ |  _ \\   (_   __) |  _ \\(____ |  _ \\ /___) | ___ | | || ___ |\n"
            + "( (_| | ____| | | |    | |  | | | | / ___ | | | |___ | | ____| | || ____|\n"
            + " \\____|_____)_| |_|    |_|  |_|_| |_\\_____|_| |_(___/|_|_____)\\_)_)_____)\n"
            + "                                                                         \n"
            + " _                                                                       \n"
            + "| |                                                                      \n"
            + "| | ___  ____  ____  _____  ____ _____  ____ ____  _____  ____           \n"
            + "| |/ _ \\|    \\|    \\| ___ |/ ___) ___ |/ _  |  _ \\| ___ |/ ___)          \n"
            + "| | |_| | | | | | | | ____| |   | ____( (_| | | | | ____| |              \n"
            + " \\_)___/|_|_|_|_|_|_|_____)_|   |_____)\\___ |_| |_|_____)_|              \n"
            + "                                      (_____|                            \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + "                                                                         \n"
            + " _______ _______ _______ _______ _______ _______ _______ _______ _______ \n"
            + "(_______|_______|_______|_______|_______|_______|_______|_______|_______)\n"
            + "                                                                         ";


    String menuString = 
            "\nVælg 1 for at beregne fremtidsværdi af nuværende kapital"
            + "\nVælg 2 for at beregne rente mellem to perioder"
            + "\nVælg 3 for at beregne antallet af terminer for at opnå en bestemt kapital"
            + "\nVælg 4 for at afslutte programmet";
    
}
