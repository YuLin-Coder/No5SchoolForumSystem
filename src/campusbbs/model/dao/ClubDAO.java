package campusbbs.model.dao;

import java.util.List;

import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubType;

/**
 * 版块
 * @author EsauLu
 *
 */
public interface ClubDAO {
	
	/**
	 * 添加版块
	 * @param club 版块
	 */
	public void saveClub(Club club);
	
	/**
	 * 删除版块
	 * @param clubName 版块名
	 */
	public void deleteClub(String clubName);
	
	/**
	 * 更新版块
	 * @param clubName 版块名
	 * @param club 版块
	 */ 
	public void updateClub(String clubName,Club club);
	
	/**
	 * 根据版块名查找版块
	 * @param clubName版块名
	 * @return 版块
	 */
	public Club findClub(String clubName);
	
	/**
	 * 查找所有版块
	 * @return 版块列表
	 */
	public List<Club> findAllClub();
	
	/**
	 * 查找回复数最多的num个版块
	 * @param num 版块数量
	 * @return 版块列表
	 */
	public List<Club> findPreClub(int num);
	
	/**
	 * 获取版块数量
	 * @return 版块总数
	 */
	public long getClubCount();
	
	/**
	 * 获取版块分类的数量
	 * @return 分类数量
	 */
	public long getClubTypeCount();
	
	/**
	 * 获取版块类型
	 * @return
	 */
	public ClubType getClubTypeById(int typeId);
	
	/**
	 * 添加版块类型
	 * @param clubType 要添加的版块类型
	 */
	public void addClubType(ClubType clubType);
	
	/**
	 * 删除版块类型
	 * @param clubType 要删除的版块类型
	 */
	public void deleteClubType(ClubType clubType);
	
	/**
	 * 更新版块类型
	 * @param clubType 要更新的版块类型
	 */
	public void updateCLubType(ClubType clubType);
	
	/**
	 * 获得版块分类
	 * @return 分类列表
	 */
	public List<ClubType> getClubTypeList();
	
}


































