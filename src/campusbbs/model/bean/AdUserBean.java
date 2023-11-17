package campusbbs.model.bean;

import java.util.List;
import java.util.Map;

import campusbbs.model.vo.MailServer;
import campusbbs.model.vo.User;

public class AdUserBean extends ListBean<User> {
	
	private List<Integer> mailServerIdList;
	private Map<String, MailServer> mailServerMap;
	
	public AdUserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Integer> getMailServerIdList() {
		return mailServerIdList;
	}
	public void setMailServerIdList(List<Integer> mailServerIdList) {
		this.mailServerIdList = mailServerIdList;
	}
	public Map<String, MailServer> getMailServerMap() {
		return mailServerMap;
	}
	public void setMailServerMap(Map<String, MailServer> mailServerMap) {
		this.mailServerMap = mailServerMap;
	}
	
}
