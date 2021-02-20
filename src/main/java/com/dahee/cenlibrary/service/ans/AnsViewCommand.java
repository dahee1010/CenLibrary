package com.dahee.cenlibrary.service.ans;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.AnsDao;
import com.dahee.cenlibrary.dto.AnsDto;
import com.dahee.cenlibrary.service.Service;

public class AnsViewCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int qNum = Integer.parseInt(request.getParameter("qNum"));

		AnsDao dao = new AnsDao();
		AnsDto dto = dao.contentView(qNum);

		request.setAttribute("ans", dto);

	}

}
