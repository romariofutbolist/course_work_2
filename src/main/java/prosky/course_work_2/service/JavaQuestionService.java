package prosky.course_work_2.service;

import org.springframework.stereotype.Service;
import prosky.course_work_2.exceptions.QuestionNotFoundException;
import prosky.course_work_2.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

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

    @Override
    public Question getRandomQuestion() {
        int maxSize = questions.size();
        Random rand = new Random();
        int random = rand.nextInt(maxSize);
        int i = 0;
        for (Question q : questions) {
            if (i == random) {
                return q;
            }
            i++;
        }
        return null;
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
