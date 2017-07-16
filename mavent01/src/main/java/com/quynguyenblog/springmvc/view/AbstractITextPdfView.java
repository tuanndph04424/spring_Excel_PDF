package com.quynguyenblog.springmvc.view;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class AbstractITextPdfView extends AbstractView {

	
	 public AbstractITextPdfView() {
	        setContentType("application/pdf");
	    }

	    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {}

	    protected abstract void buildPdfDocument(Map<String, Object> model,
	                                             Document document,
	                                             PdfWriter writer,
	                                             HttpServletRequest request,
	                                             HttpServletResponse response) throws Exception;

	    @Override
	    protected void renderMergedOutputModel(Map<String, Object> model,
	                                           HttpServletRequest request,
	                                           HttpServletResponse response) throws Exception {

	        ByteArrayOutputStream out = createTemporaryOutputStream();
	        Document document = new Document(PageSize.A4);
	        PdfWriter writer = PdfWriter.getInstance(document, out);
	        writer.setViewerPreferences(PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage);
	        buildPdfMetadata(model, document, request);

	        document.open();
	        buildPdfDocument(model, document, writer, request, response);
	        document.close();
	        writeToResponse(response, out);
	    }

	    @Override
	    protected boolean generatesDownloadContent() {
	        return true;
	    }
	
	
	
}
