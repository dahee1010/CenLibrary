package com.dahee.cenlibrary.service.mybook;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MybookDao;
import com.dahee.cenlibrary.service.Service;

public class MybookExtenCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int mbNum = Integer.parseInt(request.getParameter("mbNum"));
		
		MybookDao dao = new MybookDao();
		int ri = dao.mybookExten(mbNum);
		
		request.setAttribute("ri", ri);
		
	}

}
