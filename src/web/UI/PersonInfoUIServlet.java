package web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonInfoUIServlet
 */
@WebServlet("/PersonInfoUIServlet")
public class PersonInfoUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonInfoUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String entrance = (String) request.getSession().getAttribute("entrance");
		request.setCharacterEncoding("UTF-8");
		if(entrance.equals("teacher")){
			request.getRequestDispatcher("/WEB-INF/jsp/tch_info.jsp").forward(request, response);
		}else if(entrance.equals("student")){
			request.getRequestDispatcher("/WEB-INF/jsp/stu_info.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/jsp/admin_info.jsp").forward(request, response);
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
