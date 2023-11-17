package campusbbs.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import campusbbs.model.bean.ClubBean;
import campusbbs.model.bean.ClubEditBean;
import campusbbs.model.bean.ClubListBean;
import campusbbs.model.bean.HomeBean;
import campusbbs.model.bean.LastPostBean;
import campusbbs.model.bean.ListBean;
import campusbbs.model.bean.PostBean;
import campusbbs.model.bean.RegistBean;
import campusbbs.model.bean.UserInfoBean;
import campusbbs.model.dao.AdminDAO;
import campusbbs.model.dao.ClubDAO;
import campusbbs.model.dao.MailDAO;
import campusbbs.model.dao.PostDAO;
import campusbbs.model.dao.ReplyDAO;
import campusbbs.model.dao.UserDAO;
import campusbbs.model.factory.DAOFactory;
import campusbbs.model.service.PageService;
import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubAdmin;
import campusbbs.model.vo.ClubType;
import campusbbs.model.vo.MailServer;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.Reply;
import campusbbs.model.vo.UserInfo;

public class PageServiceImpl implements PageService {

	private UserDAO userDAO = DAOFactory.getDAOInstance("userDAO", UserDAO.class);
	private PostDAO postDAO = DAOFactory.getDAOInstance("postDAO", PostDAO.class);
	private ClubDAO clubDAO = DAOFactory.getDAOInstance("clubDAO", ClubDAO.class);
	private ReplyDAO replyDAO = DAOFactory.getDAOInstance("replyDAO", ReplyDAO.class);
	private AdminDAO adminDAO = DAOFactory.getDAOInstance("adminDAO", AdminDAO.class);
	private MailDAO mailDAO = DAOFactory.getDAOInstance("mailDAO", MailDAO.class);

	@Override
	public LastPostBean<Post> getLastPostBean(int pageCode, int size) {
		// TODO Auto-generated method stub		

		long recordTatel=postDAO.getAllPostNum();	//数据总数
		List<Post> list=postDAO.findLastPost(pageCode, size);	//最新的主题帖	

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
		
		return lastPostBean;
		
	}

	@Override
	public ClubBean<Post> getClubPageBean(String clubName,int pageCode, int size) {
		// TODO Auto-generated method stub
		
		Club club=clubDAO.findClub(clubName);
		long recordTatel=postDAO.getPostNumByCLub(clubName);//数据总数
		List<Post> list=postDAO.findPostByClub(clubName, pageCode, size);
		List<ClubAdmin> admins=adminDAO.findAdminByClub(clubName);
		
		List<PostType> postTypeList=postDAO.getPostTypeList();	//帖子分类列表	
		Map<String, PostType> postTypeMap=new HashMap<String, PostType>(); //分好类的帖子存放的Map对象
		List<Integer> postTypeIdList=new ArrayList<Integer>();		//帖子类型的ID表
		getPostType(postTypeList, postTypeMap, postTypeIdList);	
		
		ClubBean<Post> clubBean=new ClubBean<Post>();
		clubBean.setPageCode(pageCode);
		clubBean.setRecordNum(size);
		clubBean.setRecordTotel(recordTatel);
		clubBean.setBeanList(list);		
		clubBean.setClub(club); 
		clubBean.setClubAdminList(admins);
		clubBean.setPostTypeIdList(postTypeIdList);
		clubBean.setPostTypeMap(postTypeMap);
		
		return clubBean;
	}

	@Override
	public PostBean<Reply> getPostPageBean(int postId, int pageCode, int size) {
		// TODO Auto-generated method stub
		Post post=postDAO.findPostById(postId);//获得指定主题帖
		List<Reply> list=replyDAO.findReplyByPost(postId, pageCode, size);
		long recordTatel=replyDAO.getReplyCountByPost(postId);//数据总数
		
		List<PostType> postTypeList=postDAO.getPostTypeList();	//帖子分类列表	
		Map<String, PostType> postTypeMap=new HashMap<String, PostType>(); //分好类的帖子存放的Map对象
		List<Integer> postTypeIdList=new ArrayList<Integer>();		//帖子类型的ID表
		getPostType(postTypeList, postTypeMap, postTypeIdList);	
		
		PostBean<Reply> postBean=new PostBean<>();
		postBean.setPageCode(pageCode);
		postBean.setRecordNum(size);
		postBean.setRecordTotel(recordTatel);
		postBean.setBeanList(list);	
		postBean.setPost(post);
		postBean.setPostTypeIdList(postTypeIdList);
		postBean.setPostTypeMap(postTypeMap);
		
		return postBean;
	}

	@Override
	public HomeBean getHomePageBean() {
		// TODO Auto-generated method stub
		List<Post> posts=postDAO.findHostPost(1, 9);
		List<Club> clubs=clubDAO.findPreClub(6);
		HomeBean homeBean=new HomeBean();
		homeBean.setHostPosts(posts);
		homeBean.setHostClubs(clubs);
		return homeBean;
	}

	@Override
	public ClubListBean getClubListPageBean() {
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
	
	//将得到的帖子列表按照帖子类型分类放入到Map容器中
	private void getPostType(List<PostType> postTypeList,Map<String, PostType> postTypeMap,List<Integer> postTypeIdList){
		for(PostType pt:postTypeList){
			postTypeIdList.add(pt.getPostTypeId());
			postTypeMap.put("k"+String.valueOf(pt.getPostTypeId()), pt);
		}
	}

	@Override
	public ClubEditBean getClubEditBean(String clubName) {
		// TODO Auto-generated method stub
		
		Club club=clubDAO.findClub(clubName);
		
		ClubEditBean clubEditBean=new ClubEditBean();
		
		clubEditBean.setClub(club);
		
		return clubEditBean;
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
	public RegistBean getRegistBean() {
		// TODO Auto-generated method stub
		
		List<MailServer> mailServers=mailDAO.findMailServerList();
		RegistBean registBean=new RegistBean();
		registBean.setMailServerList(mailServers);
		
		return registBean;
		
	}
	
	
}

















































