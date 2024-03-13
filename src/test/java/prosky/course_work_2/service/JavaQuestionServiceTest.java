package prosky.course_work_2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import prosky.course_work_2.exceptions.QuestionNotFoundException;
import prosky.course_work_2.exceptions.QuestionStorageIsFullException;
import prosky.course_work_2.model.Question;
import prosky.course_work_2.repository.JavaQuestionRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository repository;

    @InjectMocks
    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        when(repository.getAll()).thenReturn(List.of(
                new Question("foo", "bar"),
                new Question("foo1", "bar1"),
                new Question("foo2", "bar2"),
                new Question("foo3", "bar3"),
                new Question("foo4", "bar4"),
                new Question("foo5", "bar5")));
    }

    @Test
    void testEmptyException() {
        when(repository.getAll()).thenReturn(List.of());
        assertThrows(QuestionNotFoundException.class, () -> service.getRandomQuestion());
    }


    @Test
    void getRandomQuestion() {
        assertTrue(repository.getAll().contains(service.getRandomQuestion()));


    }
}