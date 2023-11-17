package campusbbs.model.dao.impl;

import java.util.List;

import campusbbs.model.dao.PostDAO;
import campusbbs.model.utils.SQLUtils;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.UserInfo;

public class PostDAOImpl implements PostDAO {

	@Override
	public void savaPost(Post post) {
		// TODO Auto-generated method stub
		
		String sql="insert into post(postTitle,postContent,postTime,lastTime,userName,clubName,postTypeId) value(?,?,?,?,?,?,?);";
		Object[] objs={
				post.getPostTitle(),
				post.getPostContent(),
				post.getPostTime(),
				post.getLastTime(),
				post.getUserName(),
				post.getClubName(),
				post.getPostTypeId()
		};

		SQLUtils.updateRecord(sql, objs);

	}

	@Override
	public void addPostType(PostType type) {
		// TODO Auto-generated method stub
		
		String sql="insert into post_type(postType,color) value(?,?);";
		Object[] param={
			type.getPostType(),
			type.getColor()
		};
		SQLUtils.updateRecord(sql, param);
		
	}

	@Override
	public void deletePostById(int id) {
		// TODO Auto-generated method stub
		String sql="delete from post where postId="+id+";";
		SQLUtils.updateRecord(sql);
	}

	@Override
	public void deletePostType(int id) {
		// TODO Auto-generated method stub
		String sql="delete from post_type where postTypeId="+id+";";
		SQLUtils.updateRecord(sql);
	}

	@Override
	public Post findPostById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from post "
				+ "where postId="+id+";";
		
		Post post=SQLUtils.queryRecordById(sql, Post.class);
		
		//用户发帖用户的头像
		sql="select nickname,head from user_info where userName= '"+post.getUserName()+"';";

		UserInfo info=SQLUtils.queryRecordById(sql, UserInfo.class);
		post.setUserHead(info.getHead());			
		post.setUserNickname(info.getNickname());
		
		return post;
	}

	@Override
	public PostType findPostTypeById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from post_type where postTypeId="+id+";";
		return SQLUtils.queryRecordById(sql, PostType.class);
	}

	@Override
	public void updatePostType(PostType postType) {
		// TODO Auto-generated method stub
		
		String sql="update post_type set postType=?,color=? where postTypeId="+postType.getPostTypeId();
		Object[] param={
				postType.getPostType(),
				postType.getColor()
		};
		SQLUtils.updateRecord(sql, param);
		
	}

	@Override
	public long getAllPostNum() {
		// TODO Auto-generated method stub
		String sql="select count(*) from post";
		return SQLUtils.getRecordCount(sql);
	}

	@Override
	public long getPostNumByCLub(String clubName) {
		// TODO Auto-generated method stub
		String sql="select count(*) from post where clubName='"+clubName+"';";
		return SQLUtils.getRecordCount(sql);
	}

	@Override
	public long getPostTypeCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from post";
		return SQLUtils.getRecordCount(sql);
	}

	@Override
	public List<Post> findPostByClub(String clubName, int pageCode, int size) {
		// TODO Auto-generated method stub

		String sql="select post.postId,post.postTitle,post.postTime,post.lastTime,post.userName,post.clubName,post.postTypeId from post "
					+ "where post.clubName='"+clubName+"' "
					+ "order by post.lastTime desc "
					+ "limit "+((pageCode-1)*size)+","+size+";";
		return SQLUtils.queryRecordList(sql, Post.class);
	}

	@Override
	public List<Post> findLastPost(int pageCode, int size) {
		// TODO Auto-generated method stub
		
		String sql="select post.postId,post.postTitle,post.postTime,post.lastTime,post.userName,post.clubName,post.postTypeId from post "
					+ "order by postTime desc "
					+ "limit "+((pageCode-1)*size)+","+size+";";

		return SQLUtils.queryRecordList(sql, Post.class);
		
	}
	
	@Override
	public List<Post> findHostPost(int pageCode, int size) {
		// TODO Auto-generated method stub
		
		String sql="select post.postId,post.postTitle,post.postTime,post.lastTime,post.userName,post.clubName,post.postTypeId from post "
					 + "left join reply "
					 + "on post.postId=reply.postId "
					 + "group by post.postId "
					 + "order by count(reply.replyId) desc "
					 + "limit "+((pageCode-1)*size)+","+size+";";

		return SQLUtils.queryRecordList(sql, Post.class);
	}

	@Override
	public List<PostType> getPostTypeList() {
		// TODO Auto-generated method stub
		String sql="select * from post_type;";
		return  SQLUtils.queryRecordList(sql, PostType.class);
	}

	@Override
	public long getPostNumByUser(String userName) {
		// TODO Auto-generated method stub		
		String sql="select count(*) from post where userName='"+userName+"';";
		return SQLUtils.getRecordCount(sql);
	}

	@Override
	public List<Post> findPostByUser(String userName, int pageCode, int size) {
		// TODO Auto-generated method stub

		String sql="select post.postId,post.postTitle,post.postTime,post.lastTime,post.userName,post.clubName,post.postTypeId from post "
					+ "where post.userName='"+userName+"' "
					+ "order by post.lastTime desc "
					+ "limit "+((pageCode-1)*size)+","+size+";";

		return SQLUtils.queryRecordList(sql, Post.class);
		
	}	
	
}
































