package campusbbs.model.bean;

import java.util.List;

public class ListBean<T>{
	
	private int pageCode;//当前页码	
//	private int pageNum;//总页数
	private int recordNum;//每页数据条数
	private long recordTotel;//数据总数
	
	private List<T> beanList;

	public ListBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public int getPageNum() {
		int num=(int)(recordTotel/recordNum);
		return recordTotel%recordNum==0?num:num+1;
	}

//	public void setPageNum(int pageNum) {
//		this.pageNum = pageNum;
//	}

	public int getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}

	public long getRecordTotel() {
		return recordTotel;
	}

	public void setRecordTotel(long recordTotel) {
		this.recordTotel = recordTotel;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	@Override
	public String toString() {
		return "ListBean [pageCode=" + pageCode + ", recordNum=" + recordNum + ", recordTotel=" + recordTotel + "]";
	}
	
	
	
}
