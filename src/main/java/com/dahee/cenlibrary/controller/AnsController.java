package com.dahee.cenlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.ans.AnsDeleteCommand;
import com.dahee.cenlibrary.service.ans.AnsModifyCommand;
import com.dahee.cenlibrary.service.ans.AnsViewCommand;
import com.dahee.cenlibrary.service.ans.AnsWriteCommand;
import com.dahee.cenlibrary.service.que.QueViewCommand;

@Controller
public class AnsController {

	Service service = null;

	@RequestMapping("/qna/ansWrite.do")
	public String ansWrite(HttpServletRequest request, Model model) {
		System.out.println("ansWrite");

		model.addAttribute("request", request);
		service = new QueViewCommand();
		service.execute(model);

		return "qna/ansWrite";
	}

	@RequestMapping("/qna/ansWriteOk.do")
	public String ansWriteOk(HttpServletRequest request, Model model) {
		System.out.println("ansWriteOk");

		model.addAttribute("request", request);
		service = new AnsWriteCommand();
		service.execute(model);

		return "qna/ansWriteOk";
	}

	@RequestMapping("/qna/ansModify.do")
	public String ansModify(HttpServletRequest request, Model model) {
		System.out.println("ansModify");

		model.addAttribute("request", request);
		service = new QueViewCommand();
		service.execute(model);
		
		model.addAttribute("request", request);
		service = new AnsViewCommand();
		service.execute(model);

		return "qna/ansModify";
	}

	@RequestMapping("/qna/ansModifyOk.do")
	public String ansModifyOk(HttpServletRequest request, Model model) {
		System.out.println("ansModifyOk");

		model.addAttribute("request", request);
		service = new AnsModifyCommand();
		service.execute(model);

		return "qna/ansModifyOk";
	}

	@RequestMapping("/qna/ansDelete.do")
	public String ansDelete(HttpServletRequest request, Model model) {
		System.out.println("ansDelete");

		model.addAttribute("request", request);
		service = new AnsDeleteCommand();
		service.execute(model);

		return "qna/ansDeleteOk";
	}

}
