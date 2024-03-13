package prosky.course_work_2.service;

import org.springframework.stereotype.Service;
import prosky.course_work_2.exceptions.QuestionStorageIsFullException;
import prosky.course_work_2.model.Question;
import prosky.course_work_2.repository.QuestionRepository;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService mathService;
    private final QuestionService javaService;
    private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService mathService, QuestionService javaService) {
        this.mathService = mathService;
        this.javaService = javaService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        var allQuestion = new ArrayList<>(mathService.getAll());
        allQuestion.addAll(javaService.getAll());

        if(allQuestion.size()==amount) {
            return allQuestion;
        }

        if (allQuestion.size() < amount) {
            throw new QuestionStorageIsFullException("Лимит вопросов исчерпан");
        }

        Set<Question> questionSet = new HashSet<>();

        while(questionSet.size()<amount) {
            Question question = random.nextBoolean() ? mathService.getRandomQuestion():javaService.getRandomQuestion();
            questionSet.add(question);
        }
        return questionSet;
    }
}
