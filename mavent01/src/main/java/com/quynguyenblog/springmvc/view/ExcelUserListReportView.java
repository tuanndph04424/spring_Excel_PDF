package com.quynguyenblog.springmvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.quynguyenblog.springmvc.model.User;

public class ExcelUserListReportView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		response.setHeader("Content-Disposition", "attachment: filename=\"user_listxls\"");
		@SuppressWarnings("unchecked")
		List<User> list =(List<User>) model.get("userList");
		Sheet sheet = workbook.createSheet("User List");
		
		// header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("USERNAME");
		header.createCell(2).setCellValue("First Name");
		header.createCell(3).setCellValue("LAST Name");
		int rowNum = 1;
		for(User user : list){
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(user.getId());
			row.createCell(1).setCellValue(user.getUsername());			
			row.createCell(2).setCellValue(user.getFirstname());			
			row.createCell(3).setCellValue(user.getLastname());
			
			
			
		}
		
		
		
	}

}
