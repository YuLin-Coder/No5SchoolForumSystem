package campusbbs.model.service;

import campusbbs.model.bean.ClubBean;
import campusbbs.model.bean.ClubEditBean;
import campusbbs.model.bean.ClubListBean;
import campusbbs.model.bean.HomeBean;
import campusbbs.model.bean.LastPostBean;
import campusbbs.model.bean.PostBean;
import campusbbs.model.bean.RegistBean;
import campusbbs.model.bean.UserInfoBean;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.Reply;

public interface PageService {

	
	/**
	 * 获取最新帖子页面的数据
	 * @param pageCode 开始下标
	 * @param size 数量
	 * @return PageBean对象
	 */
	public LastPostBean<Post> getLastPostBean(int pageCode,int size);
	
	/**
	 * 获取版块页面的数据
	 * @param pageCode 页码
	 * @param size 数量
	 * @return ClubBean对象
	 */
	public ClubBean<Post> getClubPageBean(String clubName,int pageCode,int size);
	
	/**
	 * 获取主题帖页面的数据
	 * @param postId 主题帖ID
	 * @param pageCode 页码
	 * @param size 数量
	 * @return PostBean对象
	 */
	public PostBean<Reply> getPostPageBean(int postId,int pageCode,int size);
	
	/**
	 * 获取首页的数据
	 * @return HomeBean对象
	 */
	public HomeBean getHomePageBean();
	
	/**
	 * 获取版块选择的页面数据 
	 * @return ClubListBean对象
	 */
	public ClubListBean getClubListPageBean();
	
	/**
	 * 版块编辑页面数据
	 * @param clubName 版块名
	 * @return ClubEditPage对象
	 */
	public ClubEditBean getClubEditBean(String clubName);
	
	/**
	 * 用户信息修改的页面数据
	 * @param userName 用户名
	 * @return UserInfoBean对象
	 */
	public UserInfoBean getUserInfoBean(String userName,int postPageCode, int postPageNum ,int replyPageCode,int replyPageNum);
	
	/**
	 * 获得所有支持的邮件服务器列表
	 * @return 邮件服务器列表
	 */
	public RegistBean getRegistBean();
	
}





















