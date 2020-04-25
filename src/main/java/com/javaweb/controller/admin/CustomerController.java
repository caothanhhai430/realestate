package com.javaweb.controller.admin;

import com.javaweb.annotation.HandleRequest;
import com.javaweb.annotation.RequestMapping;
import com.javaweb.enums.RequestMethod;
import com.javaweb.service.IUserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/admin/customer/*"})
public class CustomerController extends HttpServlet{

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = -4303914889769016402L;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		List<Map<String,Object>> listActiveStaff = userService.findAllActiveStaff();
		req.setAttribute("staffMap",listActiveStaff);
		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/customerlist.jsp");
		rd.forward(req, resp);
	}


	@Override
	@HandleRequest
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}


	@Override
	@HandleRequest
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}


}
