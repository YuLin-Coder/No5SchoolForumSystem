package campusbbs.model.vo;

public class ClubType {
	private int clubTypeId;
	private String clubType;
	public ClubType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getClubTypeId() {
		return clubTypeId;
	}
	public void setClubTypeId(int clubTypeId) {
		this.clubTypeId = clubTypeId;
	}
	public String getClubType() {
		return clubType;
	}
	public void setClubType(String clubType) {
		this.clubType = clubType;
	}
	@Override
	public String toString() {
		return "ClubType [clubTypeId=" + clubTypeId + ", clubType=" + clubType + "]";
	}
	
}
