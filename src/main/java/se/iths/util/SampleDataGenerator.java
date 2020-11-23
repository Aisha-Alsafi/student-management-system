package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student student1 = new Student("Aisha", "Alsafi", "aisha@gmail.com","0707445566");
        Student student2 = new Student("Anna", "Andersson", "anna@gmail.com","0707445566");
        Student student3 = new Student("Lena", "Svensson", "lena@gmail.com","0707445566");

        Teacher teacher1 = new Teacher("Karl");
        Teacher teacher2 = new Teacher("Olof");

        Subject subject1 = new Subject("Matte");
        Subject subject2 = new Subject("Svenska");
        Subject subject3 = new Subject("Engelska");
        Subject subject4 = new Subject("Geografi");

        student1.addSubject(subject1);
        student1.addSubject(subject4);

        student2.addSubject(subject2);
        student2.addSubject(subject1);

        student3.addSubject(subject4);
        student3.addSubject(subject1);
        student3.addSubject(subject3);

        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher2.addSubject(subject3);
        teacher2.addSubject(subject4);

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
   }
}
