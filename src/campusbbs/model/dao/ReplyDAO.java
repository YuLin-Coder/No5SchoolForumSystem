package campusbbs.model.dao;

import java.util.List;

import campusbbs.model.vo.Reply;

/**
 * 回复
 * @author EsauLu
 *
 */
public interface ReplyDAO {
	
	/**
	 * 保存回复
	 * @param reply 回复
	 */
	public void saveReply(Reply reply);
	
	/**
	 * 删除指定ID的回复
	 * @param id 回复ID
	 */
	public void deleteReplyById(int ReplyId);
	
	
	/**
	 * 查找指定帖子的所有回复
	 * @param postId 帖子ID
	 * @param pageCode 页码
	 * @param size 查找数量
	 * @return 回复列表
	 */
	public List<Reply> findReplyByPost(int postId,int pageCode, int size);
	
	
	/**
	 * 查找指定用户的所有回复
	 * @param userName 用户名
	 * @param pageCode 页码
	 * @param size 查找数量
	 * @return 回复列表
	 */
	public List<Reply> findReplyByUser(String userName,int pageCode, int size);
	
	/**
	 * 获取所有回复记录
	 * @return 回复列表
	 */
	public List<Reply> findAllReply(int pageCode, int size);
	
	/**
	 * 获取某主题帖的回复数
	 * @param postId 主题帖ID
	 * @return 回复数量
	 */
	public long getReplyCountByPost(int postId);
	
	/**
	 * 获取某主题帖的回复数
	 * @param userName 用户名
	 * @return 回复数量
	 */
	public long getReplyCountByUser(String userName);
	
	/**
	 * 获取所有回复数量
	 * @return 回复记录总数
	 */
	public long getAllReplyCount();
	
	
}


































