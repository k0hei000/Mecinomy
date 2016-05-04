package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MatchingBean;
import bean.PostBean;
import logic.MatchingLogic;

public class MatchingServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -6945929109627628817L;
	protected void doPost(HttpServletRequest request , HttpServletResponse response)
			throws ServletException,IOException {
		//デフォルトの転送先
		String destination = null;
		//エラーメッセージ処理クラスのインスタンス化
		ArrayList<String> error = new ArrayList<String>();
		//セッションの取得（なければ作成）
		HttpSession session = request.getSession(true);
		String purpose = request.getParameter("purpose");
		String timeStart = request.getParameter("timeStart");
		String timeEnd = request.getParameter("timeEnd");
		String userId = request.getParameter("userId");
		if (userId == null || purpose == null) {
			error.add("null user or purpose!");
			System.out.println("error!");
			session.setAttribute("errormessage",error);
		} else {
			PostBean post = new PostBean(purpose,timeStart,timeEnd,userId);
//			GroupBean group = new GroupBean();
			//matchingのロジック
			MatchingLogic logic = new MatchingLogic();
			MatchingBean match = null;
			try {
				match = logic.matchingCheck(post);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			if(match == null){
				destination = "/WEB-INF/jsp/match/wait.jsp";
			} else {
				session.setAttribute("match", match);
				destination = "/WEB-INF/jsp/match/match.jsp";
			}
		}
		if(!error.isEmpty()){
			destination = "/WEB-INF/jsp/post.jsp";
		}
		//ServletContextオブジェクトを取得
		ServletContext sc = this.getServletContext();
		//RequestDispatcherオブジェクトを取得
		RequestDispatcher rd = sc.getRequestDispatcher(destination);
		//forwardメソッドで、処理をreceive.jspに転送
		rd.forward(request, response);
	}
}
