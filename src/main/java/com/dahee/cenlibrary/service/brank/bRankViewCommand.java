package com.dahee.cenlibrary.service.brank;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.bRankDao;
import com.dahee.cenlibrary.dto.bRankDto;
import com.dahee.cenlibrary.service.Service;

public class bRankViewCommand implements Service {
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		bRankDao dao = new bRankDao();
		ArrayList<bRankDto> dtos = dao.bookRank();

		request.setAttribute("bookrank", dtos);

	}
}
