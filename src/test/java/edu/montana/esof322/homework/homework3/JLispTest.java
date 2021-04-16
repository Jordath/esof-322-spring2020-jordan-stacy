package edu.montana.esof322.homework.homework3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JLispTest {

    /*====================================================================
    // Homework 3
    //
    // Included in this directory is a simple lisp implementation.  This
    // lisp implementation supports basic math, akin to what our reverse
    // polish notation calculator did.
    //
    // The intention with this lisp is to support simple, binary addition
    // in the form:
    //
    //  (+ 1 2)
    //
    //  or
    //
    //  (+ 1 (+ 2 3))
    //
    //
    // The `+` operator can take two and only two arguments, and must be
    // enclosed in parenthesis to be valid.
    //
    // This implementation is buggy.  Your assignment is to create four (4)
    // tests showing *different* bugs within the simple language.
    //
    //====================================================================*/

    @Test
    // This is a sample test to help you get started
    public void exampleTest() {
        assertEquals(1, 2);
        fail("test didn't pass");
        assertEquals("Foo", "Bar");
    }

    @Test
    public void takingMoreThanTwoArgs(){
        JLisp testLisp = new JLisp();
        assertEquals(3, (testLisp.eval("(+ 1 1 1)")));

    }

    @Test
    public void nullAsAnArgument(){
        JLisp testLisp = new JLisp();
        try {
            testLisp.eval(null);
            fail("Did not throw error");
        } catch (IllegalArgumentException illegalArgumentException){
            // test passes
        }
    }

    @Test
    public void operatorOtherThanPlus(){
        JLisp testLisp = new JLisp();
        assertEquals((testLisp.eval("(- 1 1)")), 0);

    }

    @Test
    public void floatsAsArgs(){
        JLisp testLisp = new JLisp();
        assertEquals((testLisp.eval("(+ 1.5 1.5)")), 3);

    }

    @Test
    public void unterminatedParenthesis(){
        JLisp testLisp = new JLisp();
        try {
            testLisp.eval("(+ 1 1");
            fail("Did not throw error for un-executed lisp statement");
        } catch (IllegalArgumentException illegalArgumentException){
            // test passes
        }

    }

}
