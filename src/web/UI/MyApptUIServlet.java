package web.UI;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.EvaluationDaoImpl;
import domain.Evaluation;
import domain.Info;
import domain.Student;
import domain.Teacher;
import service.EvaluationService;
import service.InfoService;
import service.UserService;
import service.impl.EvaluationServiceImpl;
import service.impl.InfoServiceImpl;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class MyApptUIServlet
 */
@WebServlet("/MyApptUIServlet")
public class MyApptUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyApptUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Student student = (Student) request.getSession().getAttribute("user");
		InfoService service = new InfoServiceImpl();
		
		HashMap<String, Info> map = service.findByStuID(student.getId());	
		request.getSession().setAttribute("infos", map);
		request.getRequestDispatcher("/WEB-INF/jsp/myappt.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
