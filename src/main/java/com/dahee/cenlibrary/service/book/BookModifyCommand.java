package com.dahee.cenlibrary.service.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BookDao;
import com.dahee.cenlibrary.service.Service;

public class BookModifyCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int bookNum = Integer.parseInt(request.getParameter("bookNum"));
		String bookName = request.getParameter("bookName");
		String writer = request.getParameter("writer");
		String publish = request.getParameter("publish");
		int year = Integer.parseInt(request.getParameter("year"));
		String code = request.getParameter("code");
		int bCnt = Integer.parseInt(request.getParameter("bCnt"));
		String file1 = request.getParameter("bookimg1");
		String file2 = (String) map.get("filename");

		if (file2 != "") { // 이미지 업데이트 시, 즉 파일이 널이 아닐 때는 path에 파일이름 추가 후 전송

			String bookimg = "bookimg/" + file2;

			BookDao dao = new BookDao();
			int ri = dao.bookModify(bookNum, bookName, writer, publish, year, code, bCnt, bookimg);

			request.setAttribute("ri", ri);

		} else if (file2 == "" && file1 != null) { // 이미지가 업데이트 되지는 않았지만 원래 파일값이 있을 경우

			String bookimg = file1;

			BookDao dao = new BookDao();
			int ri = dao.bookModify(bookNum, bookName, writer, publish, year, code, bCnt, bookimg);

			request.setAttribute("ri", ri);

		} else { // 이미지 업데이트도 되지 않았고, 원래 파일값도 없을 경우

			String bookimg = null;

			BookDao dao = new BookDao();
			int ri = dao.bookModify(bookNum, bookName, writer, publish, year, code, bCnt, bookimg);

			request.setAttribute("ri", ri);

		}
	}
}
