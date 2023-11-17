package campusbbs.model.dao;

import java.util.List;

import campusbbs.model.vo.Post;
import campusbbs.model.vo.PostType;

/**
 * 帖子
 * @author EsauLu
 *
 */
public interface PostDAO {	
	
	/**
	 * 保存帖子
	 * @param post 帖子
	 */
	public void savaPost(Post post);
	
	/**
	 * 添加主题帖类型
	 * @param type 类型实体
	 */
	public void addPostType(PostType type);
	
	/**
	 * 根据帖子ID删除帖子
	 * @param postId 帖子
	 */
	public void deletePostById(int id);
	
	/**
	 * 根据帖子ID删除帖子
	 * @param postId 帖子
	 */
	public void deletePostType(int id);

	/**
	 * 查找指定ID的帖子
	 * @param id 帖子ID
	 * @return 帖子
	 */
	public Post findPostById(int id);

	/**
	 * 查找指定ID的帖子
	 * @param id 帖子ID
	 * @return 帖子
	 */
	public PostType findPostTypeById(int id);

	/**
	 * 修改主题帖额类型
	 * @param postType 类型对象
	 */
	public void updatePostType(PostType postType);
	
//	/**
//	 * 获取指定主题帖的内容
//	 * @param postId 主题帖ID
//	 * @return 主题帖的内容
//	 */
//	public String getPostContent(int postId);
	
	/**
	 * 返回主题帖总数
	 * @return 主题帖总数
	 */
	public long getAllPostNum();
	
	/**
	 * 返回某版块的主题帖总数
	 * @return 主题帖总数
	 */
	public long getPostNumByCLub(String clubName);
	
	/**
	 * 返回某用户的主题帖总数
	 * @return 主题帖总数
	 */
	public long getPostNumByUser(String userName);
	
	/**
	 * 获取主题类型数
	 * @return 类型总数
	 */
	public long getPostTypeCount();
	
	/**
	 * 查找最新的主题帖
	 * @param pageCode 页码
	 * @param size 页面数据大小
	 * @return 主题帖列表
	 */
	public List<Post> findLastPost(int pageCode,int size);
	
//	/**
//	 * 查找所有的主题帖
//	 * @param pageCode 页码
//	 * @param size 页面数据大小
//	 * @return 主题帖列表
//	 */
//	public List<Post> findAllPost(int pageCode,int size);
	
	/**
	 * 查找最热门的主题帖
	 * @param pageCode 页码
	 * @param size 页面数据大小
	 * @return 主题帖列表
	 */
	public List<Post> findHostPost(int pageCode,int size);
	
	/**
	 * 查找指定版块的帖子
	 * @param clubName 版块名
	 * @param pageCode 页码
	 * @param size 查找数量
	 * @return 帖子列表
	 */
	public List<Post> findPostByClub(String clubName,int pageCode, int size);
	
	/**
	 * 查找指定用户的主题帖
	 * @param userName 用户名
	 * @param pageCode 页码
	 * @param size 查找数量
	 * @return 帖子列表
	 */
	public List<Post> findPostByUser(String userName,int pageCode, int size);
	
	/**
	 * 获取主题帖的分类
	 * @return 分类列表
	 */
	public List<PostType> getPostTypeList();
	
}


































