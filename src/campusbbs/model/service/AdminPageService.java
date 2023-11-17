package campusbbs.model.service;

import campusbbs.model.bean.AdClubEditBean;
import campusbbs.model.bean.AdReplyBean;
import campusbbs.model.bean.AdUserBean;
import campusbbs.model.bean.ClubListBean;
import campusbbs.model.bean.LastPostBean;
import campusbbs.model.bean.ListBean;
import campusbbs.model.bean.UserInfoBean;
import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubAdmin;
import campusbbs.model.vo.ClubType;
import campusbbs.model.vo.MailServer;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.Reply;
import campusbbs.model.vo.User;
import campusbbs.model.vo.UserInfo;

public interface AdminPageService {

	
	//获取系统各个数据表的数据
	public ListBean<User> getUserTable(int pageCode,int size);
	public ListBean<UserInfo> getUserInfoTable(int pageCode,int size);
	public ListBean<MailServer> getEmailServerTable();
	public ListBean<Club> getClubTable();
	public ListBean<ClubType> getClubTypeTable();
	public ListBean<ClubAdmin> getClubAdminTable(int pageCode,int size);
	public ListBean<Post> getPostTable(int pageCode,int size);
	public ListBean<PostType> getPostTypeTable();
	public ListBean<Reply> getReplyTable(int pageCode,int size);

	//管理员管理用户的页面数据
	public AdUserBean getAdUserBean(int pageCode,int size);
	
	//管理员管理版块的页面数据
	public ClubListBean getAdClubBean();

	/**
	 * 版块分类的编辑页面
	 * @return 版块类型
	 */
	public ClubType getClubTypeBean(int typeId);

	/**
	 * 版块分类的编辑页面
	 * @return 版块类型
	 */
	public PostType getPostTypeBean(int typeId);

	/**
	 * 获取修改版块的页面数据
	 * @param clubName 版块名
	 * @return 页面数据
	 */
	public AdClubEditBean getAdClubEditBean(String clubName);
	
	/**
	 * 用户信息修改的页面数据
	 * @param userName 用户名
	 * @return UserInfoBean对象
	 */
	public UserInfoBean getUserInfoBean(String userName,int pageCode, int size,int replyPageCode,int replyNum);
	
	/**
	 * 获取管理主题帖页面的数据
	 * @param pageCode 页码
	 * @param size 数据量
	 * @return 页面数据
	 */
	public LastPostBean<Post> getAdPostBean(int pageCode,int size);
	
	/**
	 * 获取管理主题回复页面的数据
	 * @param pageCode 页码
	 * @param size 数据量
	 * @return 页面数据
	 */
	public AdReplyBean getAdReplyBean(int postId, int pageCode,int size);
	
}





























