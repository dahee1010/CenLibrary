package com.dahee.cenlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.review.ReviewDeleteCommand;
import com.dahee.cenlibrary.service.review.ReviewWriteCommand;

@Controller
public class ReviewController {

	Service service = null;

	@RequestMapping("/book/reviewWrite.do")
	public String reviewWrite(HttpServletRequest request, Model model) {
		System.out.println("reviewWrite");

		model.addAttribute("request", request);
		service = new ReviewWriteCommand();
		service.execute(model);

		return "book/reviewWriteOk";
	}

	@RequestMapping("/book/reviewDelete.do")
	public String reviewDelete(HttpServletRequest request, Model model) {
		System.out.println("reviewDelete");

		model.addAttribute("request", request);
		service = new ReviewDeleteCommand();
		service.execute(model);

		return "book/reviewDeleteOk";
	}
}
