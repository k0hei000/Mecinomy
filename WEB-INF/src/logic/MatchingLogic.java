package logic;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import bean.GroupBean;
import bean.MatchingBean;
import bean.PostBean;
import bean.UserBean;
import dao.MatchingDao;
import dao.UserDao;

public class MatchingLogic extends AbstractLogic{

	public MatchingBean matchingCheck(PostBean post) throws SQLException,NamingException{
		MatchingDao matchingDao = new MatchingDao();
		MatchingBean matchingBean = null;
//		Connection con=null;
		try{
			matchingDao.getConnection();
			matchingDao.???(post);
		}finally{
			matchingDao.closeConnection();
		}
		return matchingBean;
	}
}
