package campusbbs.model.bean;

import java.util.List;
import java.util.Map;

import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubAdmin;
import campusbbs.model.vo.PostType;

public class ClubBean<T> extends ListBean<T> {
	
	private Club club;
	private List<ClubAdmin> clubAdminList;	
	private List<Integer> postTypeIdList;
	private Map<String, PostType>  postTypeMap;

	public ClubBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public List<ClubAdmin> getClubAdminList() {
		return clubAdminList;
	}

	public void setClubAdminList(List<ClubAdmin> clubAdminList) {
		this.clubAdminList = clubAdminList;
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
		return "ClubBean [club=" + club + ", clubAdminList=" + clubAdminList + ", postTypeIdList=" + postTypeIdList
				+ ", postTypeMap=" + postTypeMap + "]";
	}
		
}




















































