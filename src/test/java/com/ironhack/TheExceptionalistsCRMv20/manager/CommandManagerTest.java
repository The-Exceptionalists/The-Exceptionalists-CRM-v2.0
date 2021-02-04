package com.ironhack.TheExceptionalistsCRMv20.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandManagerTest {

    @BeforeEach
    public void setUp() {
        CommandManager commandManager = new CommandManager();
        List<String> commandList = commandManager.getCommandList();
        CommandManager.setCommandList();
    }

    @Test
    public void setCommandList_ValidCommand_OneOfTheCommands() {
        CommandManager commandManager = new CommandManager();
        List<String> commandList = commandManager.getCommandList();
        CommandManager.setCommandList();

        assertEquals("New Lead : Add a new Lead.", commandList.get(0));
        assertEquals("Show Leads : Shows a list of all the Leads.", commandList.get(1));
        assertEquals("Convert <id> : Converts a Lead into an Opportunity.", commandList.get(2));
        assertEquals("Show Opportunities: Shows a list of all the leads.", commandList.get(3));
        assertEquals("Lookup Opportunity <id> : Shows an Opportunity.", commandList.get(4));
        assertEquals("Close-Won <id> : Closes an Opportunity as won.", commandList.get(5));
        assertEquals("Close-Lost <id> : Closes an Opportunity as lost.", commandList.get(6));
        assertEquals("Help : Show the command list.", commandList.get(7));
        assertEquals("Exit : Closes the CRM.", commandList.get(8));

    }

    @Test
    public void printcorrectCommand_ListInside_True() {

        List<String> commandList = new ArrayList<>();
        commandList.add("New Lead : Add a new Lead.");
        commandList.add("Show Leads : Shows a list of all the Leads.");
        commandList.add("Convert <id> : Converts a Lead into an Opportunity.");
        commandList.add("Show Opportunities: Shows a list of all the leads.");
        commandList.add("Lookup Opportunity <id> : Shows an Opportunity.");
        commandList.add("Close-Won <id> : Closes an Opportunity as won.");
        commandList.add("Close-Lost <id> : Closes an Opportunity as lost.");
        commandList.add("Help : Show the command list.");
        commandList.add("Exit : Closes the CRM.");

        assertTrue(commandList.equals(CommandManager.getCommandList()));

    }


}
