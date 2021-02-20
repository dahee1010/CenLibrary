package com.dahee.cenlibrary.service.ans;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.AnsDao;
import com.dahee.cenlibrary.dao.QueDao;
import com.dahee.cenlibrary.service.Service;

public class AnsWriteCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int qNum = Integer.parseInt(request.getParameter("qNum"));
		String qtitle = request.getParameter("qtitle");
		String content = request.getParameter("content");
		Timestamp aDate = new Timestamp(System.currentTimeMillis());
		
		content = content.replace("\r\n","<br>");
		
		AnsDao dao = new AnsDao();
		int ri = dao.ansWrite(qNum, qtitle, content, aDate);
		
		request.setAttribute("ri", ri);
		request.setAttribute("qNum", qNum);
		
		// 답변 카운트 올리기
		QueDao upCnt = new QueDao();
		upCnt.upCnt(qNum);
	}
}
