package com.springGB.springGB.Lesson3.controllers;

import com.springGB.springGB.Lesson3.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private final StudentService studentService;

    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1>Hello my friend</h1>";
    }

    @GetMapping("/calc")
    @ResponseBody
    public int calc(@RequestParam("a") int a, @RequestParam(name = "b", required = false, defaultValue = "0") int b) {
        return a + b;
    }

    @GetMapping("/pr/{id}/info")
    @ResponseBody
    public String info(@PathVariable(name = "id") int id) {
        return "id = " + id;
    }

    @GetMapping("/index")
    public String index(Model model, @RequestParam Long id) {
        model.addAttribute("student", studentService.getStudentRepository().findById(id));
        return "index";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getStudentRepository().getStudentsList());
        return "students";
    }




}
