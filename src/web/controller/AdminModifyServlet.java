package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Admin;
import domain.Teacher;
import exception.WrongUserType;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class AdminModifyServlet
 */
@WebServlet("/AdminModifyServlet")
public class AdminModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = WebUtils.request2Bean(request, Admin.class);
		admin.setId(((Admin)request.getSession().getAttribute("user")).getId());
		UserService service = new UserServiceImpl();
		try {
			service.updateUser(admin);
		} catch (WrongUserType e) {
			e.printStackTrace();
			request.setAttribute("message", "修改失败,用户名已存在");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		}
		request.setAttribute("message", "修改成功");
		request.getSession().setAttribute("user", admin);
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
