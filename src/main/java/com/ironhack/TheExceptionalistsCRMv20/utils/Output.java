package com.ironhack.TheExceptionalistsCRMv20.utils;

import com.ironhack.TheExceptionalistsCRMv20.ConsoleApp;
import com.ironhack.TheExceptionalistsCRMv20.enums.PrintLayout;

import java.util.Locale;
import java.util.Scanner;

public class Output {

    private static final String DEFAULT = (char) 27 + "[0m";
    private static final String BLOCK = "  ";
    private static final String BOLD = (char) 27 + "[1m";
    private static final String ITALIC = (char) 27 + "[3m";
    private static final String INVERSE = (char) 27 + "[7m";
    private static final String UNDERLINE = (char) 27 + "[4m";
    private static final String MAGENTA_BCK = (char) 27 + "[45m";
    private static final String YELLOW_BCK = (char) 27 + "[43m";
    private static final String GREEN_BCK = (char) 27 + "[42m";
    private static final String RED_BCK = (char) 27 + "[41m";
    private static final String BLUE_BCK = (char) 27 + "[44m";
    private static final String CYAN_BCK = (char) 27 + "[46m";
    private static final String WHITE_BCK = (char) 27 + "[30;47m";
    private static final String DARK_GREY_BCK = (char) 27 + "[48;5;236m";
    private static final String LIGHT_GREY_TEXT = (char) 27 + "[38;5;241m";
    private static final String ORANGE_BCK = (char) 27 + "[48;5;166m";
    private static final String CORAL_BCK = (char) 27 + "[48;5;170m";
    private static final String LIGHT_GREY_BCK = (char) 27 + "[48;5;241m";
    private static final String DARK_TEXT = (char) 27 + "[38;5;234m";
    private static final String RED_TEXT = (char) 27 + "[38;5;196m";
    private static final String BLACK_TEXT = (char) 27 + "[38;5;232m";
    private static final String YELLOW_TEXT = (char) 27 + "[38;5;226m";
    private static final String GREEN_TEXT = (char) 27 + "[48;5;82m";

    /**
     * Method that print the screen, it uses a switch to determine what to print
     */
    public static void printScreen() {
        for (int i = 0; i < Buffer.screenBuffer.length; ++i) {
            for (int j = 0; j < Buffer.screenBuffer[i].length; ++j) {
                switch (Buffer.screenBuffer[i][j]) {
                    case ' ' -> System.out.print(BLOCK);
                    case 'i' -> {
                        switch (Buffer.screenBuffer[i][j + 1]) {
                            case '1' -> {
                                System.out.print(DARK_GREY_BCK + UNDERLINE
                                        + insertText(Buffer.getStringFromRepository(7), 80) + DEFAULT);
                                j += 39;
                            }
                            case '2' -> {
                                System.out.print(DARK_GREY_BCK + UNDERLINE
                                        + insertText(Buffer.getStringFromRepository(8), 80) + DEFAULT);
                                j += 39;
                            }
                            case '3' -> {
                                System.out.print(DARK_GREY_BCK + UNDERLINE
                                        + insertText(Buffer.getStringFromRepository(9), 80) + DEFAULT);
                                j += 39;
                            }

                            case 'a' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(10), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'b' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(11), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'c' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(12), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'd' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(13), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'e' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(14), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'f' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(15), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'g' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(16), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'h' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(17), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'i' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(18), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'j' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(19), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'k' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(20), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'l' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(21), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'm' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(22), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'n' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(23), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'o' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(24), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'p' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(25), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'q' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(26), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'r' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(27), 80) + DEFAULT);
                                j += 39;
                            }
                            case 's' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(28), 80) + DEFAULT);
                                j += 39;
                            }
                            case 't' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(29), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'u' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(30), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'v' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(31), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'w' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(32), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'x' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(33), 80) + DEFAULT);
                                j += 39;
                            }

                        }
                    }
                    case 'g' -> {
                        switch (Buffer.screenBuffer[i][j + 1]) {
                            case '1' -> {
                                System.out.print(DARK_GREY_BCK + BOLD + UNDERLINE
                                        + insertText(Buffer.getStringFromRepository(10) + BLOCK
                                        + Buffer.getStringFromRepository(11), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'a' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(10) + BLOCK
                                        + Buffer.getStringFromRepository(11), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'b' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(12) + BLOCK
                                        + Buffer.getStringFromRepository(13), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'c' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(14) + BLOCK
                                        + Buffer.getStringFromRepository(15), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'd' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(16) + BLOCK
                                        + Buffer.getStringFromRepository(17), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'e' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(18) + BLOCK
                                        + Buffer.getStringFromRepository(19), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'f' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(20) + BLOCK
                                        + Buffer.getStringFromRepository(21), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'g' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(22) + BLOCK
                                        + Buffer.getStringFromRepository(23), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'h' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(24) + BLOCK
                                        + Buffer.getStringFromRepository(25), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'i' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(26) + BLOCK
                                        + Buffer.getStringFromRepository(27), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'j' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(28) + BLOCK
                                        + Buffer.getStringFromRepository(29), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'k' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(30) + BLOCK
                                        + Buffer.getStringFromRepository(31), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'l' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(32) + BLOCK
                                        + Buffer.getStringFromRepository(33), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'm' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(34) + BLOCK
                                        + Buffer.getStringFromRepository(35), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'n' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(36) + BLOCK
                                        + Buffer.getStringFromRepository(37), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'o' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(38) + BLOCK
                                        + Buffer.getStringFromRepository(39), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'p' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(40) + BLOCK
                                        + Buffer.getStringFromRepository(41), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'q' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(42) + BLOCK
                                        + Buffer.getStringFromRepository(43), 80) + DEFAULT);
                                j += 39;
                            }
                            case 'r' -> {
                                System.out.print(DARK_GREY_BCK
                                        + insertText(Buffer.getStringFromRepository(44) + BLOCK
                                        + Buffer.getStringFromRepository(45), 80) + DEFAULT);
                                j += 39;
                            }

                        }
                    }

                    case 'p' -> {
                        switch (Buffer.screenBuffer[i][j + 1]) {
                            case '1' -> {
                                System.out.print(YELLOW_BCK + DARK_TEXT + insertText(Buffer.getPromptLineOne(), 64) + DEFAULT);
                                j += 31;
                            }
                            case '2' -> {
                                System.out.print(YELLOW_BCK + DARK_TEXT + insertText(Buffer.getPromptLineTwo(), 64) + DEFAULT);
                                j += 31;
                            }
                        }
                    }
                    case 'S' -> System.out.print(LIGHT_GREY_BCK + fillWithSpaces(2) + DEFAULT);
                    case 's' -> {
                        switch (Buffer.screenBuffer[i][j + 1]) {
                            case 'a' -> {
                                System.out.print(LIGHT_GREY_BCK + DARK_TEXT
                                        + insertText(Buffer.getStringFromRepository(40), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'b' -> {
                                System.out.print(LIGHT_GREY_BCK + DARK_TEXT
                                        + insertText(Buffer.getStringFromRepository(41), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'c' -> {
                                System.out.print(LIGHT_GREY_BCK + BLACK_TEXT + BOLD
                                        + insertText(Buffer.getStringFromRepository(42), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'd' -> {
                                System.out.print(LIGHT_GREY_BCK + BLACK_TEXT + BOLD
                                        + insertText(Buffer.getStringFromRepository(43), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'e' -> {
                                System.out.print(LIGHT_GREY_BCK + DARK_TEXT
                                        + insertText(Buffer.getStringFromRepository(44), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'f' -> {
                                System.out.print(LIGHT_GREY_BCK + BLACK_TEXT + BOLD
                                        + insertText(Buffer.getStringFromRepository(45), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'g' -> {
                                System.out.print(LIGHT_GREY_BCK + DARK_TEXT
                                        + insertText(Buffer.getStringFromRepository(46), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'h' -> {
                                System.out.print(LIGHT_GREY_BCK + BLACK_TEXT + BOLD
                                        + insertText(Buffer.getStringFromRepository(47), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'i' -> {
                                System.out.print(LIGHT_GREY_BCK + DARK_TEXT
                                        + insertText(Buffer.getStringFromRepository(48), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'j' -> {
                                System.out.print(LIGHT_GREY_BCK + BLACK_TEXT + BOLD
                                        + insertText(Buffer.getStringFromRepository(49), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'k' -> {
                                System.out.print(LIGHT_GREY_BCK + DARK_TEXT
                                        + insertText(Buffer.getStringFromRepository(50), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'l' -> {
                                System.out.print(LIGHT_GREY_BCK + BLACK_TEXT + BOLD
                                        + insertText(Buffer.getStringFromRepository(51), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'm' -> {
                                System.out.print(LIGHT_GREY_BCK + DARK_TEXT
                                        + insertText(Buffer.getStringFromRepository(52), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'n' -> {
                                System.out.print(LIGHT_GREY_BCK + BLACK_TEXT + BOLD
                                        + insertText(Buffer.getStringFromRepository(53), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'o' -> {
                                System.out.print(LIGHT_GREY_BCK + DARK_TEXT
                                        + insertText(Buffer.getStringFromRepository(54), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'p' -> {
                                System.out.print(LIGHT_GREY_BCK + BLACK_TEXT + BOLD
                                        + insertText(Buffer.getStringFromRepository(55), 28) + DEFAULT);
                                j += 13;
                            }
                            case 'q' -> {
                                System.out.print(LIGHT_GREY_BCK + DARK_TEXT
                                        + insertText(Buffer.getStringFromRepository(56), 28) + DEFAULT);
                                j += 13;
                            }
                        }
                    }

                    case 'B' -> System.out.print(DARK_GREY_BCK + fillWithSpaces(2) + DEFAULT);

                    case 'P' -> System.out.print(YELLOW_BCK + fillWithSpaces(2) + DEFAULT);
                    case 'n' -> System.out.print(YELLOW_BCK + BLOCK + DEFAULT);
                    case 'm' -> System.out.print(WHITE_BCK + BLOCK + DEFAULT);
                    case 'A' -> {
                        int len = stringWithGradient(Buffer.getAppName(), 160);
                        String tempStr = " from The EXCEPTIONALIST";
                        System.out.print(DEFAULT + ITALIC + tempStr + fillWithSpaces(71 - len - tempStr.length()));
                        System.out.print(DEFAULT);
                        j += 34;
                    }
                    case 'C' -> {
                        System.out.print(YELLOW_TEXT + Output.insertText(Buffer.getCompanyName() + BLOCK + DEFAULT
                                + fillWithMidLine(76), 76) + DEFAULT);
                        j += 37;
                    }

                    case 'U' -> {
                        System.out.print(Output.insertText("User: " + Buffer.getUserName(), 20) + DEFAULT);
                        j += 9;
                    }
                    case 'v' -> {
                        System.out.print(Output.insertText(Buffer.getAppVersion(), 8) + DEFAULT);
                        j += 3;
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * As name said, it prints spaces
     *
     * @param len
     * @return
     */
    public static String fillWithSpaces(int len) {
        StringBuilder r = new StringBuilder();
        if (len > 0) r.append(" ".repeat(len));
        return r.toString();
    }

    /**
     * Print a line int the middle
     *
     * @param len
     * @return
     */
    public static String fillWithMidLine(int len) {
        StringBuilder r = new StringBuilder();
        if (len > 0) r.append("-".repeat(len));
        return r.toString();
    }

    /**
     * Method that insert a line of a max certain len
     *
     * @param text
     * @param len
     * @return
     */
    public static String insertText(String text, int len) {
        int strLen = text.length();
        text = strLen > len ? text.substring(0, len) : text;
        return text + Output.fillWithSpaces(len - strLen);
    }

    /**
     * Method that print a text in a colorful way
     *
     * @param text
     * @param color starting index of the color
     * @return
     */
    public static int stringWithGradient(String text, int color) {
        char[] textArray = text.toCharArray();
        String rString = "";
        for (int i = 0; i < textArray.length - 1; i++) {
            System.out.print(((char) 27 + "[38;5;" + (color + i) + "m" + textArray[i]));
        }
        return textArray.length;
    }

    public static void introResolutionAlert() {
        System.out.println(DEFAULT + "\n\n\n\n");
        System.out.println(fillWithSpaces(26) + "RECEIVING DATA FROM DATABASE");
        System.out.print(fillWithSpaces(10));
        System.out.println(DEFAULT + "\n\n\n\n");
        for (int i = 0; i < 40; i++) {
            System.out.print(GREEN_BCK + BLOCK);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(DEFAULT + "\n\n\n\n\n\n\n");
        System.out.println(fillWithSpaces(18) + "Resize your screen for a better experience.".toUpperCase(Locale.ROOT));
        System.out.println("\n\n\n\n\n\n");
        System.out.println(fillWithSpaces(34) + "THEN".toUpperCase(Locale.ROOT));
        System.out.println(fillWithSpaces(26) + "TYPE AND PRESS INTRO".toUpperCase(Locale.ROOT));
        System.out.println(DEFAULT + "\n\n\n\n");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }


    public static void printPage(String uniquePrompt, PrintLayout printLayout) {
        Buffer.resetPromptMessages();
        Buffer.resetScreenBuffer();
        Buffer.initStringsRepository();
        Buffer.setUpLayout();
        Buffer.setPromptLineTwo(uniquePrompt);
        Buffer.insertCentralPromptPoints(2);
        if (printLayout == printLayout.MENU_ON)
            Buffer.insertOptionsAnchors();
        Output.printScreen();
    }

    public static void printHelpPage() {
        Buffer.resetPromptMessages();
        Buffer.resetScreenBuffer();
        Buffer.initStringsRepository();
        Buffer.setUpLayout();
        Buffer.setPromptLineTwo("Press INTRO to continue");
        Buffer.insertCentralPromptPoints(2);
        Buffer.insertItemList(6);
        Buffer.prepareHelpPage();
        Output.printScreen();
    }

    public static void printPage(String firstPrompt, String secondPrompt, PrintLayout printLayout) {
        Buffer.resetPromptMessages();
        Buffer.resetScreenBuffer();
        Buffer.initStringsRepository();
        Buffer.setUpLayout();
        Buffer.setPromptLineOne(firstPrompt);
        Buffer.setPromptLineTwo(secondPrompt);
        Buffer.insertCentralPromptPoints(1);
        Buffer.insertCentralPromptPoints(2);
        switch (printLayout) {
            case SOLO_LAYOUT -> Buffer.insertItemSolo();
            case THREE_LAYOUT -> Buffer.insertItemThree();
            case LIST_LAYOUT -> Buffer.insertItemList(6);
        }
        if (printLayout == PrintLayout.MENU_ON)
            Buffer.insertOptionsAnchors();
        Output.printScreen();
    }

    public static void printPage(String firstPrompt, String secondPrompt, PrintLayout printLayout, boolean resetPromptMessages) {
        if (resetPromptMessages) {
            Buffer.resetPromptMessages();
            Buffer.initStringsRepository();
        }
        Buffer.resetScreenBuffer();
        Buffer.setUpLayout();
        Buffer.setPromptLineOne(firstPrompt);
        Buffer.setPromptLineTwo(secondPrompt);
        Buffer.insertCentralPromptPoints(1);
        Buffer.insertCentralPromptPoints(2);
        switch (printLayout) {
            case SOLO_LAYOUT -> Buffer.insertItemSolo();
            case THREE_LAYOUT -> Buffer.insertItemThree();
            case LIST_LAYOUT -> Buffer.insertItemList(6);
        }
        if (printLayout == PrintLayout.MENU_ON)
            Buffer.insertOptionsAnchors();
        Output.printScreen();
    }
}
