package com.ty.crud;

public class StudentCrudDriver {
	public static void main(String[] args) {
//		StudentCrud sc = new StudentCrud();
//		sc.deleteStudent(8);
//		sc.printAllStudent();
//		sc.printStudentById(4);
//		sc.updateStudent(5, "Nuthan", "Nut@mail.com");
		
		StudentDynamic sc = new StudentDynamic();
//		sc.saveStudent(12, "sandeep", "san@mail.com");
//		sc.deleteStudent(12);
//		sc.updateStudentName(9, "sandep");
//		sc.updateStudent(9, "sandeep", "sand@mail.com");
//		sc.printStudentById(9);
		sc.printAllStudent();
	}
}
