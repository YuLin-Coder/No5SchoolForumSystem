package campusbbs.model.bean;

import java.util.List;

import campusbbs.model.vo.Club;
import campusbbs.model.vo.Post;

public class HomeBean{
	
	private List<Post> hostPosts;
	private List<Club> hostClubs;
	public List<Post> getHostPosts() {
		return hostPosts;
	}
	public void setHostPosts(List<Post> hostPosts) {
		this.hostPosts = hostPosts;
	}
	public List<Club> getHostClubs() {
		return hostClubs;
	}
	public void setHostClubs(List<Club> hostClubs) {
		this.hostClubs = hostClubs;
	}
		
}	
