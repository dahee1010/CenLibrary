package com.dahee.cenlibrary.service.mybook;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.BookDao;
import com.dahee.cenlibrary.dao.MybookDao;
import com.dahee.cenlibrary.dao.bRankDao;
import com.dahee.cenlibrary.dao.mRankDao;
import com.dahee.cenlibrary.service.Service;

public class MybookAddCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// 세션에서 아이디값 받아오기
		HttpSession session = request.getSession();

		int bNum = Integer.parseInt(request.getParameter("bookNum"));
		String mbId = (String) session.getAttribute("id");
		String mbName = request.getParameter("bookName");
		String mbWriter = request.getParameter("writer");
		int bCnt = Integer.parseInt(request.getParameter("bCnt"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		String bImg = request.getParameter("bookimg");

		if (bCnt == cnt) { // 대출가능한 횟수와 대출 횟수가 같다면 대출 못함
			int ri = 3;

			request.setAttribute("ri", ri);

		} else {
			// 책 대출시 대출횟수 +1 해주기
			BookDao book = new BookDao();
			book.loanBook(bNum);

			// 세션에서 아이디값 받아와서 내서재에 추가
			MybookDao dao = new MybookDao();
			int ri = dao.insertMybook(bNum, mbId, mbName, mbWriter);

			request.setAttribute("ri", ri);

			// 회원 랭킹서비스 수행
			mRankDao mRank = new mRankDao();
			mRank.mRankService(mbId);

			// 도서 랭킹서비스 수행
			bRankDao bRank = new bRankDao();
			int confirmBook = bRank.confirmBook(bNum);

			if (confirmBook == 1) {
				bRank.bRankUpadate(bNum);
			} else {
				bRank.bRankInsert(bNum, mbName, mbWriter, bImg);
			}

		}
	}
}
