package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/notice/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				NoticeService service = new NoticeService();
				String page = request.getParameter("currnetPage") != null ? request.getParameter("currnetPage") : "1";
				int currnetPage = Integer.parseInt(page);
				List<Notice> nList = service.selectNoticeList(currnetPage);
				if(!nList.isEmpty()) {
					request.setAttribute("nList", nList);
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp");
					
					view.forward(request, response);
				}else {
					request.setAttribute("url", "/index.jsp");
					request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
