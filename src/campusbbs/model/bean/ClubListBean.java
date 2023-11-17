package campusbbs.model.bean;

import java.util.List;
import java.util.Map;

import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubType;

public class ClubListBean {
	
	private Map<String, List<Club>> clubMap;
	private List<ClubType> clubTypeList;
	
	public ClubListBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Map<String, List<Club>> getClubMap() {
		return clubMap;
	}

	public void setClubMap(Map<String, List<Club>> clubMap) {
		this.clubMap = clubMap;
	}

	public List<ClubType> getClubTypeList() {
		return clubTypeList;
	}
	public void setClubTypeList(List<ClubType> clubTypeList) {
		this.clubTypeList = clubTypeList;
	}

	@Override
	public String toString() {
		return "ClubListBean [clubMap=" + clubMap + ", clubTypeList=" + clubTypeList + "]";
	}
	
}
