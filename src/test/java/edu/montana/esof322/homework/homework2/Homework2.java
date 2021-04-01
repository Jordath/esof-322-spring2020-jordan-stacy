package edu.montana.esof322.homework.homework2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Homework2 {

    static int invocationCount = 0;
    static StringBuilder output = new StringBuilder();

    interface IDoAThing {
        void doIt();
    }

    static class ThingDoer implements IDoAThing{
        public void doIt() {
            output.append("Did it!\n");
        }
    }

    private static class ThingDoerFactory {
        public static IDoAThing create() {
            return new ThingDoer();
        }
    }

    class ThingDoerProxy implements IDoAThing{
        IDoAThing _proxiedThing;

        public ThingDoerProxy(IDoAThing proxiedThing){
            _proxiedThing = proxiedThing;
        }

        @Override
        public void doIt() {
            invocationCount++;
            _proxiedThing.doIt();
        }
    }

    //=======================================================================
    // Your boss wants to know how many times a method on a given class is
    // being invoked.  Your job is to take the the code above and refactor it
    // using some patterns to capture the needed information.
    //=======================================================================
    @Test
    void theAssignment() {
        // Step 1: extract an interface for ThingDoer, IDoAThing and
        //         replace the variable below with
        //ThingDoer thingDoer = new ThingDoer();

        // Step 2: replace this new expression with a factory to produce
        //         IDoAThings
        //IDoAThing thingDoer = ThingDoerFactory.create();


        // Step 3: use the factory to insert a proxy object that wraps
        //         a ThingDoer and increments the invocationCount
        IDoAThing thingDoer = new ThingDoerProxy(new ThingDoer());

        assertFalse(thingDoer instanceof ThingDoer);

        // do the thing a few times...
        thingDoer.doIt();
        thingDoer.doIt();
        thingDoer.doIt();

        // the proxy should have incremented the invocation count
        assertEquals(3, invocationCount);

        // output should still be the same since the proxy passed through
        // to the underlying ThingDoer
        assertEquals(output.toString(),
                "Did it!\nDid it!\nDid it!\n");
    }
}
