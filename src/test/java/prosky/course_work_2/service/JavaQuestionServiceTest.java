package prosky.course_work_2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prosky.course_work_2.model.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    
    private JavaQuestionService javaQuestionService;
    
    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();


    }

    @Test
    void addToObject() {
        Question question1 = new Question("foo", "bar");
        Question question2 = new Question("foo1", "bar1");
        Question question3 = new Question("foo2", "bar2");

        assertEquals(javaQuestionService.add(question1), question1);
        assertEquals(javaQuestionService.getAll().size(),1);
    }

    @Test
    void testAddToParam() {
        Question question1 = new Question("foo", "bar");
        assertEquals(javaQuestionService.add("foo","bar"), question1);
        assertEquals(javaQuestionService.getAll().size(),1);
    }

    @Test
    void remove() {
        Question question1 = new Question("foo", "bar");
        Question question2 = new Question("foo1", "bar1");
        Question question3 = new Question("foo2", "bar2");

        assertEquals(javaQuestionService.add(question1), question1);
        assertEquals(javaQuestionService.remove(question1), question1);
        assertEquals(javaQuestionService.getAll().size(),0);
    }

    @Test
    void getAll() {
        Question question1 = new Question("foo", "bar");
        Question question2 = new Question("foo1", "bar1");
        Question question3 = new Question("gg", "dd");

        Set<Question> set = new HashSet<>();
        set.add(question1);
        set.add(question2);

        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        assertEquals(javaQuestionService.getAll().size(),2);
        assertArrayEquals(javaQuestionService.getAll().toArray(), set.toArray());
        assertNotNull(javaQuestionService.getAll());
        assertTrue(javaQuestionService.getAll().contains(question2));
        assertFalse(javaQuestionService.getAll().contains(question3));

    }

    @Test
    void getRandomQuestion() {
        Question question1 = new Question("foo", "bar");
        Question question2 = new Question("foo1", "bar1");
        Question question3 = new Question("gg", "dd");

        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);

        assertTrue(javaQuestionService.getAll().contains(javaQuestionService.getRandomQuestion()));

    }
}