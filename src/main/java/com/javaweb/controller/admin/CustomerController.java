package com.javaweb.controller.admin;

import com.javaweb.dto.CustomerDTO;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.IUserService;
import com.javaweb.utils.EnumUtils;
import com.javaweb.utils.FormUtils;

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


@WebServlet(urlPatterns = {"/admin/customer"})
public class CustomerController extends HttpServlet{

	@Inject
	private ICustomerService service;

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = -4303714809779015402L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		List<Map<String,Object>> listActiveStaff = userService.findAllActiveStaff();
		req.setAttribute("staffMap",listActiveStaff);

		RequestDispatcher rd = req.getRequestDispatcher("/views/customer/customerlist.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
