package com.quynguyenblog.springmvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.quynguyenblog.springmvc.model.User;

public class ItextPdfView extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<User> list = (List<User>) model.get("userList");

        PdfPTable table = new PdfPTable(4);
       

        table.addCell("ID");
        table.addCell("UserName");
        table.addCell("First Name");
        table.addCell("Last Name");
        
        
        for (User user : list){
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getUsername());
            table.addCell(user.getFirstname());
            table.addCell(user.getLastname());
            
        
        
        }



        document.add(table);
    }
}