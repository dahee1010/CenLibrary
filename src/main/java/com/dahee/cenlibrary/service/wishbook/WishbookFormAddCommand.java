package com.dahee.cenlibrary.service.wishbook;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.WishbookDao;
import com.dahee.cenlibrary.dto.WishbookDto;
import com.dahee.cenlibrary.service.Service;

public class WishbookFormAddCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int wbNum = Integer.parseInt(request.getParameter("wbNum"));

		WishbookDao dao = new WishbookDao();
		ArrayList<WishbookDto> dtos = dao.wishbook(wbNum);

		request.setAttribute("list", dtos);

	}

}
