package campusbbs.controller.servlet;

import campusbbs.model.bean.*;
import campusbbs.model.factory.BeanFactory;
import campusbbs.model.service.PageService;
import campusbbs.model.service.UserService;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.Reply;
import campusbbs.model.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class ContentServlet
 */
@WebServlet("/ContentServlet")
public class ContentServlet extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
		private PageService pageService;
		private UserService userService;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ContentServlet() {
	        super();
	        // TODO Auto-generated constructor stub
			pageService=BeanFactory.getServiceInstance("pageService", PageService.class);
			userService=BeanFactory.getServiceInstance("userService", UserService.class);
	    }	   
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ContentServlet(PageService pageService,UserService userService) {
	        super();
	        // TODO Auto-generated constructor stub
	        this.pageService=pageService;
	        this.userService=userService;
	    }
	    
	    
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String op=request.getParameter("op");
			
			if(op==null||op.equals("home")){
				
				showHomePage(request, response);
				
			}else if(op.equals("login")){
				
				showLoginPage(request, response);
				
			}else if(op.equals("loginOut")){
				
				showLoginOutPage(request, response);
				
			}else if(op.equals("register")){
				
				showRegisterPage(request, response);
				
			}else if(op.equals("clubList")){
				
				showClubListPage(request, response);
				
			}else if(op.equals("club")){
				
				showClubPage(request, response);
				
			}else if(op.equals("post")){
				
				showPostPage(request, response);
				
			}else if(op.equals("lastPost")){
				
				showLastPostPage(request, response);
				
			}else if(op.equals("public")){
				
				showPublicPage(request, response);
				
			}else if(op.equals("userSetting")){
				
				showUserSettingPage(request, response);
				
			}else if(op.equals("clubEdit")){
				
				showClueEditPage(request, response);
				
			}
			
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
		//首页
		private void showHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			HomeBean homeBean=pageService.getHomePageBean();
			request.setAttribute("homeBean", homeBean);
			request.getRequestDispatcher("/content/home.jsp").include(request, response);
		}
	
		//登陆页面
		private void showLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/content/login.jsp").include(request, response);
		}
	
		//注册页面
		private void showRegisterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			RegistBean registBean = pageService.getRegistBean();
			
			request.setAttribute("registBean", registBean);
			
			request.getRequestDispatcher("/content/register.jsp").forward(request, response);
			
		}
		
		//最新帖子页面
		private void showLastPostPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String pageNumStr=request.getParameter("pageCode");
			int pageCode=1;
			try {
				pageCode=Integer.parseInt(pageNumStr);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
			}		
			LastPostBean<Post> lastPostBean=pageService.getLastPostBean(pageCode, 20);		
			request.setAttribute("lastPostBean", lastPostBean);		
	//		request.setAttribute("pageBean", lastPostBean);		
			request.getRequestDispatcher("/content/lastPost.jsp").forward(request, response);
		}
	
		//版块选择页面
		private void showClubListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			ClubListBean clubListBean=pageService.getClubListPageBean();
			request.setAttribute("clubListBean", clubListBean);
			request.getRequestDispatcher("/content/clubList.jsp").include(request, response);
			
		}
	
		//版块页面
		private void showClubPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String clubName=getCLubName(request);
			if(clubName==null){
				showHomePage(request, response);
				return;
			}
			
			String pageNumStr=request.getParameter("pageCode");
			int pageCode=1;
			try {
				pageCode=Integer.parseInt(pageNumStr);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
			}		
			
			ListBean<Post> clubBean=pageService.getClubPageBean(clubName, pageCode, 15);
			request.setAttribute("clubBean", clubBean);	
			
			request.getRequestDispatcher("/content/club.jsp").include(request, response);
		}
	
		//主题帖页面
		private void showPostPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String postId=request.getParameter("postId");		
			String pageNumStr=request.getParameter("pageCode");
			int pageCode=1;
			int id=0;
			
			try {
				id=Integer.parseInt(postId);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				showHomePage(request, response);
				return;
			}		
	
			try {
				pageCode=Integer.parseInt(pageNumStr);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
			}
			
			PostBean<Reply> postBean=pageService.getPostPageBean(id, pageCode, 5);
			request.setAttribute("postBean", postBean);		
			request.getRequestDispatcher("/content/post.jsp").forward(request, response);
		}
		
		//用户注销
		private void showLoginOutPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			HttpSession session=request.getSession();
			if(session.getAttribute("user")!=null){
				session.removeAttribute("user");
			}
			request.getRequestDispatcher("/content/loginOut.jsp").forward(request, response);
		}
		
		//公告栏
		private void showPublicPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.getRequestDispatcher("/content/public.jsp").forward(request, response);
		}
		
		//版块编辑页面
		private void showClueEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			User user=getLoginUser(request);
			String clubName=getCLubName(request);
	
			if(user==null||clubName==null||!userService.isClubAdmin(user, clubName)){
				//用户没有登录,或没有版块名参数,或用户不是版主，跳转到主页
				System.out.println(user+","+clubName);
				showHomePage(request, response);
				return;
			}
			
			ClubEditBean clubEditBean=pageService.getClubEditBean(clubName);
			clubEditBean.setUrl(request.getQueryString());
			
			HttpSession session = request.getSession();
			session.setAttribute("clubEditBean", clubEditBean);
			
	//		request.setAttribute("clubEditBean", clubEditBean);
			request.getRequestDispatcher("/content/clubEdit.jsp").forward(request, response);
		}
		
		//用户信息修改页面
		private void showUserSettingPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			User user=getLoginUser(request);
	
			if(user==null){
				//用户没有登录,或没有版块名参数,或用户不是版主，跳转到主页
				showHomePage(request, response);
				return;
			}
			
	
			String postPageNumStr=request.getParameter("postPageCode");
			String replyPageNumStr=request.getParameter("replyPageCode");
			int postPageCode=1;
			int replyPageCode=1;
			try {
				postPageCode=Integer.parseInt(postPageNumStr);
				replyPageCode=Integer.parseInt(replyPageNumStr);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
			}			
			int postSize=6;
			int replySize=5;
	//		System.out.println(userInfoBean.toString());
			
			UserInfoBean userInfoBean=new UserInfoBean();
			userInfoBean=pageService.getUserInfoBean(user.getUserName(),postPageCode,postSize,replyPageCode,replySize);
			
			System.out.println("++"+userInfoBean.toString());
			System.out.println("++"+userInfoBean.getReplyListBean().toString());
			
			request.setAttribute("userInfoBean", userInfoBean);
	
			request.getRequestDispatcher("/content/userSetting.jsp").forward(request, response);
			
		}
		
		//在请求参数中获取版块名
		private String getCLubName(HttpServletRequest request) throws ServletException, IOException {
			// TODO Auto-generated method stub	
			String clubName=(String)request.getAttribute("clubName");
	//		String clubName=request.getParameter("clubName");
	
			if(clubName==null||clubName.trim().isEmpty()){
				clubName=request.getParameter("clubName");
				if(clubName==null||clubName.trim().isEmpty()){
					return null;
				}
//				clubName=new String(clubName.getBytes("ISO8859-1"),"utf-8");
			}
			System.out.println("clubName == "+clubName);
			return clubName;
		}
		
		//获取已经登录的用户
		private User getLoginUser(HttpServletRequest request) throws ServletException, IOException {
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("user");
			return user;
		}
	
}






























