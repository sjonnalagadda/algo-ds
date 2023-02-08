package com.samples.crls.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStack {

    @Test
    public void testPopOnEmptyStack() {
        Stack stack = new Stack(5);
        Assertions.assertThrows(RuntimeException.class, () ->stack.pop());
    }

    @Test
    public void testStackFull() {
        Stack stack = new Stack(1);
        stack.push(1);
        Assertions.assertThrows(RuntimeException.class, () ->stack.push(2));
    }


    @Test
    public void testStackOperations() {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.pop());
        stack.push(4);
        stack.push(5);
        stack.push(6);
        Assertions.assertThrows(RuntimeException.class, () ->stack.push(7));
        Assertions.assertEquals(6, stack.pop());
        Assertions.assertEquals(5, stack.pop());
        Assertions.assertEquals(4, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertThrows(RuntimeException.class, () ->stack.pop());
    }

    @Test
    public void testTwoStacksWhenEmpty() {
        TwoStacks twoStacks = new TwoStacks(5);
        Assertions.assertThrows(RuntimeException.class, () ->twoStacks.popFromHigher());
        Assertions.assertThrows(RuntimeException.class, () ->twoStacks.popFromLower());
    }

    @Test
    public void testWhenFirstStackIsfull() {
        TwoStacks twoStacks = new TwoStacks(5);
        twoStacks.pushIntoLower(1);
        twoStacks.pushIntoLower(2);
        twoStacks.pushIntoLower(3);
        twoStacks.pushIntoLower(4);
        twoStacks.pushIntoLower(5);
        Assertions.assertThrows(RuntimeException.class, () ->twoStacks.pushIntoLower(6));
        Assertions.assertThrows(RuntimeException.class, () ->twoStacks.pushIntoHigher(6));
    }

    @Test
    public void testWhenSecondStackIsfull() {
        TwoStacks twoStacks = new TwoStacks(5);
        twoStacks.pushIntoHigher(1);
        twoStacks.pushIntoHigher(2);
        twoStacks.pushIntoHigher(3);
        twoStacks.pushIntoHigher(4);
        twoStacks.pushIntoHigher(5);
        Assertions.assertThrows(RuntimeException.class, () ->twoStacks.pushIntoLower(6));
        Assertions.assertThrows(RuntimeException.class, () ->twoStacks.pushIntoHigher(6));
    }

    @Test
    public void testWhenBothStacksHasElements() {
        TwoStacks twoStacks = new TwoStacks(5);
        twoStacks.pushIntoHigher(1);
        twoStacks.pushIntoHigher(2);
        twoStacks.pushIntoHigher(3);
        twoStacks.pushIntoLower(4);
        twoStacks.pushIntoLower(5);
        Assertions.assertThrows(RuntimeException.class, () ->twoStacks.pushIntoLower(6));
        Assertions.assertThrows(RuntimeException.class, () ->twoStacks.pushIntoHigher(6));
    }

    @Test
    public void testStackSll() {
        StackSll stackSll = new StackSll();
        stackSll.push(1);
        stackSll.push(2);
        stackSll.push(3);
        Assertions.assertEquals(3, stackSll.pop());
        Assertions.assertEquals(2, stackSll.pop());
        Assertions.assertEquals(1, stackSll.pop());
        Assertions.assertThrows(RuntimeException.class, () -> stackSll.pop());
    }
}
