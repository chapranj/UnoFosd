/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.unofosd;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Omkar
 */
public class MainTest {
    
    public MainTest() {
    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of main method, of class Main.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Main.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of instantiateDeck method, of class Main.
//     */
//    @Test
//    public void testInstantiateDeck() {
//        System.out.println("instantiateDeck");
//        Main.instantiateDeck();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of startGame method, of class Main.
//     */
//    @Test
//    public void testStartGame() {
//        System.out.println("startGame");
//        Player p1 = null;
//        Player p2 = null;
//        Player p3 = null;
//        Card firstCardinPile = null;
//        Deck deck = null;
//        Main.startGame(p1, p2, p3, firstCardinPile, deck);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of generateDeck method, of class Main.
//     */
//    @Test
//    public void testGenerateDeck() {
//        System.out.println("generateDeck");
//        Deck deck = null;
//        Main.generateDeck(deck);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCardsFromDeck method, of class Main.
//     */
//    @Test
//    public void testGetCardsFromDeck() {
//        System.out.println("getCardsFromDeck");
//        Hand playerCards = null;
//        Deck deck = null;
//        Main.getCardsFromDeck(playerCards, deck);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of canPlayCard method, of class Main.
     */
//    @Test
//    public void testCanPlayCard() {
//        System.out.println("canPlayCard");
//        Card topCard = null;
//        Card playingCard = null;
//        boolean expResult = false;
//        boolean result = Main.canPlayCard(topCard, playingCard);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of cardActionHandler method, of class Main.
//     */
//    @Test
//    public void testCardActionHandler() {
//        System.out.println("cardActionHandler");
//        ArrayList<Player> players = null;
//        Player currentPlayer = null;
//        Player nextPlayer = null;
//        CardHolder deck = null;
//        Card card = null;
//        Main.cardActionHandler(players, currentPlayer, nextPlayer, deck, card);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
        @Test
    public void testCanPlayCard() {
        System.out.println("canPlayCard");
        Card topCard = new Card(Color.BLUE,Value.EIGHT);
        Card playingCard = new Card(Color.BLUE,Value.EIGHT);
        boolean expResult = true;
        boolean result = Main.canPlayCard(topCard, playingCard);
        assertEquals(expResult, result);
    }
    public void testCanPlayCardBoundary(){
        System.out.println("canPlayCardBoundaryTest");
        Card topCard = new Card(Color.BLUE,Value.FOUR);
        Card playingCard = new Card(Color.BLUE,Value.EIGHT);
        boolean expResult = true;
        boolean result = Main.canPlayCard(topCard, playingCard);
        assertEquals(expResult, result);
    }
    
    public void testCanPlayBoundaryAnother(){
        System.out.println("canPlayCard Another Boundary");
        Card topCard = new Card(Color.RED,Value.EIGHT);
        Card playingCard = new Card(Color.BLUE,Value.EIGHT);
        boolean expResult = true;
        boolean result = Main.canPlayCard(topCard, playingCard);
        assertEquals(expResult, result);
    }
    
    public void testCanPlayBad(){
        System.out.println("canPlayCard Bad");
        Card topCard = new Card(Color.GREEN,Value.EIGHT);
        Card playingCard = new Card(Color.BLUE,Value.NINE);
        boolean expResult = false;
        boolean result = Main.canPlayCard(topCard, playingCard);
        assertEquals(expResult, result);
    }
    
}
