package campusbbs.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import campusbbs.model.bean.AdClubEditBean;
import campusbbs.model.bean.AdReplyBean;
import campusbbs.model.bean.AdUserBean;
import campusbbs.model.bean.ClubListBean;
import campusbbs.model.bean.LastPostBean;
import campusbbs.model.bean.ListBean;
import campusbbs.model.bean.UserInfoBean;
import campusbbs.model.dao.AdminDAO;
import campusbbs.model.dao.ClubDAO;
import campusbbs.model.dao.MailDAO;
import campusbbs.model.dao.PostDAO;
import campusbbs.model.dao.ReplyDAO;
import campusbbs.model.dao.UserDAO;
import campusbbs.model.factory.DAOFactory;
import campusbbs.model.service.AdminPageService;
import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubAdmin;
import campusbbs.model.vo.ClubType;
import campusbbs.model.vo.MailServer;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.Reply;
import campusbbs.model.vo.User;
import campusbbs.model.vo.UserInfo;

public class AdminPageServiceImpl implements AdminPageService {

	private UserDAO userDAO=DAOFactory.getDAOInstance("userDAO", UserDAO.class);
	private PostDAO postDAO=DAOFactory.getDAOInstance("postDAO", PostDAO.class);
	private ClubDAO clubDAO=DAOFactory.getDAOInstance("clubDAO", ClubDAO.class);
	private ReplyDAO replyDAO=DAOFactory.getDAOInstance("replyDAO", ReplyDAO.class);
	private AdminDAO adminDAO=DAOFactory.getDAOInstance("adminDAO", AdminDAO.class);
	private MailDAO mailDAO=DAOFactory.getDAOInstance("mailDAO", MailDAO.class);

	@Override
	public ListBean<User> getUserTable(int pageCode,int size) {
		// TODO Auto-generated method stub
		
		ListBean<User> listBean=new ListBean<>();
		listBean.setPageCode(pageCode);
		listBean.setRecordNum(size);
		listBean.setRecordTotel(userDAO.getUserCount());
		listBean.setBeanList(userDAO.findUserList(pageCode, size));
		return listBean;
		
	}

	@Override
	public ListBean<UserInfo> getUserInfoTable(int pageCode,int size) {
		// TODO Auto-generated method stub
		
		ListBean<UserInfo> listBean=new ListBean<>();
		listBean.setPageCode(pageCode);
		listBean.setRecordNum(size);
		listBean.setRecordTotel(userDAO.getUserCount());
		listBean.setBeanList(userDAO.findUserInfoList(pageCode, size));
		return listBean;
		
	}

	@Override
	public ListBean<MailServer> getEmailServerTable() {
		// TODO Auto-generated method stub
		
		ListBean<MailServer> listBean=new ListBean<>();
		listBean.setBeanList(mailDAO.findMailServerList());
		listBean.setRecordTotel(mailDAO.getMailServerCount());
		return listBean;
		
	}

	@Override
	public ListBean<Club> getClubTable() {
		// TODO Auto-generated method stub
		
		ListBean<Club> listBean=new ListBean<>();		
		listBean.setBeanList(clubDAO.findAllClub());	
		listBean.setRecordTotel(clubDAO.getClubCount());	
		return listBean;
		
	}

	@Override
	public ListBean<ClubType> getClubTypeTable() {
		// TODO Auto-generated method stub
		ListBean<ClubType> listBean=new ListBean<>();		
		listBean.setBeanList(clubDAO.getClubTypeList());	
		listBean.setRecordTotel(clubDAO.getClubTypeCount());	
		return listBean;
	}

	@Override
	public ListBean<ClubAdmin> getClubAdminTable(int pageCode,int size) {
		// TODO Auto-generated method stub
		
		ListBean<ClubAdmin> listBean=new ListBean<>();
		listBean.setPageCode(pageCode);
		listBean.setRecordNum(size);
		listBean.setRecordTotel(adminDAO.getClubAdminCount());
		listBean.setBeanList(adminDAO.findAllClubAdmin(pageCode,size));
		
		System.err.println(listBean.toString());
		
		return listBean;
		
	}

	@Override
	public ListBean<Post> getPostTable(int pageCode,int size) {
		// TODO Auto-generated method stub
		
		ListBean<Post> listBean=new ListBean<Post>();
		listBean.setPageCode(pageCode);
		listBean.setRecordNum(size);
		listBean.setRecordTotel(postDAO.getAllPostNum());
		
		List<Post> list=postDAO.findLastPost(pageCode, size);
		for(Post p:list){			
			Post t=postDAO.findPostById(p.getPostId());
			p.setPostContent(t.getPostContent());			
		}
		
		listBean.setBeanList(list);
		return listBean;
		
	}

	@Override
	public ListBean<PostType> getPostTypeTable() {
		// TODO Auto-generated method stub		
		ListBean<PostType> listBean=new ListBean<PostType>();
		listBean.setBeanList(postDAO.getPostTypeList());
		listBean.setRecordTotel(postDAO.getAllPostNum());
		return listBean;
	}

	@Override
	public ListBean<Reply> getReplyTable(int pageCode,int size) {
		// TODO Auto-generated method stub
		
		ListBean<Reply> listBean=new ListBean<>();
		listBean.setPageCode(pageCode);
		listBean.setRecordNum(size);
		listBean.setRecordTotel(replyDAO.getAllReplyCount());
		listBean.setBeanList(replyDAO.findAllReply(pageCode, size));
		return listBean;
	}

	@Override
	public AdUserBean getAdUserBean(int pageCode,int size) {
		// TODO Auto-generated method stub
		
		AdUserBean adUserBean=new AdUserBean();		
		List<User> list=userDAO.findUserList(pageCode, size);
		
		adUserBean.setPageCode(pageCode);
		adUserBean.setRecordNum(size);
		adUserBean.setRecordTotel(userDAO.getUserCount());
		adUserBean.setBeanList(list);
				
		for(User user:list){
			UserInfo info=userDAO.findUserInfoByName(user.getUserName());
			user.setUserInfo(info);
		}

		List<MailServer> mList=mailDAO.findMailServerList();
		List<Integer> idList=new ArrayList<>();
		Map<String, MailServer> map=new HashMap<>();
		for(MailServer m:mList){
			idList.add(m.getEmailServerId());
			map.put("k"+m.getEmailServerId(), m);
		}
		
		adUserBean.setMailServerIdList(idList);
		adUserBean.setMailServerMap(map);
		
		return adUserBean;
		
	}

	@Override
	public ClubListBean getAdClubBean() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Club> clubList=clubDAO.findAllClub();//获得所有的版块
		List<ClubType> typeList=clubDAO.getClubTypeList(); //版块类型列表
		
		Map<String, List<Club>> clubMap=new HashMap<String, List<Club>>();//将版块分类保存
		
		for(ClubType type:typeList){
			List<Club> list=new ArrayList<Club>();
			clubMap.put("k"+String.valueOf(type.getClubTypeId()), list);
		}
		
		for(Club club:clubList){
			List<Club> list=clubMap.get("k"+String.valueOf(club.getClubTypeId()));
			list.add(club);
		}
		
		ClubListBean clubListBean=new ClubListBean();
		clubListBean.setClubTypeList(typeList);
		clubListBean.setClubMap(clubMap);
		
		return clubListBean;
	}

	@Override
	public ClubType getClubTypeBean(int typeId) {
		// TODO Auto-generated method stub		
		return clubDAO.getClubTypeById(typeId);
	}

	@Override
	public PostType getPostTypeBean(int typeId) {
		// TODO Auto-generated method stub
		return postDAO.findPostTypeById(typeId);
	}

	@Override
	public AdClubEditBean getAdClubEditBean(String clubName) {
		// TODO Auto-generated method stub
		
		AdClubEditBean adClubEditBean=new AdClubEditBean();
		
		if(clubName!=null){
			Club club=clubDAO.findClub(clubName);
			adClubEditBean.setClub(club);			
			adClubEditBean.setAdminList(adminDAO.findAdminByClub(clubName));
		}
		
		List<ClubType> clubTypes=clubDAO.getClubTypeList();
		
		adClubEditBean.setTypeList(clubTypes);		
		
		return adClubEditBean;
	}

	@Override
	public UserInfoBean getUserInfoBean(String userName,int postPageCode, int postPageNum ,int replyPageCode,int replyPageNum) {
		// TODO Auto-generated method stub
		
		UserInfoBean userInfoBean=new UserInfoBean();
		
		//用户信息
		UserInfo info=userDAO.findUserInfoByName(userName);		
		userInfoBean.setUserInfo(info);
		
		//邮件服务器列表
		List<MailServer> mailServers=mailDAO.findMailServerList();		
		userInfoBean.setMailServerList(mailServers);		

		//用户主题帖
		long recordTatel=postDAO.getPostNumByUser(userName);//用户发表主题帖的总数量		
		List<Post> postList=postDAO.findPostByUser(userName, postPageCode, postPageNum);	//用户发表的主题帖列表
		userInfoBean.setLastPostBean(getLastPostBean(postList, recordTatel, postPageCode, postPageNum));

		//用户回复
		userInfoBean.setReplyListBean(getReplyListBeanByUser(userName, replyPageCode, replyPageNum));
		
		//回复的主题帖
		List<Reply> replyList=userInfoBean.getReplyListBean().getBeanList();
		Map<String, Post> postMap=new HashMap<>();
		
		for(Reply reply:replyList){
			Post post=postDAO.findPostById(reply.getPostId());
			postMap.put("k"+reply.getPostId(), post);
		}
		
		userInfoBean.setPostMap(postMap);
		
		return userInfoBean;
		
	}
	
	private ListBean<Reply> getReplyListBeanByUser(String userName,int replyPageCode,int replyPageNum) {
		// TODO Auto-generated method stub		
		//用户回复
		ListBean<Reply> replyListBean=new ListBean<>();
		
		//回复总数
		long replyTatel=replyDAO.getReplyCountByUser(userName);		
		replyListBean.setRecordTotel(replyTatel);
		
		//回复列表
		List<Reply> list=replyDAO.findReplyByUser(userName, replyPageCode, replyPageNum);
		replyListBean.setBeanList(list);
		
		//分页数据
		replyListBean.setPageCode(replyPageCode);
		replyListBean.setRecordNum(replyPageNum);
		return replyListBean;
	}

	@Override
	public LastPostBean<Post> getAdPostBean(int pageCode, int size) {
		// TODO Auto-generated method stub		
		long recordTatel=postDAO.getAllPostNum();	//数据总数
		List<Post> list=postDAO.findLastPost(pageCode, size);	//最新的主题帖	
		
		return getLastPostBean(list, recordTatel, pageCode, size);
	}
	
	private LastPostBean<Post> getLastPostBean(List<Post> list,long recordTatel, int pageCode, int size) {
		// TODO Auto-generated method stub
//		long recordTatel=postDAO.getAllPostNum();	//数据总数
//		List<Post> list=postDAO.findLastPost(pageCode, size);	//最新的主题帖	
		
		for(Post post:list){
			long replyNum=replyDAO.getReplyCountByPost(post.getPostId());//数据总数
			Post post2=postDAO.findPostById(post.getPostId());
			post.setPostContent(post2.getPostContent());
			post.setReplyNum(replyNum);
		}

		List<PostType> postTypeList=postDAO.getPostTypeList();	//帖子分类列表	
		Map<String, PostType> postTypeMap=new HashMap<String, PostType>(); //分好类的帖子存放的Map对象
		List<Integer> postTypeIdList=new ArrayList<Integer>();		//帖子类型的ID表
		getPostType(postTypeList, postTypeMap, postTypeIdList);	
		
		LastPostBean<Post> lastPostBean=new LastPostBean<Post>();
		lastPostBean.setPageCode(pageCode);
		lastPostBean.setRecordNum(size);
		lastPostBean.setRecordTotel(recordTatel);
		lastPostBean.setBeanList(list);	
		lastPostBean.setPostTypeIdList(postTypeIdList);
		lastPostBean.setPostTypeMap(postTypeMap);	
		
		System.out.println(lastPostBean.toString());
		
		return lastPostBean;
	}
	
	//将得到的帖子列表按照帖子类型分类放入到Map容器中
	private void getPostType(List<PostType> postTypeList,Map<String, PostType> postTypeMap,List<Integer> postTypeIdList){
		for(PostType pt:postTypeList){
			postTypeIdList.add(pt.getPostTypeId());
			postTypeMap.put("k"+String.valueOf(pt.getPostTypeId()), pt);
		}
	}

	@Override
	public AdReplyBean getAdReplyBean(int postId, int pageCode, int size) {
		// TODO Auto-generated method stub

		AdReplyBean adReplyBean=new AdReplyBean();
		
		//主题帖
		Post post=postDAO.findPostById(postId);
		adReplyBean.setPost(post);
		
		//主题帖类型
		PostType postType=postDAO.findPostTypeById(post.getPostTypeId());
		System.out.println(postType);
		adReplyBean.setPostType(postType);
		
		//回复列表
		List<Reply> list=replyDAO.findReplyByPost(postId, pageCode, size);
		adReplyBean.setBeanList(list);
		
		//回复总数
		long num=replyDAO.getReplyCountByPost(postId);
		adReplyBean.setRecordTotel(num);
		
		//分页数据
		adReplyBean.setPageCode(pageCode);
		adReplyBean.setRecordNum(size);
		
		return adReplyBean;
	}
	
	
}






















































