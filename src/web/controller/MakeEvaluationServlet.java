package web.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import domain.Evaluation;
import domain.Info;
import domain.Student;
import service.EvaluationService;
import service.InfoService;
import service.impl.EvaluationServiceImpl;
import service.impl.InfoServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class MakeEvaluationServlet
 */
@WebServlet("/MakeEvaluationServlet")
public class MakeEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeEvaluationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		InfoService service2 = new InfoServiceImpl();
		String key = request.getParameter("tch_name");
		Info info = ((HashMap<String, Info>)request.getSession().getAttribute("infos")).get(key);
		info.setEva_state("已评价");
		service2.update(info);
		String eva = request.getParameter("evaluation");
		Evaluation e = new Evaluation();
		e.setId(WebUtils.makeId());
		e.setSubject(request.getParameter("subject"));
		e.setStu_name(((Student)request.getSession().getAttribute("user")).getName());
		e.setTch_id(request.getParameter("tch_id"));
		e.setDescription(eva);
		try {
			EvaluationService service = new EvaluationServiceImpl();
			service.add(e);
		} catch (Exception e1) {
			e1.printStackTrace();
			request.setAttribute("message", "评价失败");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		request.setAttribute("message", "评价成功");
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
