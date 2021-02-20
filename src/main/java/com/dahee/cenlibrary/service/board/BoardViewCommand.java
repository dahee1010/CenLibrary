package com.dahee.cenlibrary.service.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BoardDao;
import com.dahee.cenlibrary.dto.BoardDto;
import com.dahee.cenlibrary.service.Service;

public class BoardViewCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int wNum = Integer.parseInt(request.getParameter("wNum"));

		BoardDao dao = new BoardDao();
		BoardDto dto = dao.contentView(wNum);

		model.addAttribute("view", dto);
		
	}
}
