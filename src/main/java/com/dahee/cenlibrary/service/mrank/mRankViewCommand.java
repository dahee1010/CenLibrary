package com.dahee.cenlibrary.service.mrank;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.dahee.cenlibrary.dao.mRankDao;
import com.dahee.cenlibrary.dto.mRankDto;
import com.dahee.cenlibrary.service.Service;

public class mRankViewCommand implements Service {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		mRankDao dao = new mRankDao();
		ArrayList<mRankDto> dtos = dao.memberRank();
		
		request.setAttribute("memberrank", dtos);
		
	}
}
