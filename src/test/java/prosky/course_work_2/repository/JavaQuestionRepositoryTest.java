package prosky.course_work_2.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import prosky.course_work_2.model.Question;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    JavaQuestionRepository repository = new JavaQuestionRepository();

    @Test
    void testaddObject() {
        repository.add(new Question("foo1","bar1"));
        repository.add(new Question("foo2","bar2"));

        assertTrue(repository.getAll().contains(
                new Question("foo1", "bar1")));
        assertTrue(repository.getAll().contains(
                new Question("foo2", "bar2")));

        assertEquals(repository.getAll().size(),2);
    }

    @Test
    void testAddToParam() {
        Question question1 = new Question("foo", "bar");
        assertEquals(repository.add("foo","bar"), question1);
        assertEquals(repository.getAll().size(),1);
    }

    @Test
    void testRemove() {
        repository.add(new Question("foo1","bar1"));
        repository.add(new Question("foo2","bar2"));

        var removed = repository.remove(new Question("foo1", "bar1"));

        assertTrue(repository.getAll().contains(new Question("foo2", "bar2")));
        assertEquals(removed,new Question("foo1", "bar1"));

        var empty = repository.remove(new Question("foo", "bar"));
        assertNull(empty);

        assertEquals(repository.getAll().size(),1);

    }

    @Test
    void getAll() {

        Question question1 = new Question("foo", "bar");
        Question question2 = new Question("foo1", "bar1");
        Question question3 = new Question("gg", "dd");

        Set<Question> set = new HashSet<>();
        set.add(question1);
        set.add(question2);

        repository.add(question1);
        repository.add(question2);

        assertEquals(repository.getAll().size(),2);
        assertArrayEquals(repository.getAll().toArray(), set.toArray());
        assertNotNull(repository.getAll());
        assertTrue(repository.getAll().contains(question2));
        assertFalse(repository.getAll().contains(question3));
    }
}