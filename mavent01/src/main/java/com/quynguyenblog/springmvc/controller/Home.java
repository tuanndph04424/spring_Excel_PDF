package com.quynguyenblog.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quynguyenblog.springmvc.model.User;
import com.quynguyenblog.springmvc.view.ExcelUserListReportView;
import com.quynguyenblog.springmvc.view.ItextPdfView;

@Controller
@RequestMapping(value = "/")
public class Home {

	@RequestMapping(value = "report")
	public ModelAndView userListReport(HttpServletRequest req, HttpServletResponse res) {

		String typeReport = req.getParameter("type");

		List<User> list = new ArrayList<User>();
		list.add(new User(1, "userName 1", "firstname 1", "lastname 1"));
		list.add(new User(2, "userName 2", "firstname 2", "lastname 1"));
		list.add(new User(3, "userName 3", "firstname 3", "lastname 1"));
		list.add(new User(4, "userName 4", "firstname 4", "lastname 1"));
		list.add(new User(5, "userName 5", "firstname 5", "lastname 1"));
		list.add(new User(6, "userName 6", "firstname 6", "lastname 1"));

		if (typeReport != null && typeReport.equals("xls")) {
			return new ModelAndView(new ExcelUserListReportView(), "userList", list);

		} else if (typeReport != null && typeReport.equals("pdf")) {

			return new ModelAndView(new ItextPdfView(), "userList", list);

		}

		return new ModelAndView("userListReport", "userList", list);

	}
}
