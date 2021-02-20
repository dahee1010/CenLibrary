package com.dahee.cenlibrary.service.que;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.AnsDao;
import com.dahee.cenlibrary.dao.QueDao;
import com.dahee.cenlibrary.service.Service;

public class QueDeleteCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int qNum = Integer.parseInt(request.getParameter("qNum"));

		// 질문글 삭제
		QueDao dao = new QueDao();
		int ri = dao.queDelete(qNum);

		request.setAttribute("ri", ri);

		// 답변글 삭제
		AnsDao ans = new AnsDao();
		ans.ansDelete(qNum);

	}
}
