package com.ironhack.TheExceptionalistsCRMv20.utils;


import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.*;
import org.w3c.dom.*;

import java.io.*;

public class PdfWriter {

    public static void createPdf() throws IOException {
        String filename = "sample.pdf";
        String message = "CRM Report";

        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDFont font = PDType1Font.HELVETICA_BOLD;

            PDPageContentStream contents1 = new PDPageContentStream(doc, page);
            contents1.setLeading(16f);
            contents1.beginText();
            contents1.setFont(font, 30);
            contents1.newLineAtOffset(25, 700);
            contents1.showText(message);
            font = PDType1Font.HELVETICA;
            contents1.setFont(font, 16);
            contents1.newLine();
            contents1.showText("Prueba");
            contents1.endText();
            contents1.close();



            doc.save(filename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }
}
