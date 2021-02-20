package com.dahee.cenlibrary.service.course;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.CourseDao;
import com.dahee.cenlibrary.dto.CourseDto;
import com.dahee.cenlibrary.service.Service;

public class CourseViewCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		Calendar cal = Calendar.getInstance(); // 달력 생성

		int day = 1;
		int yy = 0;
		int mm = 0;

		if (request.getParameter("mm") == null) { // 입력값 없다면 오늘 날짜 넣기
			yy = cal.get(Calendar.YEAR);
			mm = cal.get(Calendar.MONTH);
			cal.set(yy,mm,1);
			
		} else {
			
			if (request.getParameter("action") != null) {
				yy = Integer.parseInt(request.getParameter("yy")); // 입력년넣기
				mm = Integer.parseInt(request.getParameter("mm")); // 입력달넣기
			}
			if (Integer.parseInt(request.getParameter("action")) == 1) {
				cal.set(yy, mm, 1);
				cal.add(Calendar.MONTH, 1); // 다음달
				mm = cal.get(Calendar.MONTH);
				yy = cal.get(Calendar.YEAR);
			} else {

				cal.set(yy, mm, 1);
				cal.add(Calendar.MONTH, -1); // 이전달
				mm = cal.get(Calendar.MONTH);
				yy = cal.get(Calendar.YEAR);
			}
		}

		// 해당달의 1일의 요일 (일-토 : 1-7)
		int oneDayNum = cal.get(Calendar.DAY_OF_WEEK);
		// 해당달의 마지막 날짜
		int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 해당달의 주차 수
		int weekSize = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

		request.setAttribute("yy", yy);
		request.setAttribute("mm", mm);
		request.setAttribute("day", day);

		request.setAttribute("endDay", endDay);
		request.setAttribute("oneDayNum", oneDayNum);
		request.setAttribute("weekSize", weekSize);

		// 해당월에 맞는 일정불러오기
		CourseDao dao = new CourseDao();
		ArrayList<CourseDto> dtos = dao.courseList(yy, mm+1);
		
		request.setAttribute("course", dtos);

	}
}
