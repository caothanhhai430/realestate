package com.javaweb.controller.admin;

import com.javaweb.annotation.HandleRequest;
import com.javaweb.annotation.RequestMapping;
import com.javaweb.enums.RequestMethod;
import com.javaweb.service.IUserService;
import com.javaweb.utils.EnumUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = {"/admin/building/*"})
public class BuildingController extends HttpServletCustom {

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = -4303714809779015402L;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String,String> districtsMap = EnumUtils.getDistricts();
		Map<String,String> buildingTypesMap = EnumUtils.getBuildingTypes();
		List<Map<String,Object>> listActiveStaff = userService.findAllActiveStaff();
		req.setAttribute("staffMap",listActiveStaff);
		req.setAttribute("districtsMap",districtsMap);
		req.setAttribute("buildingTypesMap",buildingTypesMap);
		RequestDispatcher rd = req.getRequestDispatcher("/views/building/buildinglist.jsp");
		rd.forward(req, resp);
	}



}
