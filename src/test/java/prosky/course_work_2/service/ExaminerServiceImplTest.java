package prosky.course_work_2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import prosky.course_work_2.exceptions.QuestionStorageIsFullException;
import prosky.course_work_2.model.Question;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    static List<Question> MATH_QUESTIONS = List.of(
            new Question("foo", "bar"),
            new Question("foo1", "bar1"));

    static List<Question> JAVA_QUESTIONS = List.of(
            new Question("foo2", "bar2"),
            new Question("foo3", "bar3"));

    @Mock
    private JavaQuestionService javaQuestionService;

    @Mock
    private MathQuestionService mathQuestionService;

    private ExaminerService examinerService;

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);

        when(javaQuestionService.getAll()).thenReturn(JAVA_QUESTIONS);

        when(mathQuestionService.getAll()).thenReturn(MATH_QUESTIONS);

    }

    @Test
    void testException() {

        assertThrows(QuestionStorageIsFullException.class, () -> examinerService.getQuestions(10));
    }

    @Test
    void testRandomException() {

   //     assertIterableEquals(examinerServiceImpl.getQuestions(6), setQuestions);

        when(javaQuestionService.getRandomQuestion()).thenReturn(JAVA_QUESTIONS.get(0));
        when(mathQuestionService.getRandomQuestion()).
                thenReturn(MATH_QUESTIONS.get(0)).
                thenReturn(MATH_QUESTIONS.get(1));

        var actual = examinerService.getQuestions(3);
        assertTrue(actual.contains(
                JAVA_QUESTIONS.get(0)));

        assertEquals(actual.size(), 3);

    }
}