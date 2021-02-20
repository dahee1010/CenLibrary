package com.dahee.cenlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.board.BoardListCommand;
import com.dahee.cenlibrary.service.book.BookListCommand;
import com.dahee.cenlibrary.service.book.BookRandomListCommand;
import com.dahee.cenlibrary.service.brank.bRankViewCommand;
import com.dahee.cenlibrary.service.mrank.mRankViewCommand;

@Controller
public class MainController {

	Service service = null;

	@RequestMapping("/main.do")
	public String main(HttpServletRequest request, Model model) {
		System.out.println("main");

		model.addAttribute("request", request);
		service = new mRankViewCommand();
		service.execute(model);

		model.addAttribute("request", request);
		service = new bRankViewCommand();
		service.execute(model);

		model.addAttribute("request", request);
		service = new BoardListCommand();
		service.execute(model);

		model.addAttribute("request", request);
		service = new BookListCommand();
		service.execute(model);

		model.addAttribute("request", request);
		service = new BookRandomListCommand();
		service.execute(model);

		return "main";

	}

}
