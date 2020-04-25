package com.javaweb.api;

import com.javaweb.annotation.HandleRequest;
import com.javaweb.annotation.RequestMapping;
import com.javaweb.annotation.RestController;
import com.javaweb.dto.TransactionDTO;
import com.javaweb.enums.RequestMethod;
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
import java.util.List;

@RestController
@WebServlet(urlPatterns= {"/api-server/transaction/*"})
public class TransactionAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	ITransactionService service;

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	private List<TransactionDTO> list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		TransactionDTO buildRequest = FormUtils.toModel(TransactionDTO.class, req);
		PageRequest PageRequest = FormUtils.toModel(PageRequest.class, req);
		List<TransactionDTO> results = service.findAll(buildRequest,PageRequest);
		return results;
	}

	@RequestMapping(value = "/count",method = RequestMethod.GET)
	private long count(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		TransactionDTO buildRequest = FormUtils.toModel(TransactionDTO.class, req);
		long  count= service.count(buildRequest);
		return count;
	}

	@RequestMapping(method = RequestMethod.POST)
	protected TransactionDTO newTransaction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		TransactionDTO transaction = HttpUtil.of(req.getReader()).toModel(TransactionDTO.class);
		Long id = service.save(transaction);
		TransactionDTO get = service.findById(id);
		return get;
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
