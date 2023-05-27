package studentController;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import studentDataAccessObject.StudentDAO;
import studentDataTransferObject.StudentDTO;

@WebServlet("/insert")
public class StudentInsert extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String sid = req.getParameter("sid");
		int sid1 = Integer.parseInt(sid);
		//System.out.println(sid);
		String sName = req.getParameter("sname");
		String gender = req.getParameter("gender");
		String semail = req.getParameter("semail");
		String sphone = req.getParameter("sphone");
		long phone = Long.parseLong(sphone);

		
		StudentDTO dto = new StudentDTO();
		dto.setsID(sid1);
		dto.setStudentName(sName);
		dto.setGender(gender);
		dto.setEmail(semail);
		dto.setPhone(phone);
		
		StudentDAO dao = new StudentDAO();
		dao.insert(dto);
		
		res.getWriter().print("<h2> Created <br> Welcome!</h2><br>"
				+ "\r\n"
				+ "	<a href=\"index.jsp\"><button id=\"butt2\">Home Page</button></a>"
				+"\r\n"
				+ "		<a href=\"create.html\"><button>Back To CreatePage</button></a>");
	}

	
	
}
