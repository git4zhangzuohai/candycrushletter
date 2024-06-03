package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRemoveNothing() {
        String input = "aabccdcbbad";
        Command<List<ProcessLog>> command = new RemoveStringCommand(input);
        List<ProcessLog> output = command.execute();
        assertTrue(output.size() == 0);
    }
    @Test
    public void testRemoveConsecutiveSub() {
        String input = "aabcccbbad";
        Command<List<ProcessLog>> command = new RemoveStringCommand(input);
        List<ProcessLog> output = command.execute();
        assertTrue(output.size() == 3);
        assertTrue(output.get(output.size()-1).getOutput().equals("d"));
    }
    @Test
    public void testRemoveConsecutiveSub2() {
        String input = "aabcccbbadxxxuup";
        Command<List<ProcessLog>> command = new RemoveStringCommand(input);
        List<ProcessLog> output = command.execute();
        assertTrue(output.size() == 4);
        assertTrue(output.get(output.size()-1).getOutput().equals("duup"));
    }

    @Test
    public void testReplaceNothing() {
        String input = "abccdcbad";
        Command<List<ProcessLog>> command = new ReplaceStringCommand(input);
        List<ProcessLog> output = command.execute();
        assertTrue(output.size() == 0);
    }

    @Test
    public void testReplaceConsecutiveSub() {
        String input = "abcccbad";
        Command<List<ProcessLog>> command = new ReplaceStringCommand(input);
        List<ProcessLog> output = command.execute();
        assertTrue(output.size() == 3);
        assertTrue(output.get(output.size()-1).getOutput().equals("d"));
    }
    @Test
    public void testReplaceConsecutiveSub2() {
        String input = "abcccbadgggxy";
        Command<List<ProcessLog>> command = new ReplaceStringCommand(input);
        List<ProcessLog> output = command.execute();
        assertTrue(output.size() == 4);
        assertTrue(output.get(output.size()-1).getOutput().equals("dfxy"));
    }
}
