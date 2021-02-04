package com.ironhack.TheExceptionalistsCRMv20.utils;


import com.ironhack.TheExceptionalistsCRMv20.model.*;
import com.ironhack.TheExceptionalistsCRMv20.repository.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.apache.pdfbox.pdmodel.*;
import java.util.List;
import org.apache.pdfbox.pdmodel.font.*;


import java.io.*;
import java.util.*;

public class PdfGenerator {

    private static LeadRepository leadRepository;
    private static OpportunityRepository opportunityRepository;
    private static AccountRepository accountRepository;
    private static SalesRepRepository salesRepRepository;
    private static ContactRepository contactRepository;

/*

    //Report
    private static List<Object[]> leadsBySalesReps = leadRepository.countOfLeadsBySalesReps();
    private static List<Object[]> opportunitiesBySalesReps = opportunityRepository.countOfOpportunitiesBySalesReps();
    private static List<Object[]> ofOpportunitiesBySalesRepsWhereClosedWon = opportunityRepository.countOfOpportunitiesBySalesRepsWhereClosedWon();
    private static List<Object[]> countOfOpportunitiesBySalesRepsWhereClosedLost = opportunityRepository.countOfOpportunitiesBySalesRepsWhereClosedLost();
    private static List<Object[]> countOfOpportunitiesBySalesRepsWhereOpen = opportunityRepository.countOfOpportunitiesBySalesRepsWhereOpen();
    //Stats
    //By Product
    private static List<Object[]> countOfLeadsByProduct = leadRepository.countOfLeadsByProduct();
    private static List<Object[]> countOfOpportunitiesByProduct = opportunityRepository.countOfOpportunitiesByProduct();
    private static List<Object[]> countOfOpportunitiesByProductWhereClosedWon = opportunityRepository.countOfOpportunitiesByProductWhereClosedWon();
    private static List<Object[]> countOfOpportunitiesByProductWhereClosedLost = opportunityRepository.countOfOpportunitiesByProductWhereClosedLost();
    private static List<Object[]> countOfOpportunitiesByProductWhereOpen = opportunityRepository.countOfOpportunitiesByProductWhereOpen();
    //By country
    private static List<Object[]> countOfLeadsByCountry = leadRepository.countOfLeadsByCountry();
    private static List<Object[]> countOfOpportuntiesByCountry = opportunityRepository.countOfOpportuntiesByCountry();
    private static List<Object[]> countOfOpportuntiesByCountryWhereClosedWon = opportunityRepository.countOfOpportuntiesByCountryWhereClosedWon();
    private static List<Object[]> countOfOpportuntiesByCountryWhereClosedLost = opportunityRepository.countOfOpportuntiesByCountryWhereClosedLost();
    private static List<Object[]> countOfOpportuntiesByCountryWhereOpen = opportunityRepository.countOfOpportuntiesByCountryWhereOpen();
    //By City
    private static List<Object[]> countOfLeadsByCity = leadRepository.countOfLeadsByCity();
    private static List<Object[]> countOfOpportuntiesByCity = opportunityRepository.countOfOpportuntiesByCity();
    private static List<Object[]> countOfOpportuntiesByCityWhereClosedWon = opportunityRepository.countOfOpportuntiesByCityWhereClosedWon();
    private static List<Object[]> countOfOpportuntiesByCityWhereClosedLost = opportunityRepository.countOfOpportuntiesByCityWhereClosedLost();
    private static List<Object[]> countOfOpportuntiesByCityWhereOpen = opportunityRepository.countOfOpportuntiesByCityWhereOpen();
    // By Industry
    private static List<Object[]> countOfLeadsByIndustry = leadRepository.countOfLeadsByIndustry();
    private static List<Object[]> countOfOpportuntiesByIndustry = opportunityRepository.countOfOpportuntiesByIndustry();
    private static List<Object[]> countOfOpportuntiesByIndustryWhereClosedWon = opportunityRepository.countOfOpportuntiesByIndustryWhereClosedWon();
    private static List<Object[]> countOfOpportuntiesByIndustryWhereClosedLost = opportunityRepository.countOfOpportuntiesByIndustryWhereClosedLost();
    private static List<Object[]> countOfOpportuntiesByIndustryWhereOpen = opportunityRepository.countOfOpportuntiesByIndustryWhereOpen();
*/

    private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.HELVETICA, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.HELVETICA, 12,
            Font.BOLD);
    private static Font smallItalics = new Font(Font.FontFamily.HELVETICA, 12,
            Font.ITALIC);




    public static void initRepos(LeadRepository leadRepository, ContactRepository contactRepository, OpportunityRepository opportunityRepository, AccountRepository accountRepository, SalesRepRepository salesRepRepository) {
        PdfGenerator.leadRepository = leadRepository;
        PdfGenerator.contactRepository = contactRepository;
        PdfGenerator.opportunityRepository = opportunityRepository;
        PdfGenerator.accountRepository = accountRepository;
        PdfGenerator.salesRepRepository = salesRepRepository;
    }


    public static void generatePdf() throws DocumentException, FileNotFoundException {
        Document document = new Document(PageSize.A4,50, 50, 50,5);
            PdfWriter.getInstance(document, new FileOutputStream("generate2.pdf"));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            //addleadsBySalesReps(document);
            addContent(document);
            document.close();


    }

 /*
 *       for (Object[] objects : result) {
            System.out.println(objects[0] + " " + objects[1]);
        }
 * */

    private static void addMetaData(Document document) {
        document.addTitle("CRM Report");
        document.addSubject("Report of your database");
        document.addAuthor("The Exceptionalists CRM 2.0");
        document.addCreator("The Exceptionalists CRM 2.0");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("The Exceptionalists CRM Report", catFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        preface.add(new Paragraph(
                "This file contains all reports and stats available at the exceptionalists CRM",
                smallItalics));

        addEmptyLine(preface, 1);

        document.add(preface);
        // Start a new page

    }




    private static void addContent(Document document) throws DocumentException {
        Anchor anchor = new Anchor("First Chapter", catFont);
        anchor.setName("First Chapter");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Hello"));

        subPara = new Paragraph("Subcategory 2", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Paragraph 1"));


        // add a list
        createList(subCatPart);
        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 5);
        subCatPart.add(paragraph);

        // add a table
        createTable(subCatPart);

        // now add all this to the document
        document.add(catPart);

        // Next section
        anchor = new Anchor("Second Chapter", catFont);
        anchor.setName("Second Chapter");

        // Second parameter is the number of the chapter
        catPart = new Chapter(new Paragraph(anchor), 1);

        subPara = new Paragraph("Subcategory", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("This is a very important message"));

        // now add all this to the document
        document.add(catPart);

    }

    private static void addleadsBySalesReps(Document document) throws DocumentException {
        Anchor anchor = new Anchor("Leads by Sales Rep", catFont);
        anchor.setName("Leads by Sales Rep");


        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
        Paragraph leadsParagraph = new Paragraph();

/*

        if (leadRepository != null) {
        for (Object object[] : leadsBySalesReps) {
            leadsParagraph.add((String) object[0] +": " + object[1]);
        }

        }
*/


        catPart.add(leadsParagraph);

        document.add(catPart);





    }

    private static void createTable(Section subCatPart)
            throws BadElementException {
        PdfPTable table = new PdfPTable(3);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);

        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 2"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 3"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("1.0");
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        subCatPart.add(table);

    }

    private static void createList(Section subCatPart) {
        com.itextpdf.text.List list = new com.itextpdf.text.List(true, false, 10);
        list.add(new ListItem("First point"));
        list.add(new ListItem("Second point"));
        list.add(new ListItem("Third point"));
        subCatPart.add(list);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }


    public void createPdf() throws IOException {
        String filename = "sample.pdf";
        String message = "CRM Report";

        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDFont font = PDType1Font.HELVETICA_BOLD;
            List<Lead> leads = leadRepository.findAll();

            PDPageContentStream contents1 = new PDPageContentStream(doc, page);
            contents1.setLeading(20f);
            contents1.beginText();
            contents1.setFont(font, 30);
            contents1.newLineAtOffset(25, 700);
            contents1.showText(message);
            font = PDType1Font.HELVETICA;
            contents1.newLine();
            contents1.setFont(font, 20);
            contents1.newLine();
            contents1.showText("Leads");
            contents1.setFont(font, 12);
            for (Lead lead : leads) {
                contents1.newLine();
                contents1.showText("Lead: " + lead.getId() + " Name: " + lead.getName());
                contents1.endText();
            }
            contents1.close();


            doc.save(filename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }
}
