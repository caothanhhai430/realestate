package com.javaweb.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.dto.TransactionDTO;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.ITransactionService;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns= {"/api-server/transaction"})
public class TransactionAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	ITransactionService service;

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

		}
	}



	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		TransactionDTO buildRequest = FormUtils.toModel(TransactionDTO.class, req);
		PageRequest PageRequest = FormUtils.toModel(PageRequest.class, req);
		List<TransactionDTO> results = service.findAll(buildRequest,PageRequest);
		obj.writeValue(resp.getOutputStream(), results);
	}

	private void count(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");
		ObjectMapper obj = new ObjectMapper();
		TransactionDTO buildRequest = FormUtils.toModel(TransactionDTO.class, req);
		long  count= service.count(buildRequest);
		obj.writeValue(resp.getOutputStream(), count);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper obj = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		TransactionDTO transaction = HttpUtil.of(req.getReader()).toModel(TransactionDTO.class);
		transaction.setCreatedBy("admin");
		transaction.setModifiedBy("admin");
		transaction.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		transaction.setModifiedDate(new Timestamp(System.currentTimeMillis()));

		Long id = service.save(transaction);

		TransactionDTO get = service.findById(id);
		obj.writeValue(resp.getOutputStream(), get);
	}

}
