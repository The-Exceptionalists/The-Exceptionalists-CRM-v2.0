package com.ironhack.TheExceptionalistsCRMv20.main;

import com.ironhack.TheExceptionalistsCRMv20.manager.CommandManager;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Buffer;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Output;
import com.ironhack.TheExceptionalistsCRMv20.utilities.State;

public class Main {
    public static void main(String[] args) {
        Output.introResolutionAlert();
        Buffer.initStringsRepository();
        State.restoreState();
        while (true) {
            CommandManager.introduceCommand();
        }
    }
}
