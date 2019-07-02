package edu.mum.cs544;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new JPAStudentDAO();
	}

	public Student getStudent(long studentid) {
		EntityManagerHelper.getCurrent().getTransaction().begin();
		Student tmp = studentdao.load(studentid);
		EntityManagerHelper.getCurrent().getTransaction().commit();
		return tmp;
	}
}
