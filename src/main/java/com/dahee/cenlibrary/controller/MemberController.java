package com.dahee.cenlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.member.IdCheckCommand;
import com.dahee.cenlibrary.service.member.JoinCommand;
import com.dahee.cenlibrary.service.member.LoginCommand;
import com.dahee.cenlibrary.service.member.MemberDeleteCommand;
import com.dahee.cenlibrary.service.member.MemberListCommand;
import com.dahee.cenlibrary.service.member.MemberModifyCommand;
import com.dahee.cenlibrary.service.member.MemberSearchCommand;
import com.dahee.cenlibrary.service.member.MemberViewCommand;
import com.dahee.cenlibrary.service.member.PwChangeCommand;
import com.dahee.cenlibrary.service.member.PwCheckCommand;

@Controller
public class MemberController {

	Service service = null;

	@RequestMapping("/member/memberLogin")
	public String memberLogin(Model model) {

		return "member/memberLogin";
	}
	
	@RequestMapping("/member/memberJoin")
	public String memberJoin(Model model) {

		return "member/memberJoin";
	}
	
	@RequestMapping("/member/memberLogout")
	public String memberLogout(Model model) {

		return "member/memberLogout";
	}
	
	@RequestMapping("/member/memberPwCheck")
	public String memberPwCheck(Model model) {

		return "member/memberPwCheck";
	}
	
	@RequestMapping("/member/memberPwChange")
	public String memberPwChange(Model model) {

		return "member/memberPwChange";
	}
	
	@RequestMapping("/member/join.do")
	public String join(HttpServletRequest request, Model model) {
		System.out.println("join");

		model.addAttribute("request", request);
		service = new JoinCommand();
		service.execute(model);

		return "member/memberJoinOk";
	}

	@RequestMapping("/member/idCheck.do")
	public String idCheck(HttpServletRequest request, Model model) {
		System.out.println("idCheck");

		model.addAttribute("request", request);
		service = new IdCheckCommand();
		service.execute(model);

		return "member/idCheck";
	}

	@RequestMapping("/member/login.do")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("login");

		model.addAttribute("request", request);
		service = new LoginCommand();
		service.execute(model);

		return "member/memberLoginOk";
	}

	@RequestMapping("/member/memberList.do")
	public String memberList(HttpServletRequest request, Model model) {
		System.out.println("memberList");

		model.addAttribute("request", request);
		service = new MemberListCommand();
		service.execute(model);

		return "member/memberList";
	}

	@RequestMapping("/member/memberSearch.do")
	public String memberSearch(HttpServletRequest request, Model model) {
		System.out.println("memberSearch");

		model.addAttribute("request", request);
		service = new MemberSearchCommand();
		service.execute(model);

		return "member/memberSearch";
	}

	@RequestMapping("/member/memberDelete.do")
	public String memberDelete(HttpServletRequest request, Model model) {
		System.out.println("memberDelete");

		model.addAttribute("request", request);
		service = new MemberDeleteCommand();
		service.execute(model);

		return "member/memberDeleteOk";
	}

	@RequestMapping("/member/memberView.do")
	public String memberView(HttpServletRequest request, Model model) {
		System.out.println("memberView");

		model.addAttribute("request", request);
		service = new MemberViewCommand();
		service.execute(model);

		return "member/memberView";
	}

	@RequestMapping("/member/memberPwCheckOk.do")
	public String memberPwCheckOk(HttpServletRequest request, Model model) {
		System.out.println("memberPwCheckOk");

		model.addAttribute("request", request);
		service = new PwCheckCommand();
		service.execute(model);

		return "member/memberPwCheckOk";
	}

	@RequestMapping("/member/memberModifyForm.do")
	public String memberModifyForm(HttpServletRequest request, Model model) {
		System.out.println("memberModifyForm");

		model.addAttribute("request", request);
		service = new MemberViewCommand();
		service.execute(model);

		return "member/memberModifyForm";
	}

	@RequestMapping("/member/memberModifyOk.do")
	public String memberModifyOk(HttpServletRequest request, Model model) {
		System.out.println("memberModifyOk");

		model.addAttribute("request", request);
		service = new MemberModifyCommand();
		service.execute(model);

		return "member/memberModifyOk";
	}

	@RequestMapping("/member/memberPwChangeOk.do")
	public String memberPwChangeOk(HttpServletRequest request, Model model) {
		System.out.println("memberPwChangeOk");

		model.addAttribute("request", request);
		service = new PwChangeCommand();
		service.execute(model);

		return "member/memberPwChangeOk";
	}
}
