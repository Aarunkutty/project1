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

@WebServlet("/fetchallsd")
public class StudentFetchAll extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//super.doGet(req, resp);
		
		StudentDAO dao = new StudentDAO();
		List<StudentDTO> dtos=dao.fetchEvery();
		
		req.setAttribute("studentlist", dtos);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("download.jsp");
		dispatcher.forward(req, resp);
		 
//		for (StudentDTO studentDTO : dtos) {
//			
//		}
	}
	
}


