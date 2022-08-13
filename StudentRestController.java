package com.bd.dipti.restapi.restcontroller;

import com.bd.dipti.restapi.exception.ResourceNotFoundException;
import com.bd.dipti.restapi.model.Student;
import com.bd.dipti.restapi.repo.StudentRepo;
import com.bd.dipti.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/student")
    public ResponseEntity<List<Student>>allStudent(){
        return ResponseEntity.ok(studentService.allStudent());
    }
    @PostMapping("/addstudent")
    public ResponseEntity<Student>addStudent(@RequestBody Student s){
        return ResponseEntity.ok(this.studentService.saveStudent(s));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id)
            throws ResourceNotFoundException {
        Student s=studentRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Id Not Found"));
        return ResponseEntity.ok().body(s);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student st)
            throws ResourceNotFoundException{
        Student s=studentRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student Not Found For This Id"));
        s.setName(st.getName());
        s.setEmail(st.getEmail());

        final Student updateStudent=studentRepo.save(s);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/student/{id}")
    public Map<String,Boolean> deleteStudent(@PathVariable Integer id)
            throws ResourceNotFoundException{
        Student s=studentRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Delete Not Possible"));
        studentRepo.delete(s);
        Map<String,Boolean> res=new HashMap<>();
        res.put("Data Delete", Boolean.TRUE);
        return res;

    }

}
