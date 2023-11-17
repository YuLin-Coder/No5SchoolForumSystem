package campusbbs.model.bean;

import java.util.List;
import java.util.Map;

import campusbbs.model.vo.Post;
import campusbbs.model.vo.PostType;

public class PostBean<T> extends ListBean<T>{
	
	private Post post;
	private List<Integer> postTypeIdList;
	private Map<String, PostType>  postTypeMap;
//	private boolean isAdmin;

	public PostBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<Integer> getPostTypeIdList() {
		return postTypeIdList;
	}

	public void setPostTypeIdList(List<Integer> postTypeIdList) {
		this.postTypeIdList = postTypeIdList;
	}

	public Map<String, PostType> getPostTypeMap() {
		return postTypeMap;
	}

	public void setPostTypeMap(Map<String, PostType> postTypeMap) {
		this.postTypeMap = postTypeMap;
	}

	@Override
	public String toString() {
		return "PostBean [post=" + post + ", postTypeIdList=" + postTypeIdList + ", postTypeMap=" + postTypeMap + "]";
	}

//	public boolean isAdmin() {
//		return isAdmin;
//	}
//
//	public void setAdmin(boolean isAdmin) {
//		this.isAdmin = isAdmin;
//	}
	
}
