package com.ironhack.TheExceptionalistsCRMv20;


import com.ironhack.TheExceptionalistsCRMv20.manager.CommandManager;
import com.ironhack.TheExceptionalistsCRMv20.repository.*;
import com.ironhack.TheExceptionalistsCRMv20.utils.Buffer;
import com.ironhack.TheExceptionalistsCRMv20.utils.Init;
import com.ironhack.TheExceptionalistsCRMv20.utils.Output;
import com.ironhack.TheExceptionalistsCRMv20.utils.Security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


@SpringBootApplication
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SalesRepRepository salesRepRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleApp.class);
    private static int exitCode;

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ConfigurableApplicationContext ctx = SpringApplication.run(ConsoleApp.class, args);
        exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return 0;
            }
        });
    }

    @Override
    public void run(String... args) throws Exception {
        Output.introResolutionAlert();
        Security.introLogin();
        Buffer.initStringsRepository();
        Init init = new Init(leadRepository, contactRepository, opportunityRepository, accountRepository, salesRepRepository);
        init.addLeads();
        init.addAccounts();
        CommandManager.initRepos(leadRepository, contactRepository, opportunityRepository, accountRepository, salesRepRepository);

        while (true) {
            CommandManager.introduceCommand();
        }
    }

    public static int getExitCode() {
        return exitCode;
    }

    public static void setExitCode(int exitCode) {
        ConsoleApp.exitCode = exitCode;
    }
}
