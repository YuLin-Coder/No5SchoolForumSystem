package campusbbs.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import campusbbs.model.factory.BeanFactory;
import campusbbs.model.service.SysAdminService;
import campusbbs.model.service.UploadService;
import campusbbs.model.utils.FileUtils;
import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubAdmin;
import campusbbs.model.vo.ClubType;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.SystemAdmin;
import campusbbs.model.vo.UserInfo;

/**
 * Servlet implementation class AdUpdateServlet
 */
@MultipartConfig
@WebServlet("/AdUpdateServlet")
public class AdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SysAdminService sysAdminService=BeanFactory.getServiceInstance("sysAdminService", SysAdminService.class);
	private UploadService uploadService=BeanFactory.getServiceInstance("uploadService", UploadService.class);
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdUpdateServlet() {
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
		
		if(op==null||op.trim().isEmpty()){
			response.sendError(404);
			return;
		}else if(op.endsWith("clubTypeUpdate")){
			updateClubType(request, response);
		}else if(op.endsWith("addClubType")){
			addClubType(request, response);
		}else if(op.endsWith("deleteClubType")){
			deleteClubType(request, response);
		}else if(op.endsWith("editClub")){
			editClub(request, response);
		}else if(op.endsWith("deleteClub")){
			deleteClub(request, response);
		}else if(op.endsWith("addClubAdmin")){
			addClubAdmin(request, response);
		}else if(op.endsWith("deleteClubAdmin")){
			deleteClubAdmin(request, response);
		}else if(op.equals("addUser")){
			addUser(request, response);
		}else if(op.equals("deleteUser")){
			deleteUser(request, response);
		}else if(op.equals("updateUserPwd")){
			updatePwd(request, response);
		}else if(op.equals("updateUserInfo")){
			updateUserInfo(request, response);
		}else if(op.equals("adminLogin")){
			adminLogin(request, response);
		}else if(op.equals("adminLoginOut")){
			adminLoginOut(request, response);
		}else if(op.equals("deletePost")){
			deletePost(request, response);
		}else if(op.equals("deletePostType")){
			deletePostType(request, response);
		}else if(op.equals("deleteReply")){
			deleteReply(request, response);
		}else if(op.equals("addPostType")){
			addPostType(request, response);
		}else if(op.equals("editPostType")){
			updatePostType(request, response);
		}
		
	}
	
	//更新版块类型
	private void updateClubType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String typeIdStr=request.getParameter("clubTypeId");		
		System.out.println(">>"+typeIdStr);
		int typeId=Integer.parseInt(typeIdStr);
		String typeName=request.getParameter("clubTypeName");
		
		ClubType clubType=new ClubType();
		clubType.setClubTypeId(typeId);
		clubType.setClubType(typeName);
		
		if(!sysAdminService.updateClubType(clubType)){
			request.setAttribute("msg", sysAdminService.getErrorMessage());
		}else{
			request.setAttribute("msg", "修改成功！");
		}
		request.getRequestDispatcher("/AdPageServlet?page=clubTypeEdit&typeId="+typeId).forward(request, response);
		
	}

	
	//添加版块类型
	private void addClubType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String typeIdStr=request.getParameter("clubTypeId");	
//		int typeId=Integer.parseInt(typeIdStr);
		String typeName=request.getParameter("clubTypeName");
		
		ClubType clubType=new ClubType();
//		clubType.setClubTypeId(typeId);
		clubType.setClubType(typeName);
		
		if(!sysAdminService.addClubType(clubType)){
			request.setAttribute("msg", sysAdminService.getErrorMessage());
		}else{
			request.setAttribute("msg", "添加成功！");
		}
		
		request.getRequestDispatcher("/AdPageServlet?page=club").forward(request, response);
		
	}

	
	//删除版块类型
	private void deleteClubType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String typeIdStr=request.getParameter("typeId");	
		int typeId=Integer.parseInt(typeIdStr);
		
		ClubType clubType=new ClubType();
		clubType.setClubTypeId(typeId);
		
		sysAdminService.deleteClubType(clubType);
		
		request.getRequestDispatcher("/AdPageServlet?page=club").forward(request, response);
		
	}
	
	//保存的版块信息
	private void editClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("编辑版块类型:");
		
		Part imgPart=null;
		Part oldClubNamePart=null;
		Part clubNamePart=null;
		Part clubIconPart=null;
		Part clubDescribePart=null;
		Part clubTypePart=null;
		try {
			
			imgPart = request.getPart("upImg");	
			System.out.println(imgPart);
			oldClubNamePart = request.getPart("oldClubName");	
			System.out.println(oldClubNamePart);
			clubNamePart = request.getPart("clubName");	
			System.out.println(clubNamePart);
			clubIconPart = request.getPart("clubIcon");	
			System.out.println(clubIconPart);
			clubDescribePart = request.getPart("clubDescribe");
			System.out.println(clubDescribePart);
			clubTypePart = request.getPart("clubTypeId");
			System.out.println(clubTypePart);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			
			System.out.println("出现异常！1");
//			request.getRequestDispatcher("/AdPageServlet?page=club").forward(request, response);
			response.sendError(404);
			return;
			
		}	
		
		if(imgPart==null||clubNamePart==null||clubTypePart==null){
//			request.getRequestDispatcher("/AdPageServlet?page=club").forward(request, response);
			System.out.println(imgPart+","+clubNamePart+","+clubIconPart+","+clubTypePart);
			response.sendError(404);
			return;
		}
		
		Club club=new Club();
		
		//获取版块类型
		String typeIdStr=uploadService.getStringParameter(clubTypePart);
		int id=0;
		System.out.println("获取版块类型:"+typeIdStr);
		try {
			id=Integer.parseInt(typeIdStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("出现异常！2");
			response.sendError(404);
		}
		club.setClubTypeId(id);
		
		
		//获取版块名
		String clubName=uploadService.getStringParameter(clubNamePart);
		System.out.println("获取版块名:"+clubName);
		if(clubName==null||clubName.trim().isEmpty()){
			response.sendError(404);
			return ;
		}
		clubName.trim();
		club.setClubName(clubName);
		
		//版块描述
		String clubDescribe=uploadService.getStringParameter(clubDescribePart);	
		club.setClubDescribe(clubDescribe);
		
		//获取原图片名
		String clubIcon=System.currentTimeMillis()+".png";
		if(clubIconPart!=null){
			String tem=uploadService.getStringParameter(clubIconPart);	
			if(tem!=null&&!tem.trim().isEmpty()){
				clubIcon=tem;
			}
		}
		System.out.println("clubIcon:"+clubIcon);
		
		//获取上传的图片
		String imgName=uploadService.getImageName(imgPart);		
		String imgPath=request.getServletContext().getRealPath("/img/club_icon");
		if(imgName!=null&&!(imgName.trim().isEmpty())){
			
			imgName=imgName.substring(imgName.lastIndexOf("."));
			imgName=clubIcon.substring(0,clubIcon.lastIndexOf("."))+imgName;

			//保存图片
			uploadService.saveImage(imgPart, imgPath,imgName, clubIcon);
			club.setClubIcon(imgName);
			
		}else{
			if(oldClubNamePart==null){
				System.out.println("新版块的图标："+imgPart+"/club.png"+"\n --> "+ imgPart+"/"+clubIcon);
				FileUtils.copyFile(imgPath+"/club.png", imgPath+"/"+clubIcon, true);
				club.setClubIcon(clubIcon);
			}
		}

		boolean flag=false;
		if(oldClubNamePart==null){
			flag=sysAdminService.addClub(club);
		}else{
			String oldClubName=uploadService.getStringParameter(oldClubNamePart);
			flag=sysAdminService.updateClub(oldClubName,club);
		}

		if(flag){

			request.setAttribute("msg", "保存成功！");
			
		}else{
			
			request.setAttribute("msg", sysAdminService.getErrorMessage());
			
		}

		request.setAttribute("update", clubName);
//		System.out.println("______>>>>"+URLEncoder.encode(clubName,"utf-8"));
		request.getRequestDispatcher("/AdPageServlet?page=adEditClub").forward(request, response);
		System.out.println(request.getContextPath()+"/AdPageServlet?page=adEditClub&clubName="+clubName+"&sta="+Math.random());
//		response.sendRedirect(request.getContextPath()+"/AdPageServlet?page=adEditClub&clubName="+URLEncoder.encode(clubName,"utf-8")+"&sta="+Math.random());
		
	}

	//删除版块
	private void deleteClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String clubName=request.getParameter("clubName");
		
		if(clubName!=null){
			clubName=new String(clubName.getBytes("ISO8859-1"),"utf-8");
			sysAdminService.deleteClub(clubName);
		}
		
		response.sendRedirect(request.getContextPath()+"/AdPageServlet?page=club");
		
	}
	
	//添加版主
	private void addClubAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String clubName=request.getParameter("clubName");
		String userName=request.getParameter("userName");
		
		ClubAdmin clubAdmin=new ClubAdmin();
		clubAdmin.setClubName(clubName);
		clubAdmin.setUserName(userName);
		
		if(sysAdminService.addClubAdmin(clubAdmin)){
			request.setAttribute("msg", "添加成功！");
		}else{
			request.setAttribute("msg", sysAdminService.getErrorMessage());
		}
		request.setAttribute("update", clubName);		
		request.getRequestDispatcher("/AdPageServlet?page=adEditClub").forward(request, response);
		
	}
	
	//删除版主
	private void deleteClubAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("删除版主");
		
		String clubName=request.getParameter("clubName");
		if(clubName!=null&&!clubName.trim().isEmpty()){
			clubName=new String(clubName.getBytes("ISO8859-1"),"utf-8");
		}else{
			response.sendRedirect(request.getContextPath()+"/AdPageServlet?page=club");
			return;
		}
		String userName=request.getParameter("userName");
		
		ClubAdmin clubAdmin=new ClubAdmin();
		clubAdmin.setClubName(clubName);
		clubAdmin.setUserName(userName);
		
		System.out.println(clubAdmin);
		
		sysAdminService.deleteClubAdmin(clubAdmin);
		request.setAttribute("update", clubName);	
		request.getRequestDispatcher("/AdPageServlet?page=adEditClub").forward(request, response);
		
	}
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName=request.getParameter("userName");
		
		if(sysAdminService.deleteUser(userName)){
			request.setAttribute("msg", "删除成功！");
		}else{
			request.setAttribute("msg", "删除失败！");
		}
		
		request.getRequestDispatcher("/AdPageServlet?page=user").forward(request, response);
		
	}
	
	//修改用户信息
	private void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Part userNamePart=null;
		Part headPart=null;
		Part imgPart=null;	
		Part namePart=null;	
		Part emailPart=null;	
		Part serverIdPart=null;	

		try {
			userNamePart = request.getPart("userName");
			headPart = request.getPart("head");
			imgPart = request.getPart("upImg");	
			namePart = request.getPart("name");	
			emailPart = request.getPart("email");	
			serverIdPart = request.getPart("serverId");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
//			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=home");	
			System.out.println("1,"+userNamePart+","+headPart+","+imgPart+","+namePart+","+emailPart+","+serverIdPart);
			response.sendError(404);
			return;
		}	
		
		UserInfo info=new UserInfo();
		
		if(userNamePart==null||imgPart==null||namePart==null||emailPart==null||serverIdPart==null){
//			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=home");	

			System.out.println("2,"+userNamePart+","+headPart+","+imgPart+","+namePart+","+emailPart+","+serverIdPart);
			response.sendError(404);
			return;
			
		}
		
		//获取用户名
		String userName=uploadService.getStringParameter(userNamePart);
		
		//获取头像图片的名称
		String head = uploadService.getStringParameter(headPart);
		if(head==null){
			head=System.currentTimeMillis()+".png";
		}
		
		//获取昵称
		String nickname=uploadService.getStringParameter(namePart); 
		System.out.println("获取昵称");
		if(nickname.length()>10){
			request.setAttribute("msg", "昵称超出长度限制！");
			System.out.println(request.getQueryString());
			request.getRequestDispatcher("/AdPageServlet?page=editUser&userName="+userName).forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/ContentServlet?op=userSetting");	
			return;
		}

		System.out.println("获取昵称");
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
			imgName=userName+imgName;
			

			System.out.println(357+" , "+imgName);
			info.setHead(imgName);//
			
			//保存图片
			String path=request.getServletContext().getRealPath("/img/user_head");
			System.out.println(362+" , "+imgName);
			uploadService.saveImage(imgPart, path,imgName, head);

		}
		

		System.out.println("editUserInfo 5");
		
		info.setUserName(userName);
		info.setNickname(nickname);
		info.setEmailServerId(Integer.parseInt(serverId));
		info.setEmailAccount(emailAccount);
		
		System.out.println("info , "+info.toString());
		
		sysAdminService.updateUserInfo(info);

		request.setAttribute("msg", "保存成功！");
		request.getRequestDispatcher("/AdPageServlet?page=editUser&userName="+userName).forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/ContentServlet?op=userSetting");
			
		
	}
	
	//修改用户密码
	private void updatePwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName= request.getParameter("userName");
		String oldPwd=request.getParameter("oldpasword");
		String newPwd=request.getParameter("newpasword");
		String pwdagain=request.getParameter("paswordagain");
		
		if(sysAdminService.updateUserPasswd(userName, oldPwd, newPwd, pwdagain)){
			request.setAttribute("msg", "密码更改成功！");
		}else{
			request.setAttribute("msg", sysAdminService.getErrorMessage());
		}

		request.getRequestDispatcher("/AdPageServlet?page=editUser&userName="+userName).forward(request, response);
	}
	
	//管理员登录
	private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//检查验证码
		if(!checkCode(request,response)){
			System.out.println("验证码不正确");
			request.getRequestDispatcher("/sys/adminLogin.jsp").forward(request, response);
			return;
		}
		
		String userName=request.getParameter("userName");
		String passwd=request.getParameter("passwd");		
		
		HttpSession session=request.getSession();		
		SystemAdmin adminUser=new SystemAdmin();
		adminUser.setAdminName(userName);
		adminUser.setPasswd(passwd);
		SystemAdmin checkUser=sysAdminService.adminLogin(adminUser);
		
		if(checkUser==null){
			System.out.println("登录失败："+sysAdminService.getErrorMessage());
			request.setAttribute("msg", sysAdminService.getErrorMessage());
			request.getRequestDispatcher("/sys/adminLogin.jsp").forward(request, response);
			return;
		}
		//删除当前登录的普通用户再记录登录的管理员账号
		session.removeAttribute("user");
		session.setAttribute("adminUser", checkUser);
		
		request.getRequestDispatcher("/sys/public/right.jsp").forward(request, response);

	}
	
	//管理员登录
	private void adminLoginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		session.removeAttribute("adminUser");		
		request.getRequestDispatcher("/sys/public/right.jsp").forward(request, response);

	}
	
	//删除主题帖
	private void deletePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String postId=(String) request.getParameter("postId");
		int id=Integer.parseInt(postId);	
		sysAdminService.deletePost(id);
		
		String userName=request.getParameter("userName");
		System.out.println("+-+-+-+-+-+-:"+userName);
		if(userName!=null){
			System.out.println("+-+-+-+-+-+-:"+request.getRequestURI());
			System.out.println("+-+-+-+-+-+-:"+request.getQueryString());
			request.getRequestDispatcher("/AdPageServlet?page=editUser&"+request.getQueryString()).forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/AdPageServlet?page=editUser&"+request.getQueryString());
			return;
		}
		response.sendRedirect(request.getContextPath()+"/AdPageServlet?page=post"+request.getQueryString());
		
	}

	
	//删除主题类型
	private void deletePostType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String pageCodeStr=(String) request.getParameter("pageCode");
		int pageCode=1;
		try {
			pageCode=Integer.parseInt(pageCodeStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		String typeId=(String) request.getParameter("typeId");
		int id=Integer.parseInt(typeId);	
		sysAdminService.deletePostType(id);
		
		response.sendRedirect(request.getContextPath()+"/AdPageServlet?page=post&pageCode="+pageCode);
	}
	
	//删除回复
	private void deleteReply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String replyIdStr=request.getParameter("replyId");
		int id=Integer.parseInt(replyIdStr);
		sysAdminService.deleteReply(id);
		
		String userName=request.getParameter("userName");
		System.out.println("+-+-+-删除操作+-+-+-:"+userName);
		if(userName!=null){
			System.out.println("+-+-+-+-+-+-:"+request.getContextPath()+"/AdPageServlet?page=editUser&"+request.getQueryString());
			request.getRequestDispatcher("/AdPageServlet?page=editUser&"+request.getQueryString()).forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/AdPageServlet?page=editUser&userName="+userName+"&pageCode="+pageCode);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/AdPageServlet?page=reply&"+request.getQueryString());
	}
	
	//添加主题类型
	private void addPostType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String postTypeName=request.getParameter("postTypeName");
		String titleColor=request.getParameter("titleColor");
		String pageCodeStr=(String) request.getParameter("pageCode");
		int pageCode=1;
		try {
			pageCode=Integer.parseInt(pageCodeStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		PostType postType=new PostType();
		postType.setPostType(postTypeName);
		postType.setColor(titleColor);
		
		if(sysAdminService.addPostType(postType)){
			request.setAttribute("msg", "添加成功！");
		}else{
			request.setAttribute("msg", sysAdminService.getErrorMessage());
		}

		request.getRequestDispatcher("/AdPageServlet?page=post&pageCode="+pageCode).forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/AdPageServlet?page=post&pageCode="+pageCode);
		
	}
	
	//修改主题帖类型
	private void updatePostType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("修改主题帖类型");
		String typeId=request.getParameter("typeId");
		String postTypeName=request.getParameter("postTypeName");
		String titleColor=request.getParameter("titleColor");

		PostType postType=new PostType();
		postType.setPostTypeId(Integer.parseInt(typeId));
		postType.setPostType(postTypeName);
		postType.setColor(titleColor);		
		
		if(sysAdminService.updatePostType(postType)){
			System.out.println("修改成功！");
			request.setAttribute("msg", "修改成功！");
		}else{
			System.out.println("修改失败！");
			request.setAttribute("msg", sysAdminService.getErrorMessage());
		}

		System.out.println("跳转："+"/AdPageServlet?page=postTypeEdit&typeId="+typeId);
		request.getRequestDispatcher("/AdPageServlet?page=postTypeEdit&typeId="+typeId).forward(request, response);
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










































