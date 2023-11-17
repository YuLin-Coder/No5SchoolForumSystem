package campusbbs.model.vo;

import java.sql.Timestamp;

/**
 * 回复
 * @author EsauLu
 *
 */
public class Reply {

	/**
	 * 回复ID
	 */
	private int replyId;
	
	/**
	 * 回复内容
	 */
	private String replyContent;
	
	/**
	 * 回复时间
	 */
	private Timestamp replyTime;
	
	/**
	 * 帖子ID
	 */
	private int postId;
	
	/**
	 * 回复用户
	 */
	private String userName;
	
	/**
	 * 用户头像
	 */
	private String userHead;
	
	/**
	 * 用户头像
	 */
	private String userNickname;

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyContent=" + replyContent + ", replyTime=" + replyTime + ", postId="
				+ postId + ", userName=" + userName + ", userHead=" + userHead + ", userNickname=" + userNickname + "]";
	}	
	
}








































