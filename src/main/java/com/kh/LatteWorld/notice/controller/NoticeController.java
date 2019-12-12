package com.kh.LatteWorld.notice.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.LatteWorld.exception.lwException;
import com.kh.LatteWorld.notice.model.service.NoticeService;
import com.kh.LatteWorld.notice.model.vo.Notice;

@Controller
public class NoticeController {
	// 항상 클래스들을 만들면(MVC구조로)
	// Controller, ServiceImpl, Dao 각각에 어노테이션을 붙여서 서로 의존성 주입 관계가 어떻게 되는지
	// 설정하고 시작하자.
	
	// 그리고 이번 공지사항은 서비스 인터페이스 먼저 만들고 시작하자.
	// PM이 어떤 메소드 쓰자고 정해주면 팀원들은 그것에 맞춰서 작업을 하게 되니까..
	// 인터페이스와 인터페이서impl을 자동 완성 했다면~
	
	
	@Autowired
	NoticeService nService;
	
	@RequestMapping("noticeListView.do")
	public ModelAndView noticeList(ModelAndView mv) {
		
		ArrayList<Notice> list = nService.selectList();
//		System.out.println(list);
		
		if(list != null) {
			mv.addObject("list",list);
			mv.setViewName("notice/noticeListView");
			
		}else {
			throw new lwException("공지사항 목록 보기 실패!!");
		}
		
		return mv;
	}
	
	@RequestMapping("noticeDetailView.do")
	public String noticeDetail(Model model, int nId, Notice n) {
		n = nService.selectOne(nId);
//		System.out.println(n);
		if(n!=null) {
			model.addAttribute("notice", n);
		}else {
			throw new lwException("공지사항 상세보기 실패!!");
		}
		
		return "notice/noticeDetailView";
	}
	
	@RequestMapping("nWriterView.do")
	public String nWriterView() {
		return "notice/noticeWriteForm";	// noticeWriteForm.jsp만들자
	}
	
	@RequestMapping("ninsert.do")
	public String noticeInsert(Notice n, HttpServletRequest request,
								@RequestParam(name = "uploadFile1", required = false) MultipartFile file) {
		// pom.xml 가서 일단 multipart 인코딩 타입으로 파일을 넘겨줄 때 필요한 라이브러리부터 다운 받자.
		// 그냥 한번 출력해 보면 다 null로 나오는 걸 확인할 수 있다.(물론, 파일 업로드 관련 라이브러리 추가 하고 나서)
		
		// required를 안 써주면 사용자가 파일을 안 올리고 공지글을 썼을 때 uploadFile이 없다는 에러가 떠버리므로
		// required=false라는 속성을 써주자.
		System.out.println(file.getOriginalFilename());
		if(!file.getOriginalFilename().contentEquals("")) {
			String savePath = saveFile(file, request);
			
			if(savePath != null) {	// 파일이 잘 저장된 경우
				n.setFilePath(file.getOriginalFilename());
			}
		}
		
		int result = nService.insertNotice(n);
		
		if(result > 0) {
			return "redirect:noticeListView.do";
		}else {
			throw new lwException("공지사항 등록 실패!");
		}
		
	}
	
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일이 저장될 경로를 설정하는 메소드
		
		// 웹 서버의 contextPath(webapp)을 불러 와서 그 아래 resources 경로를 String으로 뽑자
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String savePath = root + "\\nuploadFiles";
		
		File folder = new File(savePath);
		
		// nuploadFiles가 없으면 생성해라.
		if(!folder.exists())
		{
			folder.mkdirs();
		}
		
		// 공지글은 굳이 파일명 중복 제거는 신경쓰지 말고 게시판에서 파일명 rename하는거 하자!
		// 공지글은 보통 관리자만 쓰니깐..
		String filePath = folder + "\\" +file.getOriginalFilename(); // 실제 저장될 파일 경로 + 파일명
		
		try {
			file.transferTo(new File(filePath)); // 이 때 파일이 저장된다.
			// 이게 실행되서 파일이 경로에 저장될려면 pom.xml에서 파일 업로드 관련 라이브러리 두개를 추가하고
			// root-context.xml에서 파일 크기 지정을 해줘야지만 파일이 저장된다!!!!!!!!!!!
			
		}catch(Exception e) {
			System.out.println("파일 전송 에러 : " + e.getMessage());
		}
		
		return filePath;
	}
	
	@RequestMapping("nupView.do")
	public String noticeUpdateView(Model model, int nId) {
			model.addAttribute("notice", nService.selectOne(nId));	// 이건 기존에 상세보기에서 구현했샴
			
		return "notice/noticeUpdateView";
	}
	
	@RequestMapping("nupdate.do")
	public String noticeUpdate(HttpServletRequest request, Notice n,
								@RequestParam(value="reloadFile", required=false)
								MultipartFile reloadFile) {
		/*
		 * @RequestParam이 적용된 필드가 없으면(즉, required=false가 없으면)
		 * Bad Request, Required String parameter 'name' is not preset
		 * 라는 예외가 발생 되므로 사용자가 파일을 올리지 않아도 수정이 되게 required=false로 하자.
		 * 
		 */
		
		 if(reloadFile != null && !reloadFile.isEmpty()) {	// 새로 업로드한 파일이 있다면
			 if(n.getFilePath() != null) {	// 기존의 파일이 존재했을 경우 기존 파일을 삭제해 주자.
				 deleteFile(n.getFilePath(), request);
			 }
		 }
		 
		 // 새로 업로드 된 파일은 새로 저장해 주고
		 String savePath= saveFile(reloadFile, request);
		 
		 if(savePath != null) {	// 잘 저장 되었다면
			 n.setFilePath(reloadFile.getOriginalFilename());
		 }
		 
		 int result = nService.updateNotice(n);
		 
		 if(result > 0) {
			 return "redirect:noticeListView.do";
		 }else {
			 throw new lwException("공지사항 수정 실패!!");
		 }

	}
	
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\nuploadFiles";
		
		File f = new File(savePath + "\\" + fileName);
		if(f.exists())
			f.delete();
	}
	
	@RequestMapping("ndelete.do")
	public String noticeDelete(int nId, HttpServletRequest request) {
		Notice n = nService.selectOne(nId);	//파일 지우기 위해 nId의 공지사항 조회
		
		// DB에서 공지사항을 지우기 전에 그 녀석이 깔아놓은 파일도 깔끔하게 지우자
		if(n.getFilePath() !=null) {	// 해당 공지사항에 첨부파일이 존재했을 경우
			deleteFile(n.getFilePath(), request);
		}
		
		// 이제 DB에서 공지사항을 지우자
		int result = nService.deleteNotice(nId);
		
		if(result > 0) {
			return "redirect:noticeListView.do";
		}else {
			throw new lwException("공지사항 삭제 실패!!");
		}
			
	}

}
