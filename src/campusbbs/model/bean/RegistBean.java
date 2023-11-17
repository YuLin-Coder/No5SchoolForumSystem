package campusbbs.model.bean;

import java.util.List;

import campusbbs.model.vo.MailServer;

public class RegistBean {

	private List<MailServer> mailServerList;

	public RegistBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<MailServer> getMailServerList() {
		return mailServerList;
	}

	public void setMailServerList(List<MailServer> mailServerList) {
		this.mailServerList = mailServerList;
	}
	
}
