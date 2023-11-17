package campusbbs.model.bean;

import campusbbs.model.vo.ClubAdmin;
import campusbbs.model.vo.ClubType;

import java.util.List;

public class AdClubEditBean extends ClubEditBean{
	
	private List<ClubType> typeList;
	private List<ClubAdmin> adminList;

	public AdClubEditBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ClubType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<ClubType> typeList) {
		this.typeList = typeList;
	}

	public List<ClubAdmin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<ClubAdmin> adminList) {
		this.adminList = adminList;
	}

	@Override
	public String toString() {
		return "AdClubEditBean [typeList=" + typeList + ", adminList=" + adminList + "]";
	}
	
	
	
}
