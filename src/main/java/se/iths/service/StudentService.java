package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional

public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }


    public List<Student> getAllStudents() {
        return entityManager.createQuery(
                "SELECT s FROM Student s", Student.class).getResultList();}


    public List<Student> getStudentByLastName(String name) {
      return entityManager.createQuery("SELECT S FROM Student S WHERE S.lastName = \'"+ name +"\'", Student.class).getResultList();
    }


    public void deleteStudent(Long id) {
        Student deleteThisStudent = entityManager.find(Student.class, id);
        entityManager.remove(deleteThisStudent);
    }


    public Set<Student> getStudentsBySubject(String subjectName) {
        Subject subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT i FROM Subject i " +
                        "INNER JOIN i.students s " +
                        "WHERE i.subjectName = :subjectName ")
                .setParameter("subjectName", subjectName).getSingleResult();
        Set<Student> studentsResult = subject.getStudents();
        return studentsResult;
    }

   public Set<Student> getStudentsBySubjectAndTeacher(String subjectName, String teacherName) {

        Subject subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT i FROM Subject i " +
                        "INNER JOIN i.teacher t" +
                        " INNER JOIN i.students s" +
                        " WHERE t.teacherName = :teacherName " +
                        "AND i.subjectName =:subjectName")
                .setParameter("teacherName", teacherName).setParameter("subjectName", subjectName).getSingleResult();
        Set<Student> studentsResult = subject.getStudents();
        return studentsResult;
    }
}
