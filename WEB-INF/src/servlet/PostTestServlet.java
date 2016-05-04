package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/PostTest")
public class PostTestServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 7212317601530485832L;
	protected void doPost(HttpServletRequest request , HttpServletResponse response)
			throws ServletException,IOException {
		//デフォルトの転送先
		String destination = "/WEB-INF/jsp/post/Post.jsp";
		//エラーメッセージ処理クラスのインスタンス化
		ArrayList<String> error = new ArrayList<String>();
		//セッションの取得（なければ作成）
		HttpSession session = request.getSession(true);
		String userId = "C0002";
		session.setAttribute("userId", userId);

		//ServletContextオブジェクトを取得
		ServletContext sc = this.getServletContext();
		//RequestDispatcherオブジェクトを取得
		RequestDispatcher rd = sc.getRequestDispatcher(destination);
		//forwardメソッドで、処理をreceive.jspに転送
		rd.forward(request, response);
	}
}
