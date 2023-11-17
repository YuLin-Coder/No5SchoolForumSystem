package campusbbs.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import campusbbs.model.dao.UserDAO;
import campusbbs.model.utils.SQLUtils;
import campusbbs.model.vo.SystemAdmin;
import campusbbs.model.vo.User;
import campusbbs.model.vo.UserInfo;

public class UserDAOImpl implements UserDAO {
	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		
		UserInfo info=user.getUserInfo();
		
		if(findUserByName(user.getUserName())!=null){
			return false;
		}

		String sql="insert into bbs_user value("
					+"\""+user.getUserName()+"\","
						+"\""+user.getPasswd()+"\");";	

		SQLUtils.updateRecord(sql);

		sql="insert into user_info value("
				+"\""+user.getUserName()+"\","
					+"\""+info.getNickname()+"\","
						+"\""+info.getHead()+"\","
								+"\""+info.getEmailAccount()+"\","
										+"\""+info.getEmailServerId()+"\")"
								+ ";";

		SQLUtils.updateRecord(sql);
		
		return true;
		
	}

	@Override
	public boolean deleteUser(String userName) {
		// TODO Auto-generated method stub	

		if(findUserByName(userName)==null){
			return false;
		}
		
		String sql="delete from bbs_user where userName=\""+userName+"\";";	
		SQLUtils.updateRecord(sql);
		return true;
		
	}

	@Override
	public boolean updatePasswd(String userName, String passwd) {
		// TODO Auto-generated method stub
		
		if(findUserByName(userName)==null){
			return false;
		}
		
		String sql="update bbs_user set passwd=\""+passwd+"\" where userName=\""+userName+"\";";
		SQLUtils.updateRecord(sql);
		
		return true;
	}
	
	@Override
	public boolean updateUserInfo(UserInfo info) {
		// TODO Auto-generated method stub
		
		if(findUserByName(info.getUserName())==null){
			return false;
		}
		
		String sql="update user_info set ";
		int c=0;
		ArrayList<Object> arr=new ArrayList<>();
		
		if(info.getNickname()!=null){
			sql+=" nickname=? ";
			arr.add(info.getNickname());
			System.out.println(info.getNickname());
			c++;
		}
		
		if(info.getHead()!=null){
			if(c!=0){
				sql+=",";
			}
			sql+=" head=? ";
			arr.add(info.getHead());
			System.out.println(info.getHead());
			c++;
		}
		
		if(info.getEmailAccount()!=null){
			if(c!=0){
				sql+=",";
			}
			sql+=" emailAccount=? , emailServerId=? ";
			arr.add(info.getEmailAccount());
			arr.add(info.getEmailServerId());
			System.out.println(info.getEmailAccount());
		}
		
		sql+="where userName=\""+info.getUserName()+"\";";

		SQLUtils.updateRecord(sql,arr.toArray());

		return true;
		
	}

	@Override
	public User findUserByName(String userName) {
		// TODO Auto-generated method stub		

		String sql="select * from bbs_user where userName=\""+userName+"\"";
		return SQLUtils.queryRecordById(sql, User.class);
		
	}

	@Override
	public List<User> findUserList(int pageCode, int size) {
		// TODO Auto-generated method stub
		
		String sql="select * from bbs_user limit "+((pageCode-1)*size)+","+size+";";	
		return SQLUtils.queryRecordList(sql, User.class);
		
	}

	@Override
	public List<UserInfo> findUserInfoList(int pageCode, int size) {
		// TODO Auto-generated method stub		
		
		String sql="select * from user_info limit "+((pageCode-1)*size)+","+size+";";	

		return SQLUtils.queryRecordList(sql, UserInfo.class);
		
	}

	@Override
	public UserInfo findUserInfoByName(String userName) {
		// TODO Auto-generated method stub
		String sql="select * from user_info where userName=\""+userName+"\"";
		return SQLUtils.queryRecordById(sql, UserInfo.class);
	}

	@Override
	public long getUserCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from bbs_user";	
		return SQLUtils.getRecordCount(sql);
		
	}

	@Override
	public SystemAdmin findSystemAdmin(String adminName) {
		// TODO Auto-generated method stub
		String sql="select * from system_admin where adminName='"+adminName+"';";
		return SQLUtils.queryRecordById(sql, SystemAdmin.class);
	}

}





































