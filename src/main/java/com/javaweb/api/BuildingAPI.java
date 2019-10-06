package com.javaweb.api;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.impl.BuildingService;
import com.javaweb.utils.FormUtils;
import com.javaweb.utils.HttpUtil;

@WebServlet(urlPatterns= {"/api-server/building"})
public class BuildingAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		
		BuildingDTO buildRequest = FormUtils.toModel(BuildingDTO.class, req);
		
		BuildingService service = new BuildingService();
		PageRequest PageRequest = FormUtils.toModel(PageRequest.class, req);
		
		
		List<BuildingDTO> results = service.findAll(buildRequest,PageRequest);
		obj.writeValue(resp.getOutputStream(), results);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper obj = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		BuildingDTO building = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		building.setCreatedBy("admin");
		building.setModifiedBy("admin");
		building.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		building.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		
		BuildingService service = new BuildingService();
		Integer row = service.save(building);
		
		BuildingDTO get = service.findById(row);
		obj.writeValue(resp.getOutputStream(), get);
		
	}
	

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
