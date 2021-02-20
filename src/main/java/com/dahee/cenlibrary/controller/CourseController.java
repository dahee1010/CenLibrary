package com.dahee.cenlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dahee.cenlibrary.service.Service;
import com.dahee.cenlibrary.service.course.CourseViewCommand;

@Controller
public class CourseController {
	
	Service service = null;

	@RequestMapping("/course/courseView.do")
	public String courseView(HttpServletRequest request, Model model) {
		System.out.println("courseView");

		model.addAttribute("request", request);
		service = new CourseViewCommand();
		service.execute(model);

		return "course/courseView";
	}

}
