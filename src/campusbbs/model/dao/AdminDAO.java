package campusbbs.model.dao;

import java.util.List;

import campusbbs.model.vo.ClubAdmin;

public interface AdminDAO {
	
	/**
	 * 添加版主
	 * @param admin 版主信息
	 */
	public void saveAdmin(ClubAdmin admin);
	
	/**
	 * 判断用户userName是否clubName版块的版主
	 * @param userName 用户名
	 * @param clubName 版块名
	 * @return true表示userName是clubName的版主，否则不是
	 */
	public boolean isClubAdmin(String userName,String clubName);
	
	/**
	 * 删除版主
	 * @param userName 用户名
	 * @param clubName 版块名
	 */
	public void deleteAdmin(String userName,String clubName);
	
	/**
	 * 查找指定版主的版主
	 * @param userName 用户名
	 * @param clubName 版块名
	 * @return ClubAdmin对象
	 */
	public ClubAdmin findClubAdmin(String userName,String clubName);

	/**
	 * 获取某版块的所有版主
	 * @param clubName 版块名
	 * @return 版主列表
	 */
	public List<ClubAdmin> findAdminByClub(String clubName);
	
	/**
	 * 获取所有版主信息
	 * @return 版主列表
	 */
	public List<ClubAdmin> findAllClubAdmin(int pageCode,int size);
	
	/**
	 * 获取版主数量
	 * @return 版主数量
	 */
	public long getClubAdminCount();
	
	
}
























