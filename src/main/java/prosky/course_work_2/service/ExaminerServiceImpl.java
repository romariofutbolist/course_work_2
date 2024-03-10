package prosky.course_work_2.service;

import org.springframework.stereotype.Service;
import prosky.course_work_2.exceptions.QuestionStorageIsFullException;
import prosky.course_work_2.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if(javaQuestionService.getAll().size()==amount) {
            return javaQuestionService.getAll();
        }

        if (javaQuestionService.getAll().size() < amount) {
            throw new QuestionStorageIsFullException("Лимит вопросов исчерпан");
        }

        Set<Question> questionSet = new HashSet<>();

        while(questionSet.size()<amount) {
            questionSet.add(javaQuestionService.getRandomQuestion());
        }
        return questionSet;
    }
}
