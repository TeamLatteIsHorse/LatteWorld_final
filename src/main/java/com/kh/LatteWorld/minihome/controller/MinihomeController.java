package com.kh.LatteWorld.minihome.controller;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.LatteWorld.UserInfo.model.service.UserService;
import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;
import com.kh.LatteWorld.common.PageInfo;
import com.kh.LatteWorld.common.Pagination;
import com.kh.LatteWorld.exception.lwException;
import com.kh.LatteWorld.minihome.model.service.MinihomeService;
import com.kh.LatteWorld.minihome.model.vo.MiniHomeFolder;
import com.kh.LatteWorld.minihome.model.vo.MiniHomePost;
import com.kh.LatteWorld.minihome.model.vo.Minihomepy;

@Controller
public class MinihomeController {

	@Autowired
	MinihomeService miniService;
	
	@Autowired
	UserService uService;

	// 미니홈피 기본 정보
	@RequestMapping("minihome.do")
	public ModelAndView minihome(ModelAndView mv, String userId, String sessionId) {
		System.out.println(sessionId);
		Minihomepy minihome = miniService.selectMinihome(userId);
		UserInfo user = uService.selectUser(userId);
		
		mv.addObject("minihome", minihome);
		mv.addObject("user", user);
		mv.setViewName("minihome/miniHomeMain");
		return mv;
	}
	
	// 미니홈피 일반 게시글 전체목록 & 미니홈피 일반 게시판 목록 가져오기
	@RequestMapping("allList.do")
	public ModelAndView allList(ModelAndView mv,
								@RequestParam(value="page",required = false) Integer page,
								@RequestParam(value="bListNo", required = false) Integer bListNo,
								@RequestParam(value="homepyNo", required = false) Integer homepyNo,
								@RequestParam(value = "postType", required = false) String postType) {

		int currentPage = 1;
		if(page != null)
			currentPage = page;
		
		int listCount = miniService.getAllPostListCount(homepyNo, postType);
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<MiniHomePost> pList = miniService.selectAllPostList(pi, homepyNo, postType);
		ArrayList<MiniHomeFolder> fList = miniService.selectFolderList(homepyNo, postType);
		
		Minihomepy minihome = miniService.selectMinihome(homepyNo); 
		
		if((pList != null && pList.size() > 0) && (fList != null && fList.size() > 0)) {
			mv.addObject("minihome", minihome); 
			mv.addObject("pList", pList);
			mv.addObject("fList", fList);
			mv.addObject("pi", pi);
			mv.setViewName("post/postMain");
		} else if (fList != null && fList.size() > 0) {
			mv.addObject("minihome", minihome); 
			mv.addObject("fList", fList);
			mv.setViewName("post/postMain");
		} else
			throw new lwException("게시글 상세 조회 실패");
		
		return mv;
	}
	
	// 각 게시판 별 게시글 목록 불러오기
	@RequestMapping("postList.do")
	public ModelAndView postList(ModelAndView mv,
								@RequestParam(value="page",required = false) Integer page,
								@RequestParam(value="folderNo", required = false) Integer folderNo,
								@RequestParam(value="homepyNo", required = false) Integer homepyNo,
								@RequestParam(value="postType", required = false) String postType) {
		
		int currentPage = 1;
		if(page != null)
			currentPage = page;
		
		int fNo = folderNo;
		
		int listCount = miniService.getPostListCount(homepyNo, folderNo, postType);
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<MiniHomePost> pList = miniService.selectPostList(pi, homepyNo, folderNo, postType);
		ArrayList<MiniHomeFolder> fList = miniService.selectFolderList(homepyNo, postType);
		
		Minihomepy minihome = miniService.selectMinihome(homepyNo);
		
		if((pList != null && pList.size() > 0) && (fList != null && fList.size() > 0)) {
			mv.addObject("minihome", minihome); 
			mv.addObject("pi", pi);
			mv.addObject("pList", pList);
			mv.addObject("fList", fList);
			mv.addObject("fNo", fNo);
			mv.setViewName("post/postList");
		} else if (fList != null && fList.size() > 0) {
			mv.addObject("minihome", minihome); 
			mv.addObject("fList", fList);
			mv.setViewName("post/postList");
		} else
			throw new lwException("게시글 상세 조회 실패");
		
		return mv;
	}
	
	//미니홈피 게시글 작성페이지로 가는 것
	@RequestMapping("posetInsertView.do")
	public ModelAndView postInsert(ModelAndView mv, String postType, int homepyNo, int folderNo) {
		
		ArrayList<MiniHomeFolder> fList = miniService.selectFolderList(homepyNo, postType);
		
		mv.addObject("homepyNo", homepyNo);
		mv.addObject("fList", fList);
		mv.addObject("folderNo", folderNo);
		mv.setViewName("post/postInert");
		return mv;
	}
	
	// 미니홈피 게시글 작성
	@RequestMapping("postInsert.do")
	public String postInsert (int homepyNo, int folderNo, String postTitle, String postContent) {
		
//		MiniHomePost post = new MiniHomePost();
//		post.setHomepyNo(homepyNo);
//		post.setPostWriter();
//		post.setPostTitle(postTitle);
//		post.setPostContent(postContent);
		
//		int result = miniService.insertPost(post);
//		homepyNo, folderNo, postType
		return null;
		
	}
	
	// 미니홈피 일반  게시글 디테일
	@RequestMapping("postDetail.do")
	public ModelAndView postDetail(ModelAndView mv, int postNo,
								@RequestParam(value="page",required = false) Integer page,
								@RequestParam(value="homepyNo", required = false) Integer homepyNo) {
		
		int currentPage = 1;
		if(page != null)
			currentPage = page;
		
		miniService.postDetailCount(postNo);
		Minihomepy minihome = miniService.selectMinihome(homepyNo); 
		MiniHomePost post = miniService.selectOnePost(postNo);
		
		if(post != null) {
			mv.addObject("minihome", minihome); 
			mv.addObject("post", post);
			mv.addObject("currentPage", currentPage);
			mv.setViewName("post/postDetail");
		} else
			throw new lwException("게시글 상세 조회 실패");
		
		return mv;
	}
	
	// 미니홈피 게시판 설정페이지
	@RequestMapping("settingFolder.do")
	public ModelAndView settingBoard(ModelAndView mv, 
								@RequestParam(value="folderNo", required = false) Integer folderNo,
								@RequestParam(value="homepyNo", required = false) Integer homepyNo,
								@RequestParam(value = "postType", required = false) String postType) {
		
		Minihomepy minihome = miniService.selectMinihome(homepyNo); 
		ArrayList<MiniHomeFolder> fList = miniService.selectFolderList(homepyNo, postType);
		
		mv.addObject("minihome", minihome);
		mv.addObject("fList", fList);
		mv.setViewName("post/addFolder");
		return mv;
	}
	
	// 미니홈피 게시판 추가 (ajax)
	@RequestMapping("addFolder.do")
	@ResponseBody
	public String addFolder(MiniHomeFolder folder) {
		
		int result = miniService.addFolder(folder);
		
		if(result > 0) {
			return "success";
		} else {
			throw new lwException("게시판 목록 추가 실패");
		}
		
	}
}
