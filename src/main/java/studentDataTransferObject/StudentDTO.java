package studentDataTransferObject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDTO {
	@Id
	private int sID;
	private String studentName;
	private String email;
	private long phone;
	private String gender;

	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "StudentDTO [sID=" + sID + ", studentName=" + studentName + ", email=" + email + ", phone=" + phone
				+ ", gender=" + gender + "]";
	}
	
}