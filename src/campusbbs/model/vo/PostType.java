package campusbbs.model.vo;

public class PostType {
	private int postTypeId;
	private String postType;
	private String color;
	public PostType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPostTypeId() {
		return postTypeId;
	}
	public void setPostTypeId(int postTypeId) {
		this.postTypeId = postTypeId;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "PostType [postTypeId=" + postTypeId + ", postType=" + postType + ", color=" + color + "]";
	}
	
}
