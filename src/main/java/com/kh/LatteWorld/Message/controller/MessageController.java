package com.kh.LatteWorld.Message.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.LatteWorld.Message.model.service.MessageService;
import com.kh.LatteWorld.Message.model.vo.Message;
import com.kh.LatteWorld.Message.model.vo.PageInfoMessage;
import com.kh.LatteWorld.Message.pagination_m.Pagination;
import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.bestFriend.model.vo.BestFriend;
import com.kh.LatteWorld.exception.lwException;
import com.sun.glass.ui.Window;


//@SessionAttributes("Message")
@Controller
public class MessageController {

	@Autowired
	private MessageService meService;
	
	
	//받은메세지 리스트
	@RequestMapping("receivelist.do")
	public ModelAndView receiveMessageList(ModelAndView mv, HttpSession session,
										@RequestParam(value="page",required=false) Integer page) {
		
		UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");
		String receiveId = loginUser.getUserId();
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int listCount = meService.getListCountReceive(receiveId);
		
		PageInfoMessage pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Message> list = meService.selectListReceive(pi,receiveId);
		
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("message/receiveMessageList");
			
			System.out.println(pi);
			System.out.println(list);
			return mv;
		}
		
	//보낸 메세지 리스트
	@RequestMapping("sendlist.do")
	public ModelAndView sendMessageList(ModelAndView mv , HttpSession session,
										@RequestParam(value="page",required=false) Integer page) {
		
		UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");
		String sendId = loginUser.getUserId();
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int listCount = meService.getListCountSend(sendId);
		
		PageInfoMessage pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Message> list = meService.selectListSend(pi, sendId);
		
			mv.addObject("list",list);
			mv.addObject("pi",pi);
			mv.setViewName("message/sendMessageList");
		
		return mv;
	}
	//휴지통
		@RequestMapping("eraselist.do")
		public ModelAndView eraseMessageList(ModelAndView mv , HttpSession session,
											@RequestParam(value="page",required=false) Integer page) {
			
			UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");
			String receiveId = loginUser.getUserId();
			int currentPage = 1;
			if(page != null) {
				currentPage = page;
			}
			int listCount = meService.getListCountErase(receiveId);
			
			PageInfoMessage pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Message>list = meService.selectListErase(pi,receiveId);
			
				mv.addObject("list",list);
				mv.addObject("pi",pi);
				mv.setViewName("message/eraseMessageList");
			
				System.out.println(list);
			return mv;
		}
		//받은 메세지 디테일 뷰
		@RequestMapping("receiveMDetail.do")
		public ModelAndView receiveMessageDetail(ModelAndView mv, int messageNo) {
			System.out.println(messageNo);
			
			
			Message m = meService.receiveMessageDetail(messageNo);
//			System.out.println(m);
				
				mv.addObject("m",m);
				mv.setViewName("message/receiveMessageDetail");
				
			System.out.println(m);
			
			
			return mv;
		}
		//보낸 메세지 디테일 뷰
		@RequestMapping("sendMessageDetail.do")
		public ModelAndView sendMessageDetail(ModelAndView mv, int messageNo) {
			
			Message m = meService.sendMessageDetail(messageNo);
			
			if(m != null) {
				mv.addObject("m",m);
				mv.setViewName("message/sendMessageDetail");
			}else {
				throw new lwException("보낸 메세지 조회 실패");
			}
			return mv;
		}
		
		//메세지 휴지통으로
		@RequestMapping("eraseMessage.do")
		public String eraseMessage(String chk) {
//			System.out.println(chk);
			String[] arrChk = chk.split(",");
			for(int i=0;i<arrChk.length; i++) {
				
				meService.eraseMessage(Integer.parseInt(arrChk[i]));
//				System.out.println(meService.eraseMessage(Integer.parseInt(arrChk[i])));
			}
			
			return "redirect:receivelist.do";
		}
		
		//메세지 삭제
		@RequestMapping("deleteMessage.do")
		public String deleteMessage(String chk) {
			String[] darrChk = chk.split(",");
			for(int i=0;i<darrChk.length; i++) {
				meService.deleteMessage(Integer.parseInt(darrChk[i]));
			}
			return "redirect:eraselist.do";
		}
		
		//메세지 복원
		@RequestMapping("rewindMessage.do")
		public String rewindMessage(String chk) {
			String[] rarrChk = chk.split(",");
			for(int i=0;i<rarrChk.length; i++) {
				meService.rewindMessage(Integer.parseInt(rarrChk[i]));
			}
			return "redirect:eraselist.do";
		}
		
		//메세지 상태 업데이트
		@RequestMapping("updateMessageStatus")
		public String updateMessageStatus(int messageNo) {
			
			int result=meService.updateMessageStatus(messageNo);
			
			return "redirect:receivelist.do";
		}
		
		//메세지 보내기 뷰로가기
		@RequestMapping("sendMessageGo.do")
		public String sendMessageGo(HttpSession session) {
			
			return "message/sendMessage";
		}
		
		//메세지 보내기
		@RequestMapping("sendMessage.do")
		public void resendMessage(Message m,HttpSession session,HttpServletResponse response,
				@RequestParam(value="messageContent",required=false) String messageContent,
				@RequestParam(value="receiveId",required=false) String receiveId) throws IOException {
			
			UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");
			String sendId = loginUser.getUserId();
			
			PrintWriter out = response.getWriter();
			
			m.setReceiveId(receiveId);
			m.setSendId(sendId);
			m.setMessageContent(messageContent);
			
			int result = meService.sendMessage(m);
			
			if(result > 0) {
				out.append("success");
				out.flush();
			}
			out.close();
			
		}
		
		//답장하기 뷰
		@RequestMapping("resendView.do")
		public ModelAndView resendView(ModelAndView mv, HttpSession session, 
									int messageNo) {
			
			System.out.println(messageNo);
			UserInfo loginUser = (UserInfo)session.getAttribute("UserInfo");
			String userId=loginUser.getUserId();
			
			String receiveId = meService.resendView(messageNo);
			
			mv.addObject("receiveId", receiveId);
			mv.addObject("sendId", userId);
			mv.setViewName("message/resendMessage");
			return mv;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
