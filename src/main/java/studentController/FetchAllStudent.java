package studentController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import studentDataAccessObject.StudentDAO;
import studentDataTransferObject.StudentDTO;

@WebServlet("/fetchall")
public class FetchAllStudent extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			StudentDAO dao =   new StudentDAO();
			
			String arr = dao.fetchAll();
			res.getWriter().print("<head><title>Student List</title>\r\n"
					+ "<link rel=\"stylesheet\" href = \"css/table.css\">"
					+ "</head><form><table> "
					+arr+"</table></form>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
}
