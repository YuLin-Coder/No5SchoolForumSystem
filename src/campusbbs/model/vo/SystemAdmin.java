package campusbbs.model.vo;

/**
 * 系统管理员
 * @author Administrator
 *
 */
public class SystemAdmin {

	private String adminName;
	private String passwd;
	public SystemAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "SystemAdmin [adminName=" + adminName + ", passwd=" + passwd
				+ "]";
	}
	
}
