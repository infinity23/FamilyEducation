package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Info;
import domain.Student;
import domain.Teacher;
import service.InfoService;
import service.impl.InfoServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class MakeApptServlet
 */
@WebServlet("/MakeApptServlet")
public class MakeApptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeApptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			Student student = (Student) request.getSession().getAttribute("user");
			Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
			InfoService service = new InfoServiceImpl();
			Info info = new Info();
			info.setId(WebUtils.makeId());
			info.setTitle(request.getParameter("title"));
			info.setSubject(teacher.getSubject());
			info.setDescription(request.getParameter("description"));
			info.setStu_id(student.getId());
			info.setTch_id(teacher.getId());
			info.setState("未完成");
			info.setEva_state("未评价");
			service.add(info);
		} catch (Exception e) {
			request.setAttribute("message", "预约失败");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.setAttribute("message", "预约成功");
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
