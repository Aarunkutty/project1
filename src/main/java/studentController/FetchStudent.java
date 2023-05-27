package studentController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDataAccessObject.StudentDAO;

@WebServlet("/fetchone")
public class FetchStudent extends HttpServlet //GenericServlet 
{
	
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		try {
//			String sid = req.getParameter("sid");
//			int sid1 = Integer.parseInt(sid);
//			
//			StudentDAO dao = new StudentDAO();
//			String arr = dao.fetch(sid1);
//
//			res.getWriter().print("<head><title>Student List</title>\r\n"
//							+ "<link rel=\"stylesheet\" href = \"css/table.css\">" + 
//							"</head><form><table> " + arr
//							+ "</table></form>");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		try {
			String sid = req.getParameter("sid");
			int sid1 = Integer.parseInt(sid);
			
			StudentDAO dao = new StudentDAO();
			String arr = dao.fetch(sid1);
			resp.getWriter().print("<head><title>Student List</title>\r\n"
							+ "<link rel=\"stylesheet\" href = \"css/table.css\">" + 
							"</head><form><table> " + arr
							+ "</table></form>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
