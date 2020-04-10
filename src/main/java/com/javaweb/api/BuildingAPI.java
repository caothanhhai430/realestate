package com.javaweb.api;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.impl.BuildingService;
import com.javaweb.utils.FormUtils;
import com.javaweb.utils.HttpUtil;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns= {"/api-server/building"})
public class BuildingAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	IBuildingService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String request = req.getParameter("request");
		switch (request){
			case "list" :
				list(req,resp);
				break;
			case "count" :
				count(req,resp);
				break;
			case "find-by-id":
				findById(req,resp);
				break;
		}
	}


	private void findById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		String stringId= req.getParameter("id");
		if(stringId==null) {
			resp.setStatus(500);
			return;
		}
		Long id = null;
		try	{
			id = Long.valueOf(stringId);
			BuildingDTO buildRequest = FormUtils.toModel(BuildingDTO.class, req);
			BuildingDTO buildingDTO = service.findById(id);
			obj.writeValue(resp.getOutputStream(), buildingDTO);
		}catch (Exception e){
			e.printStackTrace();
			resp.setStatus(500);
		}

	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		BuildingDTO buildRequest = FormUtils.toModel(BuildingDTO.class, req);
		PageRequest PageRequest = FormUtils.toModel(PageRequest.class, req);
		List<BuildingDTO> results = service.findAll(buildRequest,PageRequest);
		obj.writeValue(resp.getOutputStream(), results);

	}

	private void count(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		BuildingDTO buildRequest = FormUtils.toModel(BuildingDTO.class, req);
		long  count= service.count(buildRequest);
		obj.writeValue(resp.getOutputStream(), count);

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
		
		
		Long id = service.save(building);
		
		BuildingDTO get = service.findById(id);
		obj.writeValue(resp.getOutputStream(), get);
		
	}
	

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		BuildingDTO building = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		service.update(building);
		BuildingDTO get = service.findById(building.getId());
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(resp.getOutputStream(), get);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper obj = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String ids = req.getReader().lines().collect(Collectors.joining()).replaceAll(" ","").split(":")[1];
		ids = ids.substring(1,ids.length()-2);
		String[] arr = ids.replaceAll("\\s+", "").split(",");
		List<Long> arrIds = Arrays.asList(arr).stream().map(e-> Long.valueOf(e)).collect(Collectors.toList());
		boolean res = service.delete(arrIds);
		obj.writeValue(resp.getOutputStream(), res);
	}
}
