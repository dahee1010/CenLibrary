package com.dahee.cenlibrary.service.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BookDao;
import com.dahee.cenlibrary.service.Service;

public class BookAddCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String bookName = request.getParameter("bookName");
		String writer = request.getParameter("writer");
		String publish = request.getParameter("publish");
		int year = Integer.parseInt(request.getParameter("year"));
		String code = request.getParameter("code");
		int bCnt = Integer.parseInt(request.getParameter("bCnt")); // 대출 가능 권수
		int cnt = 0; // 사용자 대출 횟수
		String file = (String) map.get("filename");

		if (file != "") { // 파일이 널이 아닐때만 path에 파일이름 추가 후 전송
			String bookimg = "bookimg/" + file;

			BookDao dao = new BookDao();
			int ri = dao.bookAdd(bookName, writer, publish, year, code, bCnt, cnt, bookimg);

			request.setAttribute("ri", ri);

		} else { // 파일이 null 일때는 쓰레기값(path+파일명) 들어가지 않게 한다 그렇지 않으면 이상한 값 들어감
			String bookimg = null;

			BookDao dao = new BookDao();
			int ri = dao.bookAdd(bookName, writer, publish, year, code, bCnt, cnt, bookimg);

			request.setAttribute("ri", ri);
		}
	}
}
