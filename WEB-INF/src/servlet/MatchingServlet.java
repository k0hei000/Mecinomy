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
		ServletContext sc = null;
		//エラーメッセージの一時保存用変数
		String message = null;
		//デフォルトの転送先
		String destination = null;
		//エラーメッセージ処理クラスのインスタンス化
		ArrayList<String> error = new ArrayList<String>();
		//セッションの取得（なければ作成）
		HttpSession session = request.getSession(true);
		String purpose = (String) session.getAttribute("purpose");
		String timeStart = (String) session.getAttribute("timeStart");
		String timeEnd = (String) session.getAttribute("timeEnd");
		String userId = (String) session.getAttribute("userId");
		PostBean post = new PostBean(purpose,timeStart,timeEnd,userId);
//		GroupBean group = new GroupBean();
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
			destination = "jsp/match/wait.jsp";
		} else {
			destination = "jsp/match/match.jsp";
		}
		//RequestDispatcherオブジェクトを取得
		RequestDispatcher rd = sc.getRequestDispatcher(destination);
		//forwardメソッドで、処理をreceive.jspに転送
		rd.forward(request, response);
	}
}
