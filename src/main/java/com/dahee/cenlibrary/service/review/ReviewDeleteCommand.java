package com.dahee.cenlibrary.service.review;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.ReviewDao;
import com.dahee.cenlibrary.service.Service;

public class ReviewDeleteCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int rNum = Integer.parseInt(request.getParameter("rNum"));

		ReviewDao dao = new ReviewDao();
		int ri = dao.reviewDelete(rNum);

		request.setAttribute("ri", ri);
		
	}
}
