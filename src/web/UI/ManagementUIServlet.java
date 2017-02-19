package web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import domain.Teacher;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class ManagementUIServlet
 */
@WebServlet("/ManagementUIServlet")
public class ManagementUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stu_name = request.getParameter("stu_name");
		String tch_name = request.getParameter("tch_name");
		UserService service = new UserServiceImpl();
		if(stu_name!="" && tch_name!="")
		{
			request.setAttribute("message", "请勿同时输入");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
			
		}else if (stu_name != "") {	
			Student student = new Student();
			student.setName(stu_name);
			student = service.findUser(student);
			if(student==null){
				request.setAttribute("message", "无此学员");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			request.getSession().setAttribute("admin_user", request.getSession().getAttribute("user"));
			request.getSession().setAttribute("user", student);
			request.getRequestDispatcher("/WEB-INF/jsp/stu_info.jsp").forward(request, response);
		}else {
			Teacher teacher = new Teacher();
			teacher.setName(tch_name);
			teacher = service.findUser(teacher);
			if(teacher==null){
				request.setAttribute("message", "无此教员");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			request.getSession().setAttribute("admin_user", request.getSession().getAttribute("user"));
			request.getSession().setAttribute("user", teacher);
			request.getRequestDispatcher("/WEB-INF/jsp/tch_info.jsp").forward(request, response);
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
