package com.dahee.cenlibrary.service.mybook;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.MybookDao;
import com.dahee.cenlibrary.dto.MybookDto;
import com.dahee.cenlibrary.service.Service;

public class MybookAllCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		MybookDao dao = new MybookDao();

		int pagenum = 1; // 페이지 번호
		if (request.getParameter("page") != null) {
			pagenum = Integer.parseInt(request.getParameter("page"));
		}

		int data = 10; // 보여줄 데이터 크기
		int tot; // 페이지수

		int cnt = dao.mybookCount();

		tot = cnt / data;

		if (cnt % data != 0) {
			tot++;
		}

		int start = ((pagenum - 1) * data) + 1;
		int end = pagenum * data;

		ArrayList<MybookDto> dtos = dao.mybookAll(start, end);

		request.setAttribute("list", dtos);
		request.setAttribute("tot", tot);
		request.setAttribute("data", data);
		request.setAttribute("cnt", cnt);
		request.setAttribute("pagenum", pagenum);

	}
}
