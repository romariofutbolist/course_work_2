package prosky.course_work_2.controller;

import org.springframework.web.bind.annotation.*;
import prosky.course_work_2.model.Question;
import prosky.course_work_2.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("exam/java/get")
public class ExamController {

    private final ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping("{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerServiceImpl.getQuestions(amount);
    }
}
