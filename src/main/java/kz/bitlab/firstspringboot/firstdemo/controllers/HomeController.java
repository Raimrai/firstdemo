package kz.bitlab.firstspringboot.firstdemo.controllers;

import kz.bitlab.firstspringboot.firstdemo.db.DBManager;
import kz.bitlab.firstspringboot.firstdemo.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        ArrayList<Student> students = DBManager.getStudents();
        model.addAttribute("examStud", students);
        return "index";

}
    @GetMapping(value = "/addStudent")
    public String studentAdd(){
        return "addStudent";
    }

    @PostMapping(value = "/add")
    public String add(@RequestParam(name = "student_name", defaultValue = "no name") String name,
                      @RequestParam(name = "student_surname", defaultValue = "no surname") String surname,
                      @RequestParam(name = "student_exam", defaultValue = "0") int exam){
        DBManager.addStudent(new Student(null,name,surname,exam));
        return "addStudent";
    }
    @GetMapping(value = "/more/{idshka}")
    public String more(Model model,@PathVariable(name="idshka")Long id){
        Student student = DBManager.getStudent(id);
        model.addAttribute("studentDet",student);
        return "more";
    }
}

