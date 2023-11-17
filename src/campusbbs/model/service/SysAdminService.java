package campusbbs.model.service;

import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubAdmin;
import campusbbs.model.vo.ClubType;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.SystemAdmin;
import campusbbs.model.vo.User;
import campusbbs.model.vo.UserInfo;

public interface SysAdminService{
	
	/**
	 * 更新版块类型
	 * @param clubType 要更新的版块类型
	 * @return 更新是否成功
	 */
	public boolean updateClubType(ClubType clubType);
	
	/**
	 * 添加版块类型
	 * @param clubType 要添加的版块类型
	 * @return 添加是否成功
	 */
	public boolean addClubType(ClubType clubType);
	
	/**
	 * 删除版块类型
	 * @param clubType 要删除的版块类型
	 */
	public void deleteClubType(ClubType clubType);	

	
	/**
	 * 更新版块
	 * @param club 版块
	 * @return 更新是否成功
	 */
	public boolean updateClub(String clubName,Club club);
	
	/**
	 * 添加版块
	 * @param club 版块
	 * @return 添加是否成功
	 */
	public boolean addClub(Club club);
	
	/**
	 * 删除版块
	 * @param clubName 版块名
	 */
	public void deleteClub(String clubName);
	
	/**
	 * 获取操作出错的信息
	 * @return 出错信息
	 */
	public String getErrorMessage();
	
	/**
	 * 设置版主
	 * @param clubAdmin 版主
	 * @return 返回设置是否成功
	 */
	public boolean addClubAdmin(ClubAdmin clubAdmin);
	
	/**
	 * 删除版主
	 * @param clubAdmin 版主
	 * @return
	 */
	public void deleteClubAdmin(ClubAdmin clubAdmin);

	
	/**
	 * 添加用户
	 * @param user 用户
	 * @return 添加是否成功
	 */
	public boolean addUser(User user);
	
	/**
	 * 更新用户
	 * @param user 用户
	 * @return 更新是否成功
	 */
	public boolean updateUserInfo(UserInfo info);
	
	/**
	 * 更新用户密码
	 * @param user 用户
	 * @return 更新是否成功
	 */
	public boolean updateUserPasswd(String userName, String oldPwd, String newPwd, String pwdAgain);
	
	/**
	 * 删除用户
	 * @param userName 用具名
	 * @return 返回删除是否成功
	 */
	public boolean deleteUser(String userName);
	
	/**
	 * 管理员用户登录
	 * @param adminUser 管理员用户的登录信息
	 * @return 返回登录是否成功
	 */
	public SystemAdmin adminLogin(SystemAdmin adminUser);
	
	/**
	 * 删除主题帖
	 * @param postID 主题帖ID
	 */
	public void deletePost(int postID);
	
	/**
	 * 
	 * 删除主题帖
	 * @param typeID 类型ID
	 */
	public void deletePostType(int typeID);
	
	/**
	 * 添加主题帖类型
	 * @param postType 类型对象
	 * @return 添加是否成功
	 */
	public boolean addPostType(PostType postType);
	
	/**
	 * 修改主题帖类型
	 * @param postType 类型对象
	 * @return 修改是否成功
	 */
	public boolean updatePostType(PostType postType);
	
	/**
	 * 删除回复
	 * @param replyId 回复Id
	 */
	public void deleteReply(int replyId);
	
}
















































