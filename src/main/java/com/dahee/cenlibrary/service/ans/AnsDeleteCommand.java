package com.dahee.cenlibrary.service.ans;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.AnsDao;
import com.dahee.cenlibrary.dao.QueDao;
import com.dahee.cenlibrary.service.Service;

public class AnsDeleteCommand implements  Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int qNum = Integer.parseInt(request.getParameter("qNum"));
		
		AnsDao dao = new AnsDao();
		int ri = dao.ansDelete(qNum);
		
		request.setAttribute("ri", ri);
		request.setAttribute("qNum", qNum);
		
		QueDao que = new QueDao();
		que.downCnt(qNum);
	}
}
