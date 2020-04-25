package com.javaweb.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.Exception.TransactionFailedException;
import com.javaweb.annotation.HandleRequest;
import com.javaweb.annotation.RequestMapping;
import com.javaweb.annotation.RestController;
import com.javaweb.enums.RequestMethod;
import com.javaweb.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@WebServlet(urlPatterns= {"/api-server/staff/*"})
public class UserAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	IUserService service;

	@RequestMapping(value="/assign-building",method= RequestMethod.GET)
	private List<Map<String,Object>> getAssignBuilding(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String idString = req.getParameter("id");
		Long id = Long.valueOf(idString);
		List<Map<String,Object>> results =  service.findAssignmentByBuildingId(id);
		return results;
	}

	@RequestMapping(value="/assign-customer",method= RequestMethod.GET)
	private List<Map<String,Object>> getAssignCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		String idString = req.getParameter("id");
		Long id = Long.valueOf(idString);
		List<Map<String,Object>> results =  service.findAssignmentByCustomerId(id);
		return results;
	}

	@RequestMapping(value="/assign-building",method= RequestMethod.POST)
	private boolean assignBuilding(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		Map<String,Object> map = new ObjectMapper().readValue(req.getReader().lines().collect(Collectors.joining()),Map.class);
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
		return result;
	}


	@RequestMapping(value="/assign-customer",method= RequestMethod.POST)
	private boolean assignCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		Map<String,Object> map = new ObjectMapper().readValue(req.getReader().lines().collect(Collectors.joining()),Map.class);
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
		return result;
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
