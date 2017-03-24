package sup.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import sup.test.entity.Student;

public class StudentDao {

	@PersistenceContext
    private EntityManager em;
	
	@Transactional
    public void saveStudent(Student student) {
        em.persist(student);
    }
	
}
