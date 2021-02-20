package com.dahee.cenlibrary.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.book.BookAddCommand;
import com.dahee.cenlibrary.service.book.BookDeleteCommand;
import com.dahee.cenlibrary.service.book.BookListCommand;
import com.dahee.cenlibrary.service.book.BookModifyCommand;
import com.dahee.cenlibrary.service.book.BookSearchCommand;
import com.dahee.cenlibrary.service.book.BookViewCommand;

@Controller
public class BookController {

	Service service = null;

	@RequestMapping("/book/bookList")
	public String bookListFirst(Model model) {

		return "book/bookList";
	}

	@RequestMapping("/book/bookAddForm")
	public String bookAddForm(Model model) {

		return "book/bookAddForm";
	}

	@RequestMapping("/book/bookList.do")
	public String bookList(HttpServletRequest request, Model model) {
		System.out.println("bookList");

		model.addAttribute("request", request);
		service = new BookListCommand();
		service.execute(model);

		return "book/bookList";
	}

	@RequestMapping(value = "/book/bookSearch.do", method = RequestMethod.GET)
	public String bookSearch(HttpServletRequest request, Model model) {
		System.out.println("bookSearch");

		model.addAttribute("request", request);
		service = new BookSearchCommand();
		service.execute(model);

		return "book/bookSearch";
	}

	@RequestMapping("/book/bookView.do")
	public String bookView(HttpServletRequest request, Model model) {
		System.out.println("bookView");

		model.addAttribute("request", request);
		service = new BookViewCommand();
		service.execute(model);

		return "book/bookView";
	}

	@RequestMapping("/book/bookListAdmin.do")
	public String bookListAdmin(HttpServletRequest request, Model model) {
		System.out.println("bookListAdmin");

		model.addAttribute("request", request);
		service = new BookListCommand();
		service.execute(model);

		return "book/bookListAdmin";
	}

	@RequestMapping("/book/bookSearchAdmin.do")
	public String bookSearchAdmin(HttpServletRequest request, Model model) {
		System.out.println("bookSearchAdmin");

		model.addAttribute("request", request);
		service = new BookSearchCommand();
		service.execute(model);

		return "book/bookSearchAdmin";
	}

	@Resource(name = "uploadPath")
	String uploadPath;

	@RequestMapping("/book/bookAddOk.do")
	public String bookAddOk(HttpServletRequest request, Model model, MultipartHttpServletRequest mtfRequest) {
		System.out.println("bookAddOk");

		MultipartFile mf = mtfRequest.getFile("file");

		String path = "C:\\Users\\LEE\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CenLibrary\\resources\\bookimg/"; // 절대경로
		String originFileName = mf.getOriginalFilename(); // 원본 파일명
		String safeFile = path + originFileName; // 저장형식

		try {
			mf.transferTo(new File(safeFile));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("filename", originFileName);
		model.addAttribute("request", request);
		service = new BookAddCommand();
		service.execute(model);

		return "book/bookAddOk";
	}

	@RequestMapping("/book/bookViewAdmin.do")
	public String bookViewAdmin(HttpServletRequest request, Model model) {
		System.out.println("bookViewAdmin");

		model.addAttribute("request", request);
		service = new BookViewCommand();
		service.execute(model);

		return "book/bookViewAdmin";
	}

	@RequestMapping("/book/bookDelete.do")
	public String bookDelete(HttpServletRequest request, Model model) {
		System.out.println("bookDelete");

		model.addAttribute("request", request);
		service = new BookDeleteCommand();
		service.execute(model);

		return "book/bookDeleteOk";
	}

	@RequestMapping("/book/bookModifyForm.do")
	public String bookModifyForm(HttpServletRequest request, Model model) {
		System.out.println("bookModifyForm");
		
		model.addAttribute("request", request);
		service = new BookViewCommand();
		service.execute(model);

		return "book/bookModifyForm";
	}

	@RequestMapping("/book/bookModifyOk.do")
	public String bookModifyOk(HttpServletRequest request, Model model, MultipartHttpServletRequest mtfRequest) {
		System.out.println("bookDelete");
		
		MultipartFile mf = mtfRequest.getFile("bookimg2");

		String path = "C:\\Users\\LEE\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\CenLibrary\\resources\\bookimg/"; // 절대경로
		String originFileName = mf.getOriginalFilename(); // 원본 파일명
		String safeFile = path + originFileName; // 저장형식

		try {
			mf.transferTo(new File(safeFile));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("filename", originFileName);
		model.addAttribute("request", request);
		service = new BookModifyCommand();
		service.execute(model);

		return "book/bookModifyOk";
	}
}
