package com.dahee.cenlibrary.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.wishbook.WishbookAddCommand;
import com.dahee.cenlibrary.service.wishbook.WishbookDeleteCommand;
import com.dahee.cenlibrary.service.wishbook.WishbookFormAddCommand;
import com.dahee.cenlibrary.service.wishbook.WishbookFormCommand;
import com.dahee.cenlibrary.service.wishbook.WishbookListCommand;

@Controller
public class WishbookController {

	Service service = null;
	
	@RequestMapping("/wishbook/wishbookForm")
	public String wishbookForm(Model model) {

		return "wishbook/wishbookForm";
	}

	@RequestMapping("/wishbook/wishbookForm.do")
	public String wishbookForm(HttpServletRequest request, Model model) {
		System.out.println("wishbookForm");

		model.addAttribute("request", request);
		service = new WishbookFormCommand();
		service.execute(model);

		return "wishbook/wishbookFormOk";
	}
	
	@RequestMapping("/wishbook/wishbookList.do")
	public String wishbookList(HttpServletRequest request, Model model) {
		System.out.println("wishbookList");

		model.addAttribute("request", request);
		service = new WishbookListCommand();
		service.execute(model);

		return "wishbook/wishbookList";
	}
	
	@RequestMapping("/wishbook/wishbookAddForm.do")
	public String wishbookAddForm(HttpServletRequest request, Model model) {
		System.out.println("wishbookAddForm");

		model.addAttribute("request", request);
		service = new WishbookFormAddCommand();
		service.execute(model);

		return "wishbook/wishbookAddForm";
	}
	
	@RequestMapping("/wishbook/wishbookAdd.do")
	public String wishbookAdd(HttpServletRequest request, Model model, MultipartHttpServletRequest mtfRequest) {
		System.out.println("wishbookAdd");
		
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
		service = new WishbookAddCommand();
		service.execute(model);

		return "wishbook/wishbookAddOk";
	}
	
	@RequestMapping("/wishbook/wishbookDelete.do")
	public String wishbookDelete(HttpServletRequest request, Model model) {
		System.out.println("wishbookForm");

		model.addAttribute("request", request);
		service = new WishbookDeleteCommand();
		service.execute(model);

		return "wishbook/wishbookDeleteOk";
	}
}
