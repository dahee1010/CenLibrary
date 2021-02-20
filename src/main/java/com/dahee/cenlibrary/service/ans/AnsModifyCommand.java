package com.dahee.cenlibrary.service.ans;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.AnsDao;
import com.dahee.cenlibrary.service.Service;

public class AnsModifyCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int qNum = Integer.parseInt(request.getParameter("qNum"));
		String content = request.getParameter("content");

		content = content.replace("\r\n", "<br>");

		AnsDao dao = new AnsDao();
		int ri = dao.ansModify(qNum, content);

		request.setAttribute("ri", ri);
		request.setAttribute("qNum", qNum);

	}

}
