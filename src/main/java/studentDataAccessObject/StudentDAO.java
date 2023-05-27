package studentDataAccessObject;

import java.sql.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentDataTransferObject.StudentDTO;

public class StudentDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void insert(StudentDTO dto) {
		entityTransaction.begin();
		entityManager.persist(dto);
		entityTransaction.commit();
	}
	
	public String delete(int x) {
		StudentDTO dto = entityManager.find(StudentDTO.class, x);
		if (dto != null) {
			entityTransaction.begin();
			entityManager.remove(dto);
			entityTransaction.commit();
			return "Data Removed";
		} else {
			return "No Record Present at the primary key";
		}
	}
	
	public void update(int id , long phone) {
		
		StudentDTO dto2 =entityManager.find(StudentDTO.class, id);
		dto2.setPhone(phone);
//		if (dto2  != null) {
			entityTransaction.begin();
			entityManager.persist(dto2);
			entityTransaction.commit();
//			return "Data Updated";
//		} else {
//			return "No Record Present at the primary key";
//		}
//		
	}
	
	public String fetchAll() throws SQLException {

		Query query =  entityManager.createQuery("select createTable from StudentDTO createTable ",StudentDTO.class);
		
		List<StudentDTO> listoftab = query.getResultList();
		
		String arr = new String();

		for (StudentDTO x : listoftab) {
			arr += "<tr>\r\n"
					+ "<td>"+x.getsID()+"</td>\r\n"
					+ "<td>"+x.getStudentName()+"</td>\r\n"
					+ "<td>"+x.getGender()+"</td>\r\n"
					+ "<td>"+x.getEmail()+"</td>\r\n"
					+ "<td>"+x.getPhone()+"</td>\r\n"
					+ "	</tr>";}
		return arr;
	}
	public String fetch(int i) throws SQLException {
		
		StudentDTO dto = entityManager.find(StudentDTO.class, i);
		
		String arr = "<tr>\r\n"
				+ "<td>"+dto.getsID()+"</td>\r\n"
				+ "<td>"+dto.getStudentName()+"</td>\r\n"
				+ "<td>"+dto.getGender()+"</td>\r\n"
				+ "<td>"+dto.getEmail()+"</td>\r\n"
				+ "<td>"+dto.getPhone()+"</td>\r\n"
				+ "	</tr>";;

		return arr;
	}

	public List<StudentDTO> fetchEvery() {
		Query query = entityManager.createQuery("select students from StudentDTO students ");
		List<StudentDTO> list = query.getResultList();
		return list;
	}

	public void update(StudentDTO dto) {
		// TODO Auto-generated method stub

		entityTransaction.begin();
		entityManager.merge(dto);
		entityTransaction.commit();
	}
}
