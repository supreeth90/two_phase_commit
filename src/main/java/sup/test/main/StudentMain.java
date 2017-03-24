package sup.test.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sup.test.dao.StudentDao;
import sup.test.entity.Student;

public class StudentMain {

	public static void main(String[] args) {
		
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfigurer.class);
//		ctx.getBean(arg0)
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("two-phase-spring.xml");
		
		StudentDao stuDao=new StudentDao();
		System.out.println("Save starting");
		Student stuObj=new Student();
		stuObj.setID(123);
		stuObj.setStudentName("supreeth");
		stuDao.saveStudent(stuObj);
//		saveObject(stuObj);
		System.out.println("Save done!!");
	}
	
	public static void saveObject(Object obj) {
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-student");
	
			EntityManager em = emf.createEntityManager();
	
			// Creating a new transaction.
			EntityTransaction tx = em.getTransaction();
	
			tx.begin();
			
			em.merge(obj);
	
			tx.commit();
	
			// Closing connection.
			em.close();
			emf.close();
		} catch (Exception ex) {
			System.err.println("Error persisting entity in database. Error: " + ex.getMessage());
			throw ex;
		}
	}
	
}
