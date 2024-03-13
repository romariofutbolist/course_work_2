package prosky.course_work_2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import prosky.course_work_2.exceptions.QuestionNotFoundException;
import prosky.course_work_2.model.Question;
import prosky.course_work_2.repository.QuestionRepository;

import java.util.*;

@Service("java")
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository repository;

    public JavaQuestionService(@Qualifier("javaRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        int maxSize = repository.getAll().size();
        if(repository.getAll().isEmpty()) {
            throw new QuestionNotFoundException("Вопросов в коллекции нет");
        }
        Random rand = new Random();
        int random = rand.nextInt(maxSize);
        int i = 0;
        for (Question q : repository.getAll()) {
            if (i == random) {
                return q;
            }
            i++;
        }
        throw new QuestionNotFoundException("Вопросов в коллекции нет");
    }

 /*   public Question remove(String question, String answer) {
        Question removeQuestion = new Question(question, answer);
        if (!questions.contains(removeQuestion)) {
            throw new QuestionNotFoundException("Такой вопрос не найден");
        }
        questions.remove(removeQuestion);
        return removeQuestion;
    }

  */
}
