package campusbbs.model.vo;

import java.sql.Timestamp;

/**
 * 帖子
 * @author EsauLu
 *
 */
public class Post {

	/**
	 * 帖子ID
	 */
	private int postId;
	
	/**
	 * 标题
	 */
	private String postTitle;
	
	/**
	 * 内容
	 */
	private String postContent;
	
	/**
	 * 发帖时间
	 */
	private Timestamp postTime;
	
	/**
	 * 最后回复时间
	 */
	private Timestamp lastTime;
	
	/**
	 * 发帖用户
	 */
	private String userName;
	
	/**
	 * 发帖版块
	 */
	private String clubName;
	
	/**
	 * 帖子类型
	 */
	private int postTypeId;
	
	/**
	 * 回复数量
	 */
	private long replyNum;
	
	/**
	 * 用户头像
	 */
	private String userHead;
	
	/**
	 * 用户头像
	 */
	private String userNickname;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	public Timestamp getPostTime() {
		return postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public long getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(long replyNum) {
		this.replyNum = replyNum;
	}

	public Timestamp getLastTime() {
		return lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	public int getPostTypeId() {
		return postTypeId;
	}

	public void setPostTypeId(int postTypeId) {
		this.postTypeId = postTypeId;
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
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent + ", postTime="
				+ postTime + ", lastTime=" + lastTime + ", userName=" + userName + ", clubName=" + clubName
				+ ", replyNum=" + replyNum + "]";
	}
	
}
