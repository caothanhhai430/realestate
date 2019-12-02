package com.javaweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.impl.BuildingService;
import com.javaweb.utils.FormUtils;


@WebServlet(urlPatterns = {"/admin/building"})
public class BuildingController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4303714809779015402L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		BuildingService service = new BuildingService();
		PageRequest PageRequest = FormUtils.toModel(PageRequest.class, req);
		BuildingDTO buildRequest = FormUtils.toModel(BuildingDTO.class, req);
		
		
		List<BuildingDTO> results = service.findAll(buildRequest,PageRequest);
		req.setAttribute("buildingList", results);
		RequestDispatcher rd = req.getRequestDispatcher("/views/buildinglist.jsp");
		
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}
