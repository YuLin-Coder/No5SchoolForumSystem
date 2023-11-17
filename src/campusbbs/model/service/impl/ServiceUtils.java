package campusbbs.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import campusbbs.model.bean.LastPostBean;
import campusbbs.model.bean.ListBean;
import campusbbs.model.dao.PostDAO;
import campusbbs.model.dao.ReplyDAO;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.Reply;

public class ServiceUtils {

	public static LastPostBean<Post> getLastPostBean(List<Post> list,ReplyDAO replyDAO,PostDAO postDAO,long recordTatel, int pageCode, int size) {
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
	
	public static ListBean<Reply> getReplyListBeanByUser(String userName,ReplyDAO replyDAO,int replyPageCode,int replyPageNum) {
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

	//将得到的帖子列表按照帖子类型分类放入到Map容器中
	public static void getPostType(List<PostType> postTypeList,Map<String, PostType> postTypeMap,List<Integer> postTypeIdList){
		for(PostType pt:postTypeList){
			postTypeIdList.add(pt.getPostTypeId());
			postTypeMap.put("k"+String.valueOf(pt.getPostTypeId()), pt);
		}
	}
	
}
