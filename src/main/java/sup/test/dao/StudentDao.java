package sup.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sup.test.entity.Student;

@Component
public class StudentDao {

	@PersistenceContext
    private EntityManager em;
	
	@Transactional
    public void saveStudent(Student student) {
		System.out.println("Trying to save StudentDao");
        em.persist(student);
    }
	
}
