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

    private LeadRepository leadRepository;
    private OpportunityRepository opportunityRepository;
    private AccountRepository accountRepository;
    private SalesRepRepository salesRepRepository;
    private ContactRepository contactRepository;

    //Report
    private List<Object[]> leadsBySalesReps = leadRepository.countOfLeadsBySalesReps();
    private List<Object[]> opportunitiesBySalesReps = opportunityRepository.countOfOpportunitiesBySalesReps();
    private List<Object[]> ofOpportunitiesBySalesRepsWhereClosedWon = opportunityRepository.countOfOpportunitiesBySalesRepsWhereClosedWon();
    private List<Object[]> countOfOpportunitiesBySalesRepsWhereClosedLost = opportunityRepository.countOfOpportunitiesBySalesRepsWhereClosedLost();
    private List<Object[]> countOfOpportunitiesBySalesRepsWhereOpen = opportunityRepository.countOfOpportunitiesBySalesRepsWhereOpen();
    //Stats
    //By Product
    private List<Object[]> countOfLeadsByProduct = leadRepository.countOfLeadsByProduct();
    private List<Object[]> countOfOpportunitiesByProduct = opportunityRepository.countOfOpportunitiesByProduct();
    private List<Object[]> countOfOpportunitiesByProductWhereClosedWon = opportunityRepository.countOfOpportunitiesByProductWhereClosedWon();
    private List<Object[]> countOfOpportunitiesByProductWhereClosedLost = opportunityRepository.countOfOpportunitiesByProductWhereClosedLost();
    private List<Object[]> countOfOpportunitiesByProductWhereOpen = opportunityRepository.countOfOpportunitiesByProductWhereOpen();
    //By country
    private List<Object[]> countOfLeadsByCountry = leadRepository.countOfLeadsByCountry();
    private List<Object[]> countOfOpportuntiesByCountry = opportunityRepository.countOfOpportuntiesByCountry();
    private List<Object[]> countOfOpportuntiesByCountryWhereClosedWon = opportunityRepository.countOfOpportuntiesByCountryWhereClosedWon();
    private List<Object[]> countOfOpportuntiesByCountryWhereClosedLost = opportunityRepository.countOfOpportuntiesByCountryWhereClosedLost();
    private List<Object[]> countOfOpportuntiesByCountryWhereOpen = opportunityRepository.countOfOpportuntiesByCountryWhereOpen();
    //By City
    private List<Object[]> countOfLeadsByCity = leadRepository.countOfLeadsByCity();
    private List<Object[]> countOfOpportuntiesByCity = opportunityRepository.countOfOpportuntiesByCity();
    private List<Object[]> countOfOpportuntiesByCityWhereClosedWon = opportunityRepository.countOfOpportuntiesByCityWhereClosedWon();
    private List<Object[]> countOfOpportuntiesByCityWhereClosedLost = opportunityRepository.countOfOpportuntiesByCityWhereClosedLost();
    private List<Object[]> countOfOpportuntiesByCityWhereOpen = opportunityRepository.countOfOpportuntiesByCityWhereOpen();
    // By Industry
    private List<Object[]> countOfLeadsByIndustry = leadRepository.countOfLeadsByIndustry();
    private List<Object[]> countOfOpportuntiesByIndustry = opportunityRepository.countOfOpportuntiesByIndustry();
    private List<Object[]> countOfOpportuntiesByIndustryWhereClosedWon = opportunityRepository.countOfOpportuntiesByIndustryWhereClosedWon();
    private List<Object[]> countOfOpportuntiesByIndustryWhereClosedLost = opportunityRepository.countOfOpportuntiesByIndustryWhereClosedLost();
    private List<Object[]> countOfOpportuntiesByIndustryWhereOpen = opportunityRepository.countOfOpportuntiesByIndustryWhereOpen();

    private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.HELVETICA, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.HELVETICA, 12,
            Font.BOLD);


    public PdfGenerator(LeadRepository leadRepository, ContactRepository contactRepository, OpportunityRepository opportunityRepository, AccountRepository accountRepository, SalesRepRepository salesRepRepository) {
        this.leadRepository = leadRepository;
        this.contactRepository = contactRepository;
        this.opportunityRepository = opportunityRepository;
        this.accountRepository = accountRepository;
        this.salesRepRepository = salesRepRepository;

    }


    public void generatePdf() {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter.getInstance(document, new FileOutputStream("igenerate.pdf"));
            document.open();
            document.addTitle("Crm Test");



        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

 /*
 *       for (Object[] objects : result) {
            System.out.println(objects[0] + " " + objects[1]);
        }
 * */

    private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("Title of the document", catFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph(
                "This document describes something which is very important ",
                smallBold));

        addEmptyLine(preface, 8);

        preface.add(new Paragraph(
                "This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-).",
                redFont));

        document.add(preface);
        // Start a new page
        document.newPage();
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
        subCatPart.add(new Paragraph("Paragraph 2"));
        subCatPart.add(new Paragraph("Paragraph 3"));

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
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
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
