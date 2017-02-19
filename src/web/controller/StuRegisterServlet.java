package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;


@WebServlet("/StuRegisterServlet")
public class StuRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public StuRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			Student student = WebUtils.request2Bean(request, Student.class);
			student.setId(WebUtils.makeId());
			UserService service = new UserServiceImpl(); 
			service.addUser(student);
			request.setAttribute("message", "注册成功");
			request.getSession().setAttribute("user", student);

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
