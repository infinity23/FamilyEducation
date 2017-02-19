package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Teacher;
import exception.WrongUserType;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class TchModifyServlet
 */
@WebServlet("/TchModifyServlet")
public class TchModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TchModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Teacher teacher = WebUtils.request2Bean(request, Teacher.class);
		teacher.setId(((Teacher)request.getSession().getAttribute("user")).getId());
		UserService service = new UserServiceImpl();
		try {
			service.updateUser(teacher);
		} catch (WrongUserType e) {
			request.setAttribute("message", "修改失败,用户名已存在");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.getSession().setAttribute("user", teacher);
		request.setAttribute("message", "修改成功");
		
		Object admin_user = request.getSession().getAttribute("admin_user");
		if(admin_user!=null)
			request.getSession().setAttribute("user", admin_user);
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
