package com.BlackJack;

import java.util.ArrayList;

public class GamePlay {

    public static int getCardValue(String card){
        String[] s=card.split(" ");
        String value = s[0];
        switch(value){
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "Ace":
                return 11;
            default:
                return 10;
        }
    }

    public static boolean checkForAce(ArrayList<String> cards){
        String[] splt= new String[2];
        String n;
        for(String s: cards){
            splt=s.split(" ");
            n=splt[0];
            if(n.equalsIgnoreCase("Ace"))
                return true;
        }
        return false;
    }

    public static boolean ifAce(String card){
        String[] splt = new String[2];
        String n;
        splt=card.split(" ");
        n=splt[0];
        return n.equalsIgnoreCase("Ace");
    }

    public static int adjustAceForBust(int sum){
        return sum-10;
    }
    public static boolean checkBust(int value) {
        return value>21;
    }

    public static boolean checkDealer(int value){
        return value<17;
    }
}
