package campusbbs.model.vo;

public class UserInfo {


	/**
	 * 头像
	 */
	private String userName;
	
	/**
	 * 头像
	 */
	private String head;
	
	/**
	 * 联系邮箱
	 */
	private String emailAccount;	
	
	/**
	 * 邮箱服务器
	 */
	private int emailServerId;
	
	/**
	 * 昵称
	 */
	private String nickname;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmailAccount() {
		return emailAccount;
	}

	public void setEmailAccount(String emailAccount) {
		this.emailAccount = emailAccount;
	}

	public int getEmailServerId() {
		return emailServerId;
	}

	public void setEmailServerId(int emailServerId) {
		this.emailServerId = emailServerId;
	}

	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", head=" + head + ", emailAccount=" + emailAccount
				+ ", emailServerId=" + emailServerId + ", nickname=" + nickname + "]";
	}
	
	
}
