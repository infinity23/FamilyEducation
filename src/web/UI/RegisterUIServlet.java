package web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/RegisterUIServlet")
public class RegisterUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("entrance")==null){
			request.setAttribute("message", "请先选择对应版本");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		String string = (String) request.getSession().getAttribute("entrance");
		
		if(string.equals("teacher")){
			request.getRequestDispatcher("/WEB-INF/jsp/tch_register.jsp").forward(request, response);
		}else if(string.equals("student")){
		request.getRequestDispatcher("/WEB-INF/jsp/stu_register.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/jsp/admin_register.jsp").forward(request, response);
		}
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
