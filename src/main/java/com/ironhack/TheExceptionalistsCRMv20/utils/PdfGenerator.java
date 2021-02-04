package com.ironhack.TheExceptionalistsCRMv20.utils;


import com.ironhack.TheExceptionalistsCRMv20.model.*;
import com.ironhack.TheExceptionalistsCRMv20.repository.*;
import com.itextpdf.text.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.*;
import org.springframework.beans.factory.annotation.*;
import org.w3c.dom.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.util.*;
import java.util.List;

public class PdfWriter {


    private LeadRepository leadRepository;
    private OpportunityRepository opportunityRepository;
    private AccountRepository accountRepository;
    private SalesRepRepository salesRepRepository;
    private ContactRepository contactRepository;

    public PdfWriter(LeadRepository leadRepository, ContactRepository contactRepository, OpportunityRepository opportunityRepository, AccountRepository accountRepository, SalesRepRepository salesRepRepository) {
        this.leadRepository = leadRepository;
        this.contactRepository = contactRepository;
        this.opportunityRepository = opportunityRepository;
        this.accountRepository = accountRepository;
        this.salesRepRepository = salesRepRepository;

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
