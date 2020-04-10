//package com.javaweb.api;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.codehaus.jackson.map.ObjectMapper;
//
//import com.javaweb.converter.DTOConverter;
//import com.javaweb.dto.CustomerDTO;
//import com.javaweb.entity.CustomerEntity;
//import com.javaweb.dto.CustomerDTO;
//import com.javaweb.paging.impl.PageRequest;
//import com.javaweb.repository.impl.CustomerRepository;
//import com.javaweb.service.impl.CustomerService;
//import com.javaweb.service.impl.CustomerService;
//import com.javaweb.utils.FormUtils;
//import com.javaweb.utils.HttpUtil;
//
//@WebServlet(urlPatterns= {"/api-server/customer"})
//public class CustomerAPI extends HttpServlet{
//	private static final long serialVersionUID = -3295693792425119026L;
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json;");
//
//		CustomerDTO customerRequest = FormUtils.toModel(CustomerDTO.class, req);
//		PageRequest pageRequest = FormUtils.toModel(PageRequest.class, req);
//
//
//		List<CustomerDTO> results =  new CustomerService().findAll(customerRequest, pageRequest);
//		ObjectMapper obj = new ObjectMapper();
//		obj.writeValue(resp.getOutputStream(), results);
//
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ObjectMapper obj = new ObjectMapper();
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json");
//		CustomerDTO Customer = HttpUtil.of(req.getReader()).toModel(CustomerDTO.class);
//		Customer.setCreatedBy("admin");
//		Customer.setModifiedBy("admin");
//		Customer.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//		Customer.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//
//		CustomerService service = new CustomerService();
//		Long id = service.save(Customer);
//		CustomerDTO get = service.findById(id);
//		obj.writeValue(resp.getOutputStream(), get);
//	}
//
//	@Override
//	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ObjectMapper obj = new ObjectMapper();
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json");
//		CustomerDTO Customer = HttpUtil.of(req.getReader()).toModel(CustomerDTO.class);
//		Customer.setModifiedBy("admin");
//		Customer.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//
//		CustomerService service = new CustomerService();
//		Long id = service.update(Customer);
//		CustomerDTO get = service.findById(id);
//		obj.writeValue(resp.getOutputStream(), get);
//	}
//
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		CustomerDTO customer = HttpUtil.of(req.getReader()).toModel(CustomerDTO.class);
//		CustomerService service = new CustomerService();
//		long[] ids = customer.getIds();
//		if(ids!=null && ids.length>0) {
//			service.delete(customer.getIds());
//		}
//	}
//
//
//
//}
