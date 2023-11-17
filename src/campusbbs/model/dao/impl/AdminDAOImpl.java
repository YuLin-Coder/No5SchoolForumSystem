package campusbbs.model.dao.impl;

import java.util.List;

import campusbbs.model.dao.AdminDAO;
import campusbbs.model.utils.SQLUtils;
import campusbbs.model.vo.ClubAdmin;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public void saveAdmin(ClubAdmin admin) {
		// TODO Auto-generated method stub
		
		String sql="insert into club_admin(userName,clubName) value('"+admin.getUserName()+"','"+admin.getClubName()+"');";		
		SQLUtils.updateRecord(sql);
				
	}

	@Override
	public boolean isClubAdmin(String userName, String clubName) {
		// TODO Auto-generated method stub
		System.out.println(userName+",,"+clubName);
		return findClubAdmin(userName, clubName)!=null;
	}


	@Override
	public void deleteAdmin(String userName, String clubName) {
		// TODO Auto-generated method stub
		
		String sql="delete from club_admin where userName='"+userName+"' and clubName='"+clubName+"';";		
		SQLUtils.updateRecord(sql);
		
	}

	@Override
	public ClubAdmin findClubAdmin(String userName, String clubName) {
		// TODO Auto-generated method stub
		
		String sql="select * from club_admin where userName='"
					+ userName
					+ "' and clubName='"
					+ clubName
					+ "';";	
		System.out.println("AdminDAO \t49\t: "+sql);
		
		return SQLUtils.queryRecordById(sql, ClubAdmin.class);
	}

	@Override
	public List<ClubAdmin> findAdminByClub(String clubName) {
		// TODO Auto-generated method stub
		
		String sql="select * from club_admin where clubName='"+clubName+"';";

		return SQLUtils.queryRecordList(sql, ClubAdmin.class);
		
	}

	@Override
	public List<ClubAdmin> findAllClubAdmin(int pageCode,int size) {
		// TODO Auto-generated method stub		
		String sql="select * from club_admin"
				+ " order by clubName "
				+ " limit "+((pageCode-1)*size)+","+size+";";
						
		return SQLUtils.queryRecordList(sql, ClubAdmin.class);
	}

	@Override
	public long getClubAdminCount() {
		// TODO Auto-generated method stub
		
		String sql="select count(*) from club_admin;";
		return SQLUtils.getRecordCount(sql);
		
	}
	

}


















































