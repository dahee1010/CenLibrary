package com.dahee.cenlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.ans.AnsViewCommand;
import com.dahee.cenlibrary.service.que.QueDeleteCommand;
import com.dahee.cenlibrary.service.que.QueListCommand;
import com.dahee.cenlibrary.service.que.QueModifyCommand;
import com.dahee.cenlibrary.service.que.QueViewCommand;
import com.dahee.cenlibrary.service.que.QueWriteCommand;

@Controller
public class QueController {
	
	Service service = null;
	
	
	@RequestMapping("/qna/queWrite")
	public String queWrite(Model model) {
		
		return "qna/queWrite";
	}

	@RequestMapping("/qna/queWrite.do")
	public String queWrite(HttpServletRequest request, Model model) {
		System.out.println("queWrite");

		model.addAttribute("request", request);
		service = new QueWriteCommand();
		service.execute(model);

		return "qna/queWriteOk";
	}

	@RequestMapping("/qna/queList.do")
	public String queList(HttpServletRequest request, Model model) {
		System.out.println("queList");

		model.addAttribute("request", request);
		service = new QueListCommand();
		service.execute(model);

		return "qna/queList";
	}

	@RequestMapping("/qna/queViewCheck.do")
	public String queViewCheck(HttpServletRequest request, Model model) {
		System.out.println("queViewCheck");

		model.addAttribute("request", request);
		service = new QueViewCommand();
		service.execute(model);

		return "qna/queViewCheck";
	}

	@RequestMapping("/qna/queView.do")
	public String queView(HttpServletRequest request, Model model) {
		System.out.println("queView");

		model.addAttribute("request", request);
		service = new QueViewCommand();
		service.execute(model);
		
		model.addAttribute("request", request);
		service = new AnsViewCommand();
		service.execute(model);
		
		return "qna/queView";
	}

	@RequestMapping("/qna/queModify.do")
	public String queModify(HttpServletRequest request, Model model) {
		System.out.println("queModify");

		model.addAttribute("request", request);
		service = new QueViewCommand();
		service.execute(model);

		return "qna/queModify";
	}

	@RequestMapping("/qna/queModifyOk.do")
	public String queModifyOk(HttpServletRequest request, Model model) {
		System.out.println("queModifyOk");

		model.addAttribute("request", request);
		service = new QueModifyCommand();
		service.execute(model);

		return "qna/queModifyOk";
	}

	@RequestMapping("/qna/queDelete.do")
	public String queDelete(HttpServletRequest request, Model model) {
		System.out.println("queDelete");

		model.addAttribute("request", request);
		service = new QueDeleteCommand();
		service.execute(model);

		return "qna/queDeleteOk";
	}


}
