package com.spring.mvc.controller;

import com.spring.mvc.dao.StudentDao;
import com.spring.mvc.model.StudentMVC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private StudentDao studentDao;

    // Index navigation
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // TASK 8: HelloWorld Program
    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World from Spring MVC!");
        return "hello";
    }

    // Common Movies List Helper (Minimum 10 items)
    private List<String> getTopMovies() {
        return new ArrayList<>(Arrays.asList(
                "1. Inception", "2. Interstellar", "3. The Dark Knight", "4. Avatar",
                "5. Titanic", "6. Gladiator", "7. The Matrix", "8. The Prestige",
                "9. Oppenheimer", "10. Pulp Fiction"
        ));
    }

    // TASK 9: Top view series/movies displayed via Expression Language (EL)
    @GetMapping("/top-movies-el")
    public String topMoviesEL(Model model) {
        model.addAttribute("moviesList", getTopMovies());
        return "movies_el";
    }

    // TASK 11 (Numbered 4 in slide): Top view series/movies displayed via JSTL <c:forEach>
    @GetMapping("/top-movies-jstl")
    public String topMoviesJSTL(Model model) {
        model.addAttribute("moviesList", getTopMovies());
        return "movies_jstl";
    }

    // TASK 10: Marks Form Calculation (Science, Maths, English)
    @GetMapping("/marks-form")
    public String marksForm() {
        return "marks_form";
    }

    @PostMapping("/calculate-marks")
    public String calculateMarks(@RequestParam("science") int science,
                                 @RequestParam("maths") int maths,
                                 @RequestParam("english") int english,
                                 Model model) {
        int total = science + maths + english;
        model.addAttribute("science", science);
        model.addAttribute("maths", maths);
        model.addAttribute("english", english);
        model.addAttribute("total", total);
        return "marks_result";
    }

    // TASK 12: Insert Student Form & Submission
    @GetMapping("/student-form")
    public String studentForm() {
        return "student_form";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") StudentMVC student, Model model) {
        studentDao.saveStudent(student);
        model.addAttribute("msg", "Student saved successfully!");
        return "redirect:/view-students";
    }

    // TASK 13: Display all inserted Students
    @GetMapping("/view-students")
    public String viewStudents(Model model) {
        List<StudentMVC> list = studentDao.getAllStudents();
        model.addAttribute("students", list);
        return "student_list";
    }

    // TASK 14: Cash Back Offer Mini Project
    @GetMapping("/cashback")
    public String cashBackForm() {
        return "cashback_form";
    }

    @PostMapping("/calculate-cashback")
    public String calculateCashBack(@RequestParam("billAmount") double billAmount,
                                    @RequestParam(value = "promoCode", required = false) String promoCode,
                                    Model model) {
        double cashback = 0.0;
        if ("CASH10".equalsIgnoreCase(promoCode)) {
            cashback = billAmount * 0.10;
        } else if ("CASH20".equalsIgnoreCase(promoCode) && billAmount >= 1000) {
            cashback = billAmount * 0.20;
        } else {
            cashback = billAmount > 500 ? 50.0 : 0.0;
        }
        double finalPayable = billAmount - cashback;
        model.addAttribute("billAmount", billAmount);
        model.addAttribute("promoCode", promoCode);
        model.addAttribute("cashback", cashback);
        model.addAttribute("finalPayable", finalPayable);
        return "cashback_result";
    }
}