package campusbbs.model.bean;

import java.util.List;
import java.util.Map;

import campusbbs.model.vo.MailServer;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.Reply;
import campusbbs.model.vo.UserInfo;

public class UserInfoBean {
	
	private UserInfo userInfo;
	private List<MailServer> mailServerList;
	private LastPostBean<Post> lastPostBean;//用户最新发表的主题帖
	private ListBean<Reply> replyListBean;//用户发表的回复
	private Map<String , Post> postMap;//回复所在主题帖的标题

	public UserInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<MailServer> getMailServerList() {
		return mailServerList;
	}

	public void setMailServerList(List<MailServer> mailServerList) {
		this.mailServerList = mailServerList;
	}

	public LastPostBean<Post> getLastPostBean() {
		return lastPostBean;
	}

	public void setLastPostBean(LastPostBean<Post> lastPostBean) {
		this.lastPostBean = lastPostBean;
	}

	public ListBean<Reply> getReplyListBean() {
		return replyListBean;
	}

	public void setReplyListBean(ListBean<Reply> replyListBean) {
		this.replyListBean = replyListBean;
	}

	public Map<String, Post> getPostMap() {
		return postMap;
	}

	public void setPostMap(Map<String, Post> postMap) {
		this.postMap = postMap;
	}

	@Override
	public String toString() {
		return "UserInfoBean [userInfo=" + userInfo + ", mailServerList=" + mailServerList + ", lastPostBean="
				+ lastPostBean + "]";
	}
	
}
