package campusbbs.model.vo;

/**
 * 用户
 * @author EsauLu
 *
 */
public class User {
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String passwd;
	
	/**
	 * 用户信息
	 */
	private UserInfo userInfo;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String passwd) {
		super();
		this.userName = userName;
		this.passwd = passwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		String to="User [userName=" + userName + ", passwd=" + passwd;
		if(userInfo!=null){
			to+=", userInfo="+userInfo.toString() + "]";
		}
		to+="]";
		return to;
	}
	
	
}
