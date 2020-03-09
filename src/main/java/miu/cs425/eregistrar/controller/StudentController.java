package miu.cs425.eregistrar.controller;

import miu.cs425.eregistrar.model.Student;
import miu.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;
    //private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

//    public ModelAndView getStudent(@RequestParam Long id){
//        Student student = studentService.getStudent(id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("updateStudent", student);
//        modelAndView.setViewName("registrar/updateForm");
////
//        return modelAndView;
//    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String searchWord){
        List<Student> searchList = studentService.search(searchWord);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("searched", searchList);
        modelAndView.setViewName("registrar/searchList");
    return modelAndView;
    }



    @GetMapping("/register")
    public ModelAndView registerForm(Model model){
        model.addAttribute("newStudent", new Student());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrar/createForm");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createNewStudent(@ModelAttribute Student student)
    {
        studentService.createNewStudentRecord(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrar/success");
        return modelAndView;
    }

    @GetMapping("/getAllStudent")
    public ModelAndView allStudent(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getStudents();
        modelAndView.addObject("allStudent", students );
        modelAndView.setViewName("registrar/list");
       return  modelAndView;
    }

    @GetMapping("/getStudent")
    public ModelAndView getStudent(@RequestParam Long id){
        Student student = studentService.getStudent(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("updateStudent", student);
        modelAndView.setViewName("registrar/updateForm");
//
        return modelAndView;
    }

    @PostMapping("/update/{id}")
//    @ModelAttribute Student updateStudent
    public ModelAndView updateStudentRecord(@PathVariable Long id,@ModelAttribute Student student){
        student.setStudentId(id);
        studentService.createNewStudentRecord(student);
//        studentService.updateStudentRecord(id, student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrar/success");
        return modelAndView;

    }

//    @RequestMapping(value = "/delete_user/{personId}", method = RequestMethod.GET)
//    public String handleDeleteUser(@PathVariable String personId) {
//        System.out.println(personId);
//        System.out.println("test");
//        return "redirect:/external";
//    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudentRecord(@PathVariable Long id){
        studentService.deleteStudentRecord(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrar/success");
//        System.out.println(id);

        return modelAndView;
    }

}
