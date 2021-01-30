package com.ironhack.TheExceptionalistsCRMv20;


import com.ironhack.TheExceptionalistsCRMv20.manager.CommandManager;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Buffer;
import com.ironhack.TheExceptionalistsCRMv20.utilities.Output;
import com.ironhack.TheExceptionalistsCRMv20.utilities.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class ConsoleApp implements CommandLineRunner {

    public static ConfigurableApplicationContext ctx;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleApp.class);

    public static void main(String[] args) {
        ctx = SpringApplication.run(ConsoleApp.class, args);
        Output.introResolutionAlert();
        Buffer.initStringsRepository();
        State.restoreState();
        while (true) {
            CommandManager.introduceCommand();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Welcome to my app");
    }
}
