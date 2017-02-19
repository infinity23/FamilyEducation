package web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.wsdl.writer.document.Service;

import domain.Teacher;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class MakeInfoUIServlet
 */
@WebServlet("/MakeInfoUIServlet")
public class MakeInfoUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeInfoUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		Teacher teacher = new Teacher();
		teacher.setName(request.getParameter("tch_name"));
		teacher = service.findUser(teacher);
		request.getSession().setAttribute("teacher", teacher);
		request.getRequestDispatcher("/WEB-INF/jsp/info.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
