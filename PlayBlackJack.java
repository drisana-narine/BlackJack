package com.BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayBlackJack {
    public static void main(String[] args) {
        System.out.println("RULES OF THE GAME:");
        System.out.println("The goal is to get 21 or as close as possible without going over");
        System.out.println("The dealer gets 2 cards, one card is face up.");
        System.out.println("The player is dealt 2 cards. then the dealer's second card is flipped face up");
        System.out.println("The dealer must take hits until their cards have a value of 17 or greater");
        System.out.println("The player says hit to get another card, and stand to keep cards they have.");
        System.out.println("If both the dealer and player bust, it's a draw.");
        System.out.println("If only the player busts, the dealer wins.");
        System.out.println("If only the dealer busts, the player wins.");
        System.out.println("If the dealer and player have the same number, it's a draw.");
        System.out.println("If the player is closer to 21 than the dealer, the player wins.");

        String playAgain;

        //make deck of cards
        ArrayList<String> newDeck = Deck.makeDeck();
        ArrayList<String> dealerCards = new ArrayList<>();
        ArrayList<String> playerCards = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        int dealerSum = 0;
        int playerSum = 0;
        int dealerAces = 0;
        int playerAces = 0;
        int dealerAcesChecked = 0;
        int playerAcesChecked = 0;
        boolean playerBust = false;
        String playerAnswer;

        do {
            //1st card for dealer, add to dealers cards, remove from deck
            String dealerCard = newDeck.get((int) (Math.random() * (newDeck.size())));
            dealerCards.add(dealerCard);
            dealerSum += GamePlay.getCardValue(dealerCard);
            newDeck.remove(dealerCard);
            System.out.println("DEALER'S FIRST CARD: " + dealerCard);
            if(GamePlay.ifAce(dealerCard)){
                dealerAces++;
            }
            System.out.println();

            //2nd card for dealer, add to dealers cards, remove from deck
            String faceDownCard = newDeck.get((int) (Math.random() * (newDeck.size())));
            dealerCards.add(faceDownCard);
            newDeck.remove(faceDownCard);


            //player gets 2 cards, add to players cards, remove from deck
            String playerCard = newDeck.get((int) (Math.random() * (newDeck.size())));
            System.out.print("PLAYER'S CARDS: ");
            playerCards.add(playerCard);
            newDeck.remove(playerCard);
            if(GamePlay.ifAce(playerCard)){
                playerAces++;
            }
            System.out.print(playerCard+", ");
            playerCard = newDeck.get((int) (Math.random() * (newDeck.size())));
            playerCards.add(playerCard);
            newDeck.remove(playerCard);
            if(GamePlay.ifAce(playerCard)){
                playerAces++;
            }
            System.out.println(playerCard);
            System.out.println();
            if (GamePlay.checkBust(playerSum)) {
                if (GamePlay.checkForAce(playerCards)) {
                    playerSum = GamePlay.adjustAceForBust(playerSum);
                    playerAcesChecked++;
                }
            }

            //get numerical value of cards
            for (String n : playerCards) {
                playerSum += GamePlay.getCardValue(n);
            }

            //dealers 2nd card revealed
            System.out.println("DEALER'S SECOND CARD: " + faceDownCard);
            System.out.println();
            if(GamePlay.ifAce(faceDownCard)){
                dealerAces++;
            }
            dealerSum += GamePlay.getCardValue(faceDownCard);
            if (GamePlay.checkBust(dealerSum)) {
                if (GamePlay.checkForAce(dealerCards)) {
                    dealerSum = GamePlay.adjustAceForBust(dealerSum);
                    dealerAcesChecked++;
                }
            }

            //dealer keep getting cards until at least value of 17
            while (GamePlay.checkDealer(dealerSum)) {
                dealerCard = newDeck.get((int) (Math.random() * (newDeck.size())));
                dealerCards.add(dealerCard);
                newDeck.remove(dealerCard);
                if(GamePlay.ifAce(dealerCard)){
                    dealerAces++;
                }
                dealerSum += GamePlay.getCardValue(dealerCard);
                if (GamePlay.checkBust(dealerSum)) {
                    if (GamePlay.checkForAce(dealerCards) && dealerAces>dealerAcesChecked) {
                        dealerSum = GamePlay.adjustAceForBust(dealerSum);
                        dealerAcesChecked++;
                    }
                }
            }

            //check is dealer busted
            boolean dealerBust = dealerSum > 21;

            //ask player if they want to hit or stand, keep going until they don't want a hit
            System.out.print("Hit or stand?:");
            playerAnswer = keyboard.next();
            while (playerAnswer.equalsIgnoreCase("hit")) {
                playerCard = newDeck.get((int) (Math.random() * (newDeck.size())));
                playerCards.add(playerCard);
                newDeck.remove(playerCard);
                if(GamePlay.ifAce(playerCard)){
                    playerAces++;
                }
                System.out.println("PLAYER'S NEW CARD: "+playerCard);
                playerSum += GamePlay.getCardValue(playerCard);
                if (GamePlay.checkBust(playerSum)) {
                    if (GamePlay.checkForAce(playerCards) && playerAces>playerAcesChecked) {
                        playerSum = GamePlay.adjustAceForBust(playerSum);
                        playerAcesChecked++;
                    } else {
                        playerAnswer = "stand";
                    }
                }
                if (!playerAnswer.equalsIgnoreCase("stand")) {
                    System.out.print("Hit or stand?: ");
                    playerAnswer = keyboard.next();
                }
            }
            playerBust=playerSum>21;

            //display result of game
            System.out.println();
            if(playerBust && dealerBust)
                System.out.println("BOTH THE PLAYER AND DEALER BUSTED. DRAW.");
            else if(playerBust)
                System.out.println("BUST. YOU LOSE");
            else if(playerSum==dealerSum)
                System.out.println("DRAW.");
            else if (dealerBust)
                System.out.println("THE DEALER BUSTED, CONGRATULATIONS YOU WON!");
            else if (playerSum > dealerSum)
                System.out.println("CONGRATULATIONS YOU WON!");
            else
                System.out.println("YOU LOST.");

            System.out.println("Dealer sum: "+dealerSum);
            System.out.println("Player sum: "+playerSum);
            System.out.println("*******************************");
            System.out.println("The dealer's cards were: ");
            for(String s: dealerCards){
                System.out.println(s);
            }
            System.out.println("*******************************");
            System.out.println("GAME OVER.");
            System.out.println("Do you want to play again?");
            playAgain= keyboard.next();

            //reset everything
            playerCards.clear();
            dealerCards.clear();
            playerSum= dealerSum= playerAces=dealerAces=playerAcesChecked=dealerAcesChecked=0;
            newDeck.clear();
            newDeck=Deck.makeDeck();
            System.out.println("----------------------------------------------------------------");
            System.out.println();
        }while(playAgain.equalsIgnoreCase("yes"));
        System.out.println("Goodbye.");
    }
}