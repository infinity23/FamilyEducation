package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Admin;
import domain.Student;
import domain.Teacher;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String entrance = (String) request.getSession().getAttribute("entrance");
		if(entrance.equals("student")){
			Student student = new Student();
			student.setName(request.getParameter("name"));
			student.setPasswd(request.getParameter("passwd"));
			UserService service = new UserServiceImpl();
			Student target = service.findUser(student);
			if(target==null){
				request.setAttribute("message", "用户不存在");
			}else if(!(target.getPasswd().equals(student.getPasswd()))){
				request.setAttribute("message", "密码错误");
			}else{
				request.getSession().setAttribute("user", target);
				request.setAttribute("message", "登录成功");
			}
		}else if(entrance.equals("teacher")){
			Teacher teacher = new Teacher();
			teacher.setName(request.getParameter("name"));
			teacher.setPasswd(request.getParameter("passwd"));
			UserService service = new UserServiceImpl();
			Teacher target = service.findUser(teacher);
			if(target==null){
				request.setAttribute("message", "用户不存在");
			}else if(!target.getPasswd().equals(teacher.getPasswd())){
				request.setAttribute("message", "密码错误");
			}else{
				request.getSession().setAttribute("user", target);
				request.setAttribute("message", "登录成功");
			}
		}else{
			Admin admin = new Admin();
			admin.setName(request.getParameter("name"));
			admin.setPasswd(request.getParameter("passwd"));
			UserService service = new UserServiceImpl();
			Admin target = service.findUser(admin);
			if(target==null){
				request.setAttribute("message", "用户不存在");
			}else if(!target.getPasswd().equals(admin.getPasswd())){
				request.setAttribute("message", "密码错误");
			}else{
				request.getSession().setAttribute("user", target);
				request.setAttribute("message", "登录成功");
			}
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
