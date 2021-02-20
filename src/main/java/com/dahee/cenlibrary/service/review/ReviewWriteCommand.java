package com.dahee.cenlibrary.service.review;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.ReviewDao;
import com.dahee.cenlibrary.service.Service;

public class ReviewWriteCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		HttpSession session = request.getSession();

		int bNum = Integer.parseInt(request.getParameter("bookNum"));
		String rId = (String) session.getAttribute("id");
		String rContent = request.getParameter("rContent");
		int rating = Integer.parseInt(request.getParameter("rating"));

		rContent = rContent.replace("\r\n","<br>");
		
		ReviewDao dao = new ReviewDao();
		int ri = dao.reviewWrite(bNum, rId, rContent, rating);

		request.setAttribute("ri", ri);
		
	}
}