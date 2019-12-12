package com.kh.LatteWorld.UserInfo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.LatteWorld.UserInfo.model.service.UserService;
import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.exception.lwException;

@SessionAttributes("UserInfo")
@Controller
public class UserController {

	@Autowired
	private UserService uService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String memberLogin(UserInfo u, Model model, SessionStatus status) {
		UserInfo user = uService.loginUser(u);
		if(bcryptPasswordEncoder.matches(u.getUserPwd(), user.getUserPwd())) {
			model.addAttribute("UserInfo",user);
		}else {
			throw new lwException("로그인 실패!");
		}
		
		return "home";
	}
	
	@RequestMapping("logout.do")
	public String userLogout(SessionStatus status) {
		status.setComplete();
		
		return "home";
	}
	
	@RequestMapping("mypage.do")
	public String userMypage(UserInfo u, Model model) {
		u = uService.selectUser(u);
		model.addAttribute("UserInfo", u);
		
		return "user/myPage";
	}
	
	@RequestMapping(value = "update.do", method=RequestMethod.POST)
	public String userUpdate(UserInfo u, Model model) {
		
		int result = uService.updateUser(u);
		
		
		return "home";
	}
	
	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public String userJoin(UserInfo u, Model model) {
		String encPwd =  bcryptPasswordEncoder.encode(u.getUserPwd());
		u.setUserPwd(encPwd);
		int result = 0;
		
		int r1 = uService.insertMember(u);
		int r2 = uService.insertMiniHome(u);
		int r3 = uService.insertFolderList1();
		int r4 = uService.insertFolderList2();
		int r5 = uService.insertMiniHomeProfile();
		
		if(r1 == 1 && r2 == 1 && r3 == 1 && r4 == 1 && r5 == 1)
			result = 1;
		
		if(result >0) {
			return "home";
		}else {
			throw new lwException("회원 가입 실패!");
		}
	}
	
	@RequestMapping("dupid.do")
	public void idDuplicateCheck(HttpServletResponse response, String userId) throws IOException {
		boolean isUsable = uService.checkIdDup(userId) == 0? true : false;
		
		response.getWriter().print(isUsable);
	}
}
