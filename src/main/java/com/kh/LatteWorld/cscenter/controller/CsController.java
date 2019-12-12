package com.kh.LatteWorld.cscenter.controller;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.cscenter.model.service.CsService;
import com.kh.LatteWorld.cscenter.model.vo.Cscenter;
import com.kh.LatteWorld.exception.lwException;


@Controller
public class CsController {
	
	@Autowired
	private CsService CsService;
	
	@RequestMapping(value = "csinsert.do", method = RequestMethod.POST)
	public String csInsert(@RequestParam(value = "csType", required = false) String csType, 
							@RequestParam(value = "csWriter", required = false) String csWriter,
							@RequestParam(value = "csDetail", required = false) String csDetail,
							@RequestParam(value = "csReply", required = false) String csReply) {
		
		Cscenter cs = new Cscenter();
		cs.setCsType(csType);
		cs.setCsWriter(csWriter);
		cs.setCsDetail(csDetail);
		cs.setCsReply(csReply);
		
		
		
		System.out.println(cs);
		int result = CsService.insertCscenter(cs);
		System.out.println(result);
		if(result > 0) {
			return "redirect:home.do";
		}else {
			throw new lwException("공지사항 등록 실패!");
		}
	}
	
	@RequestMapping("csCenter.do")
	public ModelAndView csCenter(ModelAndView mv) {
		
		mv.setViewName("cscenter/csCenter");
		return mv;		
	}
	
	@RequestMapping("csWriteForm.do")
	public ModelAndView csWriteForm(ModelAndView mv) {
		
		mv.setViewName("cscenter/csWriteForm");
		return mv;
		
	}
	
	@RequestMapping("csCenterUser.do")
	public ModelAndView csCenterUser(ModelAndView mv) {
		System.out.println("들어오나?");
		
		mv.setViewName("cscenter/csCenterUser");
		return mv;		
	}

	@RequestMapping("csListVIew.do")
	public ModelAndView csListVIew(ModelAndView mv) {
		
		ArrayList<Cscenter> list = CsService.selectList();
		
		if(list != null) {
			mv.addObject("list",list);
			mv.setViewName("cscenter/csListVIew");
			
		}else {
			throw new lwException("문의사항 보기 실패!");
			
		}
		return mv;
	}
	
	@RequestMapping(value = "updateCsReply.do", method = RequestMethod.POST)
	public String updateCsReply(@RequestParam(value = "csReply", required = false) String csReply,
								@RequestParam(value = "csListNum", required = false) int csListNum) {
		//System.out.println(csReply);
		//System.out.println(csListNum);
		
		Cscenter cs = new Cscenter();	// 이부분에 setter로 넘어온 답글과 문의내역 리스트 번호 담아줄꺼!
		cs.setCsListNum(csListNum);
		cs.setCsReply(csReply);
		
		//System.out.println(cs);
		
		int result = CsService.updateCsReply(cs);
		
		return "redirect:csListVIew.do";
	}


}