package campusbbs.controller.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import campusbbs.model.factory.BeanFactory;
import campusbbs.model.service.UploadService;
import campusbbs.model.service.UserService;
import campusbbs.model.utils.FileUtils;
import campusbbs.model.vo.Club;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.Reply;
import campusbbs.model.vo.User;
import campusbbs.model.vo.UserInfo;

/**
 * Servlet implementation class FormServlet
 */
@MultipartConfig
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService userService=BeanFactory.getServiceInstance("userService", UserService.class);
	private UploadService uploadService=BeanFactory.getServiceInstance("uploadService", UploadService.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String op=request.getParameter("op");
		
		if(op==null||op.equals("")){
			
			doGet(request, response);
			
		}else if(op.equals("login")){
			
			login(request, response);
			
		}else if(op.equals("register")){
			
			register(request, response);
			
		}else if(op.equals("addPost")){
			
			addPost(request, response);
			
		}else if(op.equals("delPost")){
			
			delPost(request, response);
			
		}else if(op.equals("addReply")){
			
			addReply(request, response);
			
		}else if(op.equals("delReply")){
			
			delReply(request, response);
			
		}else if(op.equals("updatePwd")){
			
			updatePwd(request, response);
			
		}else if(op.equals("editClub")){
			
			editClub(request, response);
			
		}else if(op.equals("editUserInfo")){
			
			editUserInfo(request, response);
			
		}else{
			
			response.sendRedirect("index.jsp");
			
		}
		
	}
	
	//用户注册
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//检查验证码
		if(!checkCode(request,response)){
			request.getRequestDispatcher("/ContentServlet?op=register").forward(request, response);
			return;
		}

		String userName=request.getParameter("userName");		
		String nickname=request.getParameter("nickname");		
		String passwd=request.getParameter("passwd");
		String emailAccount=request.getParameter("email");//serverId
		String emailServerId=request.getParameter("serverId");//serverId
		
		UserInfo info=new UserInfo();
		info.setUserName(userName);
		info.setNickname(nickname);
		info.setEmailAccount(emailAccount);
		info.setHead(userName+".png");
		try {
			info.setEmailServerId(Integer.parseInt(emailServerId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User user=new User();
		user.setUserName(userName);
		user.setPasswd(passwd);
		user.setUserInfo(info);
		
		if(!userService.register(user)){
			request.setAttribute("msg", userService.getErrorMessage());
			request.getRequestDispatcher("/ContentServlet?op=register").forward(request, response);
			return ;
		}
		
		//保存默认头像
		FileUtils.copyFile(request.getServletContext().getRealPath("/img/user_head/head.png"), request.getServletContext().getRealPath("/img/user_head")+"/"+info.getHead(), true);
		
		response.sendRedirect("content/registerSuccess.jsp");
		
	}
	
	//用户登录
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//检查验证码
		if(!checkCode(request,response)){
			request.getRequestDispatcher("/ContentServlet?op=login").forward(request, response);
			return;
		}
		
		String userName=request.getParameter("userName");
		String passwd=request.getParameter("passwd");		
		
		HttpSession session=request.getSession();		
		User loginUser=new User();
		loginUser.setUserName(userName);
		loginUser.setPasswd(passwd);
		User user=userService.login(loginUser);
		
		if(user==null){
			request.setAttribute("msg", userService.getErrorMessage());
			request.getRequestDispatcher("content/login.jsp").forward(request, response);
			return;
		}
		//删除当前登录的管理员账号再记录登录的普通用户
		session.removeAttribute("adminUser");
		session.setAttribute("user", user);
		
		request.getRequestDispatcher("content/loginSuccess.jsp").forward(request, response);
	}
	
	//发表主题帖
	private void addPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		User user=(User)session.getAttribute("user");
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=login");
			return;
		}

		String title=(String) request.getParameter("title");
		String content=(String) request.getParameter("content");
		String clubName=request.getParameter("clubName");
		Timestamp time=new Timestamp(System.currentTimeMillis());
		String typeId=request.getParameter("postTypeId");
		int postTypeId=0;
		try {
			postTypeId=Integer.parseInt(typeId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("content/home.jsp").forward(request, response);
			return;
		}

		
		//检查验证码
		if(!checkCode(request,response)){
			System.out.println("验证码错误");
			request.setAttribute("msg", "验证码错误！");
		}else{
			
			Post post=new Post();
			post.setPostTitle(title);
			post.setPostContent(content);
			post.setPostTime(time);
			post.setLastTime(time);
			post.setUserName(user.getUserName());
			post.setClubName(clubName);
			post.setPostTypeId(postTypeId);
			
			userService.savePost(post);
			
		}
		request.setAttribute("clubName", clubName);
		request.getRequestDispatcher("/ContentServlet?op=club").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/ContentServlet?op=club&clubName="+URLEncoder.encode(clubName,"utf-8"));		
		
	}
	
	//发表回复
	private void addReply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		
		User user=(User)session.getAttribute("user");
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=login");
			return;
		}		
		
		String pageCode=request.getParameter("pageCode");
		if(pageCode==null||pageCode.trim().isEmpty()){
			pageCode="1";
		}
		String postId=request.getParameter("postId");
		String replyContent=request.getParameter("replyContent");
		Timestamp time=new Timestamp(System.currentTimeMillis());
		int id=Integer.parseInt(postId);
				
		//检查验证码
		if(!checkCode(request,response)){
			System.out.println("验证码错误");
			request.setAttribute("msg", "验证码错误！");
		}else{		
			Reply reply=new Reply();
			reply.setReplyContent(replyContent);
			reply.setPostId(id);
			reply.setReplyTime(time);
			reply.setUserName(user.getUserName());		
			userService.savaReply(reply);
		}
		
//		response.sendRedirect(request.getContextPath()+"/ContentServlet?op=post&postId="+postId+"&pageCode="+pageCode);	

		request.getRequestDispatcher("/ContentServlet?op=post&postId="+postId+"&pageCode="+pageCode).forward(request, response);
	}
	
	//删除主题帖
	private void delPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		User user=(User)session.getAttribute("user");
		if(user==null){
			response.sendRedirect("content/login.jsp");
			return;
		}
		
		String postId=(String) request.getParameter("postId");
		int id=Integer.parseInt(postId);	
		userService.deletePost(id);

		String userName=request.getParameter("userName");
		if(userName!=null){
			request.getRequestDispatcher("/ContentServlet?op=userSetting&"+request.getQueryString()).forward(request, response);
			return;
		}

		
		String qstr=request.getQueryString();
		System.out.println(qstr);
		qstr=qstr.replaceAll("op=([a-zA-Z]*)", "op=club");
		System.out.println(qstr);
		response.sendRedirect(request.getContextPath()+"/ContentServlet?"+qstr);	
		
	}
	
	//删除回复
	private void delReply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		HttpSession session=request.getSession();
		
		User user=(User)session.getAttribute("user");
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=login");
			return;
		}		
		
		String replyIdStr=request.getParameter("replyId");
		String postIdStr=request.getParameter("postId");
		String pageCode=request.getParameter("pageCode");
		
		try {
			
			int replyId=Integer.parseInt(replyIdStr);		
			userService.deleteReply(replyId);
			
			String userName=request.getParameter("userName");
			System.out.println("+-+-+-用户删除操作+-+-+-:"+userName);
			if(userName!=null){
				request.getRequestDispatcher("/ContentServlet?op=userSetting&"+request.getQueryString()).forward(request, response);
				return;
			}
			
			String qstr=request.getQueryString();
			System.out.println(qstr);
			qstr=qstr.replaceAll("op=([a-zA-Z]*)", "op=post");
			System.out.println(qstr);
			response.sendRedirect(request.getContextPath()+"/ContentServlet?"+qstr);	
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println(replyIdStr+"\t"+postIdStr+"\t"+pageCode);
			response.sendError(404);
		}
		
	}
	
	//保存编辑的版块信息
	private void editClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Part imgPart=null;
		Part clubNamePart=null;
		Part clubIconPart=null;
		Part clubDescribePart=null;
		try {
			
			imgPart = request.getPart("upImg");	
			clubNamePart = request.getPart("currClubName");	
			clubIconPart = request.getPart("clubIcon");	
			clubDescribePart = request.getPart("clubDescribe");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			System.out.println("出现异常！");
			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=home");
			
		}	
		
		if(imgPart==null||clubNamePart==null||clubIconPart==null){
			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=home");	
			return;
		}
		
		Club club=new Club();
		
		//获取版块名
		String clubName=uploadService.getStringParameter(clubNamePart);
		club.setClubName(clubName);
		
		//版块描述
		String clubDescribe=uploadService.getStringParameter(clubDescribePart);	
		club.setClubDescribe(clubDescribe);
		
		//获取图片名
		String clubIcon=uploadService.getStringParameter(clubIconPart);		
		String imgName=uploadService.getImageName(imgPart);		
		if(imgName==null||imgName.trim().isEmpty()){
			imgName=clubIcon;
		}else{
			
			imgName=imgName.substring(imgName.lastIndexOf("."));
			imgName=clubIcon.substring(0,clubIcon.lastIndexOf("."))+imgName;

			//保存图片
			String path=request.getServletContext().getRealPath("/img/club_icon");
			uploadService.saveImage(imgPart, path,imgName, clubIcon);
			club.setClubIcon(imgName);
		}
		
		userService.updateClub(clubName,club);

//		request.setAttribute("msg", "保存成功！");
		
//		System.out.println("______>>>>"+URLEncoder.encode(clubName,"utf-8"));
//		request.getRequestDispatcher("/ContentServlet?op=clubEdit&clubName="+URLEncoder.encode(clubName,"utf-8")).forward(request, response);
		
		response.sendRedirect(request.getContextPath()+"/ContentServlet?op=clubEdit&clubName="+URLEncoder.encode(clubName,"utf-8")+"&sta="+Math.random());
		
	}
	
	//修改用户信息
	private void editUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user=(User)(request.getSession().getAttribute("user"));
		if(user==null){
			
			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=login");
			return;
			
		}
		
		Part imgPart=null;	
		Part namePart=null;	
		Part emailPart=null;	
		Part serverIdPart=null;	

		try {
			imgPart = request.getPart("upImg");	
			namePart = request.getPart("name");	
			emailPart = request.getPart("email");	
			serverIdPart = request.getPart("serverId");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=home");	
		}	
		
		UserInfo info=new UserInfo();
		
		if(imgPart==null||namePart==null||emailPart==null||serverIdPart==null){
			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=home");	
			return;
		}
		
		//获取昵称
		String nickname=uploadService.getStringParameter(namePart); 
		if(nickname.length()>10){
			request.setAttribute("msg", "昵称超出长度限制！");
			request.getRequestDispatcher("/ContentServlet?op=userSetting").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=userSetting");	
			return;
		}
		
		//邮箱账号
		String emailAccount=uploadService.getStringParameter(emailPart); 
		
		//邮箱服务器ID
		String serverId=uploadService.getStringParameter(serverIdPart);	
		
		//获取图片名
		String imgName=uploadService.getImageName(imgPart);
		if(imgName!=null&&!(imgName.trim().isEmpty())){

			System.out.println(356+" , "+imgName);
			imgName=imgName.substring(imgName.lastIndexOf("."));
			
			System.out.println(353+" , "+imgName);
			imgName=user.getUserName()+imgName;
			

			System.out.println(357+" , "+imgName);
			info.setHead(imgName);//
			
			//保存图片
			String path=request.getServletContext().getRealPath("/img/user_head");
			System.out.println(362+" , "+imgName);
			uploadService.saveImage(imgPart, path,imgName, user.getUserInfo().getHead());

		}
		

		System.out.println("editUserInfo 5");
		
		info.setUserName(user.getUserName());
		info.setNickname(nickname);
		info.setEmailServerId(Integer.parseInt(serverId));
		info.setEmailAccount(emailAccount);
		
		if(!userService.updateUserInfo(info)){
			request.setAttribute("msg", userService.getErrorMessage());
		}else{
			request.setAttribute("msg", "保存成功！");
		}
		
		System.out.println("info , "+info.toString());
		
		user.setUserInfo(userService.getUserInfo(user.getUserName()));
		
		System.out.println(user.getUserInfo().toString());

		request.getRequestDispatcher("/ContentServlet?op=userSetting").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/ContentServlet?op=userSetting");
			
	}
	
	private void updatePwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user=(User)(request.getSession().getAttribute("user"));
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=login");
			return;
			
		}
		
		String oldPwd=request.getParameter("oldpasword");
		String newPwd=request.getParameter("newpasword");
		String pwdagain=request.getParameter("paswordagain");
		
		if(userService.updatePasswd(user, oldPwd, newPwd, pwdagain)){
			request.setAttribute("msg", "密码更改成功！");
		}else{
			request.setAttribute("msg", userService.getErrorMessage());
		}

		request.getRequestDispatcher("/ContentServlet?op=userSetting").forward(request, response);
	}
	
	//检查验证码
	private boolean checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check=request.getParameter("check");
		HttpSession session=request.getSession();
		System.out.println("检查验证码："+check+","+session.getAttribute("check"));
		if(check!=null&&check.equalsIgnoreCase((String)session.getAttribute("check"))){
			return true;
		}
		request.setAttribute("msg", "验证码不正确！");
		return false;
	}

}

































