package studentController;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import studentDataAccessObject.StudentDAO;
import studentDataTransferObject.StudentDTO;

@WebServlet("/update")
public class StudentUpdate extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String sid = req.getParameter("sid");
		int sid1 = Integer.parseInt(sid);
		String sname = req.getParameter("sname");
		String gender = req.getParameter("gender");
		String semail = req.getParameter("semail");
		String sphone = req.getParameter("sphone");
		long phone = Long.parseLong(sphone);

		StudentDTO dto = new StudentDTO();

		dto.setsID(sid1);
		if (sname != null) {
			dto.setStudentName(sname);
		}

		dto.setGender(gender);

		if (semail != null) {
			dto.setEmail(semail);
		}
		if (sphone != null) {
			dto.setPhone(phone);
		}

		StudentDAO dao = new StudentDAO();
		dao.update(sid1,phone);

		res.getWriter()
				.print("<h2> Updated </h2><br>" + "\r\n"
						+ "	<a href=\"index.jsp\"><button id=\"butt2\">Home Page</button></a>"
						+ "		<a href=\"update.html\"><button>Back To UpdatePage</button></a>");

	}

}
