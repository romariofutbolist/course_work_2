package prosky.course_work_2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import prosky.course_work_2.exceptions.QuestionStorageIsFullException;
import prosky.course_work_2.model.Question;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    //  @InjectMocks
    // private ExaminerServiceImpl examinerService;
    ExaminerServiceImpl examinerServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerServiceImpl = new ExaminerServiceImpl(javaQuestionService);
    }

    @Test
    void getQuestions() {
        Question question1 = new Question("foo", "bar");
        Question question2 = new Question("foo1", "bar1");
        Question question3 = new Question("foo2", "bar2");
        Question question4 = new Question("foo3", "bar3");
        Question question5 = new Question("foo4", "bar4");
        Question question6 = new Question("foo5", "bar5");

        Set<Question> setQuestions = new HashSet<>(List.of(
                question1, question2, question3, question4, question5, question6));

        when(javaQuestionService.getAll()).thenReturn(setQuestions);

        assertThrows(QuestionStorageIsFullException.class, ()-> examinerServiceImpl.getQuestions(10));
        //assertThrows(EmployeeNotFoundException.class, () -> departmentService.getEmployeeWithMinSalary(111));

        assertIterableEquals(examinerServiceImpl.getQuestions(6),setQuestions);

        when(javaQuestionService.getRandomQuestion()).thenReturn(question1,question2);

        assertEquals(examinerServiceImpl.getQuestions(2).size(), 2);

    }
}