package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import bean.GroupBean;
import bean.MatchingBean;
import bean.PostBean;

public class MatchingDao extends DbConnectDao{

	public MatchingBean isMatching(PostBean newPost) throws SQLException{
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		PreparedStatement pstmt4=null;
		PreparedStatement pstmt5=null;

		MatchingBean matching = new MatchingBean();

		ArrayList<String> groupList = new ArrayList<String>();
		try {
			//自分のpostをデータベースへ
			String sql="insert into post (post_id,user_id,purpose)values (seq_post_id.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,newPost.getUserId());
			pstmt.setString(2,newPost.getPurpose());
			pstmt.executeUpdate();

			//ユーザの所属するグループすべてをgroupListへ投入
			String sql1="select group_name from usergroup where user_id = ? ";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1,newPost.getUserId());
			rs = pstmt1.executeQuery();

			while(rs.next()){
				System.out.println("このユーザの所属するteam名をリストに入れてます");
				groupList.add(rs.getString("group_name"));
			}

			for (String group : groupList){
				ArrayList<String> userList = new ArrayList<String>();

				//groupListのそれぞれにいるユーザをすべてをuserListへ投入
				String sql2="select user_id from usergroup where group_name =?";
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setString(1,group);
				rs = pstmt2.executeQuery();

				while(rs.next()){
					System.out.println("このteamに所属するuserIdをリストに入れてます");
					userList.add(rs.getString("user_id"));
				}

				//userListがもってるpost一覧をpostListへ投入（post型）
				ArrayList<PostBean> postList = new ArrayList<PostBean>();
				for (String userId : userList){

					String sql3="select post_id, purpose,user_id from post where user_id = ? and purpose=?";
					pstmt3 = con.prepareStatement(sql3);
					pstmt3.setString(1,userId);
					pstmt3.setString(2,newPost.getPurpose());
					rs = pstmt3.executeQuery();

					while(rs.next()){
						System.out.println("このteamに所属するuserが出してるpostをリストに入れてます");
						PostBean post = new PostBean();
						post.setPostId(rs.getString("post_id"));
						post.setUserId(rs.getString("user_id"));
						post.setPurpose(rs.getString("purpose"));
						postList.add(post);
					}
				}




				if(postList.size()>=3){
					//matchingへ要素追加
					matching.setPurpose(newPost.getPurpose());
					//データベースへ
					System.out.println("マッチング成立しました");
					String sql4="insert into matching (matching_id,purpose) values (seq_matching_id.nextval,?)";
					pstmt4 = con.prepareStatement(sql4);
					pstmt4.setString(1,matching.getPurpose());
					pstmt4.executeUpdate();

					//各ポストへmatching_idを追加
					for (PostBean post:postList){
						//データベースへ
						String sql5="update post set matching_id = ? where post_id = ?";
						pstmt5 = con.prepareStatement(sql5);
						pstmt5.setString(1,"3");
						pstmt5.setString(2,post.getPostId());
						pstmt5.executeUpdate();
					}
				}else{
					System.out.println("マッチング成立しませんでした");
				}
				}





			return matching;
		}finally{
			if (this.rs != null) {
				this.rs.close();
			}
			if (this.pstmt != null) {
				this.pstmt.close();
			}
		}
	}
}
