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
import com.javaweb.dto.CustomerDTO;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.impl.CustomerService;
import com.javaweb.utils.FormUtils;
import com.javaweb.utils.HttpUtil;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns= {"/api-server/customer"})
public class CustomerAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	ICustomerService service;

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
			CustomerDTO buildRequest = FormUtils.toModel(CustomerDTO.class, req);
			CustomerDTO customerDTO = service.findById(id);
			obj.writeValue(resp.getOutputStream(), customerDTO);
		}catch (Exception e){
			e.printStackTrace();
			resp.setStatus(500);
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		CustomerDTO buildRequest = FormUtils.toModel(CustomerDTO.class, req);
		PageRequest PageRequest = FormUtils.toModel(PageRequest.class, req);
		List<CustomerDTO> results = service.findAll(buildRequest,PageRequest);
		obj.writeValue(resp.getOutputStream(), results);

	}

	private void count(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		CustomerDTO buildRequest = FormUtils.toModel(CustomerDTO.class, req);
		long  count= service.count(buildRequest);
		obj.writeValue(resp.getOutputStream(), count);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper obj = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CustomerDTO customer = HttpUtil.of(req.getReader()).toModel(CustomerDTO.class);
		customer.setCreatedBy("admin");
		customer.setModifiedBy("admin");
		customer.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		customer.setModifiedDate(new Timestamp(System.currentTimeMillis()));

		Long id = service.save(customer);

		CustomerDTO get = service.findById(id);
		obj.writeValue(resp.getOutputStream(), get);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CustomerDTO customer = HttpUtil.of(req.getReader()).toModel(CustomerDTO.class);
		service.update(customer);
		CustomerDTO get = service.findById(customer.getId());
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(resp.getOutputStream(), get);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper obj = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Map<String,Object> map = obj.readValue(req.getReader().lines().collect(Collectors.joining()),Map.class);
		List<Integer> list = (List<Integer>) map.get("ids");
		List<Long> arrIds = list.stream().map(e-> e.longValue()).collect(Collectors.toList());
		boolean res = service.delete(arrIds);
		obj.writeValue(resp.getOutputStream(), res);
	}
}
