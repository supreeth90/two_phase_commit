package sup.test.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sup.test.dao.StudentDao;
import sup.test.entity.Student;

@ComponentScan(basePackages = "sup.test")
@ImportResource({ "classpath:jpaConfig.xml" })
public class StudentMain {
	
	@Autowired
	private StudentDao stuDao;
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(StudentMain.class);
		
		StudentMain stu =ctx.getBean(StudentMain.class);
		stu.start();
		
	}
	
	/*
	 * Beginning of spring container
	 */
	private void start() {
		System.out.println("Save starting");
		Student stuObj=new Student();
		stuObj.setID(12322);
		stuObj.setStudentName("supreeth2");
		stuDao.saveStudent(stuObj);
		System.out.println("Save done!!");
	}
	
	public void saveStuObject(Student obj) {
		stuDao.saveStudent(obj);
	}
	
//	public static void saveObject(Object obj) {
//		try {
//			
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-student");
//	
//			EntityManager em = emf.createEntityManager();
//	
//			// Creating a new transaction.
//			EntityTransaction tx = em.getTransaction();
//	
//			tx.begin();
//			
//			em.merge(obj);
//	
//			tx.commit();
//	
//			// Closing connection.
//			em.close();
//			emf.close();
//		} catch (Exception ex) {
//			System.err.println("Error persisting entity in database. Error: " + ex.getMessage());
//			throw ex;
//		}
//	}
	
}
