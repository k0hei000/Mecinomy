package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;

public class UserDao extends DbConnectDao {

	//	public UserBean getUserById(Connection con,String name) throws SQLException{
//		UserBean user = null;
//		PreparedStatement pstmt=null;
//		ResultSet rs = null;
//		String sql = "SELECT user_id,password FROM usertable " +
//				"where usertable.is_delete < 1 and usertable.user_id = ?";
//
//		try{
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,name);
//			rs = pstmt.executeQuery();
//
//			if(rs.next()){
//				user = new UserBean();
//				user.setUserId(rs.getString("user_id"));
//				user.setPassword(rs.getString("password"));
//			}
//		}finally{
//			if(rs!=null)
//				rs.close();
//			if(pstmt!=null)
//				pstmt.close();
//		}
//
//		return user;
//	}

	public UserBean getUserById(String userId,String password) throws SQLException{
		UserBean user = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "SELECT user_id, password FROM usertable " +
				"where usertable.is_delete < 1 and usertable.user_id = ? and usertable.password = ?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if(rs.next()){
				user = new UserBean();
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
			}
		}finally{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
		}
		return user;
	}
}
