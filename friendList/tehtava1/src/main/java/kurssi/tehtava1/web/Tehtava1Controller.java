package kurssi.tehtava1.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import exercise.domain.Student;
import exercise.domain.newStudent;

@Controller
public class Tehtava1Controller {
    
    private List<Student> students = new ArrayList<>();

    @GetMapping("/index")
    public String showStudents(Model model) {
        
        if (students.isEmpty()) {
            students.add(new Student("Kate", "Cole"));
            students.add(new Student("Dan", "Brown"));
            students.add(new Student("Mike", "Mars"));
        }
        model.addAttribute("students", students);
        model.addAttribute("newStudent", new newStudent()); 
        return "index";
    }

    @PostMapping("/index")
    public String addStudent(@ModelAttribute newStudent newStudent, Model model) {
        String[] names = newStudent.jaaNimi();
        if (names != null && names.length == 2) {
            Student uusi = new Student(names[0], names[1]);
            students.add(uusi);
        }
        model.addAttribute("students", students);
        return "redirect:/index";
    }
}


