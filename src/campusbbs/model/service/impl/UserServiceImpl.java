package campusbbs.model.service.impl;

import campusbbs.model.dao.AdminDAO;
import campusbbs.model.dao.ClubDAO;
import campusbbs.model.dao.PostDAO;
import campusbbs.model.dao.ReplyDAO;
import campusbbs.model.dao.UserDAO;
import campusbbs.model.factory.DAOFactory;
import campusbbs.model.service.UserService;
import campusbbs.model.vo.Club;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.Reply;
import campusbbs.model.vo.User;
import campusbbs.model.vo.UserInfo;

public class UserServiceImpl implements UserService{
	
	private String errorMessage="";
	private UserDAO userDAO;
	private PostDAO postDAO;
	private ReplyDAO replyDAO;
	private AdminDAO adminDAO;
	private ClubDAO clubDAO;
	

	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		errorMessage="";
		userDAO = DAOFactory.getDAOInstance("userDAO", UserDAO.class);
		postDAO = DAOFactory.getDAOInstance("postDAO", PostDAO.class);
		replyDAO = DAOFactory.getDAOInstance("replyDAO", ReplyDAO.class);
		adminDAO = DAOFactory.getDAOInstance("adminDAO", AdminDAO.class);
		clubDAO = DAOFactory.getDAOInstance("clubDAO", ClubDAO.class);
	}
 
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		if(user.getUserName()==null||user.getUserName().trim().isEmpty()){
			saveErrorMessage("用户名不能为空！");
			return null;
		}
		
		User acc=userDAO.findUserByName(user.getUserName());
		if(acc==null){
			saveErrorMessage("用户不存在！");
			return null;
		}
		
		if(user.getPasswd()==null||user.getPasswd().trim().isEmpty()){
			saveErrorMessage("密码不能为空！");
			return null;
		}
		
		if(!acc.getPasswd().equals(user.getPasswd())){
			saveErrorMessage("密码不正确！");
			return null;
		}
		
		//查找用户信息
		UserInfo info=getUserInfo(acc.getUserName());
		acc.setUserInfo(info);
		saveErrorMessage("");
		
		return acc;
	}

	@Override
	public boolean isClubAdmin(User user, String clubName) {
		// TODO Auto-generated method stub
		
		User acc=login(user);//再次验证用户登录信息
		
		if(acc==null){
			return false;
		}
		
		return adminDAO.isClubAdmin(user.getUserName(), clubName);
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		
		if(user.getUserName()==null||user.getUserName().trim().isEmpty()){
			saveErrorMessage("用户名不能为空！");
			return false;
		}
		
		User acc=userDAO.findUserByName(user.getUserName());
		if(acc!=null){
			saveErrorMessage("用户已存在！");
			return false;
		}
		
		if(user.getPasswd()==null||user.getPasswd().trim().isEmpty()){
			saveErrorMessage("密码不能为空！");
			return false;
		}
		
		UserInfo info=user.getUserInfo();
		if(info.getEmailAccount()==null||info.getEmailAccount().trim().isEmpty()){
			saveErrorMessage("邮箱不能为空！");
			return false;
		}
		
		if(info.getNickname()==null||info.getNickname().trim().isEmpty()){
			info.setNickname(info.getUserName());
		}else if(info.getNickname().length()>10){
			saveErrorMessage("昵称长度不能超过十个字！");
			return false;
		}
		
		saveErrorMessage("");
		userDAO.saveUser(user);
		
		return true;
	}

	@Override
	public boolean updateUserInfo(UserInfo info) {
		// TODO Auto-generated method stub

		if(info.getEmailAccount()==null||info.getEmailAccount().trim().isEmpty()){
			saveErrorMessage("邮箱不能为空！");
			return false;
		}
		
		if(info.getNickname().length()>10){
			saveErrorMessage("昵称长度不能超过十个字！");
			return false;
		}

		saveErrorMessage("");
		userDAO.updateUserInfo(info);
		return true;
	}

	@Override
	public boolean updatePasswd(User user, String oldPwd, String newPwd, String pwdAgain) {
		// TODO Auto-generated method stub
		
		if(oldPwd==null||oldPwd==""||newPwd==null||newPwd==""){
			saveErrorMessage("密码不能为空");
			return false;
		}
		
		User acc=userDAO.findUserByName(user.getUserName());
		if(acc!=null){
			if(!acc.getPasswd().equals(oldPwd)){
				saveErrorMessage("密码错误");
				return false;
			}
		}else{
			saveErrorMessage("用户不存在");
			return false;
		}
		
		if(!newPwd.equals(pwdAgain)){
			saveErrorMessage("前后密码不一致");
			return false;
		}
		
		userDAO.updatePasswd(acc.getUserName(), newPwd);
		
		return true;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}	
	
	@Override
	public void savePost(Post post) {
		// TODO Auto-generated method stub
		
		String content=post.getPostContent();
		
		if(content!=null){
			StringBuffer sb=new StringBuffer();
			String[] lines=content.split("\n");
			for (int i=0;i<lines.length;i++){
				sb.append("<span>");
				sb.append(lines[i]);
				sb.append("</span>");
				if(i!=lines.length-1){
					sb.append("<br>");
				}
			}
			post.setPostContent(sb.toString());
		}
		
		postDAO.savaPost(post);
		
	}

	@Override
	public void deletePost(int postId) {
		// TODO Auto-generated method stub
		postDAO.deletePostById(postId);
	}
	
	@Override
	public void savaReply(Reply reply) {
		// TODO Auto-generated method stub
		replyDAO.saveReply(reply);
	}

	@Override
	public void updateClub(String clubName,Club club) {
		// TODO Auto-generated method stub
		clubDAO.updateClub(clubName,club);
	}
	
	private void saveErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}

	@Override
	public UserInfo getUserInfo(String userName) {
		// TODO Auto-generated method stub
		
		//查找用户信息
		UserInfo info=userDAO.findUserInfoByName(userName);		
		return info;
		
	}

	@Override
	public void deleteReply(int id) {
		// TODO Auto-generated method stub
		replyDAO.deleteReplyById(id);
	}	

}




























