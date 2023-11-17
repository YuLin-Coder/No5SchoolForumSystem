package campusbbs.model.service;

import campusbbs.model.vo.Club;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.Reply;
import campusbbs.model.vo.User;
import campusbbs.model.vo.UserInfo;

public interface UserService {

	/**
	 * 用户登录
	 * @param user 用户
	 * @return 登录成功返回User对象，否则返回null
	 */
	public User login(User user);
	
	/**
	 * 判断是否版主
	 * @param user 用户
	 * @param clubName 版块名
 	 * @return true表示是版主，否则不是
	 */
	public boolean isClubAdmin(User user,String clubName);
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * 更新用户信息
	 * @param info
	 */
	public boolean updateUserInfo(UserInfo info);

	/**
	 * 修改登录密码
	 * @param user 用户
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @param pwdAgain 确认密码
	 * @return 修改是否成功
	 */
	public boolean updatePasswd(User user,String oldPwd,String newPwd,String pwdAgain);
	
	/**
	 * 获取出错信息
	 * @return 出错信息
	 */
	public String getErrorMessage();	
	
	/**
	 * 保存新发表的主题帖
	 * @param post 主题帖
	 */
	public void savePost(Post post);
	
	/**
	 * 删除主题帖
	 * @param postId 主题帖ID
	 */
	public void deletePost(int postId);
	
	/**
	 * 保存回复
	 * @param reply 回复
	 */
	public void savaReply(Reply reply);
	
	/**
	 * 删除回复
	 * @param id 回复id
	 */
	public void deleteReply(int id);
	
	/**
	 * 更新版块
	 * @param club 版块
	 */
	public void updateClub(String clubName,Club club);
	
	/**
	 * 获得用户信息
	 * @param userName 用户名
	 * @return 用户信息
	 */
	public UserInfo getUserInfo(String userName);
	
}
