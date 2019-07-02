package edu.mum.cs544;

public class StudentServiceWithClose {
	private StudentDAO studentdao;

	public StudentServiceWithClose() {
		studentdao = new JPAStudentDAOWithClose();
	}

	public Student getStudent(long studentid) {
		EntityManagerHelper.getCurrent().getTransaction().begin();
		Student tmp = studentdao.load(studentid);
		EntityManagerHelper.getCurrent().getTransaction().commit();
		EntityManagerHelper.getCurrent().close();
		return tmp;
	}
}
