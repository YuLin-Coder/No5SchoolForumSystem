package campusbbs.model.bean;

import java.util.List;
import java.util.Map;

import campusbbs.model.vo.PostType;

public class LastPostBean<T> extends ListBean<T> {

	private List<Integer> postTypeIdList;
	private Map<String, PostType>  postTypeMap;
	public LastPostBean() {
		super();
		// TODO Auto-generated constructor stub
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
		return super.toString();
	}
	
	
}
