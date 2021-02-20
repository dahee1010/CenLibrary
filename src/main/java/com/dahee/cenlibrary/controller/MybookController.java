package com.dahee.cenlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.mybook.MybookAddCommand;
import com.dahee.cenlibrary.service.mybook.MybookAllCommand;
import com.dahee.cenlibrary.service.mybook.MybookDeleteCommand;
import com.dahee.cenlibrary.service.mybook.MybookExtenCommand;
import com.dahee.cenlibrary.service.mybook.MybookListCommand;

@Controller
public class MybookController {

	Service service = null;

	@RequestMapping("/mybook/mybookAdd.do")
	public String mybookAdd(HttpServletRequest request, Model model) {
		System.out.println("mybookAdd");

		model.addAttribute("request", request);
		service = new MybookAddCommand();
		service.execute(model);

		return "mybook/mybookAddOk";
	}

	@RequestMapping("/mybook/mybookList.do")
	public String mybookList(HttpServletRequest request, Model model) {
		System.out.println("mybookList");

		model.addAttribute("request", request);
		service = new MybookListCommand();
		service.execute(model);

		return "mybook/mybookList";
	}

	@RequestMapping("/mybook/mybookDelete.do")
	public String mybookDelete(HttpServletRequest request, Model model) {
		System.out.println("mybookDelete");

		model.addAttribute("request", request);
		service = new MybookDeleteCommand();
		service.execute(model);

		return "mybook/mybookDeleteOk";
	}

	@RequestMapping("/mybook/mybookExten.do")
	public String mybookExten(HttpServletRequest request, Model model) {
		System.out.println("mybookExten");

		model.addAttribute("request", request);
		service = new MybookExtenCommand();
		service.execute(model);

		return "mybook/mybookExtenOk";
	}

	@RequestMapping("/mybook/mybookAll.do")
	public String mybookAll(HttpServletRequest request, Model model) {
		System.out.println("mybookAll");

		model.addAttribute("request", request);
		service = new MybookAllCommand();
		service.execute(model);

		return "mybook/mybookAll";
	}

}
