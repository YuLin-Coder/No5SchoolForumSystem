package campusbbs.model.vo;

import java.math.BigDecimal;

/**
 * 版块
 * @author EsauLu
 *
 */
public class Club {

	/**
	 * 版块名
	 */
	private String clubName;
	
	/**
	 * 版块图标
	 */
	private String clubIcon;
	
	/**
	 * 版块描述
	 */
	private String clubDescribe;
	
	/**
	 * 该版块的主题帖数量
	 */
	private long postNum;
	
	/**
	 * 该版块的总回复数量
	 */
	private BigDecimal replyNum;
	
	/**
	 * 版块分类
	 */
	private int clubTypeId;
		
	public Club() {
		super();
		// TODO Auto-generated constructor stub
		replyNum=new BigDecimal(0);
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubIcon() {
		return clubIcon;
	}

	public void setClubIcon(String clubIcon) {
		this.clubIcon = clubIcon;
	}

	public String getClubDescribe() {
		return clubDescribe;
	}

	public void setClubDescribe(String clubDescribe) {
		this.clubDescribe = clubDescribe;
	}

	public long getPostNum() {
		return postNum;
	}

	public void setPostNum(long postNum) {
		this.postNum = postNum;
	}

	public BigDecimal getReplyNum() {
		if(replyNum==null){
			return new BigDecimal(0);
		}
		return replyNum;
	}

	public void setReplyNum(BigDecimal replyNum) {
		if(replyNum==null){
			return;
		}
		this.replyNum = replyNum;
	}

	public int getClubTypeId() {
		return clubTypeId;
	}

	public void setClubTypeId(int clubTypeId) {
		this.clubTypeId = clubTypeId;
	}

	@Override
	public String toString() {
		return "Club [clubName=" + clubName + ", clubIcon=" + clubIcon + ", clubDescribe=" + clubDescribe + ", postNum="
				+ postNum + ", replyNum=" + replyNum + ", clubTypeId=" + clubTypeId + "]";
	}
	
	
}
