package studentController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDataAccessObject.StudentDAO;
import studentDataTransferObject.StudentDTO;

@WebServlet("/updated")
public class UpdatesStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);

		String sid = req.getParameter("id");
		int sid1 = Integer.parseInt(sid);
		String sname = req.getParameter("sname");
		String gender = req.getParameter("gender");
		String semail = req.getParameter("semail");
		String sphone = req.getParameter("sphone");
		long phone = Long.parseLong(sphone);

		StudentDTO dto = new StudentDTO();

		dto.setsID(sid1);
		dto.setStudentName(sname);
		dto.setGender(gender);
		dto.setEmail(semail);
		dto.setPhone(phone);

		StudentDAO dao = new StudentDAO();
		dao.update(dto);
		List<StudentDTO> t = dao.fetchEvery();
		req.setAttribute("studentlist", t);
		
		resp.getWriter().print("<h1>Updated succesfully</h1>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("download.jsp");
		dispatcher.include(req, resp);
	}
}
