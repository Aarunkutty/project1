package studentController;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import studentDataAccessObject.StudentDAO;

@WebServlet("/remove")
public class StudentRemove extends GenericServlet {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String sid = req.getParameter("sid");
		int sid1 = Integer.parseInt(sid);
		

		StudentDAO dao = new StudentDAO();
		dao.delete(sid1);
		

		res.getWriter().print("<h2> Removed </h2><br>"
				+ "\r\n"
				+ "	<a href=\"index.jsp\"><button id=\"butt2\">Home Page</button></a>");
	
	}
	
	
}
