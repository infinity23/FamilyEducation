package web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EntranceUIServlet
 */
@WebServlet("/EntranceUIServlet")
public class EntranceUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntranceUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = (String) request.getParameter("choose");
		request.setCharacterEncoding("UTF-8");
		if(string.equals("teacher")){
			request.getSession().setAttribute("entrance", "teacher");
			request.getSession().setAttribute("show_entrance", "教师版");
		}else if(string.equals("student")){
			request.getSession().setAttribute("entrance", "student");
			request.getSession().setAttribute("show_entrance", "学生版");
		}else{
			request.getSession().setAttribute("entrance", "admin");
			request.getSession().setAttribute("show_entrance", "管理员版");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
