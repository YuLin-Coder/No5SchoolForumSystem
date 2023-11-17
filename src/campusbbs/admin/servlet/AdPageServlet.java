package campusbbs.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import campusbbs.model.bean.AdClubEditBean;
import campusbbs.model.bean.AdReplyBean;
import campusbbs.model.bean.AdUserBean;
import campusbbs.model.bean.ClubListBean;
import campusbbs.model.bean.LastPostBean;
import campusbbs.model.bean.UserInfoBean;
import campusbbs.model.factory.BeanFactory;
import campusbbs.model.service.AdminPageService;
import campusbbs.model.vo.ClubType;
import campusbbs.model.vo.Post;
import campusbbs.model.vo.PostType;
import campusbbs.model.vo.SystemAdmin;

/**
 * Servlet implementation class AdPageServlet
 */
@WebServlet("/AdPageServlet")
public class AdPageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private AdminPageService adminPageService=BeanFactory.getServiceInstance("adminPageService", AdminPageService.class);
//	private UserService userService=BeanFactory.getServiceInstance("userService", UserService.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String page=request.getParameter("page");
		
		HttpSession session=request.getSession();
		SystemAdmin adminUser=(SystemAdmin)session.getAttribute("adminUser");
		if(adminUser==null){
			response.sendRedirect(request.getContextPath()+"/sys/public/right.jsp");
			return;
		}
		
		if(page==null||page.trim().isEmpty()){
			
			response.sendError(404);
			return;
			
		}else if(page.equals("table")){
			
			showTablePage(request, response);
						
		}else if(page.equals("user")){
			
			showAdUserPage(request, response);
			
		}else if(page.equals("club")){
			
			showAdClubPage(request, response);
			
		}else if(page.equals("post")){
			
			showAdPostPage(request, response);
			
		}else if(page.equals("reply")){
			
			showAdReplyPage(request, response);
			
		}else if(page.equals("clubTypeEdit")){
			
			showClubTypeEdit(request,response);
			
		}else if(page.equals("postTypeEdit")){
			
			showPostTypeEdit(request,response);
			
		}else if(page.equals("adEditClub")){
			
			showEditClubPage(request, response);
			
		}else if(page.equals("editUser")){
			
			showEditUserPage(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void showAdClubPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ClubListBean clubListBean=adminPageService.getAdClubBean();
		request.setAttribute("clubListBean", clubListBean);

		request.getRequestDispatcher("/sys/adClub.jsp").forward(request, response);
		
	}

	
	private void showAdPostPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String pageCodeStr=request.getParameter("pageCode");
		int pageCode=1;
		System.out.println("****************************** "+pageCodeStr);
		try {
			pageCode=Integer.parseInt(pageCodeStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("****************************** "+pageCodeStr);
//			e.printStackTrace();
		}
		int size=12;
		LastPostBean<Post> lastPostBean = adminPageService.getAdPostBean(pageCode, size);
		
		request.setAttribute("lastPostBean", lastPostBean);
		
		request.getRequestDispatcher("/sys/adPost.jsp").forward(request, response);
	}
	
	private void showAdReplyPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String postIdStr=request.getParameter("postId");
		String pageNumStr=request.getParameter("pageCode");
		int pageCode=1;
		try {
			pageCode=Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		}	
		
		int size=5;
		AdReplyBean adReplyBean=adminPageService.getAdReplyBean(
														Integer.parseInt(postIdStr), 
														pageCode, 
														size);
		
		System.out.println("showAdReplyPage\t"+adReplyBean.toString());
		request.setAttribute("adReplyBean", adReplyBean);		
		request.getRequestDispatcher("/sys/adReply.jsp").forward(request, response);
		
	}
	
	private void showAdUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pageNumStr=request.getParameter("pageCode");
		int pageCode=1;
		int size=10;
		try {
			pageCode=Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		}	
		
		AdUserBean adUserBean=adminPageService.getAdUserBean(pageCode, size);
		request.setAttribute("adUserBean", adUserBean);

		request.getRequestDispatcher("/sys/adUser.jsp").forward(request, response);
	}
	
	
	private void showTablePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String table=request.getParameter("table");
		String pageNumStr=request.getParameter("pageCode");
		int pageCode=1;
		int size=10;
		try {
			pageCode=Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		}	
		
		Object listBean=null;

		System.out.println("table:"+table);
		if(table==null||table.trim().isEmpty()||table.equals("bbs_user")){
			
			listBean=adminPageService.getUserTable(pageCode, size);
			
		}else if(table.equals("user_info")){

			listBean=adminPageService.getUserInfoTable(pageCode, size);
			
		}else if(table.equals("mail_server")){
			
			listBean=adminPageService.getEmailServerTable();
			
		}else if(table.equals("club")){
			
			listBean=adminPageService.getClubTable();
			
		}else if(table.equals("club_type")){
			
			listBean=adminPageService.getClubTypeTable();
			
		}else if(table.equals("club_admin")){
			
			listBean=adminPageService.getClubAdminTable(pageCode, size);
			
		}else if(table.equals("post")){
			
			listBean=adminPageService.getPostTable(pageCode, size);
			
		}else if(table.equals("post_type")){
			
			listBean=adminPageService.getPostTypeTable();
			
		}else if(table.equals("reply")){
			
			listBean=adminPageService.getReplyTable(pageCode, size);
			
		}

		request.setAttribute("listBean", listBean);
		
		request.getRequestDispatcher("/sys/dataTable.jsp").forward(request, response);

	}
	
	//编辑版块类型页面
	private void showClubTypeEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String typeIdStr=request.getParameter("typeId");
			int clubId=Integer.parseInt(typeIdStr);
			ClubType clubType=adminPageService.getClubTypeBean(clubId);
			request.setAttribute("clubType", clubType);
			request.getRequestDispatcher("/sys/clubTypeEdit.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("/sys/adClub.jsp").forward(request, response);
		}		

	}
	
	//编辑版块类型页面
	private void showPostTypeEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String typeIdStr=request.getParameter("typeId");
			int postId=Integer.parseInt(typeIdStr);
			PostType postType=adminPageService.getPostTypeBean(postId);
			request.setAttribute("postType", postType);
			request.getRequestDispatcher("/sys/postTypeEdit.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			showAdPostPage(request, response);
		}		

	}
	
	//编辑版块页面
	private void showEditClubPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String clubName=(String)request.getAttribute("update");
		if(clubName==null){
			clubName=request.getParameter("clubName");
			if(clubName!=null&&!clubName.trim().isEmpty()){
				clubName=new String(clubName.getBytes("ISO8859-1"),"utf-8");
				System.out.println(">>> "+clubName);
			}
		}
		
		AdClubEditBean adClubEditBean=adminPageService.getAdClubEditBean(clubName);

//		System.out.println(adClubEditBean.getClub().toString());
//		System.out.println(adClubEditBean.toString());
		
		request.setAttribute("adClubEditBean", adClubEditBean);
		
		request.getRequestDispatcher("/sys/adEditClub.jsp").forward(request, response);

	}
	
	//管理用户的页面
	private void showEditUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName=request.getParameter("userName");
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
		
		UserInfoBean userInfoBean=new UserInfoBean();
		userInfoBean=adminPageService.getUserInfoBean(userName,postPageCode,postSize,replyPageCode,replySize);
		
		System.out.println(userInfoBean.toString());
		System.out.println(userInfoBean.getReplyListBean().toString());
		
		request.setAttribute("userInfoBean", userInfoBean);

		request.getRequestDispatcher("/sys/adEditUser.jsp").forward(request, response);
		
	}

}





































