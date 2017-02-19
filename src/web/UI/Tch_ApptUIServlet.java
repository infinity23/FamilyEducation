package web.UI;

import java.io.IOException;
import java.util.HashMap;

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

/**
 * Servlet implementation class Tch_ApptUIServlet
 */
@WebServlet("/Tch_ApptUIServlet")
public class Tch_ApptUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tch_ApptUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		InfoService service = new InfoServiceImpl();
		HashMap<String, Info> map = service.findByTchID(teacher.getId());	
		request.getSession().setAttribute("infos", map);
		request.getRequestDispatcher("/WEB-INF/jsp/tch_appt.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
