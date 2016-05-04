package logic;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import bean.MatchingBean;
import bean.UserBean;
import dao.MatchingDao;
import dao.UserDao;

public class MatchingLogic extends AbstractLogic{

	public MatchingBean matchingCheck() throws SQLException,NamingException{
		MatchingDao matchingDao = new MatchingDao();
		MatchingBean matchingBean = null;
		Connection con=null;
		try{
			matchingDao.getConnection();
		}finally{
			matchingDao.closeConnection();
		}
		return matchingBean;
	}
}
