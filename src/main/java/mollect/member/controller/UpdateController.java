package mollect.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mollect.member.model.service.MemberService;
import mollect.member.model.vo.Member;

/**
 * Servlet implementation class ModifyController
 */
@WebServlet("/member/update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/member/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		String memberPhone = request.getParameter("member-phone");
		String memberEmail = request.getParameter("member-email");
		String memberGender = request.getParameter("member-gender");
		MemberService service = new MemberService();
		Member member = new Member(memberId, memberPw, memberName, memberPhone, memberEmail, memberGender);
		int result = service.updateMember(member);
		if(result > 0) {
//			response.sendRedirect("/member/mypage.do");
//			request.getRequestDispatcher("/member/mypage.do").forward(request, response);
			response.sendRedirect("/member/mypage.do");
		}else {
			request.getRequestDispatcher("/member/mypage.do").forward(request, response);
		}
	}
}
