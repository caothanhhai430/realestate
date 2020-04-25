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
import com.javaweb.annotation.HandleRequest;
import com.javaweb.annotation.RequestMapping;
import com.javaweb.annotation.RestController;
import com.javaweb.dto.CustomerDTO;
import com.javaweb.enums.RequestMethod;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.impl.CustomerService;
import com.javaweb.utils.FormUtils;
import com.javaweb.utils.HttpUtil;
import org.apache.commons.beanutils.BeanUtils;

@RestController
@WebServlet(urlPatterns= {"/api-server/customer/*"})
public class CustomerAPI extends HttpServlet{

	private static final long serialVersionUID = 13213213213214124L;

	@Inject
	ICustomerService service;

	@RequestMapping(value = "/find-by-id",method = RequestMethod.GET)
	private CustomerDTO findById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String stringId= req.getParameter("id");
		if(stringId==null) {
			return null;
		}
		try	{
			Long id = Long.valueOf(stringId);
			CustomerDTO customerDTO = service.findById(id);
			return customerDTO;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	private List<CustomerDTO> list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		CustomerDTO buildRequest = FormUtils.toModel(CustomerDTO.class, req);
		PageRequest PageRequest = FormUtils.toModel(PageRequest.class, req);
		List<CustomerDTO> results = service.findAll(buildRequest,PageRequest);
		return results;
	}

	@RequestMapping(value = "/count",method = RequestMethod.GET)
	private void count(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		ObjectMapper obj = new ObjectMapper();
		CustomerDTO buildRequest = FormUtils.toModel(CustomerDTO.class, req);
		long  count= service.count(buildRequest);
		obj.writeValue(resp.getOutputStream(), count);

	}

	@RequestMapping(method = RequestMethod.POST)
	private CustomerDTO newCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		CustomerDTO customer = HttpUtil.of(req.getReader()).toModel(CustomerDTO.class);
		Long id = service.save(customer);
		CustomerDTO get = service.findById(id);
		return get;
	}

	@RequestMapping(method = RequestMethod.PUT)
	private CustomerDTO updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		CustomerDTO customer = HttpUtil.of(req.getReader()).toModel(CustomerDTO.class);
		service.update(customer);
		CustomerDTO get = service.findById(customer.getId());
		return get;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	private boolean deleteBuilding(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		Map<String,Object> map = new ObjectMapper().readValue(req.getReader().lines().collect(Collectors.joining()),Map.class);
		List<Integer> list = (List<Integer>) map.get("ids");
		List<Long> arrIds = list.stream().map(e-> e.longValue()).collect(Collectors.toList());
		boolean res = service.delete(arrIds);
		return res;
	}

	@HandleRequest
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@HandleRequest
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}


	@HandleRequest
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@HandleRequest
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}


}
