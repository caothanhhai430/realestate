package com.javaweb.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import com.javaweb.service.impl.BuildingService;
import com.javaweb.utils.EnumUtils;
import com.javaweb.utils.FormUtils;


@WebServlet(urlPatterns = {"/admin/building"})
public class BuildingController extends HttpServlet{

	@Inject
	private IBuildingService service;

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = -4303714809779015402L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String,String> districtsMap = EnumUtils.getDistricts();
		Map<String,String> buildingTypesMap = EnumUtils.getBuildingTypes();
		List<Map<String,Object>> listActiveStaff = userService.findAllActiveStaff();
		req.setAttribute("staffMap",listActiveStaff);
		req.setAttribute("districtsMap",districtsMap);
		req.setAttribute("buildingTypesMap",buildingTypesMap);
		RequestDispatcher rd = req.getRequestDispatcher("/views/building/buildinglist.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
