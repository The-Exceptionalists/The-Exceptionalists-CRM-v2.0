# The-Exceptionalists-CRM-v2.0

The Exceptionalists CRM was a terminal-based Customer Relationship Manager that allows you to track leads, convert them
into opportunities and many more features!

Now, The Exceptionalists 2.0 also allow the user to insert data into a MySQL Database and also get reports from this.

Besides, all the reports you make **will be added into a PDF file**.

Developed in **bright 16-bit colors**, you can easily store all you customer-related data and navigate through a fancy
interface.

## Installation

1. Download the proyect from the repository.

2. Open the directory as a project on a IDE as IntelliJ.

3. Go into your application.properties and add or replace the line `spring.datasource.url`

```bash   
spring.datasource.url=jdbc:mysql://localhost:3306/crm?serverTimezone=UTC
```

4. Also in application.properties update the lines
   `spring.datasource.username=username` and `spring.datasource.password=password` with your username and password (NOT TO BE CONFUSED WITH THE LOGIN CREDENTIALS FOR THE ACTUAL APP).


5. Run the ConsoleApp.java file on the path:

```bash
 ./src/main/java/com/ironhack/TheExceptionalistsCRMv20/ConsoleApp.java
```

6. Introduce ironhacker as username and bet4TE$t as password to login.

## Functionalities

- **NEW LEAD:** Use this command to create new leads. The console will prompt you with the information needed.
- **SHOW <objectInPlural>** : Write "Show + any type of object (Account, Lead, Contact, Opportunity)" and you will be
  shown a list of all the objects of that class stored in the database.
- **CONVERT <ID>:** Enter convert + the id of a lead and it will be converted into an opportunity.
- **LOOKUP <Object> <id>:** Write the type of object you are searching and the specific id and all its information will
  be shown on screen.
- **CLOSE-WON <id>**: Closes an opportunity and marks it as won.
- **CLOSE-LOST <id>**: Closes an opportunity and marks it as lost.
- **REPORT <
  Lead/Opportunity/CLOSED-WON/CLOSED-LOST/OPEN>                                                                     
  by <SalesRep/Product/Country/City/Industry>**: Find the report you need about your opportunities by Salesrep, product,
  country, city or industry.
- **MEAN <EmployeeCount/Quantity/Opps per Account>**: Get the Mean of your employee count, quantity, and opportunities.
- **MEDIAN <EmployeeCount/Quantity/Opps per Account>**: Get the Median of your employee count, quantity, and
  opportunities.
- **MAX <EmployeeCount/Quantity/Opps per Account>**: Get the Max of your employee count, quantity, and opportunities.
- **MIN <EmployeeCount/Quantity/Opps per Account>**: Get the Min of your employee count, quantity, and opportunities.
- **PDF** : Export all the reports and stats into one PDF. The PDFs can be found at resources/reports/.
- **HELP** : A list of the command of the program.
- **EXIT:** Write exit to save your database and terminate the session.

## Diagrams

- Case Diagram:

![alt text](https://github.com/The-Exceptionalists/The-Exceptionalists-CRM-v2.0/blob/main/src/main/resources/diagrams/TheDataLayer-UseCase-Diagram.png)

- Class Diagram:

![alt text](https://github.com/The-Exceptionalists/The-Exceptionalists-CRM-v2.0/blob/main/src/main/resources/diagrams/CRM_Exceptionalists.jpeg)

- Relations Diagram

![alt text](https://github.com/The-Exceptionalists/The-Exceptionalists-CRM-v2.0/blob/main/src/main/resources/diagrams/er_model.png)

## Usage

The application starts with a fancy layout where a list of many the commands is shown in a window at the right side. The
rest can be found if your write the command help.

The central window will contain the information of the objects the user wants to check, while the window at the bottom
will prompt the required values in some of the operations.

**The navigation system in this project is pretty straight-forward:** the user has to enter a command from the list, and
the application will prompt the user with the required values while specifying them in the prompt window. Each time the
user enters an incorrect command or incorrect value, the user will be informed and asked to enter the command or value
correctly.

## Screenshots

![alt text](https://github.com/The-Exceptionalists/The-Exceptionalists-CRM-v2.0/blob/main/src/main/resources/screenshots/screen1.jpg)
![alt text](https://github.com/The-Exceptionalists/The-Exceptionalists-CRM-v2.0/blob/main/src/main/resources/screenshots/screen2.jpg)
![alt text](https://github.com/The-Exceptionalists/The-Exceptionalists-CRM-v2.0/blob/main/src/main/resources/screenshots/screen3.jpg)
![alt text](https://github.com/The-Exceptionalists/The-Exceptionalists-CRM-v2.0/blob/main/src/main/resources/screenshots/screen4.jpg)
![alt text](https://github.com/The-Exceptionalists/The-Exceptionalists-CRM-v2.0/blob/main/src/main/resources/screenshots/screen5.jpg)

## Authors

**The Excepcionalist Team**: Adrià López, Jaume Sánchez, Salvatore Corsaro, Antonio Navarro, Iván Trujillo.
