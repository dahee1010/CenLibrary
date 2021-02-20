package com.dahee.cenlibrary.service.mybook;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BookDao;
import com.dahee.cenlibrary.dao.MybookDao;
import com.dahee.cenlibrary.service.Service;

public class MybookDeleteCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String mbNum = request.getParameter("mbNum");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		MybookDao dao = new MybookDao();
		int ri = dao.mybookDelete(mbNum);
		
		request.setAttribute("ri", ri);
		
		// 책 반납시 대출횟수 -1 해주기
		BookDao book = new BookDao();
		book.returnBook(bNum);
		
		
	}
}
