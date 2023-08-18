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
