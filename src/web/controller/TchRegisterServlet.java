package web.controller;

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
import utils.WebUtils;


@WebServlet("/TchRegisterServlet")
public class TchRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public TchRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			Teacher teacher = WebUtils.request2Bean(request, Teacher.class);
			teacher.setId(WebUtils.makeId());
			UserService service = new UserServiceImpl(); 
			service.addUser(teacher);
			request.setAttribute("message", "注册成功");
			request.getSession().setAttribute("user", teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "注册失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
