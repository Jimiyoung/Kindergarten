package story;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodMenu.FoodMenuDAO;
import foodMenu.FoodMenuVO;

public class NuriContentCommand implements NuriInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null ? 0 : Integer.parseInt(request.getParameter("idx"));
		int pag = request.getParameter("pag")==null ? 1 : Integer.parseInt(request.getParameter("pag"));
		int pageSize = request.getParameter("pageSize")==null ? 1 :Integer.parseInt(request.getParameter("pageSize"));
		String flag = request.getParameter("flag")==null ? "" :  request.getParameter("flag");
		String search = request.getParameter("search")==null ? "" : request.getParameter("search");
		String searchString = request.getParameter("searchString")==null ? "" : request.getParameter("searchString");

		NuriDAO dao = new NuriDAO();
		
	//글 조회수 1회 증가시키기(조회수 중복방지처리 - 세션사용 : 'notice+고유번호'를 객체배열에 추가한다.)
			HttpSession session = request.getSession();
			ArrayList<String> contentIdx = (ArrayList) session.getAttribute("sContentIdx");
			if(contentIdx==null) {  // 없으면 생성. notice content에 처음 들어갔을 때.
				contentIdx = new ArrayList<String>();
			}
			
			String imsiContentIdx="notice"+idx;
			if(!contentIdx.contains(imsiContentIdx)) {  //없으면 조회수 증가
				dao.setReadNum(idx);
				contentIdx.add(imsiContentIdx);
			}
			session.setAttribute("sContentIdx", contentIdx);
			
	//선택한 게시글(idx)의 전체 내용 가져오기
			NuryVO vo = dao.getNuriContent(idx);
			request.setAttribute("vo", vo);
			request.setAttribute("pag", pag);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("flag", flag);
			request.setAttribute("search", search);
			request.setAttribute("searchString", searchString);
			
	//이전글과 다음글 처리(이전글/다음글의 타이틀을 가져온다.) 
			NuryVO preVo = dao.getPreNextSearch("pre",idx);
			NuryVO nextVo = dao.getPreNextSearch("next",idx);
			request.setAttribute("preVo", preVo);
			request.setAttribute("nextVo", nextVo);		
			
	// 입력한 댓글 가져오기
			ArrayList<NuriReplyVO> replyVos = dao.getNuriReply(idx);	
			request.setAttribute("replyVos", replyVos);
			
	//댓글 수정처리를 위한 작업(replyIdx를 가지고, 댓글의 content를 가져와서 다시 전송시킨다.)
			int replyIdx =request.getParameter("replyIdx")==null? 0 : Integer.parseInt(request.getParameter("replyIdx"));
			
			if(replyIdx !=0) {
				String replyContent = dao.getReplyContent(replyIdx);
				
				request.setAttribute("replyIdx", replyIdx);
				request.setAttribute("replyContent", replyContent);
				
			}
		}

}
