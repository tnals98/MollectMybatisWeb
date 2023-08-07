package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;



/**
 * Servlet implementation class ModifyController
 */
@WebServlet("/notice/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
				NoticeService service = new NoticeService();
				Notice notice = service.selectOneByNo(noticeNo);
				if(notice != null) {
					request.setAttribute("notice", notice);
					request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeSubject = request.getParameter("noticeSubject");
		String noticeContent = request.getParameter("noticeContent");
		Notice notice = new Notice(noticeNo, noticeSubject, noticeContent);
		NoticeService service = new NoticeService();
		int result = service.modifyNotice(notice);
		if(result > 0) {
			// 성공하면 상세페이지로 이동
			response.sendRedirect("/notice/detail.do?noticeNo="+noticeNo);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
		}
	}

}
