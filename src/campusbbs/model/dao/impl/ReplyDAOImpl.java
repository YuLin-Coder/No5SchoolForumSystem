package campusbbs.model.dao.impl;

import java.util.List;

import campusbbs.model.dao.ReplyDAO;
import campusbbs.model.utils.SQLUtils;
import campusbbs.model.vo.Reply;

public class ReplyDAOImpl implements ReplyDAO {
	
	private static final String REPLY_TABLE="reply";

	@Override
	public void saveReply(Reply reply) {
		// TODO Auto-generated method stub
		
		String sql="insert into "+REPLY_TABLE+"(replyContent,replyTime,postId,userName) values(?,?,?,?);";
		Object[] param={
				reply.getReplyContent(),
				reply.getReplyTime(),
				reply.getPostId(),
				reply.getUserName()
		};
		SQLUtils.updateRecord(sql, param);
		
		//更新最后回复时间
		sql="update post set lastTime='"+reply.getReplyTime()+"' where postId="+reply.getPostId()+";";
		SQLUtils.updateRecord(sql,param);
		
	}

	@Override
	public void deleteReplyById(int replyId) {
		// TODO Auto-generated method stub
		String sql="delete from reply where replyId="+replyId;
		SQLUtils.updateRecord(sql);
	}

	@Override
	public List<Reply> findReplyByPost(int postId, int pageCode, int size) {
		// TODO Auto-generated method stub
		String sql="select reply.replyId,reply.replyContent,reply.replyTime,reply.postId,reply.userName,user_info.nickname userNickname,user_info.head userHead "
				+ " from reply,user_info "
				+ " where postId="+postId+" and reply.userName=user_info.userName "
						+ " order by reply.replyTime "
						+ " limit "+((pageCode-1)*size)+","+size+";";
		
		return SQLUtils.queryRecordList(sql, Reply.class);
	}

	@Override
	public List<Reply> findReplyByUser(String userName, int pageCode, int size) {
		// TODO Auto-generated method stub
		String sql="select reply.replyId,reply.replyContent,reply.replyTime,reply.postId,reply.userName,user_info.nickname userNickname,user_info.head userHead "
				+ " from reply,user_info "
				+ " where reply.userName='"+userName+"' and reply.userName=user_info.userName "
						+ " order by reply.replyTime "
						+ " limit "+((pageCode-1)*size)+","+size+";";

		return SQLUtils.queryRecordList(sql, Reply.class);
	}

	@Override
	public List<Reply> findAllReply(int pageCode, int size) {
		// TODO Auto-generated method stub
		
		String sql="select reply.replyId,reply.replyContent,reply.replyTime,reply.postId,reply.userName,user_info.nickname userNickname,user_info.head userHead "
				+ " from reply,user_info "
				+ " where reply.userName=user_info.userName "
						+ " order by reply.replyTime "
						+ " limit "+((pageCode-1)*size)+","+size+";";

		return SQLUtils.queryRecordList(sql, Reply.class);
	}

	@Override
	public long getReplyCountByPost(int postId) {
		// TODO Auto-generated method stub
		String sql="select count(*) from reply where postId="+postId+";";
		return SQLUtils.getRecordCount(sql);
	}

	@Override
	public long getAllReplyCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from reply;";
		return SQLUtils.getRecordCount(sql);
	}

	@Override
	public long getReplyCountByUser(String userName) {
		// TODO Auto-generated method stub
		String sql="select count(*) from reply where userName='"+userName+"';";
		return SQLUtils.getRecordCount(sql);
	}
	
}











































