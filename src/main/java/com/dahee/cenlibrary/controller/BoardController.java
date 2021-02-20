package com.dahee.cenlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.board.BoardDeleteCommand;
import com.dahee.cenlibrary.service.board.BoardListCommand;
import com.dahee.cenlibrary.service.board.BoardModifyCommand;
import com.dahee.cenlibrary.service.board.BoardViewCommand;
import com.dahee.cenlibrary.service.board.BoardWriteCommand;

@Controller
public class BoardController {

	Service service = null;
	
	@RequestMapping("/board/boardWrite")
	public String boardWrite(Model model) {
		
		return "board/boardWrite";
	}
	
	@RequestMapping("/board/boardWrite.do")
	public String boardWrite(HttpServletRequest request, Model model) {
		System.out.println("boardWrite");

		model.addAttribute("request", request);
		service = new BoardWriteCommand();
		service.execute(model);

		return "board/boardWriteOk";
	}
	
	@RequestMapping("/board/boardList.do")
	public String boardList(HttpServletRequest request, Model model) {
		System.out.println("boardList");

		model.addAttribute("request", request);
		service = new BoardListCommand();
		service.execute(model);

		return "board/boardList";
	}
	
	@RequestMapping("/board/boardView.do")
	public String boardView(HttpServletRequest request, Model model) {
		System.out.println("boardView");

		model.addAttribute("request", request);
		service = new BoardViewCommand();
		service.execute(model);

		return "board/boardView";
	}
	
	@RequestMapping("/board/boardModify.do")
	public String boardModify(HttpServletRequest request, Model model) {
		System.out.println("boardModify");

		model.addAttribute("request", request);
		service = new BoardViewCommand();
		service.execute(model);

		return "board/boardModify";
	}
	
	@RequestMapping("/board/boardModifyOk.do")
	public String boardModifyOk(HttpServletRequest request, Model model) {
		System.out.println("boardModifyOk");

		model.addAttribute("request", request);
		service = new BoardModifyCommand();
		service.execute(model);

		return "board/boardModifyOk";
	}
	
	@RequestMapping("/board/boardDelete.do")
	public String boardDelete(HttpServletRequest request, Model model) {
		System.out.println("boardDelete");

		model.addAttribute("request", request);
		service = new BoardDeleteCommand();
		service.execute(model);

		return "board/boardDeleteOk";
	}
}
