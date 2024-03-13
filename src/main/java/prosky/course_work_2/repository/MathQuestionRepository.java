package prosky.course_work_2.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import prosky.course_work_2.model.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("mathRepository")
public class MathQuestionRepository implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void unit() {
        questions.add(new Question("moo1","mar1"));
        questions.add(new Question("moo2","mar2"));
        questions.add(new Question("moo3","mar3"));
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}
