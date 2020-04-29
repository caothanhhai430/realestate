package com.javaweb.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.annotation.RequestMapping;
import com.javaweb.annotation.RestController;
import com.javaweb.controller.admin.HttpServletCustom;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.enums.RequestMethod;
import com.javaweb.paging.impl.PageRequest;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.FormUtils;
import com.javaweb.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@WebServlet(urlPatterns= {"/api-server/building/*"})
public class BuildingAPI extends HttpServletCustom {

	@Inject
	IBuildingService service;

	@RequestMapping(value="/find-by-id",method= RequestMethod.GET)
	private BuildingDTO findById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;");

		String stringId= req.getParameter("id");
		if(stringId==null) {
			resp.setStatus(500);
			return null;
		}
		try	{
			Long id = Long.valueOf(stringId);
			BuildingDTO buildingDTO = service.findById(id);
			return buildingDTO;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/list",method= RequestMethod.GET)
	private List<BuildingDTO> list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		BuildingDTO buildRequest = FormUtils.toModel(BuildingDTO.class, req);
		PageRequest PageRequest = FormUtils.toModel(PageRequest.class, req);
		List<BuildingDTO> results = service.findAll(buildRequest,PageRequest);
		return results;
	}

	@RequestMapping(value="/count",method= RequestMethod.GET)
	private long count(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		BuildingDTO buildRequest = FormUtils.toModel(BuildingDTO.class, req);
		long  count= service.count(buildRequest);
		return count;
	}

	@RequestMapping(value = "/",method = RequestMethod.POST)
	private BuildingDTO newBuilding(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		BuildingDTO building = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		Long id = service.save(building);
		BuildingDTO get = service.findById(id);
		return get;
	}
	


	@RequestMapping(value = "/", method = RequestMethod.PUT)
	private BuildingDTO updateBuilding(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		BuildingDTO building = HttpUtil.of(req.getReader()).toModel(BuildingDTO.class);
		service.update(building);
		BuildingDTO get = service.findById(building.getId());
		return get;
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	private boolean deleteBuilding(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		Map<String,Object> map = new ObjectMapper().readValue(req.getReader().lines().collect(Collectors.joining()),Map.class);
		List<Integer> list = (List<Integer>) map.get("ids");
		List<Long> arrIds = list.stream().map(e-> e.longValue()).collect(Collectors.toList());
		boolean res = service.delete(arrIds);
		return res;
	}

}
