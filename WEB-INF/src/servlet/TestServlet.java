package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MatchingBean;
import bean.PostBean;
import dao.MatchingDao;


@WebServlet("/test")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
   req.setCharacterEncoding("UTF-8");
   res.setCharacterEncoding("UTF-8");

   res.setContentType("text/html; charset=UTF-8");

   PostBean newPost = new PostBean();
   newPost.setPurpose("00002");
   newPost.setUserId("aaaa");

   MatchingDao dao = new MatchingDao();
   MatchingBean newMatching = new MatchingBean();

   try {
		dao.getConnection();
		newMatching = dao.isMatching(newPost);
	} catch (NamingException | SQLException e) {
		e.printStackTrace();
	} finally{
		try {
			dao.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


 	}
 }
