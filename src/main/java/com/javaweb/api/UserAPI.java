package com.javaweb.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.Exception.TransactionFailedException;
import com.javaweb.dto.UserDTO;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.IUserService;
import com.javaweb.utils.FormUtils;
import com.javaweb.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns= {"/api-server/staff"})
public class UserAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	IUserService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String request = req.getParameter("request");
		switch (request){
			case "assign-building" :
				getAssignBuilding(req,resp);
				break;
			case "assign-customer" :
				getAssignCustomer(req,resp);
				break;
		}
	}


	private void getAssignBuilding(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		String idString = req.getParameter("id");
		Long id = Long.valueOf(idString);
		List<Map<String,Object>> results =  service.findAssignmentByBuildingId(id);
		obj.writeValue(resp.getOutputStream(), results);
	}


	private void getAssignCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		String idString = req.getParameter("id");
		Long id = Long.valueOf(idString);
		List<Map<String,Object>> results =  service.findAssignmentByCustomerId(id);
		obj.writeValue(resp.getOutputStream(), results);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String request = req.getParameter("request");
		switch (request){
			case "assign-building" :
				assignBuilding(req,resp);
				break;
			case "assign-customer" :
				assignCustomer(req,resp);
				break;
		}
	}


	private void assignBuilding(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		Map<String,Object> map = obj.readValue(req.getReader().lines().collect(Collectors.joining()),Map.class);
		Integer buildingId = (Integer) map.get("buildingId");
		List<Integer> ids = (List<Integer>) map.get("staffId");
		List<Long> arrIds = ids.stream().map(e-> e.longValue()).collect(Collectors.toList());
		boolean result = true;
		try {
			service.assignBuilding(arrIds,buildingId.longValue());
		}catch (TransactionFailedException e){
			e.printStackTrace();
			result = false;
		}
		obj.writeValue(resp.getOutputStream(), result);
	}


	private void assignCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		Map<String,Object> map = obj.readValue(req.getReader().lines().collect(Collectors.joining()),Map.class);
		Integer customerId = (Integer) map.get("customerId");
		List<Integer> ids = (List<Integer>) map.get("staffId");
		List<Long> arrIds = ids.stream().map(e-> e.longValue()).collect(Collectors.toList());
		boolean result = true;
		try {
			service.assignCustomer(arrIds,customerId.longValue());
		}catch (TransactionFailedException e){
			e.printStackTrace();
			result = false;
		}
		obj.writeValue(resp.getOutputStream(), result);
	}



}
