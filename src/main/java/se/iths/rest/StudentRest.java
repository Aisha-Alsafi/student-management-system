package se.iths.rest;


import se.iths.entity.Student;
import se.iths.service.StudentService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("create")
    @POST
    public Response createStudent(Student student){
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("update")
    @PUT
    public Response updateItem(Student student) {
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("getall")
    @GET
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

   @Path("getStudentByLastName/{lastname}")
   @GET
   public Response getStudentByLastName(@PathParam("lastname") String name) {
       List<Student> S = studentService.getStudentByLastName(name);
       if(S.size() == 0){
           throw new StudentNotFoundException("Student with last name " + name + " not found.");
       } else{
           return Response.ok(S).build();
       }
   }

   @Path("deleteStudent/{id}")
   @Produces(MediaType.TEXT_PLAIN)
   @DELETE
   public Response deleteItem(@PathParam("id") Long id) {
       Student foundItem = studentService.findStudentById(id);
       if (foundItem != null) {
           studentService.deleteStudent(id);
           return Response.ok().entity("Student with ID " + id + " was successfully deleted.").build();
       } else {
           throw new StudentNotFoundException("Student with ID " + id + " not found.");
       }
   }


    @Path("getStudentsBySubject/{subjectname}")
    @GET
    public Set<Student> getStudentsForSubject(@PathParam("subjectname") String subject) {
        return studentService.getStudentsBySubject(subject);
    }

}
