package campusbbs.model.dao;

import java.util.List;

import campusbbs.model.vo.SystemAdmin;
import campusbbs.model.vo.User;
import campusbbs.model.vo.UserInfo;

/**
 * 用户
 * @author EsauLu
 *
 */
public interface UserDAO {
	
	/**
	 * 添加用户
	 * @param user 用户
	 */
	public boolean saveUser(User user);
	
	/**
	 * 删除用户
	 * @param userName 用户名
	 */
	public boolean deleteUser(String userName);
	
	/**
	 * 更新用户
	 * @param userName 用户名
	 * @param passwd 用户
	 */
	public boolean updatePasswd(String userName,String passwd);
	
	/**
	 * 更新用户信息
	 * @param userName 用户名
	 * @param info 用户信息
	 */
	public boolean updateUserInfo(UserInfo info);
	
	/**
	 * 根据用户名查找用户
	 * @param userName 用户名
	 * @return 返回查找到的用户
	 */
	public User findUserByName(String userName);
	
	/**
	 * 根据用户名查找用户信息
	 * @param userName 用户名
	 * @return 用户信息
	 */
	public UserInfo findUserInfoByName(String userName);
	
	/**
	 * 根据范围在用户表中查找用户
	 * @param index 页数
	 * @param size 查找数量
	 * @return 用户列表
	 */
	public List<User> findUserList(int pageCode, int size);
	
	/**
	 * 根据范围在用户表中查找用户
	 * @param index 页数
	 * @param size 查找数量
	 * @return 用户列表
	 */
	public List<UserInfo> findUserInfoList(int pageCode, int size);
	
	/**
	 * 返回用户数量
	 * @return 用户总数
	 */
	public long getUserCount();
	
	/**
	 * 查找系统管理员
	 * @param adminName 管理员名
	 * @return 系统管理员账号对象
	 */
	public SystemAdmin findSystemAdmin(String adminName);
	
}







































