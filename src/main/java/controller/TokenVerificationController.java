package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.VerificationTokenBo;

/**
 * Servlet implementation class TokenVerificationController
 */
@WebServlet("/TokenVerification")
public class TokenVerificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TokenVerificationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String tokenIdTxt = request.getParameter("tokenId");
		String token = request.getParameter("token");
		if(tokenIdTxt == null || token == null) {
			response.sendRedirect("DangKy");
			return;
		}
		long tokenId = Long.parseLong(tokenIdTxt);
		VerificationTokenBo verificationTokenBo = new VerificationTokenBo();
		boolean verify = verificationTokenBo.verify(tokenId, token);
		System.out.println(verify);
		if(verify) {
			verificationTokenBo.updateVerified(tokenId);
			String email = verificationTokenBo.getEmailByTokenId(tokenId);
			session.setAttribute("email", email);
			System.out.println(email + " da xac thuc token");
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
