# student-management-system
Starting project | Java EE assignment | JU19 | ITHS
StudentManagement REST Endpoints are :

Labb 1

-----------------To create a new Student-----------------
POST    http://localhost:8080/StudentManagement/api/v1/student/create
Return a json formatted student record.
{
	"firstName":"Aisha",
	"lastName":"Alsafi",
	"email":"aisha@gmail.com",
	"phoneNumber":"0707666666"
}
All fields are required except phone Number (optional)
If (required) field is missing, you get 400 bad request as answer.


-----------------To Find a student by last name-----------------
GET     http://localhost:8080/StudentManagement/api/v1/student/getStudentByLastName/{lastname}
return a json formatted student record 
If a Last Name is not in the database, you get 400 Not found request with (Student with last name {lastname} not found.) as answer.


-----------------To get all students---------------------------
GET     http://localhost:8080/StudentManagement/api/v1/student/getall
return a list of json formatted students records


-----------------To update student information-----------------
PUT     http://localhost:8080/StudentManagement/api/v1/student/update
Send Student data as json file with modified info. 
return a modified student record.


-----------------To delete a student by sending its ID----------
DELETE  http://localhost:8080/StudentManagement/api/v1/student/deleteStudent/{id}
Return a message with confirmation if a delete success. 
If ID is not in the database, you get 400 Not found request with a message (Student with ID {id} was successfully deleted.) as answer.



labb 2
I added a new Entities( Teacher and Subject).

We kan get students list by subject name.

GET     http://localhost:8080/StudentManagement/api/v1/student/getStudentsBySubject/{subjectname}


-----------------Subject-----------------
{
	"subjectName":"Matte"	
}
 
 
POST    http://localhost:8080/StudentManagement/api/v1/subject/create
GET     http://localhost:8080/StudentManagement/api/v1/subject/getall
PUT     http://localhost:8080/StudentManagement/api/v1/subject/update

-----------------Teacher-----------------
{
	"teacherName":"Olof"	
}

POST    http://localhost:8080/StudentManagement/api/v1/teacher/create
GET     http://localhost:8080/StudentManagement/api/v1/teacher/getall
PUT     http://localhost:8080/StudentManagement/api/v1/teacher/update


