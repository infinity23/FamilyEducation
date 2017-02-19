package web.UI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.Evaluation;
import domain.Student;
import service.EvaluationService;
import service.UserService;
import service.impl.EvaluationServiceImpl;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class EvaluationUIServlet
 */
@WebServlet("/EvaluationUIServlet")
public class EvaluationUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvaluationUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EvaluationService service = new EvaluationServiceImpl();
		HashMap<String, Evaluation> map = service.findAll(request.getParameter("tch_id"));
		request.setAttribute("evaluations", map);
		request.getRequestDispatcher("/WEB-INF/jsp/showevaluations.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
