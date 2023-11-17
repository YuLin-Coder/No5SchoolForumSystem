package campusbbs.model.bean;

import campusbbs.model.vo.Post;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.Reply;

public class AdReplyBean extends ListBean<Reply>{

	private Post post;
	private PostType postType;
	
	public AdReplyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}

	public PostType getPostType() {
		return postType;
	}

	public void setPostType(PostType postType) {
		this.postType = postType;
	}

	@Override
	public String toString() {
		return "AdReplyBean [post=" + post + ", postType=" + postType + "]\n"+super.toString();
	}	
	
}
