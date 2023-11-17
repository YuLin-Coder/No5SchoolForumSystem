package campusbbs.model.vo;

/**
 * 版主
 * @author EsauLu
 *
 */
public class ClubAdmin {

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 版块名
	 */
	private String clubName;

	public ClubAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubAdmin(String userName, String clubName) {
		super();
		this.userName = userName;
		this.clubName = clubName;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "ClubAdmin [userName=" + userName + ", clubName=" + clubName + "]";
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
	
}
