package com.BlackJack;

import java.util.ArrayList;

public class Deck {

    private static ArrayList<String> cards;
    public static ArrayList<String> makeDeck()
    {
        cards = new ArrayList<>();
        putHearts();
        putSpades();
        putDiamonds();
        putClubs();
        return cards;
    }

    private static void putHearts()
    {
        cards.add("2 of Hearts");
        cards.add("3 of Hearts");
        cards.add("4 of Hearts");
        cards.add("5 of Hearts");
        cards.add("6 of Hearts");
        cards.add("7 of Hearts");
        cards.add("8 of Hearts");
        cards.add("9 of Hearts");
        cards.add("10 of Hearts");
        cards.add("Jack of Hearts");
        cards.add("Queen of Hearts");
        cards.add("King of Hearts");
        cards.add("Ace of Hearts");
    }

    private static void putSpades()
    {
        cards.add("2 of Spades");
        cards.add("3 of Spades");
        cards.add("4 of Spades");
        cards.add("5 of Spades");
        cards.add("6 of Spades");
        cards.add("7 of Spades");
        cards.add("8 of Spades");
        cards.add("9 of Spades");
        cards.add("10 of Spades");
        cards.add("Jack of Spades");
        cards.add("Queen of Spades");
        cards.add("King of Spades");
        cards.add("Ace of Spades");
    }

    private static void putDiamonds()
    {
        cards.add("2 of Diamonds");
        cards.add("3 of Diamonds");
        cards.add("4 of Diamonds");
        cards.add("5 of Diamonds");
        cards.add("6 of Diamonds");
        cards.add("7 of Diamonds");
        cards.add("8 of Diamonds");
        cards.add("9 of Diamonds");
        cards.add("10 of Diamonds");
        cards.add("Jack of Diamonds");
        cards.add("Queen of Diamonds");
        cards.add("King of Diamonds");
        cards.add("Ace of Diamonds");
    }

    private static void putClubs()
    {
        cards.add("2 of Clubs");
        cards.add("3 of Clubs");
        cards.add("4 of Clubs");
        cards.add("5 of Clubs");
        cards.add("6 of Clubs");
        cards.add("7 of Clubs");
        cards.add("8 of Clubs");
        cards.add("9 of Clubs");
        cards.add("10 of Clubs");
        cards.add("Jack of Clubs");
        cards.add("Queen of Clubs");
        cards.add("King of Clubs");
        cards.add("Ace of Clubs");
    }
}
