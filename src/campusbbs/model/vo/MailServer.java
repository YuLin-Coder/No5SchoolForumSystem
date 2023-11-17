package campusbbs.model.vo;

public class MailServer {
	
	private int emailServerId;
	private String domain;//邮件服务器域名
	
	public MailServer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmailServerId() {
		return emailServerId;
	}
	public void setEmailServerId(int emailServerId) {
		this.emailServerId = emailServerId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
	
}
