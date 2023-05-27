package studentController;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDataAccessObject.StudentDAO;
import studentDataTransferObject.StudentDTO;

@WebServlet("/delete")
public class StudentDelete extends HttpServlet {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	super.doGet(req, resp);

		String sid = req.getParameter("sid");
		int sid1 = Integer.parseInt(sid);

		StudentDAO dao = new StudentDAO();
		dao.delete(sid1);
		

		List<StudentDTO> t = dao.fetchEvery();
		req.setAttribute("studentlist", t);
		

		resp.getWriter().print("<h1>Deleted succesfully</h1>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("download.jsp");
		dispatcher.include(req, resp);

	}

}
