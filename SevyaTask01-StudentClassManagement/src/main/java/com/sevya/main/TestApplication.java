package com.sevya.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sevya.entity.Standard;
import com.sevya.entity.Exam;
import com.sevya.entity.Student;
import com.sevya.entity.StudentExamMapper;
import com.sevya.entity.StudentSubjectMapper;
import com.sevya.entity.Subject;

public class TestApplication {
	
	public static void main(String[] args) {
		
		System.out.println("APPLICATION STARTED...");
		SessionFactory factory = new Configuration().configure("com/sevya/cfgs/hibernate.cfg.xml").buildSessionFactory();		
		Session session = factory.openSession();
	
	//	Student student = new Student("Arjun", 16, "M", "good");
	//	student.setStandard(session.get(Standard.class, 9));
		
	//	saveStudent(session, student);
	
	//	deleteStudentById(session, 43);
		
	//	displayAllStudents(session);
		
	//	displayStudentSubjectDetails(session);
		
	//	displayStudentExamDetails(session);
		
		
		removeStudentEnrollmentFromExamination(session, List.of(29,43,40));
		
		factory.close();
	}
	
	
	
	//methods for saving details 

	public static String saveClassAndStudentsDetails(Session session) {
		Transaction transaction =session.beginTransaction();
		//standard details 
		Standard standard1 = new Standard("Ninth", "9"); Standard standard2 = new Standard("Tenth", "10");
		//student details
		Student student1=new Student("Arindam Podder", 14, "M", "good"); Student student2=new Student("Nikita Das", 14, "F", "good");
		Student student3=new Student("Kanchan pal", 14, "M", "good"); Student student4=new Student("Malini Sen", 15, "F", "good");
		Student student5=new Student("Koyel Mallik", 14, "F", "good"); Student student6=new Student("nil Das", 14, "M", "good");
		Student student7=new Student("Raqesh Bapat", 15, "M", "good"); Student student8=new Student("Amir Khan", 16, "M", "good");
		Student student9=new Student("Kanchan Deshmukh", 16, "M", "good"); Student student10=new Student("Priyanka Chopra", 16, "F", "good");
		Student student11=new Student("Susmita Sen", 15, "F", "good"); Student student12=new Student("Nibedita Podder", 16, "F", "good");
		 
	
		//add student to the class
		standard1.setStudents(List.of(student1,student2,student3,student4,student5,student6));
		standard2.setStudents(List.of(student7,student8,student9,student10,student11,student12));
		
		//save class and its associated student will save automatically 
		session.save(standard1);	session.save(standard2);
		
		transaction.commit();
		return "standard and students details are saved.";
	}
	
	public static void saveStudent(Session session, Student student) {
		Transaction transaction = session.beginTransaction();
		Integer studenId = (Integer) session.save(student);
		transaction.commit();
		System.out.println(student.getName()+" saved with the id = "+studenId);
	}
	
	public static String saveSubjectDetails(Session session) {
		Transaction transaction = session.beginTransaction();
		//subject details
		Subject subject1 = new Subject("Mathematics", "math");	Subject subject2 = new Subject("Chemistry", "chemistry");
		Subject subject3 = new Subject("Physics", "physics");
		//save subjects
		session.save(subject1); session.save(subject2); session.save(subject3);
		transaction.commit();
		return "subjects details are saved.";
	}
	
	public static String saveExamDetails(Session session) {
		Transaction transaction = session.beginTransaction();
		//exam details
		Exam exam1 = new Exam("Quaterly", "quaterly"); Exam exam2 = new Exam("Half Yearly", "half-yearly");
		Exam exam3 = new Exam("Annual", "annual");
		//save exams
		session.save(exam1); session.save(exam2); session.save(exam3);
		transaction.commit();
		return "exams details are saved.";
	}
	
	

	
	
	//methods for displaying or retrieving 
	
	public static void displayStandardAndItsAllActiveStudents(Session session) {
		String hqlQuery = "select distinct standard from Standard standard left join fetch standard.students as students where students.isActive=1";
		//String hqlQuery = "from Standard standard w";
		Query<Standard> query =session.createQuery(hqlQuery, Standard.class);
		query.getResultList().forEach(standard -> {
								System.out.println("class : "+standard.getName());
								System.out.println("All active students are : ");
								standard.getStudents().forEach(student -> {
															//if(st.isActive())
																System.out.println(student.getName()+" "+student.getAge()+" "+student.getGender()+" status="+student.isActive());
															});			
								});
	}
	
	public static void displayAllStudents(Session session) {
		System.out.println("ALL STUDENT DETAILS : ");
		String queryForAllStudent = "from Student s where s.isActive=true order by s.name"; 
		Query<Student> query =session.createQuery(queryForAllStudent, Student.class);
		query.getResultList().forEach(  student -> 
				System.out.println("id="+student.getId()+", name="+student.getName()+", age="+student.getAge()+", gender="
						+student.getGender()+", feedback="+student.getFeedback()+", class="+student.getStandard().getName()+"\n" )
				);	
	}
	
	public static void displaySingleStudent(Session session , Integer id) {
		Student student = session.get(Student.class, id);
		if(student == null) {
			System.out.println("student not avilable.\ngive proper id to see student details");
		}
		else {
			System.out.println("name="+student.getName()+", age="+student.getAge()+", gender="+student.getGender()+", feedback="+student.getFeedback()+", class="+student.getStandard().getName());
		}		
	}
	
	public static void displaySubjectDetails(Session session) {
		System.out.println("SUBJECT DETAILS : ");
		String hqlQuery = "from Subject";
		Query<Subject> query =session.createQuery(hqlQuery, Subject.class);
		query.getResultList().forEach( subject -> System.out.println("ID="+subject.getId()+", Name="+subject.getName()+", Code="+subject.getCode()) );
	}	
	
	public static void displayExamDetails(Session session) {
		System.out.println("Exam DETAILS : ");
		String hqlQuery = "from Exam";
		Query<Exam> query =session.createQuery(hqlQuery, Exam.class);
		query.getResultList().forEach( exam -> System.out.println("ID="+exam.getId()+", Name="+exam.getName()+", Code="+exam.getCode()) );
	}	
	
	
	
	
	
	//methods for update 
	
	public static String updateStudentFeedback(Session session, Integer id, String feedback) {
		Student st = session.get(Student.class, id);
		if(st==null) {
			return "Student with that id is not available for update.";
		}
		else {
			Transaction transaction = session.beginTransaction();
			st.setFeedback(feedback);
			session.update(st);
			transaction.commit();
			return "update successful.";
		}
	}
	
	
	
	
	
	
	//method for delete 
	
	public static void deleteStudentById(Session session, Integer id) {
		Student student = session.get(Student.class, id);
		if(student==null) {
			System.out.println("student not available.");
		}
		else {
			Transaction transaction = session.beginTransaction();
			student.setActive(false);
			session.update(student);
			transaction.commit();
			System.out.println("student deleted successfully.");
		}
	}
	
	
	
	
	
	//student-subject mapper deatails 
	
	public static void saveStudentSubjectMappingDetails(Session session) {
		Transaction transaction = session.beginTransaction();
		StudentSubjectMapper studentSubjectMapper1 = new StudentSubjectMapper(session.get(Student.class, 40), session.get(Subject.class, 1));
		StudentSubjectMapper studentSubjectMapper2 = new StudentSubjectMapper(session.get(Student.class, 40), session.get(Subject.class, 2));
		StudentSubjectMapper studentSubjectMapper3 = new StudentSubjectMapper(session.get(Student.class, 40), session.get(Subject.class, 2));
		session.save(studentSubjectMapper1);
		session.save(studentSubjectMapper2);
		session.save(studentSubjectMapper3);
		transaction.commit();
		System.out.println("student-subject mapper deatails saved successfully.");
	}
	
	public static void displayStudentSubjectDetails(Session session) {
		String hqlQuery = "from StudentSubjectMapper";
		Query<StudentSubjectMapper> query = session.createQuery(hqlQuery, StudentSubjectMapper.class);
		System.out.println("All the Students along with associated Subjects");
		List<StudentSubjectMapper> ssm = query.getResultList();
		Map<Student, List<StudentSubjectMapper>> collect = ssm.stream().collect(Collectors.groupingBy(mapper -> mapper.getStudent()));
		collect.entrySet().forEach(entry -> {
					System.out.println(entry.getKey().getName());
					entry.getValue().forEach(mapper -> System.out.println(mapper.getSubject().getName() ));
					System.out.println();
				});
	}
	
	
	
	
	
	//student-exam mapper deatails
	public static void saveStudentExamMappingDetails(Session session) {
		Transaction transaction = session.beginTransaction();
		StudentExamMapper studentExamMapper1 = new StudentExamMapper(session.get(Student.class, 40), session.get(Exam.class, 1));
		StudentExamMapper studentExamMapper2 = new StudentExamMapper(session.get(Student.class, 40), session.get(Exam.class, 2));
		StudentExamMapper studentExamMapper3 = new StudentExamMapper(session.get(Student.class, 40), session.get(Exam.class, 3));
		session.save(studentExamMapper1);	session.save(studentExamMapper2);	session.save(studentExamMapper3);
		transaction.commit();
		System.out.println("student-exam mapper deatails saved successfully.");
	}
	
	public static void displayStudentExamDetails(Session session) {
		String hqlQuery = "from StudentExamMapper";
		Query<StudentExamMapper> query = session.createQuery(hqlQuery, StudentExamMapper.class);
		System.out.println("All the Students along with enrolled examination");
		List<StudentExamMapper> resultList = query.getResultList();
		Map<Student, List<StudentExamMapper>> collect = resultList.stream().collect(Collectors.groupingBy(studentExamMapper -> studentExamMapper.getStudent() ));
		collect.entrySet().forEach(entry -> {
			System.out.println(entry.getKey().getName());
			entry.getValue().forEach(mapper -> System.out.println(mapper.getExam().getName()) );
			System.out.println();
		});
	}
	
	public static void removeStudentEnrollmentFromExamination(Session session,List<Integer> ids) {
		//get all student whose feedback is bad
		List<Student> badStudents = new ArrayList<Student>();
		String hqlQuery1 = "from Student where id=:sid and feedback=:feedback";
		Query<Student> query1 = session.createQuery(hqlQuery1, Student.class);
		ids.forEach(id-> {
			query1.setParameter("sid", id);
			query1.setParameter("feedback", "bad");
			Student student = query1.uniqueResult();
			if(student!=null)
				badStudents.add(student);
		});		
		String hqlQuery2 = "update StudentExamMapper set isActive=false where student=:student";
		Query query2 =session.createQuery(hqlQuery2);
		List<String> displayList = new ArrayList<String>();
		if(badStudents.size()>0) {
			badStudents.forEach(student ->{
				Transaction transaction =session.beginTransaction(); 
				query2.setParameter("student", student);
				int number = query2.executeUpdate();
				transaction.commit();
				displayList.add(student.getName()+" drop from total "+number+" examination because of bad feedback.");
			});
			System.out.println();
			displayList.forEach(System.out::println);	
		}
		else {
			System.out.println("no one is removed from the examination.");
		}
			
	}
		

	
	
}//end of class



























