package campusbbs.model.service.impl;

import campusbbs.model.dao.AdminDAO;
import campusbbs.model.dao.ClubDAO;
import campusbbs.model.dao.PostDAO;
import campusbbs.model.dao.ReplyDAO;
import campusbbs.model.dao.UserDAO;
import campusbbs.model.factory.DAOFactory;
import campusbbs.model.service.SysAdminService;
import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubAdmin;
import campusbbs.model.vo.ClubType;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.SystemAdmin;
import campusbbs.model.vo.User;
import campusbbs.model.vo.UserInfo;

public class SysAdminServiceImpl implements SysAdminService {

	private String errorMessage="";
	private UserDAO userDAO=DAOFactory.getDAOInstance("userDAO", UserDAO.class);
	private PostDAO postDAO=DAOFactory.getDAOInstance("postDAO", PostDAO.class);
	private ReplyDAO replyDAO=DAOFactory.getDAOInstance("replyDAO", ReplyDAO.class);
	private AdminDAO adminDAO=DAOFactory.getDAOInstance("adminDAO", AdminDAO.class);
	private ClubDAO clubDAO=DAOFactory.getDAOInstance("clubDAO", ClubDAO.class);

	@Override
	public boolean updateClubType(ClubType clubType) {
		// TODO Auto-generated method stub
		if(!checkClubType(clubType)){
			return false;
		}
		clubDAO.updateCLubType(clubType);		
		return true;
	}

	@Override
	public boolean addClubType(ClubType clubType) {
		// TODO Auto-generated method stub
		if(!checkClubType(clubType)){
			return false;
		}
		clubDAO.addClubType(clubType);
		return true;
	}

	@Override
	public void deleteClubType(ClubType clubType) {
		// TODO Auto-generated method stub
		clubDAO.deleteClubType(clubType);
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}
	
	private boolean checkClubType(ClubType clubType) {
		// TODO Auto-generated method stub
		if(clubType.getClubType()==null||clubType.getClubType().trim().isEmpty()){
			setErrorMessage("类型名不能为空！");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateClub(String clubName,Club club) {
		// TODO Auto-generated method stub
		
		Club old=clubDAO.findClub(clubName);
		if(old==null){
			setErrorMessage("版块不存在！");
			return false;
		}
		
		if(club.getClubName()!=null
				&&(club.getClubName().contains(" ")
				||club.getClubName().contains("\"")
				||club.getClubName().contains("'")
				||club.getClubName().contains(","))){
			setErrorMessage("版块名不能包括空格，逗号，冒号等字符！");
			return false;
		}
		
		clubDAO.updateClub(clubName,club);
		return true;
	}

	@Override
	public boolean addClub(Club club) {
		// TODO Auto-generated method stub

		Club old=clubDAO.findClub(club.getClubName());
		if(old!=null){
			setErrorMessage("版块不存在！");
			return false;
		}
		if(club.getClubTypeId()==0){
			setErrorMessage("请选择版块类型！");
			return false;
		}
		if(club.getClubName()==null){
			setErrorMessage("版块名不能为空！");
			return false;
		}
		clubDAO.saveClub(club);
		return true;
	}

	@Override
	public void deleteClub(String clubName) {
		// TODO Auto-generated method stub
		clubDAO.deleteClub(clubName);
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public boolean addClubAdmin(ClubAdmin clubAdmin) {
		// TODO Auto-generated method stub

		if(clubAdmin.getClubName()==null||clubAdmin.getClubName().trim().isEmpty()){
			setErrorMessage("版块名不能为空");
			return false;
		}
		if(clubAdmin.getUserName()==null||clubAdmin.getUserName().trim().isEmpty()){
			setErrorMessage("用户名不能为空");
			return false;
		}
		
		Club club = clubDAO.findClub(clubAdmin.getClubName());
		if(club==null){
			setErrorMessage("版块不存在");
			return false;
		}
		
		User user=userDAO.findUserByName(clubAdmin.getUserName());
		if(user==null){
			setErrorMessage("用户不存在");
			return false;
		}
		
		adminDAO.saveAdmin(clubAdmin);
		
		return true;
	}

	@Override
	public void deleteClubAdmin(ClubAdmin clubAdmin) {
		// TODO Auto-generated method stub
		adminDAO.deleteAdmin(clubAdmin.getUserName(),clubAdmin.getClubName());
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
	
		if(user==null){
			setErrorMessage("添加失败！");
			return false;
		}
		
		try {
			userDAO.saveUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("SysAdminService\t158行");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateUserInfo(UserInfo info) {
		// TODO Auto-generated method stub
		
		try {
			userDAO.updateUserInfo(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("SysAdminService\t174行");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean updateUserPasswd(String userName, String oldPwd, String newPwd, String pwdAgain) {
		// TODO Auto-generated method stub
		
		if(oldPwd==null||oldPwd==""||newPwd==null||newPwd==""){
			setErrorMessage("密码不能为空");
			return false;
		}
		
		User acc=userDAO.findUserByName(userName);
		if(acc!=null){
			if(!acc.getPasswd().equals(oldPwd)){
				setErrorMessage("密码错误");
				return false;
			}
		}else{
			setErrorMessage("用户不存在");
			return false;
		}
		
		if(!newPwd.equals(pwdAgain)){
			setErrorMessage("前后密码不一致");
			return false;
		}
		
		userDAO.updatePasswd(acc.getUserName(), newPwd);
		
		return true;
	}

	@Override
	public boolean deleteUser(String userName) {
		// TODO Auto-generated method stub
		
		try {
			userDAO.deleteUser(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("SysAdminService\t191行");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public SystemAdmin adminLogin(SystemAdmin adminUser) {
		// TODO Auto-generated method stub
		
		if(adminUser.getAdminName()==null||adminUser.getAdminName().trim().isEmpty()){
			setErrorMessage("用户名不能为空！");
			return null;
		}
		
		SystemAdmin admin=userDAO.findSystemAdmin(adminUser.getAdminName());
		if(admin==null){
			setErrorMessage("管理员用户不存在！");
			return null;
		}
		
		if(adminUser.getPasswd()==null||adminUser.getPasswd().trim().isEmpty()){
			setErrorMessage("密码不能为空！");
			return null;
		}
		
		if(!admin.getPasswd().equals(adminUser.getPasswd())){
			setErrorMessage("密码不正确！");
			return null;
		}
		
		setErrorMessage("");
		
		return admin;
	}

	@Override
	public void deletePost(int postID) {
		// TODO Auto-generated method stub
		postDAO.deletePostById(postID);
	}

	@Override
	public boolean addPostType(PostType postType) {
		// TODO Auto-generated method stub
		
		if(postType==null){
			setErrorMessage("添加失败");
			return false;
		}
		
		if(postType.getPostType()==null||postType.getPostType().trim().isEmpty()){			
			setErrorMessage("类型名不能为空失败");
			return false;
		}

		setErrorMessage("");
		postDAO.addPostType(postType);
		return true;
	}

	@Override
	public void deletePostType(int typeID) {
		// TODO Auto-generated method stub
		postDAO.deletePostType(typeID);
	}

	@Override
	public boolean updatePostType(PostType postType) {
		// TODO Auto-generated method stub
				
		if(postType==null){
			setErrorMessage("修改失败");
			return false;
		}
		
		if(postType.getPostType()==null||postType.getPostType().trim().isEmpty()){			
			setErrorMessage("类型名不能为空");
			return false;
		}
		
		setErrorMessage("");
		postDAO.updatePostType(postType);
		return true;
	}

	@Override
	public void deleteReply(int replyId) {
		// TODO Auto-generated method stub
		
		replyDAO.deleteReplyById(replyId);
		
	}
	
	
}


























































