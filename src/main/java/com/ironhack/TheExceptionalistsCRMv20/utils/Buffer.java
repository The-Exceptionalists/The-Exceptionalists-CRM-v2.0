package com.ironhack.TheExceptionalistsCRMv20.utils;

import com.ironhack.TheExceptionalistsCRMv20.model.*;

import java.util.Arrays;

public class Buffer {


    /**
     * boxes dimension
     * logo 4*4
     * app_name 20
     * company_name 20
     * username 20
     * central_box 78*8 (probably will need to think of a way to make it scroll)
     * side_box 20*15
     * prompt_box 78*4
     */

    static char[][] screenBuffer = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    private static final String singleSpace = " ";
    private static String appName = singleSpace + "DÉJÀ VU: your console CRM ";
    private static String companyName = singleSpace + "GlobalService Co.";
    private static String userName = singleSpace + "IronHacker";
    private static String currentLanguage = singleSpace + "En";
    private static String promptLineOne = "";
    private static String promptLineTwo = "";
    private static String resultItem = "Result ";
    private static String appVersion = "ver: 2.0";
    private static String reportColTwo = "Count";
    private static String reportColOne = "";


    private static String[] stringsRepository;


    public static void initStringsRepository() {
        stringsRepository = new String[60];
        Arrays.fill(stringsRepository, "");
    }

    public static void insertStringIntoRepository(String str, int index) {
        if (index > stringsRepository.length - 1 || index < 0) {
            throw new IllegalArgumentException();
        }
        stringsRepository[index] = str;
    }

    public static String getStringFromRepository(int index) {
        if (index > stringsRepository.length - 1 || index < 0) {
            throw new IllegalArgumentException();
        }
        return stringsRepository[index];
    }

    public static void resetScreenBuffer() {
        for (int i = 0; i < Buffer.screenBuffer.length; i++) {
            for (int j = 0; j < Buffer.screenBuffer[i].length; ++j)
                screenBuffer[i][j] = ' ';
        }
    }

    public static void printSize() {
        System.out.println("Map size:");
        System.out.println("w: " + screenBuffer[0].length);
        System.out.println("h: " + screenBuffer.length);
    }

    public static void insertCentralBox() {
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 42; j++) {
                screenBuffer[6 + i][2 + j] = 'B';
            }
        }
    }

    public static void insertCentralPrompt() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 42; j++) {
                screenBuffer[24 + i][2 + j] = 'P';
            }
        }
    }

    public static void insertCentralPromptPoints(int itemIndex) {
        switch (itemIndex) {
            case 1 -> {
                screenBuffer[25][4] = 'p';
                screenBuffer[25][5] = '1';
            }
            case 2 -> {
                screenBuffer[26][4] = 'p';
                screenBuffer[26][5] = '2';
            }
            default -> throw new IllegalStateException("Unexpected value: " + itemIndex);
        }
    }

    public static void insertVersionIndicator() {
        screenBuffer[27][53] = 'v';
    }

    public static void insertLogo() {
        screenBuffer[1][2] = ' ';
        screenBuffer[1][3] = ' ';
        screenBuffer[1][4] = 'm';
        screenBuffer[1][5] = 'm';
        screenBuffer[1][6] = 'm';
        screenBuffer[2][2] = 'n';
        screenBuffer[2][3] = 'n';
        screenBuffer[2][4] = 'n';
        screenBuffer[2][5] = 'm';
        screenBuffer[2][6] = 'm';
        screenBuffer[3][2] = 'n';
        screenBuffer[3][3] = 'n';
        screenBuffer[3][4] = 'n';
        screenBuffer[3][5] = 'm';
        screenBuffer[3][6] = 'm';
        screenBuffer[4][2] = 'n';
        screenBuffer[4][3] = 'n';
        screenBuffer[4][4] = 'n';
        screenBuffer[4][5] = ' ';
        screenBuffer[4][6] = ' ';
    }

    public static void insertAppName() {
        screenBuffer[1][8] = 'A';
    }

    public static void insertUserName() {
        screenBuffer[1][47] = 'U';
    }

    public static void insertCompanyName() {
        screenBuffer[3][8] = 'C';

    }

    public static void insertSideBox() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 15; j++) {
                screenBuffer[4 + i][47 + j] = 'S';
            }
        }
    }

    public static void insertOptionsAnchors() {
        for (int i = 0; i < 17; i++) {
            screenBuffer[4 + i][48] = 's';
            screenBuffer[4 + i][48 + 1] = (char) ('a' + i);
        }
    }

    public static void insertItemSolo() {
        int startingRow = 13;
        char startingLocationA = 'a';
        char startingLocationB = 'e';

        screenBuffer[startingRow - 1][4] = 'i';
        screenBuffer[startingRow - 1][5] = '1';

        for (int i = 0; i < 4; i++) {
            screenBuffer[startingRow + i][4] = 'i';
            screenBuffer[startingRow + i][5] = (char) (startingLocationA + i);
        }

        for (int i = 0; i < 4; i++) {
            screenBuffer[startingRow + i][24] = 'i';
            screenBuffer[startingRow + i][25] = (char) (startingLocationB + i);
        }
    }

    public static void insertItemThree() {
        int startingRow = 7;
        char startingLocationA = 'a';
        char startingLocationB = 'e';

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0 -> startingRow = 7;
                case 1 -> startingRow = 12;
                case 2 -> startingRow = 17;
            }
            screenBuffer[startingRow - 1][4] = 'i';
            screenBuffer[startingRow - 1][5] = (char) ('1' + i);


            for (int j = 0; j < 4; j++) {
                screenBuffer[startingRow + j][4] = 'i';
                screenBuffer[startingRow + j][5] = (char) (startingLocationA + i);
                screenBuffer[startingRow + i][24] = 'i';
                screenBuffer[startingRow + i][25] = (char) (startingLocationB + i);
            }

        }
    }

    public static void prepareHelpPage() {
        int startingRepository = 10;
        insertStringIntoRepository("List of Commands Available:", startingRepository += 2);
        insertStringIntoRepository("NEW LEAD", startingRepository += 2);
        insertStringIntoRepository("SHOW <ObjectInPlural>: Show a list of objects", startingRepository += 2);
        insertStringIntoRepository("CONVERT ID: Start the process to convert a lead to opportunity", startingRepository += 2);
        insertStringIntoRepository("LOOKUP <Object> <Id>: Show an object by his id", startingRepository += 2);
        insertStringIntoRepository("CLOSE-WON <Id>: Closes an opportunity and marks it as won", startingRepository += 2);
        insertStringIntoRepository("CLOSE-Close <Id>: Closes an opportunity and marks it as lost", startingRepository += 2);
        insertStringIntoRepository("REPORT <Lead/Opportunity/CLOSED-WON/CLOSED-LOST/OPEN>", startingRepository += 2);
        insertStringIntoRepository("          by <SalesRep/Product/Country/City/Industry>", startingRepository += 2);
        insertStringIntoRepository("MEAN <EmployeeCount/Quantity/Opps per Account>", startingRepository += 2);
        insertStringIntoRepository("MEDIAN <EmployeeCount/Quantity/Opps per Account>", startingRepository += 2);
        insertStringIntoRepository("MAX <EmployeeCount/Quantity/Opps per Account>", startingRepository += 2);
        insertStringIntoRepository("MIN <EmployeeCount/Quantity/Opps per Account>", startingRepository += 2);
        insertStringIntoRepository("PDF : Generates a file with all reports and stats", startingRepository += 2);
    }

    public static void insertItemList(int startingRow) {
        char startingLocation = 'a';

        for (int i = 0; i < 15; i++) {
            screenBuffer[startingRow + i][4] = 'g';
            screenBuffer[startingRow + i][5] = (char) (startingLocation + i);
        }
    }

    public static void insertSalesRepStringRepository(SalesRep salesRep, int resultIndex, int listIndex) {
        int startingRepository = 0;
        switch (listIndex) {
            case 1 -> startingRepository = 10;
            case 2 -> startingRepository = 16;
            case 3 -> startingRepository = 22;
        }
        insertStringIntoRepository(getResultItem() + resultIndex, startingRepository++);
        insertStringIntoRepository(String.valueOf(salesRep.getId()), startingRepository++);
        insertStringIntoRepository(salesRep.getName(), startingRepository++);
    }

    /**
     * Extract data from Lead
     *
     * @param lead
     * @param resultIndex
     * @param listIndex
     */
    public static void insertLeadStringRepository(Lead lead, int resultIndex, int listIndex) {
        int startingRepository = 0;
        switch (listIndex) {
            case 1 -> startingRepository = 10;
            case 2 -> startingRepository = 16;
            case 3 -> startingRepository = 22;
        }
        insertStringIntoRepository(getResultItem() + resultIndex, startingRepository++);
        insertStringIntoRepository(lead.getIdToPrint(), startingRepository++);
        insertStringIntoRepository(lead.getNameToPrint(), startingRepository++);
        insertStringIntoRepository(lead.getPhoneNumberToPrint(), startingRepository++);
        insertStringIntoRepository(lead.getEmailToPrint(), startingRepository++);
        insertStringIntoRepository(lead.getCompanyNameToPrint(), startingRepository++);
        insertStringIntoRepository(lead.getSalesRepToPrint(), startingRepository++);

    }

    /**
     * Extract data from Opportunity
     *
     * @param opportunity
     * @param resultIndex
     * @param listIndex
     */
    public static void insertOpportunityStringRepository(Opportunity opportunity, int resultIndex, int listIndex) {
        int startingRepository = 0;
        switch (listIndex) {
            case 1 -> startingRepository = 10;
            case 2 -> startingRepository = 16;
            case 3 -> startingRepository = 22;
        }
        insertStringIntoRepository(getResultItem() + resultIndex, startingRepository++);
        insertStringIntoRepository(opportunity.getIdToPrint(), startingRepository++);
        insertStringIntoRepository(opportunity.getDecisionMaker().getNameToPrint(), startingRepository++);
        insertStringIntoRepository(opportunity.getProductToPrint(), startingRepository++);
        insertStringIntoRepository(opportunity.getQuantityToPrint(), startingRepository++);
        insertStringIntoRepository(opportunity.getStatusToPrint(), startingRepository++);
    }

    /**
     * Extract data from Contact
     *
     * @param contact
     * @param resultIndex
     * @param listIndex
     */
    public static void insertContactStringRepository(Contact contact, int resultIndex, int listIndex) {
        int startingRepository = 0;
        switch (listIndex) {
            case 1 -> startingRepository = 10;
            case 2 -> startingRepository = 16;
            case 3 -> startingRepository = 22;
        }
        insertStringIntoRepository(getResultItem() + resultIndex, startingRepository++);
        insertStringIntoRepository(contact.getIdToPrint(), startingRepository++);
        insertStringIntoRepository(contact.getNameToPrint(), startingRepository++);
        insertStringIntoRepository(contact.getPhoneNumber(), startingRepository++);
        insertStringIntoRepository(contact.getEmail(), startingRepository++);
        insertStringIntoRepository(contact.getCompanyName(), startingRepository++);
    }

    /**
     * Insert data from account
     *
     * @param account
     * @param resultIndex
     * @param listIndex
     */
    public static void insertAccountStringRepository(Account account, int resultIndex, int listIndex) {
        int startingRepository = 0;
        switch (listIndex) {
            case 1 -> startingRepository = 10;
            case 2 -> startingRepository = 16;
            case 3 -> startingRepository = 22;
        }
        insertStringIntoRepository(getResultItem() + resultIndex, startingRepository++);
        insertStringIntoRepository(account.getIdToPrint(), startingRepository++);
        insertStringIntoRepository(account.getCompanyNameToPrint(), startingRepository++);
        insertStringIntoRepository(account.getIndustryToPrint(), startingRepository++);
        insertStringIntoRepository(account.getEmployeeCountToPrint(), startingRepository++);
        insertStringIntoRepository(account.getCityToPrint(), startingRepository++);
        insertStringIntoRepository(account.getCountryToPrint(), startingRepository++);
    }

    /**
     * Method that prepare the screen layout
     */
    public static void setUpLayout() {
        resetScreenBuffer();
        insertCentralBox();
        insertUserName();
        insertCentralPrompt();
        insertLogo();
        insertAppName();
        insertCompanyName();
        insertSideBox();
        insertOptionsAnchors();
        insertVersionIndicator();
    }

    public static void resetPromptMessages() {
        promptLineOne = "";
        promptLineTwo = "";
    }

    public static void resetPromptOne() {
        promptLineOne = "";
    }

    public static String getAppName() {
        return appName;
    }

    public static void setAppName(String appName) {
        Buffer.appName = appName;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        Buffer.companyName = companyName;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Buffer.userName = userName;
    }

    public static String getCurrentLanguage() {
        return currentLanguage;
    }

    public static void setCurrentLanguage(String currentLanguage) {
        Buffer.currentLanguage = currentLanguage;
    }

    public static String getPromptLineOne() {
        return promptLineOne;
    }

    public static void setPromptLineOne(String promptLineOne) {
        Buffer.promptLineOne = promptLineOne;
    }

    public static String getPromptLineTwo() {
        return promptLineTwo;
    }

    public static void setPromptLineTwo(String promptLineTwo) {
        Buffer.promptLineTwo = promptLineTwo;
    }

    public static String getResultItem() {
        return resultItem;
    }

    public static void setResultItem(String resultItem) {
        Buffer.resultItem = resultItem;
    }

    public static String getAppVersion() {
        return appVersion;
    }

    public static void setAppVersion(String appVersion) {
        Buffer.appVersion = appVersion;
    }

    public static String[] getStringsRepository() {
        return stringsRepository;
    }

    public static void setStringsRepository(String[] stringsRepository) {
        Buffer.stringsRepository = stringsRepository;
    }

    public static String getReportColTwo() {
        return reportColTwo;
    }

    public static void setReportColTwo(String reportColTwo) {
        Buffer.reportColTwo = reportColTwo;
    }

    public static String getReportColOne() {
        return reportColOne;
    }

    public static void setReportColOne(String reportColOne) {
        Buffer.reportColOne = reportColOne;
    }
}
